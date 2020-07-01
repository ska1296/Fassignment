package com.example.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Supplier {
	
	private int productId;
	@PrimaryKey
	private int supplierId;
	private String supplierName;
	private String supplierAddress;
	private double pricePerUnit;
	

	public Supplier(int productId, int supplierId, String supplierName, String supplierAddress, double pricePerUnit) {
		super();
		this.productId = productId;
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.pricePerUnit = pricePerUnit;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
