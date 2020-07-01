package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
 
    @Autowired
    CustomerRepository customerRepository;
 
    public void initializeCustomers(List<Customer> customers) {
        Flux<Customer> savedCustomers = customerRepository.saveAll(customers);
        savedCustomers.subscribe();
    }
 
    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
 
    public Mono<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

	public Flux<Customer> getCustomerByName(String customerName) {
		return customerRepository.findByCustomerName(customerName);
	}
}
