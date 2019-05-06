package com.subbu.spring.rest.jackson_databind;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			Student student = mapper.readValue(new File("data/students.json"), Student.class);
			System.out.println(student);
			
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(new File("data/output.json"), student);
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
