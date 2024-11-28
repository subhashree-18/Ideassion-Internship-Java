package com.firstconnection.testproject.controller;

import com.firstconnection.testproject.model.Order;
import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.service.OrderService;
import com.firstconnection.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getById")
    public Order getOrderById(@RequestParam Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add")
    public Order addOrder(@RequestBody OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + orderRequest.getUserId()));

        Order order = new Order();
        order.setOrderDate(orderRequest.getOrderDate());
        order.setStatus(orderRequest.getStatus());
        order.setUser(user);

        return orderService.saveOrder(order);
    }

    @PostMapping("/addBatch")
    public List<Order> addOrders(@RequestBody List<OrderRequest> orderRequests) {
        return orderService.saveAllOrders(orderRequests);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestParam Long id, @RequestBody Order updatedOrder) {
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder != null) {
            updatedOrder.setId(id);
            return orderService.saveOrder(updatedOrder);
        }
        return null;
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
    }
}
