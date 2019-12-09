package com.subbu.microservices.currencyserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyServerApplication implements CommandLineRunner {
	
	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	public static void main(String[] args) {
		SpringApplication.run(CurrencyServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		logger.info("------- Command Line Runner ----");
		
	}

}
