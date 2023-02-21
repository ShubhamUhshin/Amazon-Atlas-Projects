package com.amazon.dmataccountmanager.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//To connect and to execute SQL Statements in Database MSSQL :)

/*
	
	JDBC Procedure:
		1. Load the Driver
			1.1 Add the DataBase Library in your project
			1.2 Use API -> Class.forname
		
		2. Connect to DataBase
			URL
			Username
			Password
			API -> DriverManager.getConnection(....)
			API -> Connection
	
		3. Execute SQL Query
			API -> Using the API Statement
		
		4. Close Connection
*/

public class DB {

	public static String FILEPATH = "C:\\Users\\srvshu\\eclipse-workspace\\DMATAccountManager\\src\\main\\java\\com\\amazon\\dmataccountmanager\\db\\dbconfig.txt";
	
	public static String URL = "";
	public static String USER = "";
	public static String PASSWORD = "";
	
	Connection connection;
	Statement statement;
	
	// Creating object using Singleton design pattern
	private static DB db = new DB();
	public static DB getInstance() {
		return db;
	}
	
	// Loading SQL driver
	private DB() {
		try {
			//MS-SQL
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			System.out.println("[DB] Driver Loaded Successfully....");
			
			createConnection();
			
		} catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
	}

	// Creating SQL Connection
	private void createConnection() {
		try {
			// Checking if there is any filepath in the Command line argument
			File file = new File(FILEPATH);
			if(file.exists()) {
				FileReader reader = new FileReader(file);
				BufferedReader buffer = new BufferedReader(reader);
				
				// Copying the file details in URL, USER and Password
				// The file contains URL in 1st line
				// Username is contained in 2nd line
				// Password is contained in 3rd line
				URL = buffer.readLine();
				USER = buffer.readLine();
				PASSWORD = buffer.readLine();
				
				buffer.close();
				reader.close();
				
				System.out.println("DB Configured using File");
			}else {
				System.err.println("Cannot read the DB Config File...");
			}
			// Storing in the URL, databasename, username, password in url
			String url = URL+";user="+USER+";password="+PASSWORD+";trustServerCertificate=true";
			// Creating connection using connection statement
			connection = DriverManager.getConnection(url);
			System.out.println("[DB] Connection Created Successfully....");
			
		} catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
		
	}
	
	// Executing SQL Queries
	// This Function is used to update in SQL Table
	public int executeSQL(String sql) {
		
		int result = 0;
		
		try {
			// System.out.println("[DB] Executing SQL Query | "+sql);
			statement = connection.createStatement();
			result = statement.executeUpdate(sql); // executeUpdate -> is used to perform insert/update/delete in table
			// System.out.println("[DB] SQL Query Executed...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		
		return result;
	}
	
	// Result Set is used to store data from SQL
	// This Function is used to retrieve data from SQL table
	public ResultSet executeQuery(String sql) {
			
			ResultSet set = null;
			
			try {
				// System.out.println("[DB] Executing SQL Query | "+sql);
				statement = connection.createStatement();
				set = statement.executeQuery(sql); // which will retrieve data from the table into java application
				// System.out.println("[DB] SQL Query Executed...");
			} catch (Exception e) {
				System.err.println("Something Went Wrong: "+e);
			}
			
			return set;
		}
	
	// Closing SQL Connection
	public void closeConnection() {
		try {
			connection.close();
			System.out.println("[DB] Connection Closed...");
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
	}
}
