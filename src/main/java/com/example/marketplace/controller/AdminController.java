package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import com.example.marketplace.service.AuthenticationService;
import com.example.marketplace.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ProductService productService;
    private final AuthenticationService authService;

    public AdminController(ProductService productService, AuthenticationService authService) {
        this.productService = productService;
        this.authService = authService;
    }

    private String denyAccess(HttpSession session) {
        return (session.getAttribute("loggedUser") == null) ? "redirect:/login" : "redirect:/";
    }

    private boolean isAdmin(HttpSession session) {
        return AdminChecker.getAdmin(session) != null;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session) {
        if (!isAdmin(session)){
            return denyAccess(session);
        }
        return "admin";
    }

    @GetMapping("/products")
    public String viewProducts(HttpSession session, Model model) {
        if (!isAdmin(session)){
            return denyAccess(session);
        }

        model.addAttribute("products", productService.getAllProducts());
        return "admin_products";
    }

    //ADD NEW PRODUCTS
    @GetMapping("/products/add")
    public String createForm(Model model, HttpSession session) {
        if (!isAdmin(session)){
            return denyAccess(session);
        }

        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/products")
    public String create(@ModelAttribute Product product, HttpSession session, Model model) {
        if (!isAdmin(session)){
            return denyAccess(session);
        }

        String error = productService.validate(product);
        if (error != null) {
            model.addAttribute("error", error);
            return "admin/product_form";
        }

        productService.createProduct(product);
        return "redirect:/admin/products?created";
    }

    @GetMapping("/orders")
    public String viewOrders() {
        return "edit";
    }

    //ADMIN REGISTER
    @GetMapping("/register")
    public String adminRegisterPage(HttpSession session) {
        if (!isAdmin(session)){
            return denyAccess(session);
        }
        return "admin_register";
    }

    @PostMapping("/register")
    public String adminRegister(@RequestParam String email, @RequestParam String password,
                                @RequestParam String firstname, @RequestParam String lastname,
                                @RequestParam String confirmPassword, HttpSession session, Model model) {
        var admin = AdminChecker.getAdmin(session);
        if (admin == null) {
            return (session.getAttribute("loggedUser") == null) ? "redirect:/login" : "redirect:/";
        }

        email = email == null ? "" : email.trim();
        firstname = firstname == null ? "" : firstname.trim();
        lastname = lastname == null ? "" : lastname.trim();

        if (firstname.isBlank() || lastname.isBlank()) {
            model.addAttribute("error", "First name and last name are required.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "admin_register";
        }

        if (email.isBlank()) {
            model.addAttribute("error", "Email is required.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "admin_register";
        }

        if (password == null || password.length() < 8) {
            model.addAttribute("error", "Password must be at least 8 characters.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "admin_register";
        }

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "admin_register";
        }

        var error = authService.registerAdmin(email, password, firstname, lastname);

        if (error.isPresent()) {
            model.addAttribute("error", error.get());
            model.addAttribute("email", email);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            return "admin_register";
        }

        return "redirect:/admin?adminCreated";
    }

}
