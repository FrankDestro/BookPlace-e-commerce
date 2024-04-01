package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.MethodPayment;
import com.dev.BookPlace.entities.Payment;
import com.dev.BookPlace.entities.Pix;
import com.dev.BookPlace.enums.StatusPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PaymentDTO {

	private Long id;
	private Instant moment;
	private StatusPayment statusPayment;
	private MethodPayment methodPayment;

	public PaymentDTO(Payment entity) {
		id = entity.getId();
		moment = entity.getMoment();
		statusPayment = entity.getStatusPayment();
		methodPayment = entity.getMethodPayment();
	}
}
