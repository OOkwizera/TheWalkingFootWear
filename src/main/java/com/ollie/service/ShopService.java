package com.ollie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ollie.model.Shop;
import com.ollie.repo.ShopRepo;

@Service
public class ShopService {
	
	@Autowired
	ShopRepo repo;
	
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

}
