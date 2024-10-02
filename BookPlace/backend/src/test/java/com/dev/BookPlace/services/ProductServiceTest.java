package com.dev.BookPlace.services;

import com.dev.BookPlace.models.dto.ProductDTO;
import com.dev.BookPlace.models.dto.ProductMinDTO;
import com.dev.BookPlace.models.entities.Product;
import com.dev.BookPlace.factory.ProductFactory;
import com.dev.BookPlace.mappers.ProductDTOMapper;
import com.dev.BookPlace.mappers.ProductDTOMinMapper;
import com.dev.BookPlace.repositories.ProductRepository;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDTOMapper productDTOMapper;

    @Mock
    private ProductDTOMinMapper productDTOMinMapper;

    private long existingId;
    private long nonExistingId;
    private long dependentId;
    private Product product;
    private ProductDTO productDTO;
    private ProductMinDTO productMinDTO;
    private PageImpl<Product> page;
    private String productName;

    @BeforeEach
    void SetUp() {
        existingId = 1L;
        nonExistingId = 2L;
        dependentId = 3L;
        product = ProductFactory.createProduct();
        productMinDTO = ProductFactory.createproductMinDTO();
        productDTO = ProductFactory.createProductDTO();
        page = new PageImpl<>(List.of(product));
        productName = "Example Product";
        Pageable pageable = PageRequest.of(0, 12);

        // findById
        when(productRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(product));
        when(productRepository.findById(existingId)).thenReturn(Optional.of(product));
        when(productRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // findAll
        when(productRepository.searchByName(productName, pageable)).thenReturn(page);

        // insert / update
        when(productRepository.save(any())).thenReturn(product);

        // delete
        doNothing().when(productRepository).deleteById(existingId);
        when(productRepository.existsById(existingId)).thenReturn(true);
        when(productRepository.existsById(nonExistingId)).thenReturn(false);
        when(productRepository.existsById(dependentId)).thenReturn(true);
        doThrow(DataIntegrityViolationException.class).when(productRepository).deleteById(dependentId);

        // update
        when(productRepository.getReferenceById(existingId)).thenReturn(product);
        when(productRepository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);

        // Mapper
        when(productDTOMapper.toProductDTO(product)).thenReturn(productDTO);
        when(productDTOMapper.toProductDTO(product)).thenReturn(productDTO);
        when(productDTOMinMapper.toProductMinDTO(product)).thenReturn(productMinDTO);
    }

    @Test
    void findByIdShouldReturnProductDTOWhenIdExists() {
        ProductDTO result = productService.findById(existingId);

        assertNotNull(result);
        assertEquals(result.getId(), product.getId());
        assertEquals(result.getName(), product.getName());

        verify(productRepository, times(1)).findById(existingId);
    }

    @Test
    void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {

        assertThrows(ResourceNotFoundException.class, () -> {
            productService.findById(nonExistingId);
        });
        verify(productRepository, times(1)).findById(nonExistingId);
    }

    @Test
    void insertShouldReturnProductDTO() {
        ProductDTO result = productService.insert(productDTO);
        assertNotNull(result);
        assertEquals(result.getName(), productDTO.getName());
    }

    @Test
    public void deleteShouldThrowDatabaseExceptionWhenDependentId() {
        assertThrows(DatabaseException.class, () -> {
            productService.delete(dependentId);
        });
        verify(productRepository, times(1)).deleteById(dependentId);
    }

    @Test
    void deleteShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
        assertThrows(ResourceNotFoundException.class, () -> {
            productService.delete(nonExistingId);
        });
        verify(productRepository, times(1)).existsById(nonExistingId);
    }

    @Test
    void deleteShouldDoNothingWhenIdExists() {
        assertDoesNotThrow(() -> {
            productService.delete(existingId);
        });
        verify(productRepository, times(1)).deleteById(existingId);
    }

    @Test
    void updateShouldReturnProductDTOWhenIdExists() {
        ProductDTO result = productService.update(existingId, productDTO);

        assertNotNull(result);
        assertEquals(result.getId(), productDTO.getId());
        assertEquals(result.getName(), productDTO.getName());
    }

    @Test
    void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExists() {
        assertThrows(ResourceNotFoundException.class, () -> {
            ProductDTO result = productService.update(nonExistingId, productDTO);
        });
    }

    @Test
    void findAllProductsShouldReturnPageProductMinDTO() {
        Pageable pageable = PageRequest.of(0, 12);

        Page<ProductMinDTO> result = productService.findAllProducts(productName, pageable);

        assertNotNull(result);
        assertEquals(result.getSize(), 1);
        assertEquals(result.iterator().next().getName(), productName);
    }


    @Test
    void findAllProductsShouldReturnPageProductMinDTOWithEmptyImages() {
        product.setProductImages(Collections.emptyList());
        Pageable pageable = PageRequest.of(0, 12);

        Page<ProductMinDTO> result = productService.findAllProducts(productName, pageable);

        assertNotNull(result);
        assertEquals(result.getSize(), 1);
        assertEquals(result.iterator().next().getName(), productName);
        assertTrue(result.iterator().next().getProductImages().isEmpty());
    }

}
