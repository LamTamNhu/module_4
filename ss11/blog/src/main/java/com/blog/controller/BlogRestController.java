package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.BlogHasCategory;
import com.blog.model.Category;
import com.blog.service.IBlogHasCategoryService;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
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
    public ResponseEntity<Iterable<Blog>> getAllBlogs(@PageableDefault(size = 3) Pageable pageable) {
        System.out.println(pageable);
        Page<Blog> blogs = blogService.getAll(pageable);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/filter")
    public ResponseEntity<?> getBlogOfCategory(@RequestParam @Nullable Long categoryId, @RequestParam @Nullable String title, @PageableDefault(size = 10) Pageable pageable) {
        List<Blog> blogs = new ArrayList<>();
        if (categoryId != null) {
            Category category = categoryService.findById(categoryId).orElse(null);
            Iterable<BlogHasCategory> blogHasCategories = blogHasCategoryService.findAllBlogsByCategory(category);
            for (BlogHasCategory e : blogHasCategories) {
                blogs.add(e.getBlog());
            }
        }
        Page<Blog> blogsByTitle;
        if (title != null && !title.isEmpty()) {
            blogsByTitle = blogService.findAllByTitleContaining(title, pageable);
            return new ResponseEntity<>(blogsByTitle, HttpStatus.OK);
        } else if (title != null) {
            System.out.println("in search empty title");
            return new ResponseEntity<>(blogService.getAll(pageable), HttpStatus.OK);
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
