package com.example.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Transaction;
import com.example.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {
 
    @Autowired
    TransactionRepository transactionRepository;
 
    public void initializeTransactions(List<Transaction> transactions) {
        Flux<Transaction> savedTransactions = transactionRepository.saveAll(transactions);
        savedTransactions.subscribe();
    }
 
    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
 
    public Flux<Transaction> findByProductId(int age) {
        return transactionRepository.findByProductId(age);
    }
 
    public Mono<Transaction> getTransactionById(int transactionId) {
        return transactionRepository.findById(transactionId);
    }
}
