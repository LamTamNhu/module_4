package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.BlogHasCategory;
import com.blog.model.Category;
import com.blog.service.IBlogHasCategoryService;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BlogRestController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogService blogService;
    @Autowired
    IBlogHasCategoryService blogHasCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> getAllBlogs() {
        Iterable<Blog> blogs = blogService.findAll();
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/filter")
    public ResponseEntity<List<Blog>> getBlogOfCategory(@RequestParam Long id) {
        Category category = categoryService.findById(id).orElse(null);
        Iterable<BlogHasCategory> blogHasCategories = blogHasCategoryService.findAllBlogsByCategory(category);
        List<Blog> blogs = new ArrayList<>();
        for (BlogHasCategory e : blogHasCategories) {
            blogs.add(e.getBlog());
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
