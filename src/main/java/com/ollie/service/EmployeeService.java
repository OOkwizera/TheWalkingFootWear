package com.ollie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ollie.model.Employee;
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

}
