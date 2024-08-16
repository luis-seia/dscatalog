package com.seiadev.dscatalog.repositories;

import com.seiadev.dscatalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;
    private long existingId;
    private long nonExistentId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() {
        nonExistentId = 10060L;
        existingId = 1L;
        countTotalProducts = 25;
    }

    @Test
    public void findByIdShouldReturnOptionalProductWhenIdExists() {
        Optional <Product> productOptional = productRepository.findById(existingId);
        Assertions.assertTrue(productOptional.isPresent());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExist() {
        Optional <Product> productOptional = productRepository.findById(nonExistentId);
        Assertions.assertFalse(productOptional.isPresent());
    }

    @Test
    public void saveShouldPersistWhitAutoincrementWhenIdIsNull () {
        Product product = Factory.createProduct();
        product.setId(null);

        product = productRepository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts +1, product.getId());
    }

    @Test
    public void deleteShouldDeleteProductWhenIdExists() {
        productRepository.deleteById(existingId);
        Optional<Product> resultv = productRepository.findById(existingId);
        Assertions.assertFalse(resultv.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessWhenIdDoesNotExist() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            productRepository.deleteById(nonExistentId);
        });
    }
}
