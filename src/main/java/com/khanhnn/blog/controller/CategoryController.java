package com.khanhnn.blog.controller;

import com.khanhnn.blog.model.Category;
import com.khanhnn.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> list(){
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<Iterable<Category>>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> detail(@PathVariable ("id") Long id){
        Category category = categoryService.findById(id);

        return  new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> create(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Void> update(@RequestBody Category category, @PathVariable Long id){
        Category category1 = categoryService.findById(id);
        category1.setName(category.getName());
        categoryService.save(category1);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        if(categoryService.findById(id)== null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
