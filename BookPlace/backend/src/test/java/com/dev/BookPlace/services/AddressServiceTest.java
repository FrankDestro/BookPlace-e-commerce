package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.entities.bookplace.entities.Address;
import com.dev.BookPlace.entities.bookplace.entities.User;
import com.dev.BookPlace.factory.AddressFactory;
import com.dev.BookPlace.factory.UserFactory;
import com.dev.BookPlace.mappers.AddressDTOMapper;
import com.dev.BookPlace.repositories.AddressRepository;
import com.dev.BookPlace.repositories.UserRepository;
import com.dev.BookPlace.services.exceptions.AccessDeniedException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @InjectMocks
    @Spy
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private UserService userService;

    @Mock
    private AddressDTOMapper addressDTOMapper;

    @Mock
    private UserRepository userRepository;

    private User user;
    private AddressDTO addressDTO;
    private Address address;
    private List<Address> addressList;
    private List<AddressDTO> addressDTOList;
    private long existingAddressId;
    private long nonExistingAddressId;
    private long existingUserId;
    private long nonExistingUserId;

    @BeforeEach
    void Setup() throws Exception {
        user = UserFactory.createUserClient();
        address = AddressFactory.createAddress();
        addressDTO = AddressFactory.createAddressDTO();
        addressList = Arrays.asList(address);
        addressDTOList = Arrays.asList(addressDTO);
        existingAddressId = 1L;
        existingUserId = 10L;
        nonExistingUserId = 10000l;
    }

    @Test
    void insertAddressShouldReturnAddressDTO() {
        when(userService.authenticated()).thenReturn(user);
        doReturn(user).when(addressService).findUserByUserId(user.getId());
        when(addressDTOMapper.toAddressEntity(addressDTO)).thenReturn(address);
        when(addressDTOMapper.toAddressDTO(address)).thenReturn(addressDTO);
        when(addressRepository.save(ArgumentMatchers.any())).thenReturn(address);

        AddressDTO result = addressService.insertAddress(addressDTO);

        assertNotNull(result);
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void findAllAddressListShouldReturnListAddressDTO() {
        when(userService.authenticated()).thenReturn(user);
        when(addressRepository.searchAddressByUserId(ArgumentMatchers.any())).thenReturn(addressList);
        when(addressDTOMapper.toAddressDTO(address)).thenReturn(addressDTO);

        List<AddressDTO> result = addressService.findAllAddressList();

        assertNotNull(result);
        verify(addressRepository, times(1)).searchAddressByUserId(user.getId());
    }

    @Test
    void findByIdShouldReturnAddressDTO() {
        when(userService.authenticated()).thenReturn(user);
        when(addressRepository.getReferenceById(existingAddressId)).thenReturn(address);
        when(addressDTOMapper.toAddressDTO(address)).thenReturn(addressDTO);
        when(addressService.findAddressById(existingAddressId)).thenReturn(address);

        AddressDTO result = addressService.findById(existingAddressId);

        assertNotNull(result);
        assertEquals(addressDTO, result);
    }

    @Test
    void updateShouldReturnAddressDTO() {

        when(userService.authenticated()).thenReturn(user);
        when(addressService.findAddressById(existingAddressId)).thenReturn(address);
        doNothing().when(addressService).checkOwnership(address, user.getId());
        doNothing().when(addressDTOMapper).updateAddressFromDTO(addressDTO, address);
        when(addressRepository.save(ArgumentMatchers.any())).thenReturn(address);
        when(addressDTOMapper.toAddressDTO(address)).thenReturn(addressDTO);

        AddressDTO result = addressService.update(existingAddressId, addressDTO);

        assertNotNull(result);
    }

    @Test
    void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {

        when(userService.authenticated()).thenReturn(user);
        when(addressRepository.getReferenceById(nonExistingAddressId)).thenReturn(null);
        doThrow(EntityNotFoundException.class).when(addressService).findAddressById(nonExistingAddressId);

        assertThrows(ResourceNotFoundException.class, () -> {
            addressService.update(nonExistingAddressId, addressDTO);
        });

    }

    @Test
    void checkOwnershipShouldThrowAccessDeniedExceptionWhenUserIdDoesNotMatch() {

        Long userIdAuthenticated = 1L;
        Long userIdAddressDifferent = 2L;

        user.setId(userIdAddressDifferent);
        address.setUser(user);

        assertThrows(AccessDeniedException.class, () -> {
            addressService.checkOwnership(address, userIdAuthenticated);
        });
    }

    @Test
    void findUserByUserIdShouldReturnUser() {
        Long userId = 1L;
        User expectedUser = user;

        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));
        User resultUser = addressService.findUserByUserId(userId);

        assertEquals(expectedUser, resultUser);
    }

    @Test
    void findUserByUserIdThrowEntityNotFoundExceptionWhenIdDoesNotExists() {
        when(userRepository.findById(nonExistingUserId)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            addressService.findUserByUserId(nonExistingUserId);
        });
    }
}