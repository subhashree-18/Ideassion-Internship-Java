package com.firstconnection.testproject.service;


import com.firstconnection.testproject.model.OrderProduct;
import com.firstconnection.testproject.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    // Create or Update an OrderProduct
    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    // Update an existing OrderProduct
    public OrderProduct updateOrderProduct(Long id, OrderProduct orderProductDetails) {
        OrderProduct existingOrderProduct = orderProductRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderProduct not found"));

        existingOrderProduct.setQuantity(orderProductDetails.getQuantity());
        existingOrderProduct.setProduct(orderProductDetails.getProduct());
        existingOrderProduct.setOrder(orderProductDetails.getOrder());
        return orderProductRepository.save(existingOrderProduct);
    }

    // Get all OrderProducts
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }

    // Get OrderProduct by ID
    public OrderProduct getOrderProductById(Long id) {
        return orderProductRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderProduct not found"));
    }

    // Delete OrderProduct
    public void deleteOrderProduct(Long id) {
        orderProductRepository.deleteById(id);
    }
}
