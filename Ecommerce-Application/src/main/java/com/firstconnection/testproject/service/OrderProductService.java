package com.firstconnection.testproject.service;

import com.firstconnection.testproject.model.OrderProduct;
import com.firstconnection.testproject.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public List<OrderProduct> getAllOrderProducts() {
        return orderProductRepository.findAll();
    }

    public OrderProduct getOrderProductById(Long id) {
        return orderProductRepository.findById(id).orElse(null);
    }

    public OrderProduct getOrderProductByOrderIdAndProductId(Long orderId, Long productId) {
        return orderProductRepository.findByOrderIdAndProductId(orderId, productId);
    }

    @Transactional
    public OrderProduct saveOrderProduct(OrderProduct orderProduct) {
        if (orderProduct.getOrder() == null || orderProduct.getProduct() == null) {
            throw new IllegalArgumentException("Order and Product must not be null");
        }
        return orderProductRepository.save(orderProduct);
    }

    public List<OrderProduct> saveAllOrderProducts(List<OrderProduct> orderProducts) {
        return orderProductRepository.saveAll(orderProducts);
    }

    public void deleteOrderProduct(Long id) {
        orderProductRepository.deleteById(id);
    }
}

