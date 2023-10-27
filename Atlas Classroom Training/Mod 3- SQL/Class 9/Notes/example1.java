package com.amazon.atlas22.dao;
import java.sql.Connection;import java.sql.DriverManager;
import java.sql.Statement;
public class DB 
{		
	Connection connection;		
	public DB(){		
	try {			
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  	System.out.println("1. Loaded the Driver...");		
		} 
	catch (Exception e) 
	{			
		System.err.println("Something Went Wrong: "+e);
	}	
}	
public void createConnectionToDB() 
{
	String connectionURLString = "jdbc:sqlserver://learnoa-atlas-server.database.windows.net:1433;database = db-atlas22; user=atlas@learnoa-atlas-server; password=@tl@s123; encrypt=true; trustServerCertificate=false; hostNameInCertificate=*.database.windows.net; loginTimeout=30;";
try 	{
connection = DriverManager.getConnection(connectionURLString); System.out.println("2. Connection Created with DataBase...");		
	} 
catch (Exception e)
	 {
	System.err.println("Something Went Wrong: "+e);		
	}	
}

public void createConnectionToDB() 
{
String connectionURLString = "jdbc:sqlserver://learnoa-atlas-server.database.windows.net:1433;database = db-atlas22; user=atlas@learnoa-atlas-server; password=@tl@s123; encrypt=true; trustServerCertificate=false; hostNameInCertificate=*.database.windows.net; loginTimeout=30;";
try 	{
connection = DriverManager.getConnection(connectionURLString); System.out.println("2. Connection Created with DataBase...");		
	} 
catch (Exception e)
	 {
	System.err.println("Something Went Wrong: "+e);		
	}	
}
