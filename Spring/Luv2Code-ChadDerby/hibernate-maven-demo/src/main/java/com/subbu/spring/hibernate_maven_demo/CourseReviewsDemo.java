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
public class CourseReviewsDemo {
	public static void createCoursesAndReviews(Session session) {

		// start transaction
		session.beginTransaction();

		// Get Course
		Course course = session.createQuery("from Course c where c.title='Spring Masterclass'", Course.class)
				.getSingleResult();

		if (course != null) {
			// Create Reviews
			Review review = new Review("Greate Course! 5 stars!!", course);
			// Associate Reviews

			// save the Reviews
			session.save(review);
		}

		Course course2 = session.createQuery("from Course c where c.title='Python Programming'", Course.class)
				.getSingleResult();
		if (course2 != null) {
			Review review = new Review("Superb...");
			course2.addReview(review);
			session.save(course2);
		}

		// commit the transaction
		session.getTransaction().commit();

	}

	public static void readCoursesAndReviews(Session session) {
		session.beginTransaction();
		Course course = session.createQuery("from Course c WHERE c.title='Python Programming'", Course.class)
				.getSingleResult();
		if (course != null) {
			System.out.println(course);
			System.out.println(course.getReviews());
		}
		session.getTransaction().commit();
	}

	public static void main(String[] args) {

		System.out.println("Course Reviews manipulation...");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {

//			createCoursesAndReviews(session);

			// Create new Session
//			session = factory.getCurrentSession();
			readCoursesAndReviews(session);

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}

		System.out.println("Done Saving Reviews...");
	}
}
