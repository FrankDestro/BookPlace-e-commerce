package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.CategoryDTO;
import com.dev.BookPlace.dto.ProductDTO;
import com.dev.BookPlace.dto.ProductImageDTO;
import com.dev.BookPlace.dto.ProductMinDTO;
import com.dev.BookPlace.entities.Category;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.entities.ProductImage;
import com.dev.BookPlace.projections.ProductProjection;
import com.dev.BookPlace.repositories.CategoryRepository;
import com.dev.BookPlace.repositories.ProductRepository;
import com.dev.BookPlace.services.exceptions.DatabaseException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        System.out.println("product camada service " + product);
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAllProducts(String name, Pageable pageable) {
        Page<Product> result = productRepository.searchByName(name, pageable);
        return result.map(x -> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = productRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = productRepository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        entity.setCashPrice(dto.getCashPrice());
        entity.setInstallmentPrice(dto.getInstallmentPrice());
        entity.setDescription(dto.getDescription());
        entity.setDetails(dto.getDetails());
        entity.setCreatedAt(Instant.now());

        entity.getCategories().clear();
        for (CategoryDTO catDto : dto.getCategories()) {
            Category category = categoryRepository.getReferenceById(catDto.getId());
            entity.getCategories().add(category);
        }

        entity.getImages().clear();
        for (ProductImageDTO imageUrlDTO : dto.getProductImages()) {
            ProductImage productImage = new ProductImage();
            productImage.setImageUrl(imageUrlDTO.getImageUrl());
            productImage.setProduct(entity);
            entity.getImages().add(productImage);
        }
    }
}
