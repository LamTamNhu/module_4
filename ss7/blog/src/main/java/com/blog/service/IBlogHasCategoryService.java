package com.blog.service;

import com.blog.model.BlogHasCategory;

public interface IBlogHasCategoryService {
    Iterable<BlogHasCategory> findAllById(long i);
}
