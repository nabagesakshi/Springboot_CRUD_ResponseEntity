package com.CRUD.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="Employee_crud")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Emp_id")
	private Long id;
	
	@Column(name="Emp_name")
	@NotBlank(message="Name should not be null,blank or space")
	private String name;
	
	@Column(name="Emp_email")
	@Email(message="Enter Proper Email")
	private String email;
	
	@Column(name="Emp_department")
	@NotBlank(message="Department should not be null,blank or space")
	private String department;
	
	@Min(value=1)
	@Max(value=1000000)
	@Column(name="Emp_salary")
	private Double salary;

}
