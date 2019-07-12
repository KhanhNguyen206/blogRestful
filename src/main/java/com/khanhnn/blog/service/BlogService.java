package com.khanhnn.blog.service;

import com.khanhnn.blog.model.Blog;

public interface BlogService {

    Iterable<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);
}
