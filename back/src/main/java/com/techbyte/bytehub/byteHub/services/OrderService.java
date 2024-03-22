package com.techbyte.bytehub.byteHub.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techbyte.bytehub.byteHub.dto.AddressDTO;
import com.techbyte.bytehub.byteHub.dto.OrderDTO;
import com.techbyte.bytehub.byteHub.dto.OrderItemDTO;
import com.techbyte.bytehub.byteHub.entities.Address;
import com.techbyte.bytehub.byteHub.entities.Order;
import com.techbyte.bytehub.byteHub.entities.OrderItem;
import com.techbyte.bytehub.byteHub.entities.Product;
import com.techbyte.bytehub.byteHub.entities.User;
import com.techbyte.bytehub.byteHub.entities.enums.OrderStatus;
import com.techbyte.bytehub.byteHub.repositories.OrderItemRepository;
import com.techbyte.bytehub.byteHub.repositories.OrderRepository;
import com.techbyte.bytehub.byteHub.repositories.ProductRepository;
import com.techbyte.bytehub.byteHub.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
	public OrderDTO insert(OrderDTO dto) {
		
    	Order order = new Order();
    	
    	order.setMoment(Instant.now());
    	order.setStatus(OrderStatus.WAITING_PAYMENT);
    	
    	AddressDTO ad = dto.getAddress();
    	Address address = new Address(ad.getId());
    	order.setAddress(address);

    	User user = userService.authenticated();
    	order.setClient(user);
    	
    	for (OrderItemDTO itemDto : dto.getItems()) {
    		Product product = productRepository.getReferenceById(itemDto.getProductId());
    		OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
    		order.getItems().add(item);
    	}
    	
    	repository.save(order);
    	orderItemRepository.saveAll(order.getItems());
    	
    	return new OrderDTO(order);
	}
}
