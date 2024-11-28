package com.firstconnection.testproject.service;

import com.firstconnection.testproject.model.Refund;
import com.firstconnection.testproject.repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefundService {

    @Autowired
    private RefundRepository refundRepository;

    public List<Refund> getAllRefunds() {
        return refundRepository.findAll();
    }

    public Refund saveRefund(Refund refund) {
        return refundRepository.save(refund);
    }

    public Refund getRefundById(Long id) {
        return refundRepository.findById(id).orElse(null);
    }

    public void deleteRefundById(Long id) {
        refundRepository.deleteById(id);
    }
}
