package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
@Component
public class ProductService {

	@Autowired
	private ProductRepository repository;

//	public Product saveProduct(ProductForm form) throws IOException {
//		final Path CURRENT_FOLDER = Paths.get(System.getProperty("product.dir"));
//		Path staticPath = Paths.get("static");
//        Path imagePath = Paths.get("images");
//        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
//            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
//        }
//        Path file = CURRENT_FOLDER.resolve(staticPath)
//                .resolve(imagePath).resolve(form.getName());
//        try (OutputStream os = Files.newOutputStream(file)) {
//            os.write(form.getImage().getBytes());
//        }
//        Product product = new Product();
//        product.setName(form.getName());
//        product.setBrand(form.getBrand());
//        product.setPrice(form.getPrice());
//        product.setRemain(form.getRemain());
//        product.setImage(imagePath.resolve(form.getImage().getOriginalFilename()).toString());
//        
//		return repository.save(product);
//	}
	
	public Product saveProduct(Product product) {
//		byte[] image = Base64.getEncoder().encode(product.getImage());
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product getProductByID(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<Product> getProductByName(String name) {
		return repository.findByNameContaining(name);
	}

	public List<Product> getProductByBrand(String brand) {
		return repository.findByBrand(brand);
	}

	public String deleteProduct(String name) {
		repository.deleteByName(name);
		return (name + " was remove");
	}

	public Product updateProduct(Product product) {
		Product existing = repository.findByName(product.getName());
		existing.setName(product.getName());
		existing.setPrice(product.getPrice());
		return repository.save(existing);
	}

	public List<String> getAllBrand() {
		return repository.findDistinctBrand();
	}

}
