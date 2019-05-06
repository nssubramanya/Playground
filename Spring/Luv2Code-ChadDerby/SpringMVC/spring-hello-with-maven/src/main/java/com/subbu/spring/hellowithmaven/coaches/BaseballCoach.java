package com.subbu.spring.hellowithmaven.coaches;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkout() {
		return "Get 30 minutes of batting practice.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
