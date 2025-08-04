package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.service.ProductService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	public ProductService productservice;
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productservice.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public Product gettProductById(@PathVariable Long id) {
		return productservice.getProductById(id);
	}
	
	@PostMapping()
	public Product addProduct(@RequestBody Product product) {
		return productservice.addProduct(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
		return productservice.updateProduct(id, product);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		productservice.DeleteProductById(id);
	}
	
	

}
