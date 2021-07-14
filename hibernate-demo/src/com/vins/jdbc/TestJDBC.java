package com.vins.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl ="jdbc:mysql://localhost:3306/student_tracker?useSSL=false";
		String userId ="hbstudent";
		String passWord= "hbstudent";
		try {
			
			System.out.println("connection to data base " +jdbcUrl);
			Connection myConn= DriverManager.getConnection(jdbcUrl, userId, passWord);
			System.out.println("Connection esatblished !!!");
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}

}
