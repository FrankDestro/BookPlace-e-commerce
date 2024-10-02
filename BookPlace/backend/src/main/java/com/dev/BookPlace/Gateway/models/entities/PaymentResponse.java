package com.dev.BookPlace.Gateway.models.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentResponse {
    private String code;
    private String message;
}
