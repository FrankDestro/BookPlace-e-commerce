package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.Gateway.models.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    @Mapping(source = "client.fullName", target = "name")
    @Mapping(source = "client.email", target = "email")
    @Mapping(source = "client.cpf", target = "tax_id")
    Customer orderClientToPagSeguroCustomer(Order order);
}
