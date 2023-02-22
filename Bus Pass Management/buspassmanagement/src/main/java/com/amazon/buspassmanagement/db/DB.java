package com.amazon.buspassmanagement.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DB {

	// File address
	// If there is a file from Command Line, this value will be overridden
	public static String FILEPATH = "C:\\Users\\srvshu\\eclipse-workspace\\buspassmanagement\\src\\main\\java\\com\\amazon\\buspassmanagement\\db\\dbconfig.txt";
	public static String URL = "";
	public static String USER = "";
	public static String PASSWORD = "";
	
	Connection connection;  // API from JDBC Package to store connection :)
	Statement statement;	// API from JDBC Package to execute SQL Statements :)

	// Singleton Design Pattern to create object
	private static DB db = new DB();
	public static DB getInstance() {
		return db;
	}
	
	private DB() {
		
		try {
			// database connection
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
			System.out.println("[DB] Driver Loaded Successfully....");
				
			createConnection();
				
		} 
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

	}
	// Creating database connection
	private void createConnection() {
		try {
			
			// Checking if there is a filepath given in command line
			File file = new File(FILEPATH);
			if(file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffer = new BufferedReader(reader);
				
				// Reading the file and scraping value from file
				// 1st line of file contains database URL
				// 2nd Line contains Username
				// 3rd Line contains Password
				URL = buffer.readLine();
				USER = buffer.readLine();
				PASSWORD = buffer.readLine();
				
				buffer.close();
				reader.close();
				
				System.out.println("DB Configured using File :)");
			}else {
				System.err.println("Cannot read the DB Config File...");
			}
			
			// Combining URL, username and password
			String url = URL+";user="+USER+";password="+PASSWORD+";trustServerCertificate=true";
			// Using connection statement to connect to the database
			connection = DriverManager.getConnection(url);
			System.out.println("[DB] Connection Created Successfully....");
			
			
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}

/*
	private void createConnection() {
		
		try {
			
			String url = "jdbc:sqlserver://localhost:1433;databaseName=buspassdb;user=shubham;password=1234;trustServerCertificate=true;";
			
			connection = DriverManager.getConnection(url);
			System.out.println("[DB] Connection Created Successfully....");
				
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}
	*/
	
	// Used for inserting into database
	public int executeSQL(String sql) {
		
		int result = 0;
		
		try {
			//System.out.println("[DB] Executing SQL Query | "+sql);
			statement = connection.createStatement();
			result = statement.executeUpdate(sql); // executeUpdate -> is used to perform insert/update/delete in table
			//System.out.println("[DB] SQL Query Executed...");
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		
		return result;
	}
	
	// Used to Retrieve data from SQL using resultset
	public ResultSet executeQuery(String sql) {
		
		ResultSet set = null;
		
		try {
			//System.out.println("[DB] Executing SQL Query | "+sql);
			statement = connection.createStatement();
			set = statement.executeQuery(sql); // which will retrieve data from the table into java application
			//System.out.println("[DB] SQL Query Executed...");
		} 
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		
		return set;
	}

	// Closing connection
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("[DB] Connection Closed...");
		}
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}

}
