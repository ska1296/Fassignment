package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Supplier;
import com.example.service.SupplierService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("supplier")
public class SupplierController {
 
    @Autowired
    SupplierService supplierService;
 
    @PostConstruct
    public void saveSuppliers() {
        List<Supplier> suppliers= new ArrayList<>();
        suppliers.add(new Supplier(23, 1, "SupplierA", "P,Q,R", 10));
        suppliers.add(new Supplier(10, 2, "SupplierB", "L,K,J", 20));
        suppliers.add(new Supplier(11, 3, "SupplierC", "R,Y", 22));
        suppliers.add(new Supplier(20, 4, "SupplierD", "F,Y,W", 56));
        suppliers.add(new Supplier(23, 5, "SupplierE", "P,R,T", 98));
        suppliers.add(new Supplier(23, 6, "SupplierF", "Z,K,L", 22));
        suppliers.add(new Supplier(10, 7, "SupplierG", "I,N,G", 29));
        suppliers.add(new Supplier(11, 8, "SupplierH", "U,I,O", 98));
        suppliers.add(new Supplier(11, 9, "SupplierI", "Q,J,U", 11));
        supplierService.initializeSuppliers(suppliers);
    }
 
    @GetMapping("/list")
    public Flux<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
 
    @GetMapping("/filter/supplier/id/{supplierId}")
    public Mono<Supplier> getSupplierById(@PathVariable int supplierId) {
        return supplierService.getSupplierById(supplierId);
    }
    
    @GetMapping("/filter/supplier/name/{supplierName}")
    public Flux<Supplier> getSupplierByName(@PathVariable String supplierName) {
        return supplierService.getSupplierByName(supplierName);
    }
}