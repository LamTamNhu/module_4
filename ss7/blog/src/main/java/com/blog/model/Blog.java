package com.blog.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime dateTimePublished;
    private String category;

    public Blog() {
    }

    public Blog(String title, String content, String category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public LocalDateTime getDateTimePublished() {
        return dateTimePublished;
    }

    public void setDateTimePublished(LocalDateTime date) {
        this.dateTimePublished = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
