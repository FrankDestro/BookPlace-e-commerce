package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.ProductMinDTO;
import com.dev.BookPlace.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductImagesDTOMapper.class)
public interface ProductDTOMinMapper {

    ProductMinDTO toProductMinDTO(Product product);

}