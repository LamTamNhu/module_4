package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/add")
    public String toAddForm() {
        return "add_form";
    }

    @PostMapping("/add")
    public String addProduct() {
        productService.add();
        return "redirect:/";
    }
}
