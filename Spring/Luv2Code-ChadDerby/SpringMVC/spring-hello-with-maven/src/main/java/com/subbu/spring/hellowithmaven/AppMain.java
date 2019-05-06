package com.subbu.spring.hellowithmaven;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.subbu.spring.hellowithmaven.coaches.Coach;

public class AppMain {

	public static void main(String[] args) {
		// Create Spring Context
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean from context
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach theCoach1 = context.getBean("myCoach", Coach.class);
		
		// Call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.printf("%s   %s\n", theCoach, theCoach1);
		
		// close the context
		context.close();
		
	}

}
