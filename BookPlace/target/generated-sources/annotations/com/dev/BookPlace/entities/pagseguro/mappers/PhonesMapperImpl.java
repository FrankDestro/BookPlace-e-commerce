package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T12:20:40-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class PhonesMapperImpl implements PhonesMapper {

    @Override
    public List<Phone> orderPhonesToPagSeguroPhones(List<com.dev.BookPlace.entities.Phone> orderPhones) {
        if ( orderPhones == null ) {
            return null;
        }

        List<Phone> list = new ArrayList<Phone>( orderPhones.size() );
        for ( com.dev.BookPlace.entities.Phone phone : orderPhones ) {
            list.add( phoneToPhone( phone ) );
        }

        return list;
    }

    protected Phone phoneToPhone(com.dev.BookPlace.entities.Phone phone) {
        if ( phone == null ) {
            return null;
        }

        Phone phone1 = new Phone();

        if ( phone.getCountry() != null ) {
            phone1.setCountry( String.valueOf( phone.getCountry() ) );
        }
        if ( phone.getArea() != null ) {
            phone1.setArea( String.valueOf( phone.getArea() ) );
        }
        if ( phone.getNumber() != null ) {
            phone1.setNumber( String.valueOf( phone.getNumber() ) );
        }
        phone1.setType( phone.getType() );

        return phone1;
    }
}
