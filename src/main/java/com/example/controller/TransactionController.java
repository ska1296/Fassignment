package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        transactions.add(new Transaction(13, 55, 13, 22, false, LocalDate.fromYearMonthDay(2015, 9, 21), true, LocalDate.fromYearMonthDay(2015, 9, 22), 6));
        transactions.add(new Transaction(12, 56, 10, 10, false, LocalDate.fromYearMonthDay(2020, 5, 12), true, LocalDate.fromYearMonthDay(2020, 5, 26), 1));
        transactions.add(new Transaction(18, 23, 18, 98, false, LocalDate.fromYearMonthDay(2020, 6, 3), true, LocalDate.fromYearMonthDay(2020, 6, 13), 5));
        transactions.add(new Transaction(23, 28, 5, 10, true, LocalDate.fromYearMonthDay(2020, 4, 1), true, LocalDate.fromYearMonthDay(2020, 4, 9), 1));
        transactions.add(new Transaction(11, 30, 89, 22, true, LocalDate.fromYearMonthDay(1999, 9, 9), true, LocalDate.fromYearMonthDay(1999, 9, 12), 3));
        transactions.add(new Transaction(20, 99, 22, 56, true, LocalDate.fromYearMonthDay(2013, 6, 5), true, LocalDate.fromYearMonthDay(2013, 7, 05), 4));
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
    
}