package com.subbu.springboot.collegerestapi.model;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Student {
	private String id;
	
	@Size(min=2, max=30, message="Name must have at-least 2 characters ")
	private String name;
	
	@Past
	private LocalDate dob;
	
	public Student() {
		
	}
	
	public Student(String id, String name, LocalDate dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public String getId() {
		return id;
	}	
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
}
