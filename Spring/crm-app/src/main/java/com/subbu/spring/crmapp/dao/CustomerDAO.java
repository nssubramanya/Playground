package com.subbu.spring.crmapp.dao;

import java.util.List;

import com.subbu.spring.crmapp.model.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(long id);

	public void deleteCustomer(long id);

}
