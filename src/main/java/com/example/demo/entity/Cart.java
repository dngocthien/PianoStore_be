package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	@Id
	@GeneratedValue
	private int ID;
	private String name;
	private String address;
	private String phone;
	private String message;
	private boolean bank;
	private String date;
	private int status;

	
	public Cart() {
	}

	public Cart(int iD, String name, String address, String phone, String message, boolean bank, String date, int status) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.message = message;
		this.bank = bank;
		this.date = date;
		this.status = status;
	}





	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isBank() {
		return bank;
	}

	public void setBank(boolean bank) {
		this.bank = bank;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
