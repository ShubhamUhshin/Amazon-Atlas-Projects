import java.sql.*;

public class checkDatabase {
	public static void main(String[] args) {
		try {
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("[DB] Driver Loaded");
		
		//String dbURL = "jdbc:sqlserver://BLR135CG039BP3M\\SQLEXPRESS:51629;databaseName=practice;";
		//C:\Windows\SysWOW64\SQLServerManager15.msc
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
                "databaseName=practice; user=java1;password=java; integratedSecurity=false;" +
                "encrypt=true;trustServerCertificate=true");
        if(connection!=null) {
            System.out.println("Connected to the database...");
        
        	}
        }
	catch(Exception e) {
		System.err.println(e);
		}
		//Troubleshoot: https://learn.microsoft.com/en-us/answers/questions/499956/jdbc-connection-issue.html
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		/*
		 * String url ="jdbc:sqlserver://BLR135CG039BP3M;databaseName=master;integratedSecurity=true";
		 String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
         String userName = ""; 
         String password = "";
         Class.forName(driver);//.newInstance();
         Connection conn = DriverManager.getConnection(url,userName,password);
         /*
         String query = "select * from employees where employee_id=101";
         stmt = conn.createStatement();
         int flag = stmt.executeUpdate(query);
         System.out.println("flag = "+flag); 
         */
			
	}
}