package com.example.demo.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/addCart")
	public Cart addCart(@RequestBody Cart cart) {
		return service.saveCart(cart);
	}
	
	@GetMapping("/carts")
	public List<Cart> findAllCart() {
		return service.getAllCart();
	}
	
	@GetMapping("/carts/{name}")
	public List<Cart> findCartByName(@PathVariable String name) {
		return service.getCartByName(name);
	}
	
	@GetMapping("/cartByID/{id}")
	public Cart findCartByID(@PathVariable int id) {
		return service.getCartByID(id);
	}
	
	@DeleteMapping("/deleteCart/{id}")
	@Transactional
	public String deleteCart(@PathVariable int id) {
		return service.deleteCart(id);
	}
	
	@PutMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart cart) {
		return service.updateCart(cart);
	}

}
