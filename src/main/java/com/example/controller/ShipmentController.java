package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.LocalDate;
import com.example.model.Shipment;
import com.example.service.ShipmentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("shipment")
public class ShipmentController {
 
    @Autowired
    ShipmentService shipmentService;
 
    @PostConstruct
    public void saveShipments() {
        List<Shipment> shipments= new ArrayList<>();
        
        shipments.add(new Shipment(56, false, LocalDate.fromYearMonthDay(2020, 5, 22), 10, 1, 12));
        shipments.add(new Shipment(55, false, LocalDate.fromYearMonthDay(2015, 9, 21), 13, 6, 13));
        shipments.add(new Shipment(23, false, LocalDate.fromYearMonthDay(2020, 6, 03), 18, 5, 18));
        shipments.add(new Shipment(28, true, LocalDate.fromYearMonthDay(2020, 8, 9), 5, 1, 23));
        shipments.add(new Shipment(11, true, LocalDate.fromYearMonthDay(2011, 5, 5), 6, 2, 10));
        shipments.add(new Shipment(30, true, LocalDate.fromYearMonthDay(1999, 9, 9), 89, 3, 11));
        shipments.add(new Shipment(99, true, LocalDate.fromYearMonthDay(2013, 6, 5), 22, 4, 20));
        shipmentService.initializeShipments(shipments);
    }
 
    @GetMapping("/list")
    public Flux<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }
 
    @GetMapping("/{id}")
    public Mono<Shipment> getShipmentById(@PathVariable int id) {
        return shipmentService.getShipmentById(id);
    }
 
    @GetMapping("/filter/partyid/{id}")
    public Flux<Shipment> getShipmentsByCounterPartyId(@PathVariable int id) {
        return shipmentService.getShipmentsFilterById(id);
    }
}