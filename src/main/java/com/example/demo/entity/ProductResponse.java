package com.example.demo.entity;

import lombok.Data;

@Data
public class ProductResponse {
	private String name;
	private String brand;
	private int price;
	private boolean remain;
	private String image;
	public ProductResponse() {
		super();
	}
	
	public ProductResponse(String name, String brand, int price, boolean remain, String image) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.remain = remain;
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
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
