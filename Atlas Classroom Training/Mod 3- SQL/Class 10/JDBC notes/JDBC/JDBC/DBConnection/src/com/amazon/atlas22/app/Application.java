package com.amazon.atlas22.app;

import com.amazon.atlas22.dao.DB;

/*
 
 	Reference Documentation Link: https://learn.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16
 	
 	1. Connect to the Database :)
 		JDBC API from java.sql package
 		
		1.1. Link the Driver Library from Microsoft SQL Server
				Download the jar File
				Link it to the Project
		1.2. Load the Driver in Java Program
		1.3. Create a Connection
			  Connection String
			  Username
			  Password
 	
 	2. Execute a SQL Query :)
 		2.1. Create a SQL Statement
 		2.1. Execute a SQL Statement
 		
 	3. Close the Connection with DataBase :)
 	
 */

public class Application {

	public static void main(String[] args) {
		
		DB db = new DB();
		db.createConnectionToDB();
		db.executeSQLQuery();
		db.closeConnectionToDB();

	}

}
