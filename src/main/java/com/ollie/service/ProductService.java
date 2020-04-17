package com.ollie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ollie.model.Product;
import com.ollie.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		repo.findAll().forEach(prod -> products.add(prod));
		return products;
	}
	
	public Product getProductById(long id) {
		Optional<Product> p = repo.findById(id);
		if (p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	public void deleteProductById(long id) {
		repo.deleteById(id);
	}
	
	public void saveProduct(Product p) {
		repo.save(p);
	}
	
	
}
