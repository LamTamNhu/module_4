package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);

    void save(Blog blog);

    Blog getById(Long id);

    void deleteById(Long idDelete);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

}
