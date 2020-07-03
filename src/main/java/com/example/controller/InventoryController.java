package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Inventory;
import com.example.service.InventoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@PostConstruct
	public void saveInventories() {
		List<Inventory> inventories = new ArrayList<>();
		inventories.add(new Inventory(12, "ABC", 90, 2, true));
		inventories.add(new Inventory(13, "DEF", 23, 6, true));
		inventories.add(new Inventory(15, "GHI", 11, 8, true));
		inventories.add(new Inventory(18, "JKL", 11, 8, true));
		inventories.add(new Inventory(23, "MNO", 18, 16, false));
		inventories.add(new Inventory(10, "PQR", 22, 16, false));
		inventories.add(new Inventory(11, "STU", 100, 20, false));
		inventories.add(new Inventory(20, "VWX", 11, 11, false));
		inventories.add(new Inventory(21, "YZ", 55, 10, true));
		inventoryService.initializeInventories(inventories);

	}

	@GetMapping("/list")
	public Flux<Inventory> getAllInventories() {
		return inventoryService.getAllInventories();
	}

	@GetMapping("/filter/byId/{id}")
	public Mono<Inventory> getInventoryById(@PathVariable int id) {
		return inventoryService.getInventoryById(id);
	}

	@GetMapping("/filter/minquantity/{quantity}")
	public Flux<Inventory> getInventoriesFilterByMinQtLessThan(@PathVariable int quantity) {
		return inventoryService.getInventoriesFilterByMinQuantityToMaintain(quantity);
	}
	
	@PostMapping("/add")
    public Mono<Object> create(@RequestBody Inventory inventory) {
    	return inventoryService.save(inventory).map(savedUser -> ResponseEntity.ok(savedUser));
    }
    
    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteOne(@RequestBody int id) {
    	return inventoryService.delete(id);
    }
    
    @DeleteMapping("/delete/all")
    public Mono<Void> deleteAll() {
    	return inventoryService.deleteAll();
    }
}