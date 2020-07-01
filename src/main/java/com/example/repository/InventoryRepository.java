package com.example.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.model.Inventory;

import reactor.core.publisher.Flux;

public interface InventoryRepository extends ReactiveCassandraRepository<Inventory, Integer> {
	
	@AllowFiltering
    Flux<Inventory> findByProductIdGreaterThan(int id);

	@AllowFiltering
	Flux<Inventory> findByMinQuantityToMaintainLessThan(int minQuantityToMaintain);

}
