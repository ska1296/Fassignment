package com.example.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.LocalDate;

@Table
public class Shipment {
	
	@PrimaryKey
	private int shipmentId;
	private boolean incoming;
	private LocalDate shipmentDate;
	private int itemQuantity;
	private int counterPartyId;
	private int productId;
	
	public Shipment(int shipmentId, boolean incoming, LocalDate shipmentDate, int itemQuantity, int counterPartyId, int productId) {
		super();
		this.shipmentId = shipmentId;
		this.incoming = incoming;
		this.shipmentDate = shipmentDate;
		this.itemQuantity = itemQuantity;
		this.counterPartyId = counterPartyId;
		this.productId = productId;
	}
	
	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public boolean isIncoming() {
		return incoming;
	}
	public void setIncoming(boolean incoming) {
		this.incoming = incoming;
	}
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getCounterPartyId() {
		return counterPartyId;
	}
	public void setCounterPartyId(int counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
