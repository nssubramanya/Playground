package com.subbu.spring.di_annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(App.class);

		// Create Spring Context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve Bean from Context
		BaseballCoach coach = context.getBean("baseballCoach", BaseballCoach.class);
		TennisCoach tCoach = context.getBean("tennisCoach", TennisCoach.class);

		// Execute Bean methods
		logger.info(coach.getDailyWorkout());
		logger.info(tCoach.getDailyFortune());

		// Close Context
		context.close();
	}
}
