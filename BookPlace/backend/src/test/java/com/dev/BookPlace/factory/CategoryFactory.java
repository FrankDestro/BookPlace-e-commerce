package com.dev.BookPlace.factory;

import com.dev.BookPlace.dto.CategoryDTO;
import com.dev.BookPlace.entities.Category;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.mappers.CategoryDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

public class CategoryFactory {

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    public static Category createCategory() {
        Set<Product> listProduct = new HashSet<>();
        listProduct.add(ProductFactory.createProduct());

        Category category = new Category(1L, "Fantasia", listProduct);
        return category;
    }

    public static CategoryDTO createCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTO(1L, "Fantasia");
        return categoryDTO;
    }
}
