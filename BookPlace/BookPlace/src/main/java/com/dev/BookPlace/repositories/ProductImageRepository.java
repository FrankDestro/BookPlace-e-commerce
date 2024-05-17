package com.dev.BookPlace.repositories;

import com.dev.BookPlace.entities.bookplace.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepository extends JpaRepository <ProductImage, Long> {
}
