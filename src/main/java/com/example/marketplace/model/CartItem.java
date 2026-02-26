package com.example.marketplace.model;

import java.math.BigDecimal;

public class CartItem {
    private Long productId;

    private String name;

    private double unitPrice;

    private int quantity;

    private String image;

    public CartItem(Long productId, String name, double unitPrice, int quantity, String image) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.image = image;
    }

    public double getLineTotal() {
        return unitPrice * quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}