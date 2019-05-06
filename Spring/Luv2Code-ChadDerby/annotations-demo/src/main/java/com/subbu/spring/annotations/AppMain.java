package com.subbu.spring.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.subbu.spring.coaches.Coach;

public class AppMain {

	public static void main(String[] args) {
		// Create Spring Context
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean from context
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		// Call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
		
	}

}
