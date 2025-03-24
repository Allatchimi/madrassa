package com.kidami.webapp.controllers;

import com.kidami.webapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/all")
    public String getUsers(Model model) {
        String url = "http://localhost:8080/api/v1/user/getAllUsers";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        String users = responseEntity.getBody();
        model.addAttribute("users", users);
        System.out.println("User: " + users);
        return "users";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // This should match your registration HTML page template name.
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // This should match your login HTML page template name.
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to the home page!";
    }


}
