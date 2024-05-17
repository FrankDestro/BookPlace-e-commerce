package com.dev.BookPlace.entities.pagSeguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class AddresssShipping {

    private Long id;
    private String street;
    private String number;
    private String complement;
    private String locality;
    private String city;
    private String region_code;
    private String country;
    private String postal_code;
}
