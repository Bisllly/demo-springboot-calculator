package com.example.cuongcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/calculator")
    public String calculate(
            @RequestParam(value = "num1", required = false) Double num1,
            @RequestParam(value = "num2", required = false) Double num2,
            @RequestParam(value = "operator", required = false) String operator,
            Model model)
    {
        if (num1 == null || num2 == null || operator == null) {
            model.addAttribute("error", "Missing parameters");
            return "calculator";
        }

        double result;
        switch (operator) {
            case "add" -> result = num1 + num2;
            case "subtract" -> result = num1 - num2;
            case "multiply" -> result = num1 * num2;
            case "divide" -> {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("error", "Cannot divide by zero!");
                    return "calculator";
                }
            }
            default -> {
                model.addAttribute("error", "Invalid operator");
                return "calculator";
            }
        }
        model.addAttribute("result", result);
        return "calculator";
    }
}
