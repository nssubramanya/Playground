package com.subbu.spring.hellowithmaven.coaches;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	private String[] fortunes = { "Be Cautious Today", "Don't fail to get up if you fall down!",
			"You will get what you wanted..." };

	public String getFortune() {
		Random random = new Random();
		int r = random.nextInt(3);
		System.out.println("Random:" + r);
		return fortunes[r];
	}
}
