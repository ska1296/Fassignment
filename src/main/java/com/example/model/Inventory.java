package com.example.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Inventory {
	@PrimaryKey
	private int productId;
	private String productname;
	private int quantityStored;
	private int minQuantityToMaintain;
	private boolean manufactured;
	
	public Inventory(int productId, String productname, int quantityStored, int minQuantityToMaintain, boolean manufactured) {
		super();
		this.productId = productId;
		this.productname = productname;
		this.quantityStored = quantityStored;
		this.minQuantityToMaintain = minQuantityToMaintain;
		this.manufactured = manufactured;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getQuantityStored() {
		return quantityStored;
	}
	public void setQuantityStored(int quantityStored) {
		this.quantityStored = quantityStored;
	}
	public int getMinQuantityToMaintain() {
		return minQuantityToMaintain;
	}
	public void setMinQuantityToMaintain(int minQuantityToMaintain) {
		this.minQuantityToMaintain = minQuantityToMaintain;
	}
	public boolean isManufactured() {
		return manufactured;
	}
	public void setManufactured(boolean manufactured) {
		this.manufactured = manufactured;
	}
	
}
