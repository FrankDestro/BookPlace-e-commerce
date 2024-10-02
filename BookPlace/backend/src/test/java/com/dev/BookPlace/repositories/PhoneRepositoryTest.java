package com.dev.BookPlace.repositories;

import com.dev.BookPlace.models.entities.Phone;
import com.dev.BookPlace.factory.PhoneFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@DataJpaTest
@Transactional
public class PhoneRepositoryTest {

    @Autowired
    private PhoneRepository phoneRepository;

    private Long existingId;
    private long noExistingId;
    private PhoneFactory phoneFactory;


    @BeforeEach
    void SetUp() throws Exception {
        existingId = 1L;
        noExistingId = 1000L;
        Phone phone = new Phone();
        phone.setId(existingId);
        phoneRepository.save(phone);
    }

//    @Test
//    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
//        Phone phone = PhoneFactory.createPhone();
//        phone.setId(null);
//
//        phone = phoneRepository.save(phone);
//
//        Assertions.assertNotNull(phone.getId());
//    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        phoneRepository.deleteById(existingId);
        Optional<Phone> result = phoneRepository.findById(existingId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void findByIdShouldReturnOptionalProductNotEmptyWhenIdExist() {
        Optional<Phone> result = phoneRepository.findById(existingId);
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void findByIdShouldReturnOptionalEmptyWhenIdNotExist() {
        Optional<Phone> result = phoneRepository.findById(noExistingId);
        Assertions.assertTrue(result.isEmpty());
    }



}
