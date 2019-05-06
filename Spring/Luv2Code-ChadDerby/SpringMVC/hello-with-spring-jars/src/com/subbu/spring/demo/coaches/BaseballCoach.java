package com.subbu.spring.demo.coaches;

public class BaseballCoach implements Coach {
	
	@Override
	public String getDailyWorkout() {
		return("Get 30 minutes of batting practice.");	
	}
}
