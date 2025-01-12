package com.dev.BookPlace.factory;

import com.dev.BookPlace.models.dto.AddressDTO;
import com.dev.BookPlace.models.entities.Address;
import com.dev.BookPlace.mappers.AddressDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressFactory {

    @Autowired
    private AddressDTOMapper addressDTOMapper;

    public static Address createAddress() {
        Address address = new Address(1L, "AV. Noventa e nove", 355, "Apt", "Jardim Cem",
                "Guarulhos", "SP", "BRA", "00090-001", true, UserFactory.createUserClient());
        return address;
    }

    public static AddressDTO createAddressDTO() {
        AddressDTO addressDTO = new AddressDTO(1L, "AV. Noventa e nove", 355, "Apt", "Jardim Cem",
                "Guarulhos", "SP", "BRA", "00090-001", true);
        return addressDTO;
    }
}
