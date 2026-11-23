package com.CRUD;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudResponseEntityApplication {
	private final static Logger logger = LoggerFactory.getLogger(SpringBootCrudResponseEntityApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudResponseEntityApplication.class, args);
		logger.info("Application has been started successfully.");
		
	}

}