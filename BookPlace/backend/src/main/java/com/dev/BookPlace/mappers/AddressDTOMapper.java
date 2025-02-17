package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.AddressDTO;
import com.dev.BookPlace.models.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface AddressDTOMapper {

    AddressDTO toAddressDTO(Address address);

    Address toAddressEntity(AddressDTO addressDTO);

    @Mapping(target = "id", ignore = true)
    void updateAddressFromDTO(AddressDTO addressDTO, @MappingTarget Address addressEntity);

}
