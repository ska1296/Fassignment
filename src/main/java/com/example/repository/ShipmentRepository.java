package com.example.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.model.Shipment;

import reactor.core.publisher.Flux;

public interface ShipmentRepository extends ReactiveCassandraRepository<Shipment, Integer> {
	
	@AllowFiltering
	Flux<Shipment> findByShipmentIdGreaterThan(int id);
	
	@AllowFiltering
	Flux<Shipment> findByCounterPartyId(int id);
}
