package com.subbu.spring.di_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice swinging bat for 30 min.";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
