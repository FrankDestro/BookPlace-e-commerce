package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.CategoryDTO;
import com.dev.BookPlace.dto.ProductDTO;
import com.dev.BookPlace.entities.bookplace.entities.Category;
import com.dev.BookPlace.entities.bookplace.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryDTOMapper {

    CategoryDTO toCategoryDTO(Category category);

    Category toCategoryEntity(CategoryDTO categoryDTO);

    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDTO(CategoryDTO categoryDTO, @MappingTarget Category category);

}
