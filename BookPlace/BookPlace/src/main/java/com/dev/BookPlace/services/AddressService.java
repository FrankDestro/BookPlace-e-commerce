package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.User;
import com.dev.BookPlace.repositories.AddressRepository;
import com.dev.BookPlace.repositories.UserRepository;
import com.dev.BookPlace.services.exceptions.DatabaseException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<AddressDTO> findAllAddressList() {
        Long userId = userService.authenticated().getId();
        List<Address> list = addressRepository.searchAddressByUserId(userId);
        return list.stream().map(addressList -> new AddressDTO(addressList)).toList();
    }

    @Transactional
    public AddressDTO insertAddress(AddressDTO dto) {
        Address entity = new Address();
        copyDtoToEntity(dto, entity);
        entity = addressRepository.save(entity);
        return new AddressDTO(entity);
    }

    @Transactional
    public AddressDTO update(Long id, AddressDTO dto) {
        try {

            Address entity = addressRepository.getReferenceById(id);
            Long userId = userService.authenticated().getId();

            if (userId == entity.getUser().getId()) {
                copyDtoToEntity(dto, entity);
                entity = addressRepository.save(entity);
                return new AddressDTO(entity);
            } else {
                throw new UsernameNotFoundException("usuário logado diferente");
            }
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
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
}
