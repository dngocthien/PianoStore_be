package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Brand;
import com.example.demo.repository.BrandRepo;
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
	@Autowired
	private BrandRepo brandRepo;
	
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

	public List<Product> getProductByBrand(int brand) {
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

	public List<Product> getCheapProducts(){
		return repository.findCheap();
	}

	public List<Product> getDiscountProducts(){
		return repository.findDiscount();
	}

    public Brand saveBrand(Brand brand) {
		return  brandRepo.save(brand);
    }

	public List<Brand> getAllBrand() {
		return brandRepo.findAll();
	}

	public Brand getBrandById(int id){
		return brandRepo.findById(id).orElse(null);
	}

	public Brand getBrandByName(String name){
		return brandRepo.findByName(name);
	}
}
