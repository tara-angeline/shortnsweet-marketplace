package com.example.marketplace.controller;

import com.example.marketplace.model.Cart;
import com.example.marketplace.model.Order;
import com.example.marketplace.model.User;
import com.example.marketplace.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login";
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.isEmpty()) {
            return "redirect:/cart";
        }

        model.addAttribute("cart", cart);
        model.addAttribute("total", cart.getTotal());

        return "checkout";
    }

    @PostMapping("/checkout/place")
    public String placeOrder(HttpSession session, RedirectAttributes ra) {
        User user = (User) session.getAttribute("loggedUser");
        Cart cart = (Cart) session.getAttribute("cart");

        if (user == null){
            return "redirect:/login";
        }
        if (cart == null || cart.isEmpty()) {
            ra.addFlashAttribute("error", "Your cart is empty.");
            return "redirect:/cart";
        }

        try {
            Order order = orderService.placeOrder(user, cart);
            session.setAttribute("cart", new Cart());

            ra.addFlashAttribute("success", "Order placed! Order ID: " + order.getId());
            return "redirect:/account";

        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
            return "redirect:/cart";
        }
    }
}
