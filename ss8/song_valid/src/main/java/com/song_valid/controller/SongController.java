package com.song_valid.controller;

import com.song_valid.model.Song;
import com.song_valid.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SongController {
    @Autowired
    ISongService songService;

    @ModelAttribute
    public Song getDefaultSong() {
        return new Song();
    }

    @GetMapping("/")
    public String toHome(Model model) {
        model.addAttribute("song_list", songService.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String toForm() {
        return "form";
    }

    @PostMapping("/create")
    public String save(@Valid Song song, BindingResult bindingResult) {
        System.out.println("In post");
        if (bindingResult.hasFieldErrors()) {
            return "form";
        }
        songService.save(song);
        System.out.println("OK");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String toEditForm(@PathVariable Long id,Model model){
        model.addAttribute("song",songService.getById(id));
        return "form";
    }
    @PostMapping("/edit/{id}")
    public String saveEdit(Song song){
        songService.save(song);
        return "redirect:/";
    }
}
