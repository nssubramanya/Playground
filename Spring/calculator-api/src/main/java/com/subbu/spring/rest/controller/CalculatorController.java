package com.subbu.spring.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	@GetMapping("/add")
	public double add(@RequestParam("num1") double a, @RequestParam("num2") double b) {
		return a + b;
	}
	
}
