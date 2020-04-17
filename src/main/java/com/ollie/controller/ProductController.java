package com.ollie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ollie.model.Product;
import com.ollie.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") long id) {
		return service.getProductById(id);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProductById(@PathVariable("id") long id) {
		service.deleteProductById(id);
	}
	
	@PostMapping("/product")
	public long saveProduct(@RequestBody Product p) {
		service.saveProduct(p);
		return p.getId();
	}
	
	@PutMapping("/product")
	public void updateProduct(@RequestBody Product p) {
		service.saveProduct(p);
	}
	

}
