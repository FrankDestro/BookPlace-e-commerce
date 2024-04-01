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
    private String address;
    private Integer number;
    private String addressDetails;
    private String neighborhood;
    private String zip;
    private Boolean main;

    public AddressDTO(Address entity) {
        this.id = entity.getId();
        this.address = entity.getAddress();
        this.number = entity.getNumber();
        this.addressDetails = entity.getAddress();
        this.neighborhood = entity.getNeighborhood();
        this.zip = entity.getZip();
        this.main = entity.getMain();
    }
}
