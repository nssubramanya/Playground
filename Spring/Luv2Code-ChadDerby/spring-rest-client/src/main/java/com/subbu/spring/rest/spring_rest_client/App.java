package com.subbu.spring.rest.spring_rest_client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final String url = "http://ip.jsontest.com";
    	
    	// Get Result and Show
    	RestTemplate restTemplate = new RestTemplate();
//    	String result = restTemplate.getForObject(url, String.class);
//    	System.out.println(result);
    	
    	
    }
}
