package com.subbu.spring.hellowithmaven;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.subbu.spring.hellowithmaven.coaches.CricketCoach;

public class App {

	public static void main(String[] args) {
		// Create Spring Context
		ClassPathXmlApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve Bean from context
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// Call methods on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.printf("By: %s - %s", theCoach.getTeam(), theCoach.getEmail());
		
		// close the context
		context.close();
		
	}

}
