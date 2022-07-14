package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findByNameContaining(String name);

	@Query("SELECT c FROM Cart c ORDER BY c.date DESC")
	List<Cart> findAllByDate();
}
