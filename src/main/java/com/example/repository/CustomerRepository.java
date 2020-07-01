package com.example.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository extends ReactiveCassandraRepository<Customer, Integer> {

	@AllowFiltering
	Flux<Customer> findByCustomerName(String customerName);

}
