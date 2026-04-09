package com.practical.jwtauth.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
public class SecureController {

    @PostMapping("/admin/add")
    public Map<String, String> adminAdd(Principal principal) {
        return Map.of("message", "Admin add action successful", "user", principal.getName());
    }

    @DeleteMapping("/admin/delete")
    public Map<String, String> adminDelete(Principal principal) {
        return Map.of("message", "Admin delete action successful", "user", principal.getName());
    }

    @GetMapping("/employee/profile")
    public Map<String, String> employeeProfile(Principal principal) {
        return Map.of("message", "Employee profile data", "user", principal.getName());
    }
}
