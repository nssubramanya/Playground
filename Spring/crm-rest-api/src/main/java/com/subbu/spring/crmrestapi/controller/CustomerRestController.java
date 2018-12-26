package com.subbu.spring.crmrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.subbu.spring.crmrestapi.exceptions.CustomerNotFoundException;
import com.subbu.spring.crmrestapi.model.Customer;
import com.subbu.spring.crmrestapi.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		// validate Customer
		// If Invalid, return Bad Request
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(
			@RequestBody Customer customer) {
		// validate Customer
		// If Invalid, return Bad Request
		
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		
		Customer customer = customerService.getCustomer(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		
		customerService.deleteCustomer(id);
		
		return "Deleted Customer with Id: " + id;
	}
}
