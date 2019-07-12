package com.khanhnn.blog.controller;

import com.khanhnn.blog.model.Blog;
import com.khanhnn.blog.service.BlogService;
import com.khanhnn.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> listBlog(){
        Iterable<Blog> blogs = blogService.findAll();
        return new ResponseEntity<Iterable<Blog>>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<Void> create(@RequestBody Blog blog){
        blogService.save(blog);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity<Void> edit(@PathVariable Long id, @RequestBody Blog blog){
        Blog blog1= blogService.findById(id);
        blog1.setTitle(blog.getTitle());
        blog1.setContent(blog.getContent());
        blog1.setCategory(blog.getCategory());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        blogService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
