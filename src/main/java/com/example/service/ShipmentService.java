package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Shipment;
import com.example.repository.ShipmentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ShipmentService {
 
    @Autowired
    ShipmentRepository purchaseRepository;
 
    public void initializeShipments(List<Shipment> purchases) {
        Flux<Shipment> savedShipments = purchaseRepository.saveAll(purchases);
        savedShipments.subscribe();
    }
 
    public Flux<Shipment> getAllShipments() {
        return purchaseRepository.findAll();
    }
 
    public Flux<Shipment> getShipmentsFilterById(int age) {
        return purchaseRepository.findByCounterPartyId(age);
    }
 
    public Mono<Shipment> getShipmentById(int id) {
        return purchaseRepository.findById(id);
    }
}
