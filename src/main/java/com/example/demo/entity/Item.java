package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
	@Id
	@GeneratedValue
	int ID;
	int cartID;
	String productName;
	int unitPrice;
	int quantity;

	public Item() {
	}

	public Item(int iD, int cartID, String productName, int unitPrice, int quantity) {
		ID = iD;
		this.cartID = cartID;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int orderID) {
		this.cartID = orderID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
