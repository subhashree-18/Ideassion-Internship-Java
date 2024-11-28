package com.firstconnection.testproject.service;


import com.firstconnection.testproject.model.Order;
import com.firstconnection.testproject.model.OrderProduct;
import com.firstconnection.testproject.model.Product;
import com.firstconnection.testproject.model.User;
import com.firstconnection.testproject.repository.OrderProductRepository;
import com.firstconnection.testproject.repository.OrderRepository;
import com.firstconnection.testproject.repository.ProductRepository;
import com.firstconnection.testproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    // Place an Order (BUYER purchases products)
    public Order placeOrder(Long buyerId, List<OrderProduct> orderProducts) {
        Optional<User> buyer = userRepository.findById(buyerId);
        if (buyer.isPresent() && buyer.get().getRole() == User.Role.BUYER) {
            Order order = new Order();
            order.setUser(buyer.get());
            order.setOrderDate(new Date());

            Order savedOrder = orderRepository.save(order);

            for (OrderProduct orderProduct : orderProducts) {
                Product product = productRepository.findById(orderProduct.getProduct().getId())
                        .orElseThrow(() -> new IllegalArgumentException("Product not found"));

                if (product.getStock() < orderProduct.getQuantity()) {
                    throw new IllegalArgumentException("Insufficient stock for product: " + product.getName());
                }

                // Reduce stock
                product.setStock(product.getStock() - orderProduct.getQuantity());
                productRepository.save(product);

                // Save OrderProduct
                orderProduct.setOrder(savedOrder);
                orderProductRepository.save(orderProduct);
            }

            return savedOrder;
        }
        throw new IllegalArgumentException("Only BUYER users can place orders.");
    }

    // Update an Order
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        existingOrder.setOrderDate(orderDetails.getOrderDate());
        return orderRepository.save(existingOrder);
    }

    // Get all Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get Order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Delete Order (and associated OrderProducts)
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
