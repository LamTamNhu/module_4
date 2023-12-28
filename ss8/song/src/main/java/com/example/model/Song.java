package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Max(800)
    @Pattern(regexp = "\\w",message = "No special character allowed")
    private String name;
    @NotBlank
    @Max(300)
    @Pattern(regexp = "\\w",message = "No special character allowed")
    private String singer;
    @NotBlank
    @Max(1000)
    @Pattern(regexp = "\\w",message = "No special character allowed, only comma")
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
}
