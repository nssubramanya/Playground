package com.subbu.springboot.collegerestapi.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.subbu.springboot.collegerestapi.model.Student;

@Repository
public class StudentRepository {
	private List<Student> students = null;
	
	public StudentRepository() {
		students = new ArrayList<Student>();
		students.add(new Student("1", "Subramanya", LocalDate.of(1976, 07, 16)));
	}
	
	public List<Student> getAllStudents() {
		return students;
	}
	
	public Student getStudentById(String id) {
		for (Student s : students) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		if (student != null) {
			if(student.getId() == null) {
				student.setId(Integer.toString(students.size() + 1));
			}
			
			// Find if student with ID or Name is already present
			for (Student s : students) {
				if (s.getId().equals(student.getId()) ||
					s.getName().equals(student.getName())) {
					// throw Exception
					return null;
				}
			}
			
			if (students.add(student) == true) {
				return student;
			}
			else {
				return null;
			}
		}
		return null;
	}

	public boolean deleteStudent(String id) {
		Iterator<Student> studentIterator = students.iterator();
		Student student = null;
		
		while(studentIterator.hasNext()) {
			student = (Student) studentIterator.next();
			
			if (student.getId().equals(id)) {
				studentIterator.remove();
				return true;
			}
		}
		return false;
	}

	public void deleteAllStudents() {
		students.clear();
	}
}
