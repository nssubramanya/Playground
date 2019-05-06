package com.subbu.spring.springapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.subbu.spring.demo.coaches.Coach;

public class MySpringApp {

	public static void main(String[] args) {
		// Create Spring Context
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean from context
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// Call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
		
	}

}
