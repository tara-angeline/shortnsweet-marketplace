package com.example.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginRegisterController {

    @GetMapping("/login")
    public String customerLogin() {
        return "customer_login";
    }

    @GetMapping("/register")
    public String customerRegister() {
        return "customer_register";
    }

    @GetMapping("/adminlogin")
    public String adminLogin() {
        return "admin_login";
    }

    @GetMapping("/adminregister")
    public String adminRegister() {
        return "admin_register";
    }
}
