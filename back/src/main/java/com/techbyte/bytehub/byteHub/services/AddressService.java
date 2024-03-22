package com.techbyte.bytehub.byteHub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.techbyte.bytehub.byteHub.dto.AddressDTO;
import com.techbyte.bytehub.byteHub.entities.Address;
import com.techbyte.bytehub.byteHub.entities.User;
import com.techbyte.bytehub.byteHub.repositories.AddressRepository;
import com.techbyte.bytehub.byteHub.repositories.UserRepository;
import com.techbyte.bytehub.byteHub.services.exceptions.DatabaseException;
import com.techbyte.bytehub.byteHub.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public List<AddressDTO> findAll() {
		List<Address> list = addressRepository.findAll();
		return list.stream().map(x -> new AddressDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public AddressDTO findById(Long id) {
		Optional<Address> obj = addressRepository.findById(id);
		Address entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO insert(AddressDTO dto) {
		Address entity = new Address();
		copyDtoToEntity(dto, entity);
		entity = addressRepository.save(entity);
		return new AddressDTO(entity);
	}

	@Transactional
	public AddressDTO update(Long id, AddressDTO dto) {
		try {
			Address entity = addressRepository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = addressRepository.save(entity);
			return new AddressDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!addressRepository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		try {
			addressRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}

	private void copyDtoToEntity(AddressDTO dto, Address entity) {

		entity.setAddress(dto.getAddress());
		entity.setNumber(dto.getNumber());
		entity.setAddressDetails(dto.getAddressDetails());
		entity.setNeighborhood(dto.getNeighborhood());
		entity.setZip(dto.getZip());
		entity.setMain(dto.getMain());
		Long userId = userService.authenticated().getId();
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + userId));		
		entity.setUser(user);

	}

}