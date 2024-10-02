package com.dev.BookPlace.mappers;


import com.dev.BookPlace.models.dto.ProductImageDTO;
import com.dev.BookPlace.models.entities.ProductImage;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface ProductImagesDTOMapper {

    ProductImageDTO toProductImagesDTO(ProductImage productImage);
    ProductImage toEntity(ProductImageDTO productImageDTO);

}
