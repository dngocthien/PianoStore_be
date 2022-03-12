package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductResponse;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestParam("name") String name, @RequestParam("brand") String brand,
			@RequestParam("price") int price, @RequestParam("remain") boolean remain,
			@RequestParam(value="file", required = false) MultipartFile file) throws IOException {

		Product product = new Product();

		product.setName(name);
		product.setBrand(brand);
		product.setPrice(price);
		product.setRemain(remain);
		if (file != null) {
			product.setImage(file.getBytes());
		}

		return service.saveProduct(product);
	}

	@GetMapping("/products")
	public List<ProductResponse> findAllProduct() {
		return service.getAllProducts().stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable int id) throws IOException {
		Product p = service.getProductByID(id);
		return p.getImage();
	}

	@Transactional
	@GetMapping("/products/{name}")
	public List<ProductResponse> findProductByName(@PathVariable String name) {
		return service.getProductByName(name).stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@Transactional
	@GetMapping("/productByBrand/{brand}")
	public List<ProductResponse> findProductByBrand(@PathVariable String brand) {
		return service.getProductByBrand(brand).stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@GetMapping("/brands")
	public List<String> findAllBrand() {
		return service.getAllBrand();
	}

	@DeleteMapping("/delete/{name}")
	@Transactional
	public String deleteProduct(@PathVariable String name) {
		return service.deleteProduct(name);
	}

	@PostMapping("/updateProduct")
	public Product updateProduct(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("brand") String brand, @RequestParam("price") int price,
			@RequestParam("remain") boolean remain, @RequestParam( value="file", required = false) MultipartFile file) throws IOException {

		Product product = service.getProductByID(id);
		product.setName(name);
		product.setBrand(brand);
		product.setPrice(price);
		product.setRemain(remain);
		if (file != null) {
			product.setImage(file.getBytes());
		}

		return service.saveProduct(product);
	}

	private ProductResponse mapToFileResponse(Product product) {
		String uri = null;
		if(product.getImage()!=null) {
			uri  = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(product.getID()+"")
					.toUriString();
		}
		return new ProductResponse(product.getID() ,product.getName(), product.getBrand(), product.getPrice(), product.getRemain(), uri);
	}
}
