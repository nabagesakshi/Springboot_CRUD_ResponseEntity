package com.CRUD.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControllerWithActuator {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeControllerWithActuator.class);

	@GetMapping("/employee/{id}")
	public String getEmployee(@PathVariable Long id) {
		System.out.println("Employee Id: " + id);
		log.info("Employee Id: " + id);
		return "Employee Id: " + id;
	}

	@GetMapping("/welcome")
	public String welcome() {
		log.error("ERROR........");
		return "welcome";
	}
	
	@GetMapping("/welcome1")
	public String welcome1() {
		log.warn("WARNING........");
		return "welcome";
	}
}
