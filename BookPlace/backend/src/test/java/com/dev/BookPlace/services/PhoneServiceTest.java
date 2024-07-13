package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.entities.Phone;
import com.dev.BookPlace.entities.User;
import com.dev.BookPlace.factory.PhoneFactory;
import com.dev.BookPlace.factory.UserFactory;
import com.dev.BookPlace.mappers.PhoneDTOMapper;
import com.dev.BookPlace.repositories.PhoneRepository;
import com.dev.BookPlace.repositories.UserRepository;
import com.dev.BookPlace.services.exceptions.AccessDeniedException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class PhoneServiceTest {

    @InjectMocks
    @Spy
    private PhoneService phoneService;

    @Mock
    private PhoneRepository phoneRepository;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PhoneDTOMapper phoneDTOMapper;

    private PhoneDTO phoneDTO;
    private Phone phone;
    private User user;
    private PhoneFactory phoneFactory;
    private long existingId;
    private long nonExistingId;
    @BeforeEach
    void setUp() {
        phoneDTO = phoneFactory.createPhoneDTO();
        phone = phoneFactory.createPhone();
        user = UserFactory.createUserClient();
        existingId = 1L;
        nonExistingId = 4L;
    }

    @Test
    void savePhoneNumberShouldReturnPhoneDTO() {

        when(userService.authenticated()).thenReturn(user);
        doReturn(user).when(userService).getUser(user.getId());
        when(phoneDTOMapper.toPhoneEntity(phoneDTO)).thenReturn(phone);
        when(phoneDTOMapper.toPhoneDTO(phone)).thenReturn(phoneDTO);
        when(phoneRepository.save(any(Phone.class))).thenReturn(phone);

        PhoneDTO result = phoneService.savePhoneNumber(phoneDTO);

        assertNotNull(result);
        verify(phoneRepository, times(1)).save(phone);
    }

    @Test
    void deletePhoneNumberShouldDoNothingWhenIdPhoneExists () {
        when(userService.authenticated()).thenReturn(user);
        when(phoneRepository.findById(existingId)).thenReturn(Optional.of(phone));

        assertDoesNotThrow(() -> {
            phoneService.deletePhoneNumber(existingId);
        });
        verify(phoneRepository, times(1)).deleteById(existingId);
    }

    @Test
    void deletePhoneNumberShouldThrowResourceNotFoundExceptionWhenIdPhoneDoesNotExists () {
        when(userService.authenticated()).thenReturn(user);

        when(phoneRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            phoneService.deletePhoneNumber(nonExistingId);
        });

        verify(phoneRepository, times(1)).findById(nonExistingId);

    }

    @Test
    void deletePhoneNumberShouldThrowAccessDeniedExceptionWhenUserIdDoesNotMatch() {
        Long differentUserId = 2L;

        User client = new User();
        client.setId(differentUserId);
        phone.setClient(client);

        when(phoneRepository.findById(existingId)).thenReturn(Optional.of(phone));
        when(userService.authenticated()).thenReturn(user);

        assertThrows(AccessDeniedException.class, () -> {
            phoneService.deletePhoneNumber(existingId);
        });

        verify(phoneRepository, times(1)).findById(existingId);
    }
}