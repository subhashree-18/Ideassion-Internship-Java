package com.firstconnection.testproject.controller;


import com.firstconnection.testproject.model.Product;
import com.firstconnection.testproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get")
    public Product getProductById(@RequestParam Long id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product, @RequestParam Long sellerId) {
        return productService.saveProduct(product, sellerId);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
    }
}
