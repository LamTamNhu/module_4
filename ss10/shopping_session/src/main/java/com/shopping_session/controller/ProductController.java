package com.shopping_session.controller;

import com.shopping_session.model.Cart;
import com.shopping_session.model.Product;
import com.shopping_session.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String toHome() {
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (productOptional.isEmpty()) {
            return "/error_404";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/product/" + id;
    }

    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable Long id,
                              Model model) {
//        System.out.println("ok");
        model.addAttribute("product", productService.findById(id).orElse(null));
        return "product";
    }
}