package com.CRUD.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.entity.Employee;
import com.CRUD.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	// CREATE
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.createEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
	}

	// GET all emps API
	@GetMapping("/getAllEmps")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}

	// GET particular Employee by Id
	@GetMapping("/getEmpById/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeService.getEmployeeById(id);

		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			// Build the response entity with no body.
		}

		return ResponseEntity.ok(employee);
	}

	// UPDATE API
	@PutMapping("/updateEmpById/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		if (updatedEmployee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(updatedEmployee);
	}

	// DELETE API by ID
	@DeleteMapping("/deleteEmpById/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeeService.getEmployeeById(id);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

}
