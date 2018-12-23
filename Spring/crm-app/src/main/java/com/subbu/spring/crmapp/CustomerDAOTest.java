package com.subbu.spring.crmapp;

import com.subbu.spring.crmapp.dao.CustomerDAO;
import com.subbu.spring.crmapp.dao.CustomerDAOImpl;

public class CustomerDAOTest {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		if (dao != null)
			System.out.println(dao.getCustomers());

	}

}
