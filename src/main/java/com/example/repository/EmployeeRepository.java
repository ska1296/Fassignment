package com.example.repository;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import com.example.model.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {
	
	@AllowFiltering
    Flux<Employee> findByAgeGreaterThan(int age);

}
