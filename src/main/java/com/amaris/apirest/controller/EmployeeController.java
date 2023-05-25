package com.amaris.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amaris.apirest.model.Employee;
import com.amaris.apirest.repository.EmployeeRepository;
import com.amaris.apirest.service.EmployeeBusiness;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeBusiness employeeBusiness;

	public EmployeeController(EmployeeRepository employeeRepository, EmployeeBusiness employeeBusiness) {
		this.employeeRepository = employeeRepository;
		this.employeeBusiness = employeeBusiness;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeRepository.getEmployeeById(id);
	}

	@GetMapping("/employee/{id}/annual-salary")
	public int calculateAnnualSalary(@PathVariable String id) {
		Employee employee = employeeRepository.getEmployeeById(id);
		int monthlySalary = (employee.getEmployee_salary());
		return employeeBusiness.calculateAnnualSalary(monthlySalary);
	}
}
