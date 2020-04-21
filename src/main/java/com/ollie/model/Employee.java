package com.ollie.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	private long empId;
	private String firstName;
	private String lastName;
	private double salary;
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;
//	
	public Employee() {}

	public Employee(long empId, String firstName, String lastName, double salary, EmployeeType type, Shop shop) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.type = type;
		this.shop = shop;
	}


	public long getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public EmployeeType getType() {
		return type;
	}


	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}


	

}
