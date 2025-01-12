package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Item;
import com.dev.BookPlace.Gateway.response.PagSeguroBarCodeResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
)
@Component
public class BarCodeResponseMapperImpl implements BarCodeResponseMapper {

    @Override
    public PagSeguroBarCodeResponse toBarCodeResponse(PagSeguroBarCodeResponse pagSeguroBarCodeResponse) {
        if ( pagSeguroBarCodeResponse == null ) {
            return null;
        }

        PagSeguroBarCodeResponse pagSeguroBarCodeResponse1 = new PagSeguroBarCodeResponse();

        pagSeguroBarCodeResponse1.setId( pagSeguroBarCodeResponse.getId() );
        pagSeguroBarCodeResponse1.setCreated_at( pagSeguroBarCodeResponse.getCreated_at() );
        pagSeguroBarCodeResponse1.setCustomer( pagSeguroBarCodeResponse.getCustomer() );
        List<Item> list = pagSeguroBarCodeResponse.getItems();
        if ( list != null ) {
            pagSeguroBarCodeResponse1.setItems( new ArrayList<Item>( list ) );
        }
        pagSeguroBarCodeResponse1.setShipping( pagSeguroBarCodeResponse.getShipping() );
        List<String> list1 = pagSeguroBarCodeResponse.getNotification_urls();
        if ( list1 != null ) {
            pagSeguroBarCodeResponse1.setNotification_urls( new ArrayList<String>( list1 ) );
        }
        pagSeguroBarCodeResponse1.setReference_id( pagSeguroBarCodeResponse.getReference_id() );

        return pagSeguroBarCodeResponse1;
    }
}
