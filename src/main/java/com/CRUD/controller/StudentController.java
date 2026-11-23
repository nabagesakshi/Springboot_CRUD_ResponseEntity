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

import com.CRUD.entity.Student;
import com.CRUD.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

	private final StudentService studentService;

	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student saveStudent = studentService.createStudent(student);
		return new ResponseEntity<Student>(saveStudent, HttpStatus.CREATED);
	}

	// get student by Id
	@GetMapping("/getById/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	// GET ALL STUDENTS
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	// UPDATE STUDENT
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {

		Student updatedStudent = studentService.updateStudent(id, student);

		return ResponseEntity.ok(updatedStudent);
	}

	// DELETE STUDENT
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully");
	}

	

}
