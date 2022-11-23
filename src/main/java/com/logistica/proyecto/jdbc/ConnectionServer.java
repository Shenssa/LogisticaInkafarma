package com.logistica.proyecto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionServer {
	 
	private String JDBC_DRIVER;
	private Connection connection = null;
	private String USER  = "root";
	private String PASSWORD = "";
	private final String DB_URL = "jdbc:mysql://localhost/logistica?serverTimezone=America/Lima"; 
    
	
	public Connection getConnection() {
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection =  DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;		
	}
	
	 
	
	 
}
