package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.ProductDTO;
import com.dev.BookPlace.models.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {CategoryDTOMapper.class, ProductImagesDTOMapper.class, PropsDTOMapper.class})
public interface ProductDTOMapper {

    ProductDTO toProductDTO(Product product);

    @InheritInverseConfiguration
    Product toEntity(ProductDTO productDTO);

    @Mapping(target = "id", ignore = true)
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}
