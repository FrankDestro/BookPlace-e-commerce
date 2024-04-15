package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.Address;
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

    public AddressDTO(Address addressEntity) {
        id = addressEntity.getId();
        street = addressEntity.getStreet();
        number = addressEntity.getNumber();
        complement = addressEntity.getComplement();
        locality = addressEntity.getLocality();
        city = addressEntity.getCity();
        regionCode = addressEntity.getRegionCode();
        country = addressEntity.getCountry();
        postalCode = addressEntity.getPostalCode();
        main = addressEntity.getMain();
    }
}
