package com.product_manager_orm.controller;

import com.product_manager_orm.model.Product;
import com.product_manager_orm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute
    public Product getDefaultProduct(){
        return new Product();
    }

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
    public String addProduct(Product product,
                             RedirectAttributes redirectAttributes) {
        productService.add(product);
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
    public String edit(Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("message", "Edit succeed!");
        return "redirect:/";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Remove succeed!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search_text, Model model) {
        List<Product> searchResult = productService.search(search_text);
        model.addAttribute("products", searchResult);
        for (Product p : searchResult) {
            System.out.println(p);
        }
        return "search";
    }

}
