package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Product {
	@Id
	@GeneratedValue
	private int ID;
	private String name;
	private int brand;
	private int price;
	private boolean remain;
	private int discount;
	@Lob
	private byte[] image;

}
