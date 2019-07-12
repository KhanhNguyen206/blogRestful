package com.khanhnn.blog.repository;

import com.khanhnn.blog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
}
