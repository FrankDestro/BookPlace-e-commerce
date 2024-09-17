package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.models.entities.Item;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T14:21:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class PixResponseMapperImpl implements PixResponseMapper {

    @Override
    public PagSeguroPixResponse toPagSeguroPixResponse(PagSeguroPixResponse pixResponse) {
        if ( pixResponse == null ) {
            return null;
        }

        PagSeguroPixResponse pagSeguroPixResponse = new PagSeguroPixResponse();

        pagSeguroPixResponse.setId( pixResponse.getId() );
        pagSeguroPixResponse.setCreated_at( pixResponse.getCreated_at() );
        pagSeguroPixResponse.setCustomer( pixResponse.getCustomer() );
        List<Item> list = pixResponse.getItems();
        if ( list != null ) {
            pagSeguroPixResponse.setItems( new ArrayList<Item>( list ) );
        }
        pagSeguroPixResponse.setShipping( pixResponse.getShipping() );
        List<String> list1 = pixResponse.getNotification_urls();
        if ( list1 != null ) {
            pagSeguroPixResponse.setNotification_urls( new ArrayList<String>( list1 ) );
        }

        return pagSeguroPixResponse;
    }
}
