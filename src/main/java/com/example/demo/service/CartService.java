package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository repository;
	
	public Cart saveCart(Cart cart) {
		return repository.save(cart);
	}
	
	public List<Cart> getAllCart() {
		return repository.findAllByDate();
	}
	
	public Cart getCartByID(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Cart> getCartByName(String name) {
//		return repository.findByName(name);
		return repository.findByNameContaining(name);
	}
	
	public String deleteCart(int id) {
		repository.deleteById(id);
		return (id + " was remove");
	}
	
	public Cart updateCart(Cart cart) {
		Cart existing = repository.findById(cart.getID()).orElse(null);
		existing.setStatus(cart.getStatus());
		return repository.save(existing);
	}

}
