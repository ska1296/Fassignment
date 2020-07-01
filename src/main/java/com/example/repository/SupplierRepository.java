package com.example.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.model.Supplier;

import reactor.core.publisher.Flux;

public interface SupplierRepository extends ReactiveCassandraRepository<Supplier, Integer> {
	
	@AllowFiltering
	Flux<Supplier> findBySupplierName(String supplierName);
}
