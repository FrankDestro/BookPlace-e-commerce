package com.dev.BookPlace.mappers;


import com.dev.BookPlace.dto.ProductImageDTO;
import com.dev.BookPlace.entities.bookplace.entities.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface ProductImagesDTOMapper {

    ProductImageDTO toProductImagesDTO(ProductImage productImage);
    ProductImage toEntity(ProductImageDTO productImageDTO);

}
