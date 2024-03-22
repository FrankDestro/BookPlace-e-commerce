package com.techbyte.bytehub.byteHub.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.techbyte.bytehub.byteHub.entities.Order;
import com.techbyte.bytehub.byteHub.entities.OrderItem;
import com.techbyte.bytehub.byteHub.entities.enums.OrderStatus;

import jakarta.validation.constraints.NotEmpty;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDTO client;
	
	private PaymentDTO payment;
	
	private AddressDTO address;
	
	@NotEmpty(message = "Deve ter pelo menos um item")
	private List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment, AddressDTO address) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
		this.address = address;
	}
	
	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.client = new ClientDTO(entity.getClient());
		this.address = new AddressDTO(entity.getAddress());
		this.payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
		for (OrderItem item : entity.getItems()) {
			OrderItemDTO itemDto = new OrderItemDTO(item);
			items.add(itemDto);
		}
		
 	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}
	
	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItemDTO item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}
}
