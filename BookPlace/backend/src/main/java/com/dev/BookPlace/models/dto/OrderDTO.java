package com.dev.BookPlace.models.dto;

import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.OrderItem;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.enums.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {

	private Long id;
	private Instant moment;
	private OrderStatus status;
	private ClientDTO client;
	private AddressDTO address;
	private PaymentDTO payment;
	private PaymentMethod paymentMethod;
	private Double totalSum;

	@NotEmpty(message = "Deve ter pelo menos um item")
	private List<OrderItemDTO> items = new ArrayList<>();

	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentMethod paymentMethod, Double totalSum) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.paymentMethod = paymentMethod;
		this.totalSum = totalSum;
	}

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.client = new ClientDTO(entity.getClient());
		this.paymentMethod = entity.getPaymentMethod();
		this.totalSum = entity.getTotalSum();
		this.payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
//		this.address = new AddressDTO(entity.getAddress());
		for (OrderItem item : entity.getItems()) {
			OrderItemDTO itemDto = new OrderItemDTO(item);
			items.add(itemDto);
		}
	}

	public Double getTotal() {
		double sum = 0.0;
		for (OrderItemDTO item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}
}
