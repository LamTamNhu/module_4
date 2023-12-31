package com.blog.service;

import com.blog.model.Category;

import java.util.Optional;

public interface ICategoryService {
    void save(Category category);
    Iterable<Category> findAll();

    void deleteById(Long id);

    Optional<Category> findById(Long catId);
}
