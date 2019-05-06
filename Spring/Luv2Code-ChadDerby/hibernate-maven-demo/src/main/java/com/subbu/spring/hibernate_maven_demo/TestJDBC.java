package com.subbu.spring.hibernate_maven_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {	
	
	public static void main(String[] args) {
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSD=false&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		System.out.println("Connecting to database: " + jdbcUrl);
		
		try {
			Connection conn =
					DriverManager.getConnection(jdbcUrl, user, password);
			
			System.out.println("Connection Successful...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
