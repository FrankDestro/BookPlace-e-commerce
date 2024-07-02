package com.dev.BookPlace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
