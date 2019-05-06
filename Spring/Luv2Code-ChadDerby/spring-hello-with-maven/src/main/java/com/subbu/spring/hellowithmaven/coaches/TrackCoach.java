package com.subbu.spring.hellowithmaven.coaches;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach () {
		System.out.println("TrackCoach: Default Constructor Called...");
	}
	public TrackCoach(FortuneService fortuneService) {
		System.out.println("TrackCoach: 1-arg Constructor Called...");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Run a hard 5K.";
	}

	public String getDailyFortune() {
		return "Just do it: " + fortuneService.getFortune();
	}
	
	public void initMethod() {
		System.out.println("TrackCoach: Bean Init Method Called...");
	}
	
	public void destroyMethod() {
		System.out.println("TrackCoach: Bean Destroy Method Called...");
	}
}
