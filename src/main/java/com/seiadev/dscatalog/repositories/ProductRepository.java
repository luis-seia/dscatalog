package com.seiadev.dscatalog.repositories;

import com.seiadev.dscatalog.entities.Category;
import com.seiadev.dscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
