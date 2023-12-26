package com.blog.controller;

import com.blog.model.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class BlogController {
    @Autowired
    IBlogService blogService;

    @ModelAttribute
    Blog getBlog() {
        return new Blog();
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
    public String addBlog(Blog newBlog,
                          RedirectAttributes redirectAttributes) {
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
                         Model model){
        Blog blogToEdit = blogService.getById(id);
        model.addAttribute("blog",blogToEdit);
        return "form";
    }
    @PostMapping("/edit/{id}")
    public String save(Blog blog,
                       RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Edit succeed!");
        return "redirect:/";
    }
}
