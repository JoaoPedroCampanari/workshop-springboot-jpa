package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {


    private final CategoryService categoryService;

    @Autowired
    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> list = categoryService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }

}
