package com.example.marketplace.controller;

import com.example.marketplace.model.Role;
import org.springframework.ui.Model;
import com.example.marketplace.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        var userOpt = authService.authenticate(email, password);

        if (userOpt.isEmpty()) {
            return "redirect:/login?error";
        }

        var user = userOpt.get();
        session.setAttribute("loggedUser", user);

        // Role-based redirect
        if (user.getRole() == Role.ADMIN) {
            return "redirect:/admin";
        }
        return "redirect:/account";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "customer_register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password,
                           @RequestParam String firstname, @RequestParam String lastname,
                           @RequestParam String confirmPassword, Model model) {

        email = email == null ? "" : email.trim();
        firstname = firstname == null ? "" : firstname.trim();
        lastname = lastname == null ? "" : lastname.trim();

        if (firstname.isBlank() || lastname.isBlank()) {
            model.addAttribute("error", "First name and last name are required.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "customer_register";
        }

        if (email.isBlank()) {
            model.addAttribute("error", "Email is required.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "customer_register";
        }

        if (password == null || password.length() < 8) {
            model.addAttribute("error", "Password must be at least 8 characters.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "customer_register";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "customer_register";
        }

        var error = authService.registerCustomer(email, password, firstname, lastname);

        if (error.isPresent()) {
            model.addAttribute("error", error.get());
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "customer_register";
        }

        return "redirect:/login?registered";
    }

    //ADMIN STUFF COME BACK LATER!
    @GetMapping("/adminlogin")
    public String adminLogin() {
        return "admin_login";
    }

    @GetMapping("/adminregister")
    public String adminRegister() {
        return "admin_register";
    }
}