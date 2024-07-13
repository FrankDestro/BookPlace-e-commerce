package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.entities.Phone;
import com.dev.BookPlace.entities.User;
import com.dev.BookPlace.mappers.PhoneDTOMapper;
import com.dev.BookPlace.repositories.PhoneRepository;
import com.dev.BookPlace.services.exceptions.AccessDeniedException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneDTOMapper phoneDTOMapper;
    private final UserService userService;

    @Transactional
    public PhoneDTO savePhoneNumber(PhoneDTO phoneDTO) {
        Long userId = userService.authenticated().getId();
        User user = userService.getUser(userId);
        Phone phoneEntity = phoneDTOMapper.toPhoneEntity(phoneDTO);
        phoneEntity.setClient(user);
        phoneEntity = phoneRepository.save(phoneEntity);
        return phoneDTOMapper.toPhoneDTO(phoneEntity);
    }

    @Transactional
    public void deletePhoneNumber(Long phoneId) {
        Long userId = userService.authenticated().getId();
        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new ResourceNotFoundException("Phone not found for this id: " + phoneId));
        if (!phone.getClient().getId().equals(userId)) {
            throw new AccessDeniedException("You do not have permission to delete this phone number");
        }
        phoneRepository.deleteById(phoneId);
    }
}
