package com.subbu.spring.hibernate_maven_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.subbu.spring.hibernate.entity.Course;
import com.subbu.spring.hibernate.entity.Instructor;
import com.subbu.spring.hibernate.entity.InstructorDetail;
import com.subbu.spring.hibernate.entity.Review;
import com.subbu.spring.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class ManyToManyDemo {

	public static Course getCourse(Session session, String title) {
		Course course = session.createQuery("from Course c where c.title=:title", Course.class)
				.setParameter("title", title)
				.getSingleResult();
		
		System.out.println("Got Course: " + course);
		return course;
	}

	public static void addCourseStudents(Session session) {

		Student s1 = session.createQuery("FROM Student s WHERE s.firstName='Sushruth'", Student.class)
				.getSingleResult();
		Student s2 = session.createQuery("FROM Student s WHERE s.firstName='Roopashree'", Student.class)
				.getSingleResult();

		s1.addCourse(getCourse(session, "Spring Masterclass"));
		s1.addCourse(getCourse(session, "Analytics with Python"));
		s2.addCourse(getCourse(session, "Spring Masterclass"));
		s2.addCourse(getCourse(session, "Hibernate explained"));
		
		session.save(s1);
		session.save(s2);
		
		session.getTransaction().commit();
	}

	public static void main(String[] args) {

		System.out.println("Starting Hibernate activity...");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();
			
//			addCourseStudents(session);

			// Get Course from DB
			Course course = getCourse(session, "Spring Masterclass");
			System.out.println(course);
			System.out.println(course.getStudents());

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}
	}
}
