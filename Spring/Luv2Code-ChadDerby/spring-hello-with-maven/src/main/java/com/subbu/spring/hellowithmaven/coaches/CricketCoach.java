package com.subbu.spring.hellowithmaven.coaches;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String email;
	private String team;

	public CricketCoach() {

	}

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getDailyWorkout() {
		return "Bowl 10 overs.";
	}

	public String getDailyFortune() {
		return "Remember Tendulkar: " + fortuneService.getFortune();
	}

}
