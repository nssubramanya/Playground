package com.subbu.spring.hibernate_maven_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.subbu.spring.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		System.out.println("Starting Hibernate activity...");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Create Student
			Student student = new Student("Roopashree", "M V", "roopashreee.mv@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the student
			session.save(student);

			// commit the transaction
			session.getTransaction().commit();
			
			// Print the ID Generated
			System.out.println(student.toString());
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			factory.close();
		}

		System.out.println("Done Saving Student...");
	}
}
