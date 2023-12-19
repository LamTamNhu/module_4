package com.currency.controller;

import com.currency.service.IConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ConverterController {
    @Autowired
    private IConverterService converterService;

    @GetMapping("/convert")
    public String convert(@RequestParam double amount, @RequestParam String type, Model model) {
        System.out.println(type);
        String result = converterService.convert(type,amount);
        model.addAttribute("result", result);
        return "form";
    }

    @GetMapping("/form")
    public String formInput() {
        return "form";
    }
}
