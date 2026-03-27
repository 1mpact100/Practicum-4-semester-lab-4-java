package com.example.myapp;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    @ResponseBody
    public Map<String, String> login() {
        return Map.of("author", "1160491");
    }
}
