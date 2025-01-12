package com.dev.BookPlace.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class AddressDTO {

    private Long id;
    private String street;
    private Integer number;
    private String complement;
    private String locality;
    private String city;
    private String regionCode;
    private String country;
    private String postalCode;
    private Boolean main;

}
