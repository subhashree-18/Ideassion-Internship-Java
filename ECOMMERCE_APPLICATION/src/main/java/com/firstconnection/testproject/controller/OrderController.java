package com.firstconnection.testproject.controller;


import com.firstconnection.testproject.model.Order;
import com.firstconnection.testproject.model.OrderProduct;
import com.firstconnection.testproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get")
    public Order getOrderById(@RequestParam Long id) {
        return orderService.getOrderById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    @PostMapping("/create")
    public Order createOrder(@RequestParam Long buyerId, @RequestBody List<OrderProduct> orderProducts) {
        return orderService.placeOrder(buyerId, orderProducts);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestParam Long id, @RequestBody Order orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    @DeleteMapping("/delete")
    public void deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
    }
}
