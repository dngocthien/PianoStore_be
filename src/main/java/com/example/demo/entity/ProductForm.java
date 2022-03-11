package com.example.demo.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductForm {

	private String name;
	private String brand;
	private int price;
	private int remain;
	private MultipartFile image;

	public ProductForm() {
	}

	

	public ProductForm(String name, String brand, int price, int remain, MultipartFile image) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.remain = remain;
		this.image = image;
	}



	public MultipartFile getImage() {
		return image;
	}



	public void setImage(MultipartFile image) {
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

	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	};

}
