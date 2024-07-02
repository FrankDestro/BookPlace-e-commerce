package com.dev.BookPlace.repositories;

import com.dev.BookPlace.entities.bookplace.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
