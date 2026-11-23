package com.CRUD.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

	@Value("${spring.application.name}")
	private String appName;
	@Value("${spring.application.message}")
	private String appMsg;
	@Value("${spring.application.version}")
	private String appVersion;
	
	@GetMapping("/applicationInfo")
	public String getInfo() {
	return appName+" , "+appMsg+" , "+appVersion;	
	}
}
