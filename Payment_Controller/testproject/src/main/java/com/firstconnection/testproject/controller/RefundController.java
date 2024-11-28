package com.firstconnection.testproject.controller;

import com.firstconnection.testproject.model.Refund;
import com.firstconnection.testproject.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refunds")
public class RefundController {

    @Autowired
    private RefundService refundService;

    @GetMapping
    public List<Refund> getAllRefunds() {
        return refundService.getAllRefunds();
    }

    @PostMapping
    public Refund createRefund(@RequestBody Refund refund) {
        return refundService.saveRefund(refund);
    }

    @GetMapping("/{id}")
    public Refund getRefundById(@PathVariable Long id) {
        return refundService.getRefundById(id);
    }

    @PutMapping("/{id}")
    public Refund updateRefund(@PathVariable Long id, @RequestBody Refund refund) {
        refund.setId(id);
        return refundService.saveRefund(refund);
    }

    @DeleteMapping("/{id}")
    public String deleteRefund(@PathVariable Long id) {
        refundService.deleteRefundById(id);
        return "Refund with ID " + id + " has been deleted successfully.";
    }
}
