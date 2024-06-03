package com.seiadev.dscatalog.resources;

import com.seiadev.dscatalog.dto.CategoryDTO;
import com.seiadev.dscatalog.entities.Category;
import com.seiadev.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {


    @Autowired
    private  CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findByID(@PathVariable("id") Long id){


        CategoryDTO categoryDTO = service.findById(id);
        return ResponseEntity.ok().body(categoryDTO);
    }
}
