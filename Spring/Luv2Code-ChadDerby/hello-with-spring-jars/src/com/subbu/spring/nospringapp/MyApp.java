package com.subbu.spring.nospringapp;

import com.subbu.spring.demo.coaches.Coach;
import com.subbu.spring.demo.coaches.TrackCoach;

public class MyApp {

	public static void main(String[] args) {
		Coach theCoach = new TrackCoach();
		
		System.out.println(theCoach.getDailyWorkout());
	}
}
