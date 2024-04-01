package com.dev.BookPlace.dto;


import com.dev.BookPlace.entities.MethodPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class MethodPaymentDTO {

    private Long id;
    private String methodPayment;

    public MethodPaymentDTO(MethodPayment entity) {
        id = entity.getId();
        methodPayment = entity.getMethodPayment();
    }
}
