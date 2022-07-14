package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	@Autowired
	private CartService service;
	
	@PostMapping("/carts")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		return ResponseEntity.ok().body(service.saveCart(cart));
	}
	
	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> findAllCart() {
		return ResponseEntity.ok().body(service.getAllCart());
	}
	
	@GetMapping("/carts/{name}")
	public ResponseEntity<List<Cart>> findCartByName(@PathVariable String name) {
		return ResponseEntity.ok().body(service.getCartByName(name));
	}
	
	@GetMapping("/carts/id/{id}")
	public ResponseEntity<Cart> findCartByID(@PathVariable int id) {
		return ResponseEntity.ok().body(service.getCartByID(id));
	}
	
	@DeleteMapping("/carts/{id}")
	@Transactional
	public String deleteCart(@PathVariable int id) {
		return service.deleteCart(id);
	}
	
	@PutMapping("/carts")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
		return ResponseEntity.ok().body(service.updateCart(cart));
	}

}
