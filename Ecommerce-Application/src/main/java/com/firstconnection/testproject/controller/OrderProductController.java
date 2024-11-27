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

    @PostMapping("/add")
    public OrderProduct addOrderProduct(@RequestBody OrderProduct orderProduct) {
        return orderProductService.saveOrderProduct(orderProduct);
    }

    @PostMapping("/addBatch")
    public List<OrderProduct> addOrderProducts(@RequestBody List<OrderProduct> orderProducts) {
        return orderProductService.saveAllOrderProducts(orderProducts);
    }

    @PutMapping("/updateQuantity")
    public OrderProduct updateProductQuantity(@RequestParam Long orderId, @RequestParam Long productId, @RequestParam int quantity) {
        OrderProduct existingOrderProduct = orderProductService.getOrderProductByOrderIdAndProductId(orderId, productId);
        if (existingOrderProduct != null) {
            existingOrderProduct.setQuantity(quantity);
            return orderProductService.saveOrderProduct(existingOrderProduct);
        }
        throw new IllegalArgumentException("Order-Product mapping not found");
    }

    @DeleteMapping("/delete")
    public void deleteOrderProduct(@RequestParam Long id) {
        orderProductService.deleteOrderProduct(id);
    }
}
