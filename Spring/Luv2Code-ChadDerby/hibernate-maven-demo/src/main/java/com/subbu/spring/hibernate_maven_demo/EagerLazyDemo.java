package com.subbu.spring.hibernate_maven_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.subbu.spring.hibernate.entity.Course;
import com.subbu.spring.hibernate.entity.Instructor;
import com.subbu.spring.hibernate.entity.InstructorDetail;
import com.subbu.spring.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class EagerLazyDemo {
	public static void main(String[] args) {
		
		System.out.println("Starting Hibernate activity...");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();
			
			// Get Instructor from DB
			Instructor instructor = session.createQuery("FROM Instructor i WHERE i.firstName='Subramanya'", Instructor.class).getSingleResult();
			// Print Instructor Details
			System.out.println(instructor);
			
			// Get Courses of Instructor
			System.out.println(instructor.getCourses());
			// Print Course Details
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}
	}
}
