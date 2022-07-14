package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.demo.entity.Brand;
import com.example.demo.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Product;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService service;
	@Autowired
	private BrandRepo brandRepo;

	@PostMapping("/products")
	public Product addProduct(@RequestParam("name") String name, @RequestParam("brand") int brand,
			@RequestParam("price") int price, @RequestParam("remain") boolean remain, @RequestParam("discount") int discount,
			@RequestParam(value="file", required = false) MultipartFile file) throws IOException {

		Product product = new Product();

		product.setName(name.toUpperCase());
		product.setBrand(brand);
		product.setPrice(price);
		product.setRemain(remain);
		product.setDiscount(discount);
		if (file != null) {
			product.setImage(file.getBytes());
		}

		return service.saveProduct(product);
	}

	@GetMapping("/products")
	public List<ProductDto> findAllProduct() {
		return service.getAllProducts().stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable int id) throws IOException {
		Product p = service.getProductByID(id);
		return p.getImage();
	}

	@Transactional
	@GetMapping("/products/{name}")
	public List<ProductDto> findProductByName(@PathVariable String name) {
		return service.getProductByName(name.toUpperCase()).stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@Transactional
	@GetMapping("/products/brand/{brand}")
	public List<ProductDto> findProductByBrand(@PathVariable int brand) {
		return service.getProductByBrand(brand).stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@GetMapping("/brands")
	public List<Brand> findAllBrand() {
		return service.getAllBrand();
	}

	@GetMapping("/products/cheap")
	public List<ProductDto> findCheapProducts() {
		return service.getCheapProducts().stream().map(this::mapToFileResponse).collect(Collectors.toList());
	}

	@DeleteMapping("/products/{name}")
	@Transactional
	public String deleteProduct(@PathVariable String name) {
		return service.deleteProduct(name);
	}

	@PutMapping("/products")
	public Product updateProduct(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("brand") String brand, @RequestParam("price") int price,
			@RequestParam("remain") boolean remain, @RequestParam("discount") int discount, @RequestParam( value="file", required = false) MultipartFile file) throws IOException {

		Product product = service.getProductByID(id);
		product.setName(name);
		product.setBrand(service.getBrandByName(brand).getID());
		product.setPrice(price);
		product.setRemain(remain);
		product.setDiscount(discount);
		if (file != null) {
			product.setImage(file.getBytes());
		}
		return service.saveProduct(product);
	}

	private ProductDto mapToFileResponse(Product product) {
		String uri = null;
		if(product.getImage()!=null) {
			uri  = ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(product.getID()+"")
					.toUriString();
		}
//		brandRepo.getById(product.getBrand()).getName()
		return new ProductDto(product.getID() ,product.getName(), service.getBrandById(product.getBrand()).getName() , product.getPrice(), product.isRemain(), product.getDiscount(), uri);
	}
}
