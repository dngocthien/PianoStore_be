package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	@Id
	@GeneratedValue
	private int ID;
	private String name;
	private String brand;
	private int price;
	private boolean remain;
	@Lob
	private byte[] image;

	public Product() {
	}

	public Product(int iD, String name, String brand, int price, boolean remain, byte[] image) {
		super();
		ID = iD;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.remain = remain;
		this.image = image;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean getRemain() {
		return remain;
	}

	public void setRemain(boolean remain) {
		this.remain = remain;
	};

}
