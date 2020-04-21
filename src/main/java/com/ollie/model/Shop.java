package com.ollie.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ollie.model.Product;

@Entity
@Table(name="shops")
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="shop_id")
	private long id;
	private String name;
	@JsonManagedReference
	@OneToMany(mappedBy="shop", cascade = CascadeType.ALL)
	private List<Employee> employees;
	@JsonManagedReference
	@OneToMany(mappedBy="shop", cascade = CascadeType.ALL)
	private Set<Product> inventory;
	
	
	public Shop() {}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Shop(long id, String name, List<Employee> employees, Set<Product> inventory) {
		super();
		this.id = id;
		this.name = name;
		this.employees = employees;
		this.inventory = inventory;
		
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

	public Set<Product> getInventory() {
		return inventory;
	}


	public void setInventory(Set<Product> inventory) {
		this.inventory = inventory;
	}
	
	public void addProduct(Product p) {
		this.inventory.add(p);
	}
	
	public void addEmployee(Employee e) {
		this.employees.add(e);
	}
	
	
	
	
	
	
}
