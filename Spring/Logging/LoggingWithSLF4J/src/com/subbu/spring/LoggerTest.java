package com.subbu.spring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(LoggerTest.class);
		// TODO Auto-generated method stub
		
		System.out.println("Hello");
		logger.info("Hello, World");
		logger.debug("Debug Msg: {} {} {}", 5, 6.0, "Hello");
		logger.error("Error");
	}

}
