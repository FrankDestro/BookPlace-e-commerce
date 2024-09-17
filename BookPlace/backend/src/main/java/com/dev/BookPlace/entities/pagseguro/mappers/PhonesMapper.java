package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.Phone;
import com.dev.BookPlace.entities.pagseguro.models.entities.PhonePag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PhonesMapper {

    List<PhonePag> orderPhonesToPagSeguroPhones(List<Phone> orderPhones);

}
