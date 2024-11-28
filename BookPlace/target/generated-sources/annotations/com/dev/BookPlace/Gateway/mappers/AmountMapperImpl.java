package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Amount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
)
@Component
public class AmountMapperImpl implements AmountMapper {

    @Override
    public Amount toAmountCompleted(Amount amount) {
        if ( amount == null ) {
            return null;
        }

        Amount amount1 = new Amount();

        amount1.setValue( amount.getValue() );
        amount1.setCurrency( amount.getCurrency() );

        return amount1;
    }
}
