package com.blog.service;

import com.blog.model.BlogHasCategory;
import com.blog.repository.IBlogHasCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogHasCategoryService implements IBlogHasCategoryService{
    @Autowired
    IBlogHasCategoryRepository repository;
    @Override
    public Iterable<BlogHasCategory> findAllById(long i) {
        return repository.findAllByBlog_Id(i);
    }
}
