package com.dev.BookPlace.services;

import com.dev.BookPlace.enums.PaymentStatus;
import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.Payment;
import com.dev.BookPlace.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Order order) {
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.WAITING_PAYMENT);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setAmount(BigDecimal.valueOf(order.getTotalSum()));
        payment.setOrder(order);
        Payment savedPayment = paymentRepository.save(payment);

        return savedPayment;
    }
}
