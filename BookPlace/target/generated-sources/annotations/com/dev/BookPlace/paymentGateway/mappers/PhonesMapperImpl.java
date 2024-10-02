package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.models.entities.Phone;
import com.dev.BookPlace.Gateway.models.entities.PhonePag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T17:46:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Red Hat, Inc.)"
)
@Component
public class PhonesMapperImpl implements PhonesMapper {

    @Override
    public List<PhonePag> orderPhonesToPagSeguroPhones(List<Phone> orderPhones) {
        if ( orderPhones == null ) {
            return null;
        }

        List<PhonePag> list = new ArrayList<PhonePag>( orderPhones.size() );
        for ( Phone phone : orderPhones ) {
            list.add( phoneToPhonePag( phone ) );
        }

        return list;
    }

    protected PhonePag phoneToPhonePag(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhonePag phonePag = new PhonePag();

        phonePag.setId( phone.getId() );
        phonePag.setType( phone.getType() );
        if ( phone.getCountry() != null ) {
            phonePag.setCountry( String.valueOf( phone.getCountry() ) );
        }
        if ( phone.getArea() != null ) {
            phonePag.setArea( String.valueOf( phone.getArea() ) );
        }
        if ( phone.getNumber() != null ) {
            phonePag.setNumber( String.valueOf( phone.getNumber() ) );
        }

        return phonePag;
    }
}
