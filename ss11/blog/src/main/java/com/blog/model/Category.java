package com.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<BlogHasCategory> blogs;

    public Category(Long id, String name, List<BlogHasCategory> blogs) {
        this.id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BlogHasCategory> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogHasCategory> blogs) {
        this.blogs = blogs;
    }
}
