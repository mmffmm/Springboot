package com.example.securingweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @PostMapping("/greet")
    public String greet(@RequestParam("name") String name, Model model) {
        String test = "TestName";
        model.addAttribute("name", name);
        model.addAttribute("test", test);
        return "response";
    }
}
