package com.dev.BookPlace.entities.pagseguro.models.entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TokenData {

    private String requestor_id;
    private String wallet;
    private String cryptogram;
    private String ecommerce_domain;
    private Integer assurance_level;
}
