package com.dev.BookPlace.entities.pagseguro.entities;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroBarCodeResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Charge {
    private String id;
    private String reference_id;
    private String status;
    private String created_at;
    private String description;
    private Amount amount;
    private PaymentResponse payment_response;
    private PaymentMethod payment_method = new PaymentMethod();
    private List<Link> links;

}
