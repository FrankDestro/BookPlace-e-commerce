package com.dev.BookPlace.Gateway.strategy;

import com.dev.BookPlace.models.dto.OrderDTO;
import com.dev.BookPlace.models.entities.Order;

public class BarcodePaymentStrategy implements PaymentStrategy{

    @Override
    public OrderDTO processPayment(Order order) {

        return null;
    }
}
