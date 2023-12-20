package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addProduct(@RequestParam int id,
                             @RequestParam String name,
                             @RequestParam double price,
                             @RequestParam String description,
                             @RequestParam String brand,
                             RedirectAttributes redirectAttributes) {
        productService.add(new Product(id, name, price, description, brand));
        redirectAttributes.addFlashAttribute("message", "Product added!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String toEditForm(@RequestParam int id, Model model) {
        Product productToEdit = productService.getProduct(id);
        model.addAttribute("product", productToEdit);
        return "edit_form";
    }

    @PostMapping("/edit")
    public String edit(@RequestParam int id,
                       @RequestParam String name,
                       @RequestParam double price,
                       @RequestParam String description,
                       @RequestParam String brand,
                       RedirectAttributes redirectAttributes) {
        productService.edit(new Product(id,name,price,description,brand));
        redirectAttributes.addFlashAttribute("message","Edit succeed!");
        return "redirect:/";
    }
}
