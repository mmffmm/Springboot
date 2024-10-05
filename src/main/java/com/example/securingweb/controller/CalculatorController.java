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
import org.thymeleaf.expression.Lists;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculatorController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("num1") int num1,
            @RequestParam("num2") int num2,
            @RequestParam("operation") String operation,
            Model model) throws JsonProcessingException {


        Map<String, Object> data = new HashMap<>();
        data.put("num1", num1);
        data.put("num2", num2);
        data.put("operation", operation);

        // Set the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HttpEntity with the body (data) and headers
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(data, headers);

        // Call the Python API using POST
        String apiUrl = "http://localhost:5000/calculator";
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

        String result = response.getBody();
        try{  
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(result);
            int resultValue = jsonNode.get("result").asInt();

            model.addAttribute("result", resultValue); // Add the result to the model
            
            return "calculator"; // Return to the same Thymeleaf template
        } catch (JsonProcessingException e) {
            model.addAttribute("result", "error");
            return "calculator"; 
        }

    }



    // @PostMapping("/calculate")
    // public String calculate(Model model) {

    //         // Hardcode the response to always be "3" for testing
    //     String result = "3"; // Hardcoded result
    //     model.addAttribute("result", result);
        
    //     return "calculator"; // Return to the same Thymeleaf template
    // }

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
