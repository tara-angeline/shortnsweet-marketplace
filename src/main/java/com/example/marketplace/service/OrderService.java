package com.example.marketplace.service;

import com.example.marketplace.model.*;
import com.example.marketplace.repository.OrderRepository;
import com.example.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order placeOrder(User user, Cart cart) {
        if (user == null) throw new IllegalStateException("Login required.");
        if (cart == null || cart.isEmpty()) throw new IllegalStateException("Cart is empty.");

        Order order = new Order();
        order.setUser(user);
        order.setStatus(OrderStatus.PROCESSING);

        for (CartItem cartitem : cart.getItems()) {
            Long productId = cartitem.getProductId();
            int quantity = cartitem.getQuantity();

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

            if (!product.getActive()) {
                throw new IllegalStateException(product.getName() + " is no longer available.");
            }

            if (product.getStock() < quantity) {
                throw new IllegalStateException("Not enough stock for " + product.getName());
            }

            OrderItem item = new OrderItem(order, product, quantity, product.getName(), product.getPrice());
            order.addItem(item);

            product.setStock(product.getStock() - quantity);
            productRepository.save(product);
        }
        double shipping = 4.00;
        order.setTotal(cart.getTotal() + shipping);

        return orderRepository.save(order);

    }

    public List<Order> getAllOrdersNewestFirst() {
        return orderRepository.findAllWithItemsNewestFirst();
    }

    public Order getOrderWithItems(Long id) {
        return orderRepository.findByIdWithItems(id).orElseThrow();
    }

    public void updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(status);
        orderRepository.save(order);
    }

}
