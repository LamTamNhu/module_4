package com.blog.service;

import com.blog.model.BlogHasCategory;
import com.blog.model.Category;

import java.util.List;

public interface IBlogHasCategoryService {
    Iterable<BlogHasCategory> findAllById(long i);

    void saveAll(List<BlogHasCategory> blogHasCategories);

    void removeAllByBlogId(long id);

    Iterable<BlogHasCategory> findAllBlogsByCategory(Category category);
}
