package com.seiadev.dscatalog.services;

import com.seiadev.dscatalog.dto.CategoryDTO;
import com.seiadev.dscatalog.entities.Category;
import com.seiadev.dscatalog.repositories.CategoryRepository;
import com.seiadev.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll();
       return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category  entity = obj.orElseThrow( () -> new EntityNotFoundException("Entity not found"));
        return new CategoryDTO(entity);
    }
}
