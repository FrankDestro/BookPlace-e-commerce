package com.dev.BookPlace.Gateway.services;


import com.dev.BookPlace.Gateway.mappers.BarCodeResponseMapper;
import com.dev.BookPlace.Gateway.models.entities.Charge;
import com.dev.BookPlace.Gateway.response.PagSeguroBarCodeResponse;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.Payment;
import com.dev.BookPlace.repositories.OrderItemRepository;
import com.dev.BookPlace.repositories.OrderRepository;
import com.dev.BookPlace.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BarCodeService {

    private final PaymentService paymentService;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository Orderrepository;
    private final BarCodeResponseMapper barCodeResponseMapper;

    public void gravarOrderBarCodeRepository(Order order, PagSeguroBarCodeResponse barCodeResponse) {

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        Orderrepository.save(order);
        orderItemRepository.saveAll(order.getItems());
        Payment payment = paymentService.createPayment(order);
        order.setPayment(payment);

        PagSeguroBarCodeResponse result = barCodeResponseMapper.toBarCodeResponse(barCodeResponse);











    }


}
