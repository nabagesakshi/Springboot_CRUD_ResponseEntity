package com.CRUD.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Student_Data")
@Data
public class Student {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private String email;
	private int age;
	private String gender;
	private String highestQualification;
	private String course;
	private String intro;

}
