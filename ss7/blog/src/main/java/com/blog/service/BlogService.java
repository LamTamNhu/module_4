package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog getById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long idDelete) {
        blogRepository.deleteById(idDelete);
    }
}
