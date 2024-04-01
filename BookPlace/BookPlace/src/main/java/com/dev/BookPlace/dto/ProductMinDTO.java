package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.Category;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.entities.ProductImage;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductMinDTO {

    private Long id;
    private String name;
    private Double price;
    private Double cashPrice;
    private Double installmentPrice;
    private String description;
    private String details;

    private List<ProductImageDTO> productImages = new ArrayList<>();

    public ProductMinDTO(Product productEntity) {
        id = productEntity.getId();
        name = productEntity.getName();
        price = productEntity.getPrice();
        cashPrice = productEntity.getCashPrice();
        installmentPrice = productEntity.getInstallmentPrice();
        description = productEntity.getDescription();
        details = productEntity.getDetails();

        if (!productEntity.getImages().isEmpty()) {
            ProductImage firstImage = productEntity.getImages().get(0);
            productImages.add(new ProductImageDTO(firstImage));
        }
    }
}
