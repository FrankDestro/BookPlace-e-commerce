package com.dev.BookPlace.entities.pagseguro.request;

import com.dev.BookPlace.entities.pagseguro.entities.QrCode;
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


