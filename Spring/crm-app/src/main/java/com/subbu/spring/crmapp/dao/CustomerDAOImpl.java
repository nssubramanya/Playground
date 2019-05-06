package com.subbu.spring.crmapp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.subbu.spring.crmapp.model.Customer;

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

		try {
			currentSession.beginTransaction();
			// create Query
			customers = currentSession.createQuery("from Customer order by lastName", Customer.class).getResultList();

			currentSession.getTransaction().commit();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			currentSession.close();
		}

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		currentSession.saveOrUpdate(theCustomer);

		currentSession.getTransaction().commit();

	}

	@Override
	public Customer getCustomer(long custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		Customer customer = currentSession.get(Customer.class, custId);

		currentSession.getTransaction().commit();

		return customer;
	}

	@Override
	public void deleteCustomer(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.beginTransaction();

		currentSession
			.createQuery("delete from Customer where id=:theCustomerId")
			.setParameter("theCustomerId", id)
			.executeUpdate();

		currentSession.getTransaction().commit();
	}
}
