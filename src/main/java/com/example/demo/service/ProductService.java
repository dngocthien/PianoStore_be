package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Component
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductByID(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Product> getProductByName(String name) {
		return repository.findByNameContaining(name);
	}

	public List<Product> getProductByBrand(String brand) {
		return repository.findByBrand(brand);
	}

	public String deleteProduct(String name) {
		repository.deleteByName(name);
		return (name + " was remove");
	}

	public Product updateProduct(Product product) {
		Product existing = repository.findByName(product.getName());
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		return repository.save(existing);
	}

	public List<String> getAllBrand() {
		return repository.findDistinctBrand();
	}

	public List<Product> getCheapProducts(){
		return repository.findCheap();
	}

}
