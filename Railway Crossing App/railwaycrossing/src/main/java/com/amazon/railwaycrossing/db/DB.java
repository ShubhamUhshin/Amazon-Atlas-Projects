package com.amazon.railwaycrossing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// This is the Database class
// We use this class to connect to the database using Connection
public class DB {
	
	// Creating a private object
	private static DB db = new DB();
	
	// Singleton Design pattern to use DB object
	public static DB getInstance() {
		return db;
	}

	Connection connection;
	Statement statement;
	// Loading MSSQL Driver
	private DB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("***************");
			System.out.println();
			System.out.println("Driver Loaded");
			createConnection();
		}
		
		catch (Exception e) {
			System.err.println("Error while Loading Driver");
		}
		
	}
	
	// Creating Connection
	public void createConnection() {
		try {
			
			// Specifying The DB NAME Username and password
			String URL = "jdbc:sqlserver://localhost:1433;databaseName=railwaycrossingdb";
			String USER = "shubham";
			String PASSWORD = "1234";
			
			// Merging the above data
			String url = URL+";user="+USER+";password="+PASSWORD+";trustServerCertificate=true";
			
			// Using connection statement to connect to the database
			connection = DriverManager.getConnection(url);
			System.out.println("[DB] Connection Created Successfully....");
			System.out.println();
			System.out.println("***************");
		}
		
		catch (Exception e){
			System.err.println("Error in creating connection");
		}
	}
	
	// Adding data into the sql server
	// We'll return integer based on the data inserted in the table
	public int executeSQL(String sql) {
		
		int result = 0;
		try {
			// Using java.sql package's Statement to update data in the database
			statement = connection.createStatement();
			
			result = statement.executeUpdate(sql);
			
		}
		
		catch(Exception e) {
			System.err.println("Error in executing Query");
		}
		
		return result;
		
	}
	
	// Retrieving data from SQL using ResultSet
	public ResultSet executeQuery(String sql) {
		
		ResultSet set = null;
		
		try {
			// Using java.sql package's Statement to update data in the database
			statement = connection.createStatement();
			set = statement.executeQuery(sql);
		
		}
		
		catch(Exception e) {
			System.err.println("Error in executing Query");
		}
		
		return set;
	}
	
	// Closing Connection
	public void closeConnection() {
		try {
			
			connection.close();
			System.out.println("Connection Closed");
			
		}
		
		catch (Exception e) {
			System.err.println("Error while closing Connection");
		}
		
	}
}
