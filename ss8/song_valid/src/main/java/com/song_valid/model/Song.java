package com.song_valid.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 800)
    @Pattern(regexp = "\\w*", message = "No special character allowed")
    private String name;
    @NotBlank
    @Size(min = 2, max = 300)
    @Pattern(regexp = "\\w*", message = "No special character allowed")
    private String singer;
    @NotBlank
    @Size(min = 2, max = 1000)
    @Pattern(regexp = "^[\\w+\\s,*]+$", message = "No special character allowed, only comma")
    @Column(columnDefinition = "LONGTEXT")
    private String genre;

    public Song(String name, String singer, String genre) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
    }

    public Song(Long id, String name, String singer, String genre) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.genre = genre;
    }

    public Song() {
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
