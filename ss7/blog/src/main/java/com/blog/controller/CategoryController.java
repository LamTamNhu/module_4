package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @ModelAttribute
    public Category getNewCategory() {
        return new Category();
    }

    @PostMapping("/add")
    public String add(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "New category added!");
        return "redirect:/";
    }
}
