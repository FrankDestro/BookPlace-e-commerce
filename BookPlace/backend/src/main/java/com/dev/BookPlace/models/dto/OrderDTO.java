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

	public OrderDTO(Order entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.status = entity.getStatus();
		this.client = new ClientDTO(entity.getClient());
		this.paymentMethod = entity.getPaymentMethod();
		this.totalSum = entity.getTotalSum();
		if (entity.getPayment() != null) {
			this.payment = new PaymentDTO(entity.getPayment());
		}

		for (OrderItem item : entity.getItems()) {
			OrderItemDTO itemDto = new OrderItemDTO(item);
			items.add(itemDto);
		}
	}
}
