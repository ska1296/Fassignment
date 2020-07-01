package com.example.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.model.Transaction;

import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveCassandraRepository<Transaction, Integer> {
	
	@AllowFiltering
	Flux<Transaction> findByProductId(int id);

}
