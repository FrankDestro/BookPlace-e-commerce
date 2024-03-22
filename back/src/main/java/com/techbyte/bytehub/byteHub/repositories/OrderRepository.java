package com.techbyte.bytehub.byteHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techbyte.bytehub.byteHub.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
