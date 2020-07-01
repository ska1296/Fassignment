package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Customer;
import com.example.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("customer")
public class CustomerController {
 
    @Autowired
    CustomerService customerService;
 
    @PostConstruct
    public void saveCustomers() {
        List<Customer> customers= new ArrayList<>();
        customers.add(new Customer(12,	1, "CustomerA", "A,B,C", 10));
        customers.add(new Customer(12,	2, "CustomerB", "X,B,C", 20));
        customers.add(new Customer(13,	3, "CustomerC", "A,F,G", 22));
        customers.add(new Customer(15,	4, "CustomerD", "Q,X,C", 56));
        customers.add(new Customer(18,	5, "CustomerE", "Q,F,R", 98));
        customers.add(new Customer(13,	6, "CustomerF", "Z,S,Q", 22));
        customers.add(new Customer(18,	7, "CustomerG", "A,G,H", 98));
        customerService.initializeCustomers(customers);
    }
 
    @GetMapping("/list")
    public Flux<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
 
    @GetMapping("/filter/customer/id/{customerId}")
    public Mono<Customer> getCustomerById(@PathVariable int customerId) {
        return customerService.getCustomerById(customerId);
    }
    
    @GetMapping("/filter/customer/name/{customerName}")
    public Flux<Customer> getCustomerByName(@PathVariable String customerName) {
        return customerService.getCustomerByName(customerName);
    }
    
}