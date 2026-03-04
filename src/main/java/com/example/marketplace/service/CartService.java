package com.example.marketplace.service;

import com.example.marketplace.model.CartItem;
import com.example.marketplace.model.Product;
import com.example.marketplace.model.Cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    public static final String CART_SESSION_KEY = "cart";

    private final ProductService productService;

    public CartService(ProductService productService) {
        this.productService = productService;
    }

    public Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new Cart();
            session.setAttribute(CART_SESSION_KEY, cart);
        }
        return cart;
    }

    public void addToCart(Long productId, int quantity, HttpSession session) {
        if (quantity <= 0) quantity = 1;

        Product p = productService.getProductById(productId);
        if (p == null) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }

        Cart cart = getCart(session);
        cart.addItem(new CartItem(p.getId(), p.getName(), p.getPrice(), quantity, p.getImage()));
        session.setAttribute(CART_SESSION_KEY, cart);
    }

    public void updateQuantity(Long productId, int quantity, HttpSession session) {
        Cart cart = getCart(session);
        cart.updateQuantity(productId, quantity);
        session.setAttribute(CART_SESSION_KEY, cart);
    }

    public void remove(Long productId, HttpSession session) {
        Cart cart = getCart(session);
        cart.remove(productId);
        session.setAttribute(CART_SESSION_KEY, cart);
    }

    public void clear(HttpSession session) {
        session.removeAttribute(CART_SESSION_KEY);
    }
}