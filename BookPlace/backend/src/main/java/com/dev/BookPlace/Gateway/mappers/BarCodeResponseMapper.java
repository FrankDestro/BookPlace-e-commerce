package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.response.PagSeguroBarCodeResponse;
import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface BarCodeResponseMapper {

    BarCodeResponseMapper INSTANCE = Mappers.getMapper(BarCodeResponseMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "created_at", target = "created_at")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "shipping", target = "shipping")
    @Mapping(source = "notification_urls", target = "notification_urls")
    @Mapping(target = "charges", ignore = true)
    @Mapping(target = "links", ignore = true)
    PagSeguroBarCodeResponse toBarCodeResponse(PagSeguroBarCodeResponse pagSeguroBarCodeResponse);
}
