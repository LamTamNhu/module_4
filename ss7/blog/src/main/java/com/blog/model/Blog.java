package com.blog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
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
    @Column(updatable = false)
    private LocalDateTime dateTimePublished;
    @OneToMany(mappedBy = "blog")
    @JsonBackReference
    private List<BlogHasCategory> categories;

    public Blog() {
    }

    public Blog(long id, String title, String content, LocalDateTime dateTimePublished, List<BlogHasCategory> categories) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTimePublished = dateTimePublished;
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

    public List<BlogHasCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<BlogHasCategory> categories) {
        this.categories = categories;
    }
}
