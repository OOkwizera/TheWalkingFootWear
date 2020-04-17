package com.ollie.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id 
	private long id;
	private String name;
	private String description;
	private double price;
//	@ManyToMany(mappedBy="inventory")
//	private List<Shop> shops;
//	
	public Product() {}

//	public Product(long prodId, String name, String description, double price, List<Shop> shops) {
//		super();
//		this.id = prodId;
//		this.name = name;
//		this.description = description;
//		this.price = price;
//		this.shops = shops;
//	}



	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
//	public List<Shop> getShop() {
//	return shops;
//}
//
//public void setShop(List<Shop> shop) {
//	this.shops = shop;
//}

	
}


