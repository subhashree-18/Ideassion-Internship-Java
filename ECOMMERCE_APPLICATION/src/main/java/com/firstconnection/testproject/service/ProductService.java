package com.firstconnection.testproject.service;


import com.firstconnection.testproject.model.Product;
import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.repository.ProductRepository;
import com.firstconnection.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    // Create or Update a Product (only SELLER can add products)
    public Product saveProduct(Product product, Long sellerId) {
        Optional<User> seller = userRepository.findById(sellerId);
        if (seller.isPresent() && seller.get().getRole() == User.Role.SELLER) {
            product.setSeller(seller.get());
            return productRepository.save(product);
        }
        throw new IllegalArgumentException("Only SELLER users can add products.");
    }

    // Update an existing Product
    public Product updateProduct(Long id, Product productDetails) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setStock(productDetails.getStock());
        return productRepository.save(existingProduct);
    }

    // Get all Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Delete Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
