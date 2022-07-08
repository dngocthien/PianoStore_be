package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

	List<Product> findByBrand(String brand);

	List<Product> findByNameContaining(String name);

	void deleteByName(String name);

	@Query("SELECT DISTINCT brand FROM Product")
	List<String> findDistinctBrand();

//	@Query("SELECT p FROM Product p WHERE p.price > 0 ORDER BY p.price LIMIT 8")
	@Query(value="SELECT * from Product p ORDER BY p.price LIMIT 8", nativeQuery = true)
	List<Product> findCheap();

}
