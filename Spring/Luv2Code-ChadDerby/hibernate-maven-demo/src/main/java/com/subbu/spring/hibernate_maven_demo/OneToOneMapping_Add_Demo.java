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
public class OneToOneMapping_Add_Demo {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Create objects
			
			Instructor instructor = new Instructor ("Roopashree","MV","roopashree.mv@gmail.com");
			
			InstructorDetail detail = new InstructorDetail("http://anveshitech.youtube.com", "Cooking");
			
			instructor.setInstructorDetail(detail);

			// start transaction
			session.beginTransaction();

			// save the student
			session.save(instructor);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println(instructor);
			
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			factory.close();
		}

		System.out.println("Done Saving Student...");
	}
}
