package com.example.studentmanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/WaterlooStudentManagement?useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "ww3952052";
	
	public static Connection getConnection() throws SQLException {
		
//		Connection connection = null;
//		
//		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//		try {
//			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//			
//		} catch (Exception e) {
//			e.printStackTrace();

//		}
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public static void printSQLException(SQLException ex) {
		
		
		for(Throwable e: ex) {
			
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + ((SQLException) e).getMessage());
				Throwable t = ex.getCause();
				
				while(t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
			
		}
		
	}

}
