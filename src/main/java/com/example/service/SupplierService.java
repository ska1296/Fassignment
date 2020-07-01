package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Supplier;
import com.example.model.Supplier;
import com.example.repository.SupplierRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SupplierService {
 
    @Autowired
    SupplierRepository supplierRepository;
 
    public void initializeSuppliers(List<Supplier> suppliers) {
        Flux<Supplier> savedSuppliers = supplierRepository.saveAll(suppliers);
        savedSuppliers.subscribe();
    }
 
    public Flux<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
 
    public Mono<Supplier> getSupplierById(int id) {
        return supplierRepository.findById(id);
    }

	public Flux<Supplier> getSupplierByName(String supplierName) {
		return supplierRepository.findBySupplierName(supplierName);
	}
	
}
