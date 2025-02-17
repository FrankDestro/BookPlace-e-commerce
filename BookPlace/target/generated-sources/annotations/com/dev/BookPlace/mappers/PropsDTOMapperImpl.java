package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.PropsDTO;
import com.dev.BookPlace.models.entities.Props;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
)
@Component
public class PropsDTOMapperImpl implements PropsDTOMapper {

    @Override
    public PropsDTO toPropsDTO(Props props) {
        if ( props == null ) {
            return null;
        }

        PropsDTO propsDTO = new PropsDTO();

        propsDTO.setId( props.getId() );
        propsDTO.setName( props.getName() );
        propsDTO.setPropValue( props.getPropValue() );
        propsDTO.setType( props.getType() );

        return propsDTO;
    }

    @Override
    public Props toPropsEntity(PropsDTO propsDTO) {
        if ( propsDTO == null ) {
            return null;
        }

        Props props = new Props();

        props.setId( propsDTO.getId() );
        props.setName( propsDTO.getName() );
        props.setPropValue( propsDTO.getPropValue() );
        props.setType( propsDTO.getType() );

        return props;
    }
}
