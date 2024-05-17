package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.bookplace.entities.Category;
import com.dev.BookPlace.entities.bookplace.entities.Product;
import com.dev.BookPlace.entities.bookplace.entities.ProductImage;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductDTO {

    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisar ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    private Double price;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    private Double cashPrice;
    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    private Double installmentPrice;
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String description;
    @Size(min = 10, message = "detalhes precisa ter no mínimo 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String details;
    private Instant createdAt;
    private Instant updatedAt;

    private String author;
    private Integer pages;
    private String language;
    private String publishingCompany;
    private String publicationDate;
    private String isbn10;
    private String isbn13;
    private String dimensions;
    private String format;

    @NotEmpty(message = "Produto sem categoria não é permitido")
    private List<CategoryDTO> categories = new ArrayList<>();

    private List<ProductImageDTO> productImages = new ArrayList<>();

    public ProductDTO(Product productEntity) {
        id = productEntity.getId();
        name = productEntity.getName();
        price = productEntity.getPrice();
        cashPrice = productEntity.getCashPrice();
        installmentPrice = productEntity.getInstallmentPrice();
        description = productEntity.getDescription();
        details = productEntity.getDetails();
        createdAt = productEntity.getCreatedAt();
        updatedAt = productEntity.getUpdatedAt();
        author = productEntity.getAuthor();
        pages = productEntity.getPages();
        language = productEntity.getLanguage();
        publishingCompany = productEntity.getPublishingCompany();
        publicationDate = productEntity.getPublicationDate();
        isbn10 = productEntity.getIsbn10();
        isbn13 = productEntity.getIsbn13();
        dimensions = productEntity.getDimensions();
        format = productEntity.getFormat();

        for (Category cat : productEntity.getCategories()) {
            categories.add(new CategoryDTO(cat));
        }
        for (ProductImage images : productEntity.getImages()) {
            productImages.add(new ProductImageDTO(images));
        }
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
    }
}
