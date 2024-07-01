package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.entities.bookplace.entities.Address;
import com.dev.BookPlace.entities.bookplace.entities.User;
import com.dev.BookPlace.mappers.AddressDTOMapper;
import com.dev.BookPlace.repositories.AddressRepository;
import com.dev.BookPlace.repositories.UserRepository;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final AddressDTOMapper addressDTOMapper;

    @Transactional
    public AddressDTO insertAddress(AddressDTO dto) {
        Long userId = userService.authenticated().getId();
        User user = findUserByUserId(userId);
        Address AddressEntity = addressDTOMapper.toAddressEntity(dto);
        AddressEntity.setUser(user);
        AddressEntity = addressRepository.save(AddressEntity);
        return addressDTOMapper.toAddressDTO(AddressEntity);
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> findAllAddressList() {
        Long userId = userService.authenticated().getId();
        List<Address> list = addressRepository.searchAddressByUserId(userId);
        List<AddressDTO> listAddress = list.stream().map(addressList -> (addressDTOMapper.toAddressDTO(addressList))).toList();
        return listAddress;
    }

    @Transactional
    public AddressDTO findById(Long id) {
        Long userId = userService.authenticated().getId();
        Address address = findAddressById(id);
        checkOwnership(id, userId);
        return addressDTOMapper.toAddressDTO(address);
    }

    @Transactional
    public AddressDTO update(Long id, AddressDTO dto) {
        try {
            Long userId = userService.authenticated().getId();
            checkOwnership(id, userId);
            Address entity = addressRepository.getReferenceById(id);
            addressDTOMapper.updateAddressFromDTO(dto, entity);
            entity = addressRepository.save(entity);
            return addressDTOMapper.toAddressDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public User findUserByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with: " + userId));
        return user;
    }

    public Address findAddressById(Long addressId) {
        Address entity = addressRepository.getReferenceById(addressId);
        return entity;
    }

    private void checkOwnership(Long addressId, Long userId) {
        Address address = addressRepository.getReferenceById(addressId);
        if (!Objects.equals(address.getUser().getId(), userId)) {
            throw new ResourceNotFoundException("Id not found " + addressId);
        }
    }
}



















