package com.blog.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateTimePublished;
    @ManyToMany
    @JoinTable(
            name = "blog_categories",
            joinColumns = @JoinColumn(name="blog_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="cat_id",referencedColumnName = "id")
    )
    private Set<Category> categories;

    public Blog() {
    }

    public Blog(String title, String content, Set<Category> categories) {
        this.title = title;
        this.content = content;
        this.categories = categories;
    }

    public LocalDateTime getDateTimePublished() {
        return dateTimePublished;
    }

    public void setDateTimePublished(LocalDateTime date) {
        this.dateTimePublished = date;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
