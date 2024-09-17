package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.OrderItem;
import com.dev.BookPlace.entities.pagseguro.models.entities.Item;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T14:21:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class ItemsMapperImpl implements ItemsMapper {

    @Override
    public Item orderItemToItem(OrderItem orderItens) {
        if ( orderItens == null ) {
            return null;
        }

        Item item = new Item();

        item.setName( orderItens.getName() );
        item.setQuantity( orderItens.getQuantity() );

        item.setUnit_amount( convertToCents(orderItens.getUnitAmount()) );

        return item;
    }
}
