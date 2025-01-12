package com.dev.BookPlace.Gateway.strategy;

import com.dev.BookPlace.enums.PaymentMethod;
import com.dev.BookPlace.models.dto.OrderDTO;
import com.dev.BookPlace.models.entities.Order;

public interface PaymentStrategy {
    PaymentMethod getType();
    OrderDTO processPayment(Order order);
}
