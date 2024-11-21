package com.firstconnection.testproject.controller;

import com.firstconnection.testproject.model.Payment;
import com.firstconnection.testproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    
    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    
    @GetMapping("/getById")
    public Payment getPaymentById(@RequestParam Long id) {
        return paymentService.getPaymentById(id);
    }

    
    @PutMapping("/update/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        payment.setId(id);
        return paymentService.savePayment(payment);
    }

    
    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return "Payment with ID " + id + " has been deleted successfully.";
    }
}
