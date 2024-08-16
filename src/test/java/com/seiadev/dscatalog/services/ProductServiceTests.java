package com.seiadev.dscatalog.services;

import com.seiadev.dscatalog.dto.ProductDTO;
import com.seiadev.dscatalog.entities.Product;
import com.seiadev.dscatalog.repositories.Factory;
import com.seiadev.dscatalog.repositories.ProductRepository;
import com.seiadev.dscatalog.services.exceptions.DatabaseException;
import com.seiadev.dscatalog.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class ProductServiceTests {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;
    private long existingId;
    private long nonExistentId;
    private long dependentId;
    private PageImpl<Product> page;
    private Product product;

    @BeforeEach
    void setUp() {
        existingId = 1L;
        nonExistentId = 2231L;
        dependentId = 3L;
        product = Factory.createProduct();
        page = new PageImpl<>(List.of(product) );

        Mockito.when(productRepository.save(ArgumentMatchers.any(Product.class))).thenReturn(product);
        Mockito.when(productRepository.findAll((Pageable) ArgumentMatchers.any())).thenReturn(page);
        Mockito.when(productRepository.findById(existingId)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Mockito.doNothing().when(productRepository).deleteById(existingId);
        Mockito.doThrow(EmptyResultDataAccessException.class).when(productRepository).deleteById(nonExistentId);
        Mockito.doThrow(DataIntegrityViolationException.class).when(productRepository).deleteById(dependentId);
    } 

    @Test
    public void findAllPagedShouldReturnPage(){
        Pageable pageable = PageRequest.of(0, 10);

        Page<ProductDTO> products = productService.findAllPaged(pageable);

        Assertions.assertNotNull(products);
        Mockito.verify(productRepository, Mockito.times(1)).findAll(pageable);
    }


    @Test
    public void deleteShouldThrowDataIntegrityViolationExceptionWhenDependentIdI() {
        Assertions.assertThrows(DatabaseException.class, () ->{
           productService.delete(dependentId);
        });
    }

    @Test
    public void deleteShouldResourceNotFoundExceptionWhenIdNoExists() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> productService.delete(nonExistentId));
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(nonExistentId);
    }

    @Test
    public void deleteShouldDoNothingWhenIdExists() {
        Assertions.assertDoesNotThrow(() -> productService.delete(existingId));
        Mockito.verify(productRepository, Mockito.times(1)).deleteById(existingId);
    }
}
