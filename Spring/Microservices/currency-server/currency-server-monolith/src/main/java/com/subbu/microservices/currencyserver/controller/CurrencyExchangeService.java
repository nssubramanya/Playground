package com.subbu.microservices.currencyserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subbu.microservices.currencyserver.model.Currencies;
import com.subbu.microservices.currencyserver.model.CurrencyRepository;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeService {
	
	@Autowired
	CurrencyRepository repository;
	
	@GetMapping(value = "/api/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Currencies>> getCurrencyList(){
		List<Currencies> currencyList = repository.findAll();
		return new ResponseEntity<List<Currencies>>(currencyList, HttpStatus.ACCEPTED);
	}
	

}
