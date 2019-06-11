package com.subbu.springboot.collegerestapi.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.subbu.springboot.collegerestapi.exceptions.StudentCollectionEmptyException;
import com.subbu.springboot.collegerestapi.exceptions.StudentNotFoundException;
import com.subbu.springboot.collegerestapi.model.Student;
import com.subbu.springboot.collegerestapi.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping("")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = this.studentService.findAllStudents();
		if (students.isEmpty()) {
			return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") String id) {
		Student student = this.studentService.findStudentById(id);
		if (student == null) {
			throw new StudentNotFoundException("id-" + id);
//			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Object> addStudent(@Valid @RequestBody Student student) {
		// Validate Student
		if (student != null) {
			Student s = this.studentService.saveStudent(student);
			if (s != null) {
				URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(s.getId())
					.toUri();
				
				return ResponseEntity.created(location).build();
			}	
			else
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable("id") String id){
		if (id == null || id.length()==0) {
			return ResponseEntity.badRequest().build();
		}
		
		if (this.studentService.deleteStudent(id) == false) {
			throw new StudentNotFoundException("id=" + id);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Object> deleteAllStudents(){
		return ResponseEntity.noContent().build();
	}
}
