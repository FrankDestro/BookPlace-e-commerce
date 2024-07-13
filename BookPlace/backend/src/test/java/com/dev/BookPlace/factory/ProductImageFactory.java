package com.dev.BookPlace.factory;

import com.dev.BookPlace.entities.Product;
import com.dev.BookPlace.entities.ProductImage;

public class ProductImageFactory {

    public static ProductImage createProductImage() {
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

        ProductImage images = new ProductImage(3L, product, "urlImages");

        return images;
    }
}
