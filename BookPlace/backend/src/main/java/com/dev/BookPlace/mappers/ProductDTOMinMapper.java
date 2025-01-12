package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.ProductMinDTO;
import com.dev.BookPlace.models.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductImagesDTOMapper.class)
public interface ProductDTOMinMapper {

    ProductMinDTO toProductMinDTO(Product product);

}