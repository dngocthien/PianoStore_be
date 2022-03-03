package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
@CrossOrigin
public class ItemController {
	@Autowired
	private ItemService service;
	
	@PostMapping("/addItems")
	public List<Item> addItems(@RequestBody List<Item> items) {
		return service.saveItems(items);
	}
	
	@PostMapping("/addItem")
	public Item addItem(@RequestBody Item item) {
		return service.saveItem(item);
	}
	
	@GetMapping("/items/{id}")
	public List<Item> findItemsByCartID(@PathVariable int id) {
		return service.getItemsByCartID(id);
	}
}
