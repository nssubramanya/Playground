package com.subbu.spring.crmrestapi.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subbu.spring.crmrestapi.dao.CustomerDAO;
import com.subbu.spring.crmrestapi.model.Customer;
import com.subbu.spring.crmrestapi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}

	
	@Override
	@Transactional
	public Customer getCustomer(long id) {
		return customerDAO.getCustomer(id);
	}

	@Override
	@Transactional
	public void deleteCustomer(long id) {
		customerDAO.deleteCustomer(id);
	}

}
