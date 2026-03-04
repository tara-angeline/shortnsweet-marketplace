package com.example.marketplace.controller;

import com.example.marketplace.service.ProductService;
import org.springframework.ui.Model;
import com.example.marketplace.model.Product;
import com.example.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("products", productRepository.findByActiveTrue());
        return "shop";
    }

    @GetMapping("/shop/search")
    public String search(@RequestParam String q, Model model) {
        var products = productService.searchProducts(q);
        model.addAttribute("products", products);
        model.addAttribute("searchQuery", q);
        return "shop";
    }
    @GetMapping("/productdetail")
    public String productDetail(@RequestParam Long id, Model model) {
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);
        return "product_detail";
    }
}
