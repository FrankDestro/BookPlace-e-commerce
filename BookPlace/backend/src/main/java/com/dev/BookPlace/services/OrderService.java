package com.dev.BookPlace.services;

import com.dev.BookPlace.Gateway.strategy.PaymentStrategy;
import com.dev.BookPlace.models.dto.AddressDTO;
import com.dev.BookPlace.models.dto.OrderDTO;
import com.dev.BookPlace.models.dto.OrderItemDTO;
import com.dev.BookPlace.models.entities.*;
import com.dev.BookPlace.repositories.AddressRepository;
import com.dev.BookPlace.repositories.OrderRepository;
import com.dev.BookPlace.repositories.ProductRepository;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final AddressRepository addressRepository;
    private final UserService userService;

    private final List<PaymentStrategy> paymentStrategies;

    @Autowired
    private PaymentStrategy paymentStrategy;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO recordOrder(OrderDTO orderDTO) throws JsonProcessingException {
        Order order = getOrder(orderDTO);
        PaymentStrategy paymentStrategy = paymentStrategies.stream().filter(strategy -> strategy.getType() == orderDTO.getPaymentMethod()).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Método de pagamento não suportado: " + orderDTO.getPaymentMethod()));
        return paymentStrategy.processPayment(order);
    }

    private Order getOrder(OrderDTO dto) {
        Order order = new Order();
        order.setPaymentMethod(dto.getPaymentMethod());
        User user = userService.authenticated();
        order.setClient(user);
        AddressDTO address = dto.getAddress();
        Address addressShipping = addressRepository.getReferenceById(address.getId());
        order.setAddress(addressShipping);

        double total = 0.0;

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            double subtotal = product.getPrice() * itemDto.getQuantity();
            total += subtotal;
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice(), subtotal, product.getName());
            order.getItems().add(item);
        }
        order.setTotalSum(total);
        return order;
    }
}
