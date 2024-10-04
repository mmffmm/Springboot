package com.example.securingweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculatorController {

    @Autowired
    private RestTemplate restTemplate;

    // @GetMapping("/calculator")
    // public String calculatorHome() {
    //     return "calculator"; // Returns the Thymeleaf template
    // }

    // @PostMapping("/calculate")
    // public String calculate(
    //         @RequestParam("num1") int num1,
    //         @RequestParam("num2") int num2,
    //         @RequestParam("operation") String operation,
    //         Model model) {

    //     // Map<String, Object> data = new HashMap<>();
    //     // data.put("num1", num1);
    //     // data.put("num2", num2);
    //     // data.put("operation", operation);

    //     // // Set the headers
    //     // HttpHeaders headers = new HttpHeaders();
    //     // headers.setContentType(MediaType.APPLICATION_JSON);

    //     // // Create the HttpEntity with the body (data) and headers
    //     // HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(data, headers);

    //     // // Call the Python API using POST
    //     // String apiUrl = "http://localhost:5000/calculator";
    //     // ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

    //     // // Get the result from the response
    //     // String result = response.getBody();
    //     // System.out.println(result);

    //     // model.addAttribute("result", result); // Add the result to the model


    //         // Hardcode the response to always be "3" for testing
    //     String result = "3"; // Hardcoded result

    //     // Add the result to the model
    //     model.addAttribute("result", result);
        
    //     return "calculator"; // Return to the same Thymeleaf template
    // }



    @PostMapping("/calculate")
    public String calculate() {

            // Hardcode the response to always be "3" for testing
        String result = "3"; // Hardcoded result
        
        return "calculator"; // Return to the same Thymeleaf template
    }

    @PostMapping("/testpost")
    public String tespost(Model model) {
        model.addAttribute("message", "Hello"); // Add the greeting message to the model
        return "testpost";
    }

    // @PostMapping("/testpost")
    // public String greet(@RequestParam("name") String name, Model model) {
    //     model.addAttribute("name", name);
    //     return "response";
    // }
}
