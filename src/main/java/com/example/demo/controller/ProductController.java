package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProduct(@RequestBody List<Product> product) {
		return service.saveProducts(product);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProduct() {
		return service.getAllProduct();
	}
	
	@GetMapping("/productByID/{id}")
	public Product findProductByID(@PathVariable int id) {
		return service.getProductByID(id);
	}
	
	@GetMapping("/productByName/{name}")
	public List<Product> findProductByName(@PathVariable String name) {
		return service.getProductByName(name);
	}
	
	@GetMapping("/productByBrand/{brand}")
	public List<Product> findProductByBrand(@PathVariable String brand) {
		return service.getProductByBrand(brand);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
}
