package com.example.controller;

import com.example.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @GetMapping("/")
    public String toHome() {
        return "index";
    }

    @GetMapping("/create")
    public String toCreateForm(Song song) {
        return "index";
    }
}
