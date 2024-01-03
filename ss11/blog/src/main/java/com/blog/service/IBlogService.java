package com.blog.service;

import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);

    void save(Blog blog);

    Blog getById(Long id);

    void deleteById(Long idDelete);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Iterable<Blog> findAll();

    Blog findById(Long id);
}
