package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.CategoryDTO;
import com.dev.BookPlace.models.entities.Category;
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
