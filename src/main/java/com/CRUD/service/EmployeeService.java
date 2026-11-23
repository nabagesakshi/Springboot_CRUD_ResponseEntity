package com.CRUD.service;

import java.util.List;

import com.CRUD.entity.Employee;

public interface EmployeeService {

	//we can write abstract method in interface
	//CRUD Operation
	
	//POST API abstract method
	Employee createEmployee(Employee employee);
	
	//GET API abstract method
	List<Employee>getAllEmployee();
	
	//GET API abstract method
	Employee getEmployeeById(Long id);
	
	//PUT API abstract method
	Employee updateEmployee(Long id, Employee employee);
	
	//DELETE API abstract method
	void deleteEmployee(Long id);
	
}
