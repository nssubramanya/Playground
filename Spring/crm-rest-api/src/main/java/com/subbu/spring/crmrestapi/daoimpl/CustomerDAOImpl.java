package com.subbu.spring.crmrestapi.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subbu.spring.crmrestapi.dao.CustomerDAO;
import com.subbu.spring.crmrestapi.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CustomerDAOImpl() {

	}

	@Override
	public List<Customer> getCustomers() {

		List<Customer> customers = null;
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create Query
		customers = currentSession.createQuery("from Customer order by lastName", Customer.class).getResultList();

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(long custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = currentSession.get(Customer.class, custId);

		
		return customer;
	}

	@Override
	public void deleteCustomer(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.createQuery("delete from Customer where id=:theCustomerId").setParameter("theCustomerId", id)
				.executeUpdate();
		
	}
}
