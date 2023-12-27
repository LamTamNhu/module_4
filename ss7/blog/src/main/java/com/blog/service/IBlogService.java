package com.blog.service;

import com.blog.model.Blog;

public interface IBlogService {
    Iterable<Blog> getAll();

    void save(Blog blog);

    Blog getById(Long id);

    void deleteById(Long idDelete);
}
