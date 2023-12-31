package com.blog.controller;

import com.blog.model.Blog;
import com.blog.model.BlogHasCategory;
import com.blog.model.Category;
import com.blog.model.CategoryDTO;
import com.blog.service.IBlogHasCategoryService;
import com.blog.service.IBlogService;
import com.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller

public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IBlogHasCategoryService blogHasCategoryService;

    @ModelAttribute
    public Category getNewCategory() {
        return new Category();
    }

    @ModelAttribute
    public Blog getNewBlog() {
        return new Blog();
    }

    @ModelAttribute("categories_list")
    public List<CategoryDTO> getAllCategoryDTOS() {
        Iterable<Category> catList = categoryService.findAll();
        List<CategoryDTO> catListDTO = new ArrayList<>();
        for (Category e : catList) {
            CategoryDTO newCatDTO = new CategoryDTO();
            newCatDTO.setId(e.getId());
            newCatDTO.setName(e.getName());
            catListDTO.add(newCatDTO);
        }
        return catListDTO;
    }

    @GetMapping("/")
    public String toHome(@PageableDefault(value = 3) Pageable pageable,
                         @RequestParam @Nullable String title,
                         Model model) {
        System.out.println(pageable);
        Page<Blog> blogs;
        if (title != null && !title.isEmpty()) {
            blogs = blogService.findAllByTitleContaining(title, pageable);
        } else {
            blogs = blogService.getAll(pageable);
        }

        String sortLink;
        if (pageable.getSort().isUnsorted()) {
            sortLink = "/?sort=dateTimePublished,asc";
        } else {
            Sort.Direction sortDirection = pageable.getSort().getOrderFor("dateTimePublished").getDirection();
            if (sortDirection.isAscending()) {
                sortLink = "/?sort=dateTimePublished,desc";
            } else {
                sortLink = "/?sort=dateTimePublished,asc";
            }
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("sort", sortLink);
        return "index";
    }

    @GetMapping("/create")
    public String toCreateForm() {
        return "form";
    }

    @PostMapping("/create")
    public String addBlog(Blog newBlog,
                          @RequestParam("category") List<Category> newCategory,
                          RedirectAttributes redirectAttributes) {
        List<BlogHasCategory> blogHasCategories = new ArrayList<>();
        for (Category newCat : newCategory) {
            blogHasCategories.add(new BlogHasCategory(newBlog, newCat));
        }
        blogService.save(newBlog);
        blogHasCategoryService.saveAll(blogHasCategories);
        redirectAttributes.addFlashAttribute("message", "New blog added!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Iterable<BlogHasCategory> categories = blogHasCategoryService.findAllById(id);
        model.addAttribute("blog", blogService.getById(id));
        model.addAttribute("cats", categories);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String toUpdateForm(@PathVariable Long id,
                               Model model) {
        Iterable<BlogHasCategory> categories = blogHasCategoryService.findAllById(id);
        List<CategoryDTO> catListDTO = getAllCategoryDTOS();
        for (BlogHasCategory cat : categories) {
            for (CategoryDTO e : catListDTO) {
                if (Objects.equals(cat.getCategory().getId(), e.getId())) {
                    e.setChecked(true);
                    break;
                }
            }
        }
        for (CategoryDTO e : catListDTO) {
            System.out.println(e.getName());
            System.out.println(e.getChecked());
        }
        Blog blogToEdit = blogService.getById(id);
        model.addAttribute("blog", blogToEdit);
        model.addAttribute("categories_list", catListDTO);
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String save(Blog blog, @RequestParam("category") List<Category> newCategory,
                       RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        blogHasCategoryService.removeAllByBlogId(blog.getId());
        List<BlogHasCategory> blogHasCategories = new ArrayList<>();
        for (Category newCat : newCategory) {
            blogHasCategories.add(new BlogHasCategory(blog, newCat));
        }
        blogHasCategoryService.saveAll(blogHasCategories);
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

    @GetMapping("/category/{id}")
    public String findBlogsByCategory(@PathVariable Long id,
                                      Model model) {
        Category category = categoryService.findById(id).orElse(null);
        Iterable<BlogHasCategory> blogHasCategory = blogHasCategoryService.findAllBlogsByCategory(category);
        model.addAttribute("blogs",blogHasCategory);
        return "blogs_by_category";
    }
}
