package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.PropsDTO;
import com.dev.BookPlace.entities.bookplace.entities.Props;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PropsDTOMapper {

    PropsDTO toPropsDTO(Props props);

    Props toPropsEntity(PropsDTO propsDTO);

}
