package com.example.cuongcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("inputValue", "");
        return "calculator";
    }
    @PostMapping("/calculate")
    public String calculate(@RequestParam(value = "inputValue", required = false) String inputValue, Model model) {
        String result;

        if (inputValue != null && !inputValue.isEmpty()) {
            try {
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("javascript");
                result = engine.eval(inputValue).toString();
            } catch (ScriptException e) {
                result = "Error";
            }
        } else {
            result = "";
        }

        model.addAttribute("inputValue", result);
        return "calculator";
    }
}