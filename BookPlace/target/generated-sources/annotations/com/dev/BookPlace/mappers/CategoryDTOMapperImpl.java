package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.CategoryDTO;
import com.dev.BookPlace.models.entities.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T17:46:26-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Red Hat, Inc.)"
)
@Component
public class CategoryDTOMapperImpl implements CategoryDTOMapper {

    @Override
    public CategoryDTO toCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }

    @Override
    public Category toCategoryEntity(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setName( categoryDTO.getName() );

        return category;
    }

    @Override
    public void updateCategoryFromDTO(CategoryDTO categoryDTO, Category category) {
        if ( categoryDTO == null ) {
            return;
        }

        category.setName( categoryDTO.getName() );
    }
}
