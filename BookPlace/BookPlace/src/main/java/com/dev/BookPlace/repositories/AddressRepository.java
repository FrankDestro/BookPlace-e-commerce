package com.dev.BookPlace.repositories;

import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.entities.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository <Address, Long> {

    @Query("SELECT obj FROM Address obj " +
            "WHERE obj.user.id = :userId")
    List<Address> searchAddressByUserId(Long userId);
}
