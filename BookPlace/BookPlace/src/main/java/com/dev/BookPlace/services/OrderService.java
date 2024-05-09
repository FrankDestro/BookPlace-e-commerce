package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.dto.OrderDTO;
import com.dev.BookPlace.dto.OrderItemDTO;
import com.dev.BookPlace.entities.*;
import com.dev.BookPlace.repositories.*;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public OrderDTO recordOder (OrderDTO dto) {

        Order order = new Order();

        //Carregar endereço escolhido pelo cliente
        AddressDTO address = dto.getAddress();
        Address addressShipping = addressRepository.getReferenceById(address.getId());

        // Carregar dados client
        User client = userRepository.getReferenceById(userService.authenticated().getId());

        // Carrega a lista de items bem como quantidade.
        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            double amount = product.getPrice() * itemDto.getQuantity();
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice(), amount, product.getName());
            order.getItems().add(item);
        }

        //Chama API PagSeguro e preencher o objeto PaymentRequest



        // Pega o response e salva no Order.



        // Salvar o order
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());


        //Retornar o pedido realizado.
        return new OrderDTO(order);
    }
}
