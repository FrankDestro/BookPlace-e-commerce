package com.dev.BookPlace.repositories;

import com.dev.BookPlace.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository <ProductImage, Long> {

    @Query("SELECT obj FROM ProductImage obj " +
            "WHERE obj.product.id = :productId")
    List<ProductImage> findAllProductImagesByIdProduct(Long productId);

}
