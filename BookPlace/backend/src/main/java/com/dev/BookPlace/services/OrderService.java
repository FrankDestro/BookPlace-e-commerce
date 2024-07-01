package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.dto.OrderDTO;
import com.dev.BookPlace.dto.OrderItemDTO;
import com.dev.BookPlace.entities.bookplace.entities.*;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.enums.PaymentMethod;
import com.dev.BookPlace.repositories.*;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO recordOder(OrderDTO dto) {

        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        PaymentMethod paymentMethod = PaymentMethod.PIX;

        User user = userService.authenticated();
        order.setClient(user);

        AddressDTO address = dto.getAddress();
        Address addressShipping = addressRepository.getReferenceById(address.getId());
        order.setAddress(addressShipping);

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            double amount = product.getPrice() * itemDto.getQuantity();
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice(), amount, product.getName());
            order.getItems().add(item);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
