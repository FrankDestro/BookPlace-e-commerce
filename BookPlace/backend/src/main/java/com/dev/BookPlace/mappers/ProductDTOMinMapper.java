package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.ProductImageDTO;
import com.dev.BookPlace.dto.ProductMinDTO;
import com.dev.BookPlace.entities.bookplace.entities.Product;
import com.dev.BookPlace.entities.bookplace.entities.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductImagesDTOMapper.class)
public interface ProductDTOMinMapper {

    ProductMinDTO toProductMinDTO(Product product);

}