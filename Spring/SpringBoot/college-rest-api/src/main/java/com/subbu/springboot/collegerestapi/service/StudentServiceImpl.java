package com.subbu.springboot.collegerestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subbu.springboot.collegerestapi.model.Student;
import com.subbu.springboot.collegerestapi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> findAllStudents() {
		return studentRepo.getAllStudents();
	}

	@Override
	public Student findStudentById(String id) {		
		return studentRepo.getStudentById(id);
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.addStudent(student);
	}

	@Override
	public boolean deleteStudent(String id) {
		
		return studentRepo.deleteStudent(id);
	}

	@Override
	public void deleteAllStudents() {
		studentRepo.deleteAllStudents();
	}
}
