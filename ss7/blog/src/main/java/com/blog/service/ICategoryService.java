package com.blog.service;

import com.blog.model.Category;

public interface ICategoryService {
    void save(Category category);
    Iterable<Category> findAll();

    void deleteById(Long id);
}
