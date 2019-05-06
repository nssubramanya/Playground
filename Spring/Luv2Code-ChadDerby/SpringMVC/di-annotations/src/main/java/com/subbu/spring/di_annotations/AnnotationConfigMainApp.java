package com.subbu.spring.di_annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigMainApp {

	public static void main(String[] args) {
		// Create context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// Get Bean
		Coach theCoach = context.getBean("baseballCoach", Coach.class);

		// Call bean methods
		System.out.println(theCoach.getDailyWorkout());

		// Close Context
		context.close();

	}

}
