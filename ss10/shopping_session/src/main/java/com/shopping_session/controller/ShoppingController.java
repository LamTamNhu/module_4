package com.shopping_session.controller;

import com.shopping_session.model.Cart;
import com.shopping_session.model.Product;
import com.shopping_session.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ShoppingController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/shopping-cart/product/{id}")
    public String changeProductQuantity(@RequestParam @Nullable String action,
                                        @RequestParam @Nullable Integer amount,
                                        @PathVariable Long id,
                                        @SessionAttribute("cart") Cart cart) {
        Product product = productService.findById(id).orElse(null);
        System.out.println(action);
        if (product == null) {
            return "/error_404";
        }
        if (action != null) {
            if (action.equals("add")) {
                cart.addProduct(product);
            } else {
                cart.removeProduct(product);
            }
        }
        if (amount!=null){
            cart.changeAmount(product,amount);
        }
        return "redirect:/shopping-cart";
    }
}