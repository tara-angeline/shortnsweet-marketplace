package com.example.marketplace.controller;
import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session) {
        Object obj = session.getAttribute("loggedUser");
        if (obj != null) {
            User user = (User) obj;
            if (user.getRole() == Role.ADMIN) {
                return "redirect:/admin/dashboard";
            }
        }
        return "home";
    }
}

