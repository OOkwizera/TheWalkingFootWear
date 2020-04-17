package com.ollie.controller;

import java.util.List;

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
import com.ollie.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable("empId") long empId) {
		return empService.getEmployeeById(empId);
	}
	
	@DeleteMapping("/employee/{empId}")
	public void deleteEmployeeById(@PathVariable("empId") long empId) {
		empService.deleteEmployeeById(empId);
	}
	
	@PostMapping("/employee") 
	public long saveEmployee(@RequestBody Employee emp){
		empService.saveOrUpdate(emp);
		return emp.getEmpId();
	}
	
	@PutMapping("/employee")
	public void updateEmployee(@RequestBody Employee emp){
		empService.saveOrUpdate(emp);
	}

}
