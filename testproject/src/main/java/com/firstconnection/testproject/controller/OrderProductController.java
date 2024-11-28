package com.firstconnection.testproject.controller;

import com.firstconnection.testproject.model.OrderProduct;
import com.firstconnection.testproject.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }

    @GetMapping("/get")
    public OrderProduct getOrderProductById(@RequestParam Long id) {
        return orderProductService.getOrderProductById(id);
    }

    @PostMapping("/create")
    public OrderProduct createOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.saveOrderProduct(orderProduct);
    }

    @PutMapping("/update")
    public OrderProduct updateOrderProduct(@RequestParam Long id, @RequestBody OrderProduct orderProductDetails) {
        return orderProductService.updateOrderProduct(id, orderProductDetails);
    }

    @DeleteMapping("/delete")
    public void deleteOrderProduct(@RequestParam Long id) {
        orderProductService.deleteOrderProduct(id);
    }
}
