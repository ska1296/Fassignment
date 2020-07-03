package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Transaction;
import com.example.repository.InventoryRepository;
import com.example.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {
 
    @Autowired
    TransactionRepository transactionRepository;
    
    @Autowired
    InventoryRepository inventoryRepository;
 
    public void initializeTransactions(List<Transaction> transactions) {
        Flux<Transaction> savedTransactions = transactionRepository.saveAll(transactions);
        savedTransactions.subscribe();
    }
 
    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
 
    public Mono<Transaction> getTransactionById(int transactionId) {
        return transactionRepository.findById(transactionId);
    }

	public Mono<Transaction> save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Mono<Void> delete(int id) {
		return transactionRepository.deleteById(id);
	}

	public Mono<Void> deleteAll() {
		return transactionRepository.deleteAll();
	}
}
