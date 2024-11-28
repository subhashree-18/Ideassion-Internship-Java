package com.firstconnection.testproject.repository;

import com.firstconnection.testproject.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    OrderProduct findByOrderIdAndProductId(Long orderId, Long productId);
}
