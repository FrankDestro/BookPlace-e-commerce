package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.entities.bookplace.entities.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-03T17:39:37-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class AddressDTOMapperImpl implements AddressDTOMapper {

    @Override
    public AddressDTO toAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setNumber( address.getNumber() );
        addressDTO.setComplement( address.getComplement() );
        addressDTO.setLocality( address.getLocality() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setRegionCode( address.getRegionCode() );
        addressDTO.setCountry( address.getCountry() );
        addressDTO.setPostalCode( address.getPostalCode() );
        addressDTO.setMain( address.getMain() );

        return addressDTO;
    }

    @Override
    public Address toAddressEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setStreet( addressDTO.getStreet() );
        address.setNumber( addressDTO.getNumber() );
        address.setComplement( addressDTO.getComplement() );
        address.setLocality( addressDTO.getLocality() );
        address.setCity( addressDTO.getCity() );
        address.setRegionCode( addressDTO.getRegionCode() );
        address.setCountry( addressDTO.getCountry() );
        address.setPostalCode( addressDTO.getPostalCode() );
        address.setMain( addressDTO.getMain() );

        return address;
    }

    @Override
    public void updateAddressFromDTO(AddressDTO addressDTO, Address addressEntity) {
        if ( addressDTO == null ) {
            return;
        }

        addressEntity.setStreet( addressDTO.getStreet() );
        addressEntity.setNumber( addressDTO.getNumber() );
        addressEntity.setComplement( addressDTO.getComplement() );
        addressEntity.setLocality( addressDTO.getLocality() );
        addressEntity.setCity( addressDTO.getCity() );
        addressEntity.setRegionCode( addressDTO.getRegionCode() );
        addressEntity.setCountry( addressDTO.getCountry() );
        addressEntity.setPostalCode( addressDTO.getPostalCode() );
        addressEntity.setMain( addressDTO.getMain() );
    }
}
