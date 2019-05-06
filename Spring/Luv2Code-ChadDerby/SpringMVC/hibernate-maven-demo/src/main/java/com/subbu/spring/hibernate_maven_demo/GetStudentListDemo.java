package com.subbu.spring.hibernate_maven_demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.subbu.spring.hibernate.entity.Student;

/**
 * Hello world!
 *
 */
public class GetStudentListDemo {

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	public static void main(String[] args) {

		System.out.println("Starting Hibernate activity...");

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			List<Student> students = session
					.createQuery("from Student s where s.firstName = 'Subramanya'", Student.class).getResultList();
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.email LIKE '%gmail.com'", Student.class).getResultList();
			displayStudents(students);

		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
			factory.close();
		}
	}
}
