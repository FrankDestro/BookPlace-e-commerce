package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Link;
import com.dev.BookPlace.Gateway.models.entities.LinkQrcodes;
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
public class LinksMapperImpl implements LinksMapper {

    @Override
    public List<Link> toListLinks(List<Link> arrangements) {
        if ( arrangements == null ) {
            return null;
        }

        List<Link> list = new ArrayList<Link>( arrangements.size() );
        for ( Link link : arrangements ) {
            list.add( link );
        }

        return list;
    }

    @Override
    public List<LinkQrcodes> toListLinksQrcode(List<LinkQrcodes> qrcodes) {
        if ( qrcodes == null ) {
            return null;
        }

        List<LinkQrcodes> list = new ArrayList<LinkQrcodes>( qrcodes.size() );
        for ( LinkQrcodes linkQrcodes : qrcodes ) {
            list.add( linkQrcodes );
        }

        return list;
    }
}
