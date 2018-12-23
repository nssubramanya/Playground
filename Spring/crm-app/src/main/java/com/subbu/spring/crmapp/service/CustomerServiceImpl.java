package com.subbu.spring.crmapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subbu.spring.crmapp.dao.CustomerDAO;
import com.subbu.spring.crmapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	public Customer getCustomer(long id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	public void deleteCustomer(long id) {
		customerDAO.deleteCustomer(id);
	}

}
