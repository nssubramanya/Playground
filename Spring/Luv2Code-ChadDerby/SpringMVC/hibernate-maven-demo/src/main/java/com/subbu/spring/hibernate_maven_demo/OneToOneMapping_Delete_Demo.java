package com.subbu.spring.hibernate_maven_demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.subbu.spring.hibernate.entity.Instructor;
import com.subbu.spring.hibernate.entity.InstructorDetail;

/**
 * Hello world!
 *
 */
public class OneToOneMapping_Delete_Demo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			Instructor instr = session
					.createQuery("from Instructor i where i.email='subramanya.ns@gmail.com'",Instructor.class)
					.getSingleResult();
			
			System.out.println(instr);
			
			// save the student
			session.delete(instr);

			// commit the transaction
			session.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

		System.out.println("Done Saving Student...");
	}
}
