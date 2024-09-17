package com.dev.BookPlace.entities.pagseguro.mappers;


import com.dev.BookPlace.entities.pagseguro.models.entities.Link;
import com.dev.BookPlace.entities.pagseguro.models.entities.LinkQrcodes;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface LinksMapper {

    List<Link> toListLinks(List<Link> arrangements);

    List<LinkQrcodes> toListLinksQrcode(List<LinkQrcodes> qrcodes);


}
