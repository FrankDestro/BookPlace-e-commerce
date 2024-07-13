package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.CategoryDTO;
import com.dev.BookPlace.entities.Category;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.factory.CategoryFactory;
import com.dev.BookPlace.factory.ProductFactory;
import com.dev.BookPlace.mappers.CategoryDTOMapper;
import com.dev.BookPlace.repositories.CategoryRepository;
import com.dev.BookPlace.services.exceptions.DatabaseException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryDTOMapper categoryDTOMapper;

    private long existingCategoryId;
    private long nonExistingCategoryId;
    private long dependentId;
    private Product product;
    private Category category;
    private List<Category> listCategory;
    private CategoryDTO categoryDTO;

    @BeforeEach
    void SetUp() {
        existingCategoryId = 1L;
        nonExistingCategoryId = 2L;
        dependentId = 3L;
        product = ProductFactory.createProduct();
        category = CategoryFactory.createCategory();
        categoryDTO = CategoryFactory.createCategoryDTO();
        listCategory = Arrays.asList(category);
    }

    @Test
    void findAllShouldReturnListCategoryDTO() {
        when(categoryRepository.findAll()).thenReturn(listCategory);
        when(categoryDTOMapper.toCategoryDTO(category)).thenReturn(categoryDTO);

        List<CategoryDTO> result = categoryService.findAll();

        assertNotNull(result);
    }

    @Test
    void findByIdShouldReturnCategoryDTO() {
        when(categoryRepository.findById(existingCategoryId)).thenReturn(Optional.of(category));
        when(categoryDTOMapper.toCategoryDTO(category)).thenReturn(categoryDTO);

        CategoryDTO result = categoryService.findById(existingCategoryId);

        assertNotNull(result);
    }

    @Test
    void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
        when(categoryRepository.findById(nonExistingCategoryId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            categoryService.findById(nonExistingCategoryId);
        });
    }

    @Test
    void insertShouldReturnCategoryDTO() {
        when(categoryDTOMapper.toCategoryEntity(categoryDTO)).thenReturn(category);
        when(categoryDTOMapper.toCategoryDTO(category)).thenReturn(categoryDTO);
        when(categoryRepository.save(ArgumentMatchers.any())).thenReturn(category);

        CategoryDTO result = categoryService.insert(categoryDTO);

        assertNotNull(result);

        verify(categoryRepository, times(1)).save(category);
        verify(categoryDTOMapper, times(1)).toCategoryEntity(categoryDTO);
        verify(categoryDTOMapper, times(1)).toCategoryDTO(category);
    }

    @Test
    void updateShouldReturnCategoryDTO() {
        when(categoryRepository.getReferenceById(existingCategoryId)).thenReturn(category);
        doNothing().when(categoryDTOMapper).updateCategoryFromDTO(categoryDTO, category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryDTOMapper.toCategoryDTO(category)).thenReturn(categoryDTO);

        CategoryDTO result = categoryService.update(existingCategoryId, categoryDTO);

        assertNotNull(result);

        verify(categoryRepository, times(1)).save(category);

    }

    @Test
    void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {

        when(categoryRepository.getReferenceById(nonExistingCategoryId)).thenReturn(null);
        doThrow(EntityNotFoundException.class).when(categoryRepository).getReferenceById(nonExistingCategoryId);

        assertThrows(ResourceNotFoundException.class, () -> {
            categoryService.update(nonExistingCategoryId, categoryDTO);
        });

    }

    @Test
    public void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
        assertThrows(ResourceNotFoundException.class, () -> {
            categoryService.delete(nonExistingCategoryId);
        });
        verify(categoryRepository, times(1)).existsById(nonExistingCategoryId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        doNothing().when(categoryRepository).delete(any());
        when(categoryRepository.existsById(anyLong())).thenReturn(true);

        categoryService.delete(1L);
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenDependentId() {
        doNothing().when(categoryRepository).delete(any());
        when(categoryRepository.existsById(anyLong())).thenReturn(true);
        doThrow(DataIntegrityViolationException.class).when(categoryRepository).deleteById(dependentId);

        assertThrows(DatabaseException.class, () -> {
            categoryService.delete(dependentId);
        });
    }
}