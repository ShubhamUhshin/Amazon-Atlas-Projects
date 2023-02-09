package com.amazon.internalclassifieds.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	
	public static String FILEPATH = "C:\\Users\\srvshu\\eclipse-workspace\\internalclassifieds\\src\\main\\java\\com\\amazon\\internalclassifieds\\db\\dbconfig.txt";
	public static String URL = "";
	public static String USER = "";
	public static String PASSWORD = "";
	
	Connection connection;
	Statement statement;
	
	private static DB db = new DB();
	
	public static DB getInstance() {
		return db;
	}
	
	private DB() {
		try {
			//database connection
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
			System.out.println("[DB] Driver Loaded Successfully....");
				
			createConnection();
				
		} 
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

	}

	private void createConnection() {
		// TODO Auto-generated method stub
		try {
			File file = new File(FILEPATH);
			if(file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffer = new BufferedReader(reader);
				
				URL = buffer.readLine();
				USER = buffer.readLine();
				PASSWORD = buffer.readLine();
				
				buffer.close();
				reader.close();
				
				System.out.println("DB Configured using File :)");
			}else {
				System.err.println("Cannot read the DB Config File...");
			}
			
			String url = URL+";user="+USER+";password="+PASSWORD+";trustServerCertificate=true";
			connection = DriverManager.getConnection(url);
			System.out.println("[DB] Connection Created Successfully....");
			
			
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}
	
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
