package com.dev.BookPlace.Gateway.request;

import com.dev.BookPlace.Gateway.models.entities.QrCode;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PixOrderRequest extends PaymentOrderRequest {
    private List<QrCode> qr_codes;

}


