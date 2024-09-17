package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.ProductImageDTO;
import com.dev.BookPlace.entities.ProductImage;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T14:21:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class ProductImagesDTOMapperImpl implements ProductImagesDTOMapper {

    @Override
    public ProductImageDTO toProductImagesDTO(ProductImage productImage) {
        if ( productImage == null ) {
            return null;
        }

        ProductImageDTO productImageDTO = new ProductImageDTO();

        productImageDTO.setId( productImage.getId() );
        productImageDTO.setImageUrl( productImage.getImageUrl() );

        return productImageDTO;
    }

    @Override
    public ProductImage toEntity(ProductImageDTO productImageDTO) {
        if ( productImageDTO == null ) {
            return null;
        }

        ProductImage productImage = new ProductImage();

        productImage.setId( productImageDTO.getId() );
        productImage.setImageUrl( productImageDTO.getImageUrl() );

        return productImage;
    }
}
