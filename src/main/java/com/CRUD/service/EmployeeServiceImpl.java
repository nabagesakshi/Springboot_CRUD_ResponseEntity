package com.CRUD.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CRUD.entity.Employee;
import com.CRUD.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository ;
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		if (existingEmployee == null) {
			return null;
		}
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setDepartment(employee.getDepartment());
		existingEmployee.setSalary(employee.getSalary());
		return employeeRepository.save(existingEmployee);

	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

}
