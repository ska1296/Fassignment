package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Inventory;
import com.example.repository.InventoryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryService {
 
    @Autowired
    InventoryRepository inventoryRepository;
 
    public void initializeInventories(List<Inventory> inventories) {
        Flux<Inventory> savedInventories = inventoryRepository.saveAll(inventories);
        savedInventories.subscribe();
    }
 
    public Flux<Inventory> getAllInventories() {
        return  inventoryRepository.findAll();
    }
 
    public Flux<Inventory> getInventoriesFilterByMinQuantityToMaintain(int minQuantityToMaintain) {
        return inventoryRepository.findByMinQuantityToMaintainLessThan(minQuantityToMaintain);
    }
 
    public Mono<Inventory> getInventoryById(int id) {
        return inventoryRepository.findById(id);
    }

	public Mono<Inventory> save(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	public Mono<Void> delete(int id) {
		return inventoryRepository.deleteById(id);
	}

	public Mono<Void> deleteAll() {
		return inventoryRepository.deleteAll();
	}

}