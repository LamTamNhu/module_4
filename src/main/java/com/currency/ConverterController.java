package com.currency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/convert")
    public String convert(@RequestParam double amount,String type, Model model) {
        System.out.println(amount);
        model.addAttribute("amount", amount);
        return "convert";
    }

    @GetMapping("/form")
    public String formInput() {
        return "form";
    }
}
