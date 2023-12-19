package com.example.dictionary.controller;

import com.example.dictionary.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private IService service;

    @GetMapping("/**")
    public String menu() {
        return "menu";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String word, Model model) {
        String result = service.translate(word);
        model.addAttribute("result", result);
        return "menu";
    }
}
