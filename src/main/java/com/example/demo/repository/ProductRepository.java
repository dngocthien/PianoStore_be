package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Product;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

	List<Product> findByBrand(int brand);

	List<Product> findByNameContaining(String name);

	void deleteByName(String name);

	@Transactional
	@Query("SELECT p FROM Product p WHERE p.price > 0 ORDER BY p.price")
	List<Product> findCheap();
//	@Query(value="SELECT p from Product p ORDER BY p.price LIMIT 0, 8", nativeQuery = true)

	@Transactional
	@Query("SELECT p FROM Product p WHERE p.discount > 0 ORDER BY p.price")
	List<Product> findDiscount();

}
