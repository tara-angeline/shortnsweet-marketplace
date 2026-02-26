package com.example.marketplace.controller;

import com.example.marketplace.model.Cart;
import com.example.marketplace.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        Cart cart = cartService.getCart(session);
        model.addAttribute("cartItems", cart.getItems());
        model.addAttribute("subtotal", cart.getTotal());
        model.addAttribute("shipping", 4.00);
        model.addAttribute("total", cart.getTotal() + 4.00);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId, @RequestParam(defaultValue = "1") int quantity, HttpSession session) {
        cartService.addToCart(productId, quantity, session);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateQuantity(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) {
        cartService.updateQuantity(productId, quantity, session);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeItem(@RequestParam Long productId, HttpSession session) {
        cartService.remove(productId, session);
        return "redirect:/cart";
    }
}
