package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.models.entities.QrCode;
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
public class QrCodeMapperImpl implements QrCodeMapper {

    @Override
    public QrCode toQrcodeCompleted(QrCode qrCode) {
        if ( qrCode == null ) {
            return null;
        }

        QrCode qrCode1 = new QrCode();

        qrCode1.setId( qrCode.getId() );
        qrCode1.setExpiration_date( qrCode.getExpiration_date() );
        qrCode1.setText( qrCode.getText() );

        return qrCode1;
    }

    @Override
    public List<String> toListArrangements(List<String> arrangements) {
        if ( arrangements == null ) {
            return null;
        }

        List<String> list = new ArrayList<String>( arrangements.size() );
        for ( String string : arrangements ) {
            list.add( string );
        }

        return list;
    }
}
