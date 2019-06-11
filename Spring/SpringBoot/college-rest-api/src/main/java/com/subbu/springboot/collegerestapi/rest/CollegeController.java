package com.subbu.springboot.collegerestapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollegeController {

	@GetMapping("/colleges")
	public String getColleges () {
		return "College API";
	}
}
