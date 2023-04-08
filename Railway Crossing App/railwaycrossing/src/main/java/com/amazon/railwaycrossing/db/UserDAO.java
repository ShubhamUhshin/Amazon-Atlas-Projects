package com.amazon.railwaycrossing.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.railwaycrossing.model.Users;

public class UserDAO implements DAO <Users>{
	
	DB db = DB.getInstance();
	
	public int insert(Users Object) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Users (name, emailID, password, userType) VALUES ('"+Object.name+"', '"+Object.emailID+"', '"+Object.password+"', "+Object.userType+")";
		return db.executeSQL(sql);
	}

	public int delete(Users Object) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Users Object) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Retrieve all data from user table
	public List<Users> retrieve() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from Users";
		ResultSet set = db.executeQuery(sql);
		List<Users> user = new ArrayList<Users>();
		try {
			while (set.next()) {
				
				Users Object = new Users();
				Object.name = set.getString("name");
				Object.emailID = set.getString("emailID");
				Object.password = set.getString("password");
				Object.userType = set.getInt("userType");
				Object.userID = set.getInt("userID");
				
				user.add(Object);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Something Went Wrong: "+e);
		}
			
		return user;
	}

	// Return Data from Users table based on a query
	public List<Users> retrieve(String sql) {
		// TODO Auto-generated method stub
		
		ResultSet set = db.executeQuery(sql);
		List<Users> user = new ArrayList<Users>();
		try {
			while (set.next()) {
				
				Users Object = new Users();
				Object.name = set.getString("name");
				Object.emailID = set.getString("emailID");
				Object.password = set.getString("password");
				Object.userType = set.getInt("userType");
				Object.userID = set.getInt("userID");
				
				user.add(Object);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Something Went Wrong: "+e);
		}
			
		return user;
	}

}
