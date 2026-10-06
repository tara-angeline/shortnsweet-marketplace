package com.example.marketplace.controller;

import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import com.example.marketplace.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Object obj = session.getAttribute("loggedUser");
        if (obj != null) {
            User user = (User) obj;
            if (user.getRole() == Role.ADMIN) {
                return "redirect:/admin/dashboard";
            }
        }

        model.addAttribute("featproducts", productService.getFeaturedProducts());

        model.addAttribute("seaproducts", productService.getSEAProducts());

        model.addAttribute("activePage", "home");
        return "home";
    }

    @GetMapping("/about")
    public String about(HttpSession session, Model model) {
        Object obj = session.getAttribute("loggedUser");
        if (obj != null) {
            User user = (User) obj;
            if (user.getRole() == Role.ADMIN) {
                return "redirect:/admin/dashboard";
            }
        }
        return "about";
    }
}

