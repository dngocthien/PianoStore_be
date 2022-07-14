package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ProductDto {
	private int id;
	private String name;
	private String brand;
	private int price;
	private boolean remain;
	private int discount;
	private String image;
	public ProductDto() {
		super();
	}

}
