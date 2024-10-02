package com.dev.BookPlace.Gateway.models.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Holder {

    private String name;
    private String tax_id;
    private String email;
    private AddressPag address;
}
