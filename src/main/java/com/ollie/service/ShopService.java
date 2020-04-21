package com.ollie.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ollie.model.Employee;
import com.ollie.model.Product;
import com.ollie.model.Shop;
import com.ollie.repo.ShopRepo;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepo repo;
	
	public List<Shop> getAllShops(){
		List<Shop> allShops = new ArrayList<>();
		repo.findAll().forEach(shop -> allShops.add(shop));
		return allShops;
	}
	
	public Shop getShopById(long id) {
		Optional<Shop> s = repo.findById(id);
		if (s.isPresent()) {
			return s.get();
		}
		return null;	
	}
	
	public void deleteShopById(long id) {
		repo.deleteById(id);
	}
	
	public void saveShop(Shop s) {
		repo.save(s);
	}
	
	public List<Employee> getAllEmployeesByShopId(long id){
		Optional<Shop> s = repo.findById(id);
		List<Employee> allEmployees = new ArrayList<>();
		if (s.isPresent()) {
			 Shop shop = s.get();
			 shop.getEmployees().forEach(emp -> allEmployees.add(emp));
		}
		
		return allEmployees;
	}
	
	public Set<Product> getAllProductsByShopId(long id){
		Optional<Shop> s = repo.findById(id);
		Set<Product> allProducts = new HashSet<>();
		if (s.isPresent()) {
			Shop shop = s.get();
			shop.getInventory().forEach(prod -> allProducts.add(prod));
		}
		return allProducts;
	}
	

}
