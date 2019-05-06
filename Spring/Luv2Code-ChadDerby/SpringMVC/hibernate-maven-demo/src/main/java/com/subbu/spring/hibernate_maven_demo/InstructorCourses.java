package com.subbu.spring.hibernate_maven_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.subbu.spring.hibernate.entity.Course;
import com.subbu.spring.hibernate.entity.Instructor;
import com.subbu.spring.hibernate.entity.InstructorDetail;

/**
 * Hello world!
 *
 */
public class InstructorCourses {
	public static void main(String[] args) {
		
		System.out.println("Creating Instructors and courses...");
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();
			
			// Create Instructor
//			Instructor instructor1 = new Instructor(
//					"Subramanya", "NS", "subramanya.ns@gmail.com");
//			instructor1.setInstructorDetail(new InstructorDetail("nss@youtube.com","Programming"));
//			instructor1.setCourses(null);
//			session.save(instructor1);
			
			Instructor instructor1 = session.createQuery("from Instructor i where i.firstName = 'Subramanya'", Instructor.class).getSingleResult();
			Instructor instructor2 = session.createQuery("from Instructor i where i.firstName = 'Roopashree'", Instructor.class).getSingleResult();
			
			Course course1 = new Course("Spring Masterclass");
			Course course2 = new Course("Hibernate explained");
			Course course3 = new Course("Analytics with Python");
			Course course4 = new Course("Python Programming");
			
			course1.setInstructor(instructor1);
			course2.setInstructor(instructor1);
			
			course3.setInstructor(instructor2);
			course4.setInstructor(instructor2);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			
			session.getTransaction().commit();
			System.out.println(instructor1);
			System.out.println(instructor2);
			
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

		System.out.println("Done Saving Instructor...");
	}
}
