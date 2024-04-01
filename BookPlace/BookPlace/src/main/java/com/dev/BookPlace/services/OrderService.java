package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.dto.OrderDTO;
import com.dev.BookPlace.dto.OrderItemDTO;
import com.dev.BookPlace.entities.*;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.repositories.OrderItemRepository;
import com.dev.BookPlace.repositories.OrderRepository;
import com.dev.BookPlace.repositories.PixRepository;
import com.dev.BookPlace.repositories.ProductRepository;
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
    private PixRepository pixRepository;

    @Autowired
    private UserService userService;
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {

        Order order = new Order();

        // ORDER
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        // CLIENTE
        User user = userService.authenticated();
        order.setClient(user);

        // ENDEREÇO
        AddressDTO ad = dto.getAddress();
        Address address = new Address(ad.getId());
        order.setAddress(address);

        // LISTA DE ITENS
        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }

        // FORMA DE PAGAMENTO
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
