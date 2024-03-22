package com.techbyte.bytehub.byteHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techbyte.bytehub.byteHub.entities.OrderItem;
import com.techbyte.bytehub.byteHub.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
