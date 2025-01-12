package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Item;
import com.dev.BookPlace.models.entities.OrderItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
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
