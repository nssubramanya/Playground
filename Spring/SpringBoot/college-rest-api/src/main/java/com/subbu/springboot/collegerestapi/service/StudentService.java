package com.subbu.springboot.collegerestapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subbu.springboot.collegerestapi.model.Student;

public interface StudentService {
	public List<Student> findAllStudents ();

	public Student findStudentById(String id);
	
	public Student saveStudent (Student student);

	public boolean deleteStudent(String id);

	public void deleteAllStudents();
}
