package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.entities.bookplace.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface AddressDTOMapper {
    @Mapping(source = "apelido", target = "nickname")
    AddressDTO toAddressDTO(Address address);

    @Mapping(source = "nickname", target = "apelido")
    Address toAddress(AddressDTO addressDTO);
}
