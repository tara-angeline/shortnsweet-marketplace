package com.example.marketplace.controller;

import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String dashboard() {
        return "admin";
    }

    @GetMapping("/admin/products")
    public String deleteProduct() {
        return "delete";
    }

    @GetMapping("/admin/orders")
    public String editProduct() {
        return "edit";
    }

}
