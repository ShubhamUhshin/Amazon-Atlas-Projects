// Create Connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
// For reading Data of Table
import java.sql.ResultSet;
// Execute SQL Statements
import java.sql.Statement;

public class CRUDOperations {

	public static void main(String[] args) {
		
		/*
		 	DB Interaction from Java
		 	
		 	1. Load the Driver
		 		1.1 Download the Jar File | https://learn.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver16
		 		1.2 Link jar File with Project
		 			Rt Click on Project > Build Path > Configure > Add External Jars in Class Path
		 		1.3: Use API and Load the Driver Class :)
				API: Class.forname
			2. Create Connection to DataBase
				URL to DB
				API: Connection and DriverManager
			3. Execute SQL Statement
				API: Statement and ResultSet
			4. Close the Connection
				invoking method close() on Connection
		 	
		 */
		
		try {
			
			// 1. Load the Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("1. Driver Loaded...");
			
			
			// Troubleshoot: https://learn.microsoft.com/en-us/answers/questions/499956/jdbc-connection-issue.html
			String url = "jdbc:sqlserver://learnoa-atlas-server.database.windows.net:1433;database=db-atlas22;user=atlas@learnoa-atlas-server;password=@tl@s123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			
			//String url = "jdbc:sqlserver://localhost:1433;databaseName=master;user=sa;password=sqlserveradmin;trustServerCertificate=true"
			//String url = "jdbc:sqlserver://localhost:1433;databaseName=sample; user=java;password=java;integratedSecurity=false;encrypt=true;trustServerCertificate=true"
			
			// 2. Create the Connection
			Connection connection = DriverManager.getConnection(url);
			System.out.println("2. Connection Created..");
			
			// 3. Execute SQL Statement
			//String sql = "INSERT INTO Customer (name, phone, email, cashBack) VALUES ('Leo', '+91 99999 55443', 'leo@example.com', 200)";
			//String sql = "DELETE FROM Customer WHERE cid = 10";
			//String sql = "UPDATE Customer SET name = 'Mike M', cashBack = 593 WHERE cid = 12";
			
			//String sql = "SELECT * FROM Customer";
			
			//Statement statement = connection.createStatement();
			
			/*
			// executeUpdate method is used for Insert, Update and Delete
			int i = statement.executeUpdate(sql);
			if(i > 0) {
				System.out.println("3. SQL Statement Executed..");
			}else {
				System.out.println("3. SQL Statement Failed...");
			}
			*/
			
			// executeQuery -> works with Select Statement
			/*ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				System.out.print(set.getInt("cid")+"\t");
				System.out.print(set.getString("name")+"\t");
				System.out.print(set.getString("phone")+"\t");
				System.out.print(set.getString("email")+"\t");
				System.out.print(set.getInt("cashBack")+"\t");
				System.out.println();
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}*/
			
			
			String sql = "INSERT INTO Customer (name, phone, email, cashBack) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "Pam");
			statement.setString(2, "+91 80808 30303");
			statement.setString(3, "pam@example.com");
			statement.setInt(4, 375);
			
			int i = statement.executeUpdate();
			if(i > 0) {
				System.out.println("3. SQL Statement Executed..");
			}else {
				System.out.println("3. SQL Statement Failed...");
			}
			
			//4. Close the Connection
			connection.close();
			System.out.println("4. Connection Closed..");
			
		} catch (Exception e) {
			System.out.println("Something Went Wrong: "+e);
		}
		

	}

}
