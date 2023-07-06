package com.example.cuongcalculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {
    private List<String> history = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("inputValue", "");
        model.addAttribute("history", history);
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
                history.add(inputValue + " = " + result);
            } catch (ScriptException e) {
                result = "Error";
            }
        } else {
            result = "";
        }

        model.addAttribute("inputValue", result);
        model.addAttribute("history", history);
        return "calculator";
    }

    @GetMapping("/clearHistory")
    public String clearHistory() {
        history.clear();
        return "redirect:/";
    }
    @PostMapping("/getHistory")
    @ResponseBody
    public List<String> getHistory() {
        return history;
    }
}
