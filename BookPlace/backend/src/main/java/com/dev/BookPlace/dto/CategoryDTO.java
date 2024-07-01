package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.bookplace.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }
}