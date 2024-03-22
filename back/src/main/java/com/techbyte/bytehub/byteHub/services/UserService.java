package com.techbyte.bytehub.byteHub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techbyte.bytehub.byteHub.dto.UserDTO;
import com.techbyte.bytehub.byteHub.dto.UserInsertDTO;
import com.techbyte.bytehub.byteHub.dto.UserUpdateDTO;
import com.techbyte.bytehub.byteHub.entities.Role;
import com.techbyte.bytehub.byteHub.entities.User;
import com.techbyte.bytehub.byteHub.entities.enums.StatusUser;
import com.techbyte.bytehub.byteHub.projections.UserDetailsProjection;
import com.techbyte.bytehub.byteHub.repositories.AddressRepository;
import com.techbyte.bytehub.byteHub.repositories.RoleRepository;
import com.techbyte.bytehub.byteHub.repositories.UserRepository;
import com.techbyte.bytehub.byteHub.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Transactional(readOnly = true)
	public UserDTO findUserLogged() {
		User entity = authenticated();
		return new UserDTO(entity);
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO Register(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity.getRoles().clear();
		Role role = roleRepository.findByAuthority("ROLE_CLIENT");
		entity.getRoles().add(role);
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		entity.setStatus(StatusUser.ACTIVE);
		entity = userRepository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = userRepository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = userRepository.save(entity);
			return new UserDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setPhone(dto.getPhone());
		entity.setBirthDate(dto.getBirthDate());	
}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<UserDetailsProjection> result = userRepository.searchUserAndRoleByEmail(username);
		if (result.size() == 0) {
			throw new UsernameNotFoundException("User not found");
		}
				
		User user = new User();
		user.setEmail(username);
		user.setPassword(result.get(0).getPassword());		
		user.setStatus(StatusUser.values()[result.get(0).getStatus().intValue()]);

		for (UserDetailsProjection projection : result) {
			user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
		}

		return user;
	}

	protected User authenticated() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
			String username = jwtPrincipal.getClaim("username");
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException("Invalid user");
		}
	}

}
