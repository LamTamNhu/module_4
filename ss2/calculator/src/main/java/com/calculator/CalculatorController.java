package com.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculatorController {
    @GetMapping("/")
    public String home(){
        return "index";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam String operator,
                            @RequestParam double first,
                            @RequestParam double second,
                            Model model) {
        String result = "";
        switch (operator) {
            case "+":
                result = String.valueOf(first + second);
                break;
            case "-":
                result = String.valueOf(first - second);
                break;
            case "*":
                result = String.valueOf(first * second);
                break;
            case "/":
                if (second == 0) {
                    result = "Divide by zero";
                    break;
                }
                result = String.valueOf(first / second);
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
