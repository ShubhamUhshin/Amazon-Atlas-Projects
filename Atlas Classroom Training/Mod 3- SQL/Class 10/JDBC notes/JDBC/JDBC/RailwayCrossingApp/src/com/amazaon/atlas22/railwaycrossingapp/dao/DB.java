package com.amazaon.atlas22.railwaycrossingapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 	
 	DB Connection Steps
 	
 	1. Load the Driver
 		1.1 Download the Jar File from Microsoft Web Site
 			Link -> https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16
 			
 		1.2 Configure the Build Path (Link Jar File with Project)
 			Rt Click on Project > Build Path > Configure build Path > Library > Add External Jars in ClassPath
 			
 		1.3 Use Class.forname to load the Driver class file
 		
 	2. Create the Connection with DataBase
 		Here, we need to use 2 APIs from JDBC (Connection and DriverManager)
 		ConnectionString -> URL which will be for SQLServer
 		UserName
 		Password
 	
 	3. Create SQL Statement and Execute it
 		Use API Statement from JDBC to execute SQL Statements
 		
 	4. Close the Connection
 */

public class DB {
	
	private static DB db = new DB();
	private Connection connection;
	
	// Singleton Design Pattern
	private DB() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("[DB] Driver Loaded..");
			createConnection();
		} catch (Exception e) {
			System.err.println("[DB] [Driver] Something Went Wrong: "+e);
		}
		
	}
	
	public static DB getDB() {
		return db;
	}
	
	// Troubleshoot: https://learn.microsoft.com/en-us/answers/questions/499956/jdbc-connection-issue.html
	// 				 Enable TCP/IP Service in SQL Server Configuration and Restart
	private void createConnection() {
		try {
			
			String url = "jdbc:sqlserver://learnoa-atlas-server.database.windows.net:1433;database=db-atlas22;user=atlas@learnoa-atlas-server;password=@tl@s123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";	
			//String url = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=sqlserveradmin;trustServerCertificate=true"
		
			connection = DriverManager.getConnection(url);
			System.out.println("[DB] Connection Created...");
			
		} catch (Exception e) {
			System.err.println("[DB] [Connection] Something Went Wrong: "+e);
		}
	}
	
	// WRITE OPERATION (Insert/Update/Delete)
	public int executeSQL(String sql) {
		
		int result = 0;
		
		try {
			// Create Statement to execute SQL from Java Application
			Statement stmt = connection.createStatement();
			// executeUpdate can be used to perform DML operation - Insert/Update/Delete
			result = stmt.executeUpdate(sql);
			System.out.println("[DB] SQL Statement Executed...");
		} catch (Exception e) {
			System.err.println("[DB] [Execute SQL] Something Went Wrong: "+e);
		}
		
		return result;
	}
	
	// READ OPERATION (SELECT)
	public ResultSet executeRetrieveQuery(String sql) {
		
		// ResultSet holds Table Data
		ResultSet set = null;
		
		try {
			// Create Statement to execute SQL from Java Application
			Statement stmt = connection.createStatement();
			
			// For Select Statement
			// Here executeQuery -> Returns a ResultSet which shall have all the rows of the table
			set = stmt.executeQuery(sql);
			
			System.out.println("[DB] SQL Statement Executed...");
		} catch (Exception e) {
			System.err.println("[DB] [Execute SQL] Something Went Wrong: "+e);
		}
		
		return set;
		
	}
	
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("[DB] Connection Closed..");
		} catch (Exception e) {
			System.err.println("[DB] [Connection] Something Went Wrong: "+e);
		}
	}
}
