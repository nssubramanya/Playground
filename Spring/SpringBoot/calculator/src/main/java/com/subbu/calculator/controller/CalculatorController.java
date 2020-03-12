package com.subbu.calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@GetMapping("/add")
	public ResponseEntity<Double> add(
			@RequestParam("num1") Double num1,
			@RequestParam("num2") Double num2
			){
		
		return new ResponseEntity<>(num1 + num2, HttpStatus.OK);
	}

}
