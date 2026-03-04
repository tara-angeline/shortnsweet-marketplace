package com.example.marketplace.controller;

import com.example.marketplace.model.User;
import com.example.marketplace.repository.OrderRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    private final OrderRepository orderRepository;

    public AccountController(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @GetMapping("/account")
    public String accountPage(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedUser");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);
        model.addAttribute("orders", orderRepository.findByUserOrderByCreatedAtDesc(user));

        return "account";
    }
}