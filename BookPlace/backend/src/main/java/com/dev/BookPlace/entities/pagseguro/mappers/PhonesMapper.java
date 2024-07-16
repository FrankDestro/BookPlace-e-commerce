package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring")
public interface PhonesMapper {

    List<com.dev.BookPlace.entities.pagseguro.entities.Phone>
    orderPhonesToPagSeguroPhones(List<Phone> orderPhones);

}
