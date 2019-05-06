package com.anveshitech.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	Logger logger = LoggerFactory.getLogger(App.class);
    	
        System.out.println( "Hello World!" );
        logger.info("This is from Logback-SLF4J");
        logger.error("Error");
        logger.debug("Debug");
    }
}
