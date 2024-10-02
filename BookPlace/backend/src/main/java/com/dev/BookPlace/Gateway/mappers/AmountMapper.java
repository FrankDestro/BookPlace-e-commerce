package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Amount;
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
