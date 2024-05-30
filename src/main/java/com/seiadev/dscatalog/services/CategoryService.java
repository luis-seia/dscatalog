package com.seiadev.dscatalog.services;

import com.seiadev.dscatalog.entities.Category;
import com.seiadev.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public List<Category> findAll() {
        return repository.findAll();
    }

}
