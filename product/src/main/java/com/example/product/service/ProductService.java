package com.example.product.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	public Product updateProduct(Long id,Product product) {
		  Product existingProduct = productRepository.findById(id)
			        .orElse(null);

			    existingProduct.setName(product.getName());
			    existingProduct.setPrice(product.getPrice());
			    existingProduct.setYear(product.getYear());

			    return productRepository.save(existingProduct);
	}
	
	public void DeleteProductById(Long id) {
		 productRepository.deleteById(id);
	}
	

	
	

}
