package com.techbyte.bytehub.byteHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbyte.bytehub.byteHub.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
