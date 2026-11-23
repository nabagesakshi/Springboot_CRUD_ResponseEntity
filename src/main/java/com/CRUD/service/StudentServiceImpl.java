package com.CRUD.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.CRUD.entity.Student;
import com.CRUD.exception.StudentNotFoundException;
import com.CRUD.repository.StudentRepository;

//import com.CRUD.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	//CREATE
	@Override
	public Student createStudent(Student student) {

		return studentRepository.save(student);
	}

	//GetById
	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow(
				()-> new StudentNotFoundException("Student Not Found with the id: "+id)
				);
	}
	
	// GET ALL
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
	
 // UPDATE
    @Override
    public Student updateStudent(Long id, Student student) {
    	Student existingStudent = studentRepository.findById(id).orElseThrow(
                    () -> new StudentNotFoundException("Student Not Found with the id: " + id )
                );

        existingStudent.setName(student.getName());
        existingStudent.setCity(student.getCity());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setAge(student.getAge());
        existingStudent.setGender(student.getGender());
        existingStudent.setHighestQualification(student.getHighestQualification());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setIntro(student.getIntro());

        return studentRepository.save(existingStudent);
    }

	// DELETE
	@Override
	public void deleteStudent(Long id) {

		Student existingStudent = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found with the id: " + id));

		studentRepository.delete(existingStudent);
	}
	
	

}
