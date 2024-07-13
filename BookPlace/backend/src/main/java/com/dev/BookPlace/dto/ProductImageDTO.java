package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.ProductImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProductImageDTO {

    private Long id;
    private String imageUrl;

    public ProductImageDTO(ProductImage productImageEntity) {
        this.id = productImageEntity.getId();
        this.imageUrl = productImageEntity.getImageUrl();
    }

}
