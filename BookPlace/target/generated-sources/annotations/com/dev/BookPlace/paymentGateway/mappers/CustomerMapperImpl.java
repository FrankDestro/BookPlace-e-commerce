package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.User;
import com.dev.BookPlace.Gateway.models.entities.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T17:46:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Red Hat, Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer orderClientToPagSeguroCustomer(Order order) {
        if ( order == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( orderClientFullName( order ) );
        customer.setEmail( orderClientEmail( order ) );
        customer.setTax_id( orderClientCpf( order ) );

        return customer;
    }

    private String orderClientFullName(Order order) {
        if ( order == null ) {
            return null;
        }
        User client = order.getClient();
        if ( client == null ) {
            return null;
        }
        String fullName = client.getFullName();
        if ( fullName == null ) {
            return null;
        }
        return fullName;
    }

    private String orderClientEmail(Order order) {
        if ( order == null ) {
            return null;
        }
        User client = order.getClient();
        if ( client == null ) {
            return null;
        }
        String email = client.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private String orderClientCpf(Order order) {
        if ( order == null ) {
            return null;
        }
        User client = order.getClient();
        if ( client == null ) {
            return null;
        }
        String cpf = client.getCpf();
        if ( cpf == null ) {
            return null;
        }
        return cpf;
    }
}
