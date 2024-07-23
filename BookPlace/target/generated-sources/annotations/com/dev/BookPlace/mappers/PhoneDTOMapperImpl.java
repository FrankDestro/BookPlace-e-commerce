package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-22T16:56:01-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class PhoneDTOMapperImpl implements PhoneDTOMapper {

    @Override
    public PhoneDTO toPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setUserId( map( phone.getClient() ) );
        phoneDTO.setId( phone.getId() );
        phoneDTO.setCountry( phone.getCountry() );
        phoneDTO.setArea( phone.getArea() );
        phoneDTO.setNumber( phone.getNumber() );
        phoneDTO.setType( phone.getType() );

        return phoneDTO;
    }

    @Override
    public Phone toPhoneEntity(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setCountry( phoneDTO.getCountry() );
        phone.setArea( phoneDTO.getArea() );
        phone.setNumber( phoneDTO.getNumber() );
        phone.setType( phoneDTO.getType() );

        return phone;
    }

    @Override
    public void updatePhoneFromDTO(PhoneDTO phoneDTO, Phone phone) {
        if ( phoneDTO == null ) {
            return;
        }

        phone.setCountry( phoneDTO.getCountry() );
        phone.setArea( phoneDTO.getArea() );
        phone.setNumber( phoneDTO.getNumber() );
        phone.setType( phoneDTO.getType() );
    }

    @Override
    public List<Phone> toPhoneList(List<PhoneDTO> phoneDTOList) {
        if ( phoneDTOList == null ) {
            return null;
        }

        List<Phone> list = new ArrayList<Phone>( phoneDTOList.size() );
        for ( PhoneDTO phoneDTO : phoneDTOList ) {
            list.add( toPhoneEntity( phoneDTO ) );
        }

        return list;
    }
}
