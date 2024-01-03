package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        categoryService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name){
        Category updateCategory = new Category(id,name);
        categoryService.save(updateCategory);
        return "redirect:/";
    }
}
