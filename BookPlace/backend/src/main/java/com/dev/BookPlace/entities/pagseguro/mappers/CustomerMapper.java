package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.Order;
import com.dev.BookPlace.entities.pagseguro.models.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    @Mapping(source = "client.fullName", target = "name")
    @Mapping(source = "client.email", target = "email")
    @Mapping(source = "client.cpf", target = "tax_id")
    Customer orderClientToPagSeguroCustomer(Order order);
}
