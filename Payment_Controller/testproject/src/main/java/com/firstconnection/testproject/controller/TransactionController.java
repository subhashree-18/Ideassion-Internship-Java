package com.firstconnection.testproject.controller;

import com.firstconnection.testproject.model.Transaction;
import com.firstconnection.testproject.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping("/getById")
    public Transaction getTransactionById(@RequestParam Long id) {
        return transactionService.getTransactionById(id);
    }

    @PutMapping("/update")
    public Transaction updateTransaction(@RequestParam Long id, @RequestBody Transaction transaction) {
        transaction.setId(id);
        return transactionService.saveTransaction(transaction);
    }

    @DeleteMapping("/delete")
    public String deleteTransaction(@RequestParam Long id) {
        transactionService.deleteTransactionById(id);
        return "Transaction with ID " + id + " has been deleted successfully.";
    }

    @PutMapping("/updateStatus")
    public Transaction updateTransactionStatus(@RequestParam Long id, @RequestParam String status) {
        Transaction transaction = transactionService.getTransactionById(id);
        if (transaction != null) {
            transaction.setStatus(status);
            return transactionService.saveTransaction(transaction);
        } else {
            return null;
        }
    }
}
