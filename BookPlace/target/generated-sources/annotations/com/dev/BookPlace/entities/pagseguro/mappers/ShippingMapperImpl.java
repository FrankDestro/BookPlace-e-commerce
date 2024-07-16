package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.pagseguro.entities.Shipping;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T12:20:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class ShippingMapperImpl implements ShippingMapper {

    @Override
    public Shipping orderAddressToPagSeguroShipping(Address address) {
        if ( address == null ) {
            return null;
        }

        Shipping shipping = new Shipping();

        shipping.setAddress( addressToAddress( address ) );

        return shipping;
    }

    protected com.dev.BookPlace.entities.pagseguro.entities.Address addressToAddress(Address address) {
        if ( address == null ) {
            return null;
        }

        com.dev.BookPlace.entities.pagseguro.entities.Address address1 = new com.dev.BookPlace.entities.pagseguro.entities.Address();

        address1.setStreet( address.getStreet() );
        if ( address.getNumber() != null ) {
            address1.setNumber( String.valueOf( address.getNumber() ) );
        }
        address1.setComplement( address.getComplement() );
        address1.setLocality( address.getLocality() );
        address1.setCity( address.getCity() );
        address1.setRegion_code( address.getRegionCode() );
        address1.setCountry( address.getCountry() );
        address1.setPostal_code( address.getPostalCode() );
        address1.setRegion( address.getCity() );

        return address1;
    }
}
