package com.firstconnection.testproject.service;

import com.firstconnection.testproject.model.Order;
import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.repository.OrderRepository;
import com.firstconnection.testproject.repository.UserRepository;
import com.firstconnection.testproject.controller.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> saveAllOrders(List<OrderRequest> orderRequests) {
        List<Order> orders = new ArrayList<>();

        for (OrderRequest request : orderRequests) {
            User user = userRepository.findById(request.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getUserId()));

            Order order = new Order();
            order.setOrderDate(request.getOrderDate());
            order.setStatus(request.getStatus());
            order.setUser(user);

            orders.add(order);
        }

        return orderRepository.saveAll(orders);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
