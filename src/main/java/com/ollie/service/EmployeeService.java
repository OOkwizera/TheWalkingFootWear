package com.ollie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ollie.model.Employee;
import com.ollie.model.Shop;
import com.ollie.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	
	
	public List<Employee> getAllEmployees(){
		List<Employee> emps = new ArrayList<>();
		empRepo.findAll().forEach(emp -> emps.add(emp));
		return emps;
	}
	
	public Employee getEmployeeById(long id) {
		Optional<Employee> e = empRepo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmployeeById(long id) {
		empRepo.deleteById(id);
	}
	
	public void saveOrUpdate(Employee e) {
		empRepo.save(e);
	}
	
	public Shop getShopByEmployeeId(long id) {
		Optional<Employee> e = empRepo.findById(id);
		if (e.isPresent()) {
			return e.get().getShop();
		}
		return null;
	}
	
	public long setShop(long id, Shop shop) {
		Optional<Employee> e = empRepo.findById(id);
		if (e.isPresent()) {
			Employee emp = e.get();
			emp.setShop(shop);
			empRepo.save(emp);
			return emp.getShop().getId();
		}
		return 0;
	}

}
