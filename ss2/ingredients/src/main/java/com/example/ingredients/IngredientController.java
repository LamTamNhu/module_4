package com.example.ingredients;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IngredientController {
    @GetMapping("/")
    public String homeRedirect() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam (defaultValue = "") String[] condiments, Model model) {
        for (String e : condiments) {
            System.out.println(e);
        }
        model.addAttribute("condiments", condiments);
        return "result";
    }
}
