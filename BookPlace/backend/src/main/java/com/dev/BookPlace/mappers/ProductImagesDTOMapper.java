package com.dev.BookPlace.mappers;


import com.dev.BookPlace.dto.ProductImageDTO;
import com.dev.BookPlace.entities.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ProductImagesDTOMapper {

    ProductImageDTO toProductImagesDTO(ProductImage productImage);
    ProductImage toEntity(ProductImageDTO productImageDTO);

}
