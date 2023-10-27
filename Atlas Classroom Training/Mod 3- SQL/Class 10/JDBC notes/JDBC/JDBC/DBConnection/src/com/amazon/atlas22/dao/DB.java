package com.amazon.atlas22.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 	1. Download the Jar File
 		Link it to the Project
 			> Rt. Click -> build Path -> Configure Build Path -> Library -> Add External Jars under classpath
 			
 	2. Load the Driver Class from Jar File
 		Use Class.forname API from Java
 		
 	3. Create the Connection
 		To Create Connection, you need 3 things:
 		1. Connection String -> For Local MSSQL Server Installation -> "jdbc:sqlserver://localhost;database=YourDBName"
 		2. Username
 		3. Password
 			
 		APIs: 1 Connection API and DriverManager API
 */

public class DB {

	
	Connection connection;
	
	public DB(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
			System.out.println("1. Loaded the Driver...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}
	
	public void createConnectionToDB() {
		String connectionURLString = "jdbc:sqlserver://learnoa-atlas-server.database.windows.net:1433;database=db-atlas22;user=atlas@learnoa-atlas-server;password=@tl@s123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

		/*String localUrl = "jdbc:sqlserver://localhost;database=AdventureWorks";
		String username = "atlas";
		String password = "@tl@s123";*/
		
		try {
			 connection = DriverManager.getConnection(connectionURLString); // Connection is in the Cloud DB
			
			// Try Connecting like this: 
			//Connection connection = DriverManager.getConnection(localUrl, username, password);
			
			System.out.println("2. Connection Created with DataBase...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}
	
	public void executeSQLQuery() {
		try {
			
			String sql = "INSERT INTO Customers VALUES(3, 'Leo', '+91 99999 14565', 'leo@example.com', '6655 Country Homes','')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("3. SQL Statement Executed...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}
	
	
	public void closeConnectionToDB() {
		try {
			connection.close();
			System.out.println("4. Connection Closed with DataBase...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);// TODO: handle exception
		}
	}
	
}
