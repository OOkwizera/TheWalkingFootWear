package com.ollie.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ollie.model.Employee;
import com.ollie.model.Product;
import com.ollie.model.Shop;
import com.ollie.service.ShopService;

@RestController
@RequestMapping("/api")
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@GetMapping("/allShops")
	public List<Shop> getAllShops() {
		return service.getAllShops();
				
	}
	
	@GetMapping("/shop/{id}")
	public Shop getShopById(@PathVariable("id") long id) {
		return service.getShopById(id);
	}
	
	@GetMapping("/shop/{id}/employees")
	public List<Employee> getEmployeesShopById(@PathVariable("id") long id){
		return service.getAllEmployeesByShopId(id);
	}
	
	@GetMapping("/shop/{id}/products")
	public Set<Product> getProductsShopById(@PathVariable("id") long id){
		return service.getAllProductsByShopId(id);
	}
	
	@DeleteMapping("/shop/{id}")
	public void deleteShopById(@PathVariable("id") long id) {
		service.deleteShopById(id);
	}
	
	@PostMapping("/shop")
	public long addShop(@RequestBody Shop s) {
		service.saveShop(s);
		return s.getId();
	}
	
	@PutMapping("/shop")
	public void updateShop(@RequestBody Shop s) {
		service.saveShop(s);
	}
	

}
