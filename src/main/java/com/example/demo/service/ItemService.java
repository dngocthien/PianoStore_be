package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repository;
	
	public List<Item> saveItems(List<Item> items) {
		return repository.saveAll(items);
	}
	
	public Item saveItem(Item item) {
		return repository.save(item);
	}
	
	public List<Item> getItemsByCartID(int cartID) {
		return repository.findByCartID(cartID);
	}

}
