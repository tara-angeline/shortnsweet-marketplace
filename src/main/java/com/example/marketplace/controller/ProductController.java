package com.example.marketplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("/productdetail")
    public String productDetail() {
        return "product_detail";
    }

    @GetMapping("/addcart")
    public String addToCart() {
        return "add_cart";
    }

    @GetMapping("/checkout")
    public String checkout() {
        return "checkout";
    }
}
