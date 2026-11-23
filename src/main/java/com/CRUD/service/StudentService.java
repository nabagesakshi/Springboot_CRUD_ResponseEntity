package com.CRUD.service;

import java.util.List;

//import org.jspecify.annotations.Nullable;

import com.CRUD.entity.Student;


public interface StudentService{

	//save student
	Student createStudent(Student student);
	
	//get the data based on studentId
     Student getStudentById(Long id);


	//get all student
     List<Student> getAllStudents();

     //update student
	 Student updateStudent(Long id, Student student);

	 //delete student
	 void deleteStudent(Long id);
	

     
     
     
}

