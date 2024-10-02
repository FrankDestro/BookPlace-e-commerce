package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.models.entities.Phone;
import com.dev.BookPlace.Gateway.models.entities.PhonePag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PhonesMapper {

    List<PhonePag> orderPhonesToPagSeguroPhones(List<Phone> orderPhones);

}
