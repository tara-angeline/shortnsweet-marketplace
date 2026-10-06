package com.example.marketplace.service;

import com.example.marketplace.model.Product;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProducts(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return productRepository.findAll();
        }

        return productRepository.findByTagsContainingIgnoreCaseAndActiveTrue(keyword);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        product.setActive(true);
        productRepository.save(product);
    }

    public String validate(Product p) {
        if (p.getName() == null || p.getName().trim().isEmpty()) return "Product name is required.";
        if (p.getPrice() < 0) return "Price cannot be negative.";
        if (p.getStock() < 0) return "Stock cannot be negative.";
        return null;
    }

    public void updateProduct(Long id, Product addedProduct) {
        Product existing = getProductById(id);
        if (existing == null) return;

        existing.setName(addedProduct.getName());
        existing.setShortDescription(addedProduct.getShortDescription());
        existing.setLongDescription(addedProduct.getLongDescription());
        existing.setTags(addedProduct.getTags());
        existing.setPrice(addedProduct.getPrice());
        existing.setStock(addedProduct.getStock());
        existing.setImage(addedProduct.getImage());
        productRepository.save(existing);
    }

    public void hideProduct(Product product){
        product.setActive(false);
        productRepository.save(product);
    }

    public void unhideProduct(Product product){
        product.setActive(true);
        productRepository.save(product);
    }

    public List<Product> getFeaturedProducts() {
        List<Product> activeProducts = productRepository.findByTagsContainingIgnoreCaseAndActiveTrue("most loved");
        return activeProducts.subList(0, Math.min(4, activeProducts.size()));
    }

    public List<Product> getSEAProducts() {
        List<Product> activeProducts = productRepository.findByTagsContainingIgnoreCaseAndActiveTrue("southeast asian");
        return activeProducts.subList(0, Math.min(4, activeProducts.size()));
    }
}
