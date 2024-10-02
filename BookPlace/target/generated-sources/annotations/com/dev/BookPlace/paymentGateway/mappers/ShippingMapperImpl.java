package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.models.entities.Address;
import com.dev.BookPlace.Gateway.models.entities.AddressPag;
import com.dev.BookPlace.Gateway.models.entities.Shipping;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T17:46:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Red Hat, Inc.)"
)
@Component
public class ShippingMapperImpl implements ShippingMapper {

    @Override
    public Shipping orderAddressToPagSeguroShipping(Address address) {
        if ( address == null ) {
            return null;
        }

        Shipping shipping = new Shipping();

        shipping.setAddress( addressToAddressPag( address ) );

        return shipping;
    }

    protected AddressPag addressToAddressPag(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressPag addressPag = new AddressPag();

        addressPag.setStreet( address.getStreet() );
        if ( address.getNumber() != null ) {
            addressPag.setNumber( String.valueOf( address.getNumber() ) );
        }
        addressPag.setComplement( address.getComplement() );
        addressPag.setLocality( address.getLocality() );
        addressPag.setCity( address.getCity() );
        addressPag.setRegion_code( address.getRegionCode() );
        addressPag.setCountry( address.getCountry() );
        addressPag.setPostal_code( address.getPostalCode() );
        addressPag.setRegion( address.getCity() );

        return addressPag;
    }
}
