package com.dev.BookPlace.factory;

import com.dev.BookPlace.dto.ProductDTO;
import com.dev.BookPlace.dto.ProductMinDTO;
import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.entities.ProductImage;

import java.util.ArrayList;
import java.util.List;

public class ProductFactory {

    public static Product createProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Example Product");
        product.setPrice(100.0);
        product.setCashPrice(90.0);
        product.setInstallmentPrice(30.0);
        product.setDescription("Example description");
        product.setDetails("Example details");
        product.setCreatedAt(null);
        product.setUpdatedAt(null);

        ProductImage productImage = ProductImageFactory.createProductImage();
        List<ProductImage> list = new ArrayList<>();
        list.add(productImage);
        product.setProductImages(list);

        return product;
    }

    public static ProductMinDTO createproductMinDTO () {
        ProductMinDTO productMinDTO = new ProductMinDTO();
        productMinDTO.setId(1L);
        productMinDTO.setName("Example Product");
        productMinDTO.setPrice(100.0);
        productMinDTO.setCashPrice(90.0);
        productMinDTO.setInstallmentPrice(30.0);
        productMinDTO.setDescription("Example description");
        productMinDTO.setDetails("Example details");

        return productMinDTO;
    }

    public static ProductDTO createProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Example Product");
        productDTO.setPrice(100.0);
        productDTO.setCashPrice(90.0);
        productDTO.setInstallmentPrice(30.0);
        productDTO.setDescription("Example description");
        productDTO.setDetails("Example details");
        productDTO.setCreatedAt(null);
        productDTO.setUpdatedAt(null);
        return productDTO;
    }
}
