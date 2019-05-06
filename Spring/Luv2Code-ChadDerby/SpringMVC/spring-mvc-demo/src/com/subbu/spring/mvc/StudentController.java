package com.subbu.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/student-register")
	public String showStudentRegistrationForm(Model theModel) {

		// Create Student object
		Student theStudent = new Student();

		// add student to model
		theModel.addAttribute("student", theStudent);

		return "student-registration";
	}

	@RequestMapping("/student-confirmation")
	public String showStudentConfirmation(@ModelAttribute("student") Student theStudent) {

		// Log the input data
		System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
	
		return "student-confirmation";
	}

}
