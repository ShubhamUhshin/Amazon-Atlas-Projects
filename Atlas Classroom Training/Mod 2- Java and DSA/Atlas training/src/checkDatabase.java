import java.sql.*;


public class checkDatabase {
	public static void main(String[] args) {
		try {
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
			
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("[DB] Driver Loaded");
		
		
		Connection connection = DriverManager.getConnection("jdbc:sqlserver://BLR135CG039BP3M\\SQLEXPRESS:1433","ANT\\srvshu","");
		System.out.println("[DB] Connection Created");
         connection.close();
		}
	catch(Exception e) {
		System.err.println(e);
		}
	}
}