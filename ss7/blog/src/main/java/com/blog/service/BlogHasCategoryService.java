package com.blog.service;

import com.blog.model.BlogHasCategory;
import com.blog.model.Category;
import com.blog.repository.IBlogHasCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogHasCategoryService implements IBlogHasCategoryService{
    @Autowired
    IBlogHasCategoryRepository repository;
    @Override
    public Iterable<BlogHasCategory> findAllById(long i) {
        return repository.findAllByBlog_Id(i);
    }

    @Override
    public void saveAll(List<BlogHasCategory> blogHasCategories) {
        repository.saveAll(blogHasCategories);
    }

    @Override
    public void removeAllByBlogId(long id) {
        repository.deleteBlogHasCategoriesByBlog_Id(id);
    }

    @Override
    public Iterable<BlogHasCategory> findAllBlogsByCategory(Category category) {
        return repository.findAllByCategory(category);
    }

}
