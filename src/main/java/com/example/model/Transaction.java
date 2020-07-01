package com.example.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import com.datastax.driver.core.LocalDate;

public class Transaction {
	
	@PrimaryKey
	private int productId;
	private int orderId;
	private int productQuantity;
	private double pricePerUnit;
	private boolean bought;
	private LocalDate orderDate;
	private boolean received;
	private LocalDate receivedDate;
	private int counterPartyId;
	
	public Transaction(int productId, int orderId, int productQuantity, double pricePerUnit, boolean bought, LocalDate orderDate, boolean received, LocalDate receivedDate, int counterPartyId) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.productQuantity = productQuantity;
		this.pricePerUnit = pricePerUnit;
		this.bought = bought;
		this.orderDate = orderDate;
		this.received = received;
		this.receivedDate = receivedDate;
		this.counterPartyId = counterPartyId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public boolean isReceived() {
		return received;
	}

	public void setReceived(boolean received) {
		this.received = received;
	}

	public LocalDate getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(LocalDate receivedDate) {
		this.receivedDate = receivedDate;
	}

	public int getCounterPartyId() {
		return counterPartyId;
	}

	public void setCounterPartyId(int counterPartyId) {
		this.counterPartyId = counterPartyId;
	}

}
