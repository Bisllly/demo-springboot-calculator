package com.example.cuongcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("inputValue", "");
        return "calculator";
    }
}