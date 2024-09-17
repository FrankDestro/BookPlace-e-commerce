package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.pagseguro.models.entities.Shipping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel="spring")
public interface ShippingMapper {

    @Mappings({
            @Mapping(source = "address.street", target = "address.street"),
            @Mapping(source = "address.number", target = "address.number"),
            @Mapping(source = "address.complement", target = "address.complement"),
            @Mapping(source = "address.locality", target = "address.locality"),
            @Mapping(source = "address.city", target = "address.city"),
            @Mapping(source = "address.regionCode", target = "address.region_code"),
            @Mapping(source = "address.country", target = "address.country"),
            @Mapping(source = "address.postalCode", target = "address.postal_code"),
            @Mapping(source = "address.city", target = "address.region")
    })
    Shipping orderAddressToPagSeguroShipping(Address address);
}
