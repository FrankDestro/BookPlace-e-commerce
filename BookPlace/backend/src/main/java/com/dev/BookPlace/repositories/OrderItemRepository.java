package com.dev.BookPlace.repositories;

import com.dev.BookPlace.models.entities.OrderItem;
import com.dev.BookPlace.models.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}