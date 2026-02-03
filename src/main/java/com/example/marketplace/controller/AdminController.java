package com.example.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/addproduct")
    public String addProduct() {
        return "add";
    }

    @GetMapping("/deleteproduct")
    public String deleteProduct() {
        return "delete";
    }

    @GetMapping("/editproduct")
    public String editProduct() {
        return "edit";
    }
}
