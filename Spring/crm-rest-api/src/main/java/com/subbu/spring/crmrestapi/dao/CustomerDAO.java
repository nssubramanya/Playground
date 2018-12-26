package com.subbu.spring.crmrestapi.dao;

import java.util.List;

import com.subbu.spring.crmrestapi.model.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(long id);

	public void deleteCustomer(long id);

}
