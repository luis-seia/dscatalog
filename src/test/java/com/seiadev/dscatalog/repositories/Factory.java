package com.seiadev.dscatalog.repositories;

import com.seiadev.dscatalog.dto.ProductDTO;
import com.seiadev.dscatalog.entities.Category;
import com.seiadev.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {
    public static Product createProduct(){
        Product product = new Product(1L, "phone", "Good phone", 800.0, "https://img.com/img.png", Instant.parse("2024-10-20T03:00:00Z"));
        product.getCategories().add(new Category(1L, "Livros"));
        return product;
    }

    public static ProductDTO createProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }
}
