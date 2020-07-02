package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.LocalDate;
import com.example.model.Transaction;
import com.example.service.TransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("transaction")
public class TransactionController {
 
    @Autowired
    TransactionService transactionService;
 
    @PostConstruct
    public void saveTransactions() {
        List<Transaction> transactions= new ArrayList<>();
        transactions.add(new Transaction(13, 55, 13, 22, false, true, 6));
        transactions.add(new Transaction(12, 56, 10, 10, false, true, 1));
        transactions.add(new Transaction(18, 23, 18, 98, false, true, 5));
        transactions.add(new Transaction(23, 28, 5, 10, true, true, 1));
        transactions.add(new Transaction(11, 30, 89, 22, true, true, 3));
        transactions.add(new Transaction(20, 99, 22, 56, true, true, 4));
        transactionService.initializeTransactions(transactions);
    }
 
    @GetMapping("/list")
    public Flux<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
 
    @GetMapping("/{id}")
    public Mono<Transaction> getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }
 
    @GetMapping("/filter/product/{age}")
    public Flux<Transaction> getTransactionsFilterByAge(@PathVariable int age) {
        return transactionService.findByProductId(age);
    }
    
    
    @PostMapping("/add")
    public Mono<Object> create(@RequestBody Transaction transaction){
    	return transactionService.save(transaction).map(savedUser -> ResponseEntity.ok(savedUser));
    }
    
}