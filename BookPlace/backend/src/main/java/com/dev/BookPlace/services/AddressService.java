package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.User;
import com.dev.BookPlace.mappers.AddressDTOMapper;
import com.dev.BookPlace.repositories.AddressRepository;
import com.dev.BookPlace.services.exceptions.AccessDeniedException;
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
    private final UserService userService;
    private final AddressDTOMapper addressDTOMapper;

    @Transactional
    public AddressDTO insertAddress(AddressDTO dto) {
        Long userId = userService.authenticated().getId();
        User user = userService.getUser(userId);
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
        checkOwnership(address, userId);
        return addressDTOMapper.toAddressDTO(address);
    }

    @Transactional
    public AddressDTO update(Long id, AddressDTO dto) {
        try {
            Long userId = userService.authenticated().getId();
            Address entity = findAddressById(id);
            checkOwnership(entity, userId);
            addressDTOMapper.updateAddressFromDTO(dto, entity);
            entity = addressRepository.save(entity);
            return addressDTOMapper.toAddressDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public Address findAddressById(Long addressId) {
        Address entity = addressRepository.getReferenceById(addressId);
        return entity;
    }

    public void checkOwnership(Address address, Long userId) {
        if (!Objects.equals(address.getUser().getId(), userId)) {
            throw new AccessDeniedException("You do not have permission to update this address");
        }
    }
}