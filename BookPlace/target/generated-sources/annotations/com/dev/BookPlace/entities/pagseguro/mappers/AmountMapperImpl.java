package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.models.entities.Amount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T14:21:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
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
