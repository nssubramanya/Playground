package com.subbu.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.subbu.spring.rest.model.Student;

@RestController
public class StudentController {

	private List<Student> students;

	@PostConstruct
	private void initialize() {
		students = new ArrayList<Student>();

		students.add(new Student("Subramanya", "N S"));
		students.add(new Student("Sushruth", "Subramanya"));
		students.add(new Student("Shashank", "Mouli"));
		students.add(new Student("Satthvik", "Mouli"));
	}

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return students;
	}

	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable("id") int studentId) {

		if ((studentId > students.size()) || studentId < 0) {
			throw new StudentNotFoundException("Student ID Not found - " + studentId);
		}
		return students.get(studentId);
	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add exception handler to catch all kinds of exceptions
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
