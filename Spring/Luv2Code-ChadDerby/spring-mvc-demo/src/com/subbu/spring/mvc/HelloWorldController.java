package com.subbu.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
	// method to show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersion2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// Reqd request Parameter
		String name = request.getParameter("studentName");
		
		// Convert to Upper Case
		name = name.toUpperCase();
		
		// Add to Model
		model.addAttribute("message", name);
		
		return "helloworld";
	}
}
