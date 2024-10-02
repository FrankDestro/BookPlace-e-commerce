package com.dev.BookPlace.repositories;

import com.dev.BookPlace.models.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
