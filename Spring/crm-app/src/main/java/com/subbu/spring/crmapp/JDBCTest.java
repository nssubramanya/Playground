package com.subbu.spring.crmapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "root";
		String pass = "root";

		String jdbcUrl = "jdbc:mysql://localhost:3306/anveshi_crm";

		String driver = "com.mysql.jdbc.Driver";
		
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Success");
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

	}

}
