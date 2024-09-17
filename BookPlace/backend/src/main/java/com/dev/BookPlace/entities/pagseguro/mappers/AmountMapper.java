package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.models.entities.Amount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AmountMapper {

    @Mappings({
            @Mapping(target = "summary", ignore = true)
    })
    Amount toAmountCompleted(Amount amount);

}
