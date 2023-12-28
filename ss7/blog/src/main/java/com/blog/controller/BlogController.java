package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.Category;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @ModelAttribute
    public Category getNewCategory() {
        return new Category();
    }

    @ModelAttribute
    public Blog getNewBlog() {
        return new Blog();
    }
    @ModelAttribute("categories_list")
    public Iterable<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public String toHome(Model model) {
        Iterable<Blog> blogs = blogService.getAll();
        model.addAttribute("blogs", blogs);
        return "index";
    }

    @GetMapping("/create")
    public String toCreateForm() {
        return "form";
    }

    @PostMapping("/create")
    public String addBlog(@ModelAttribute("blog") Blog newBlog,
                          RedirectAttributes redirectAttributes) {
        System.out.println("in post create");
        blogService.save(newBlog);
        redirectAttributes.addFlashAttribute("message", "New blog added!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Blog blog = blogService.getById(id);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String toUpdateForm(@PathVariable Long id,
                               Model model) {
        Blog blogToEdit = blogService.getById(id);
        model.addAttribute("blog", blogToEdit);
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String save(Blog blog,
                       RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Edit succeed!");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam Long idDelete,
                         RedirectAttributes redirectAttributes) {
        blogService.deleteById(idDelete);
        redirectAttributes.addFlashAttribute("message", "Delete succeed!");
        return "redirect:/";
    }
}
