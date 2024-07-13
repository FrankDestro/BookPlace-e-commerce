package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.ProductDTO;
import com.dev.BookPlace.dto.ProductMinDTO;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.entities.ProductImage;
import com.dev.BookPlace.mappers.CategoryDTOMapper;
import com.dev.BookPlace.mappers.ProductDTOMapper;
import com.dev.BookPlace.mappers.ProductDTOMinMapper;
import com.dev.BookPlace.repositories.CategoryRepository;
import com.dev.BookPlace.repositories.ProductImageRepository;
import com.dev.BookPlace.repositories.ProductRepository;
import com.dev.BookPlace.repositories.specification.ProductSpecification;
import com.dev.BookPlace.services.exceptions.DatabaseException;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductDTOMapper productDTOMapper;
    private final ProductDTOMinMapper productDTOMinMapper;
    private final ProductImageRepository productImageRepository;
    private final CategoryDTOMapper categoryDTOMapper;
    private final ProductSpecification productSpecification;

    public Page<ProductMinDTO> findProductsFilters(String category, Map<String, String> subfilters, Pageable pageable) {
        long categoryId = Long.parseLong(category);

        Map<String, String> filters = subfilters.entrySet().stream()
                .filter(entry -> !entry.getKey().equals("page") &&
                        !entry.getKey().equals("size") &&
                        !entry.getKey().equals("category"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println("filters " + filters);

        Specification<Product> spec = ProductSpecification.withCategoryAndFilters(categoryId, filters);
        Page<Product> productsPage = productRepository.findAll(spec, pageable);
        return productsPage.map(productDTOMinMapper::toProductMinDTO);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("resource not found"));
        ProductDTO productDTO = productDTOMapper.toProductDTO(product);
        return productDTO;
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAllProducts(String name, Pageable pageable) {
        Page<Product> result = productRepository.searchByName(name, pageable);

        for (Product product : result.getContent()) {
            if (!product.getProductImages().isEmpty()) {
                ProductImage firstImage = product.getProductImages().get(0);
                List<ProductImage> list = new ArrayList<>();
                list.add(firstImage);
                result.getContent().get(0).setProductImages(list);
            } else {
                List<ProductImage> listEmpty = new ArrayList<>();
                result.getContent().get(0).setProductImages(listEmpty);
            }
        }

        return result.map(x -> productDTOMinMapper.toProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = productDTOMapper.toEntity(dto);
        entity = productRepository.save(entity);
        return productDTOMapper.toProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            Product entity = productRepository.getReferenceById(id);
            productDTOMapper.updateProductFromDTO(dto, entity);
            entity = productRepository.save(entity);
            return productDTOMapper.toProductDTO(entity);
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
}
