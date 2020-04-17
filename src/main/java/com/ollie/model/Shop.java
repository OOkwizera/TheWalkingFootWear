package com.ollie.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;

import com.ollie.model.Product;



@Entity
@Table(name="shops")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	@OneToMany(mappedBy="shop")
	private List<Employee> employees;
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "products_shops", 
//	    joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"), 
//	    inverseJoinColumns = @JoinColumn(name = "shop_id", 
//	    referencedColumnName = "id"))
//	private List<Product> inventory;
	
	
	public Shop() {}


//	public Shop(long id, String name, List<Employee> employees, List<Product> inventory) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.employees = employees;
//		this.inventory = inventory;
//	}


	public long getShopID() {
		return id;
	}


	public void setShopID(long shopID) {
		this.id = shopID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
//
//
//	public List<Product> getInventory() {
//		return inventory;
//	}
//
//
//	public void setInventory(List<Product> inventory) {
//		this.inventory = inventory;
//	}
	
	
	
	
	
	
}
