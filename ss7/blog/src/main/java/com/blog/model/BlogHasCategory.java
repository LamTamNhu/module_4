package com.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class BlogHasCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public BlogHasCategory() {
    }

    public BlogHasCategory(Blog blog, Category category) {
        this.blog = blog;
        this.category = category;
    }

    public BlogHasCategory(Long id, Blog blog, Category category) {
        this.id = id;
        this.blog = blog;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
