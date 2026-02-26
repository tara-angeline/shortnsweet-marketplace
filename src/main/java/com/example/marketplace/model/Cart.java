package com.example.marketplace.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private final Map<Long, CartItem> items = new LinkedHashMap<>();

    public Collection<CartItem> getItems() {
        return items.values();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(CartItem item) {
        CartItem existing = items.get(item.getProductId());
        if (existing == null) {
            items.put(item.getProductId(), item);
        } else {
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        }
    }

    public void updateQuantity(Long productId, int quantity) {
        if (quantity <= 0) {
            items.remove(productId);
        } else {
            CartItem existing = items.get(productId);
            if (existing != null){
                existing.setQuantity(quantity);
            }
        }
    }

    public void remove(Long productId) {
        items.remove(productId);
    }

    public double getTotal() {
        return items.values().stream().mapToDouble(CartItem::getLineTotal).sum();

    }
}