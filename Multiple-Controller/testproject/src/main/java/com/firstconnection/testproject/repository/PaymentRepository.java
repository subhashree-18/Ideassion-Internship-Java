package com.firstconnection.testproject.repository;

import com.firstconnection.testproject.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // You can add custom query methods here if needed
}
