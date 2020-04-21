package com.ollie.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="products")
public class Product {
	
	@Id
	@Column(name="product_id")
	private long id;
	private String name;
	private String description;
	private double price;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;
	
	public Product() {
	}

	public Product(long prodId, String name, String description, double price, Shop shop) {
		super();
		this.id = prodId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.shop = shop;
	}



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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	
	

	
}


