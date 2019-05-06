package com.subbu.spring.demo.coaches;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return ("Run a hard 5K");
	}

}
