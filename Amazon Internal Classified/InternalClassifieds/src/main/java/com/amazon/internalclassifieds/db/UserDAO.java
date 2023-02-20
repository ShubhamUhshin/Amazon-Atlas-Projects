package com.amazon.internalclassifieds.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.internalclassifieds.model.Users;

public class UserDAO implements DAO<Users>{
	
	DB db = DB.getInstance();
	passwordEncryptor encryptor = passwordEncryptor.getInstance();
	
	// Inserting into Users Table
	public int insert(Users Object) {
		String sql = "INSERT INTO Users (name, phone, email, password, address, userType, userStatus) VALUES ('"+Object.name+"', '"+Object.phone+"', '"+Object.email+"', '"+encryptor.encryptor(Object.password)+"', '"+Object.address+"', '"+Object.userType+"', '"+Object.userStatus+"')";
		return db.executeSQL(sql);
	}

	// Deleting from user table based on the email
	// This function is a dummy function as we have implemented DAO.
	// This function is never used  
	public int delete(Users Object) {
		String sql = "DELETE FROM Users WHERE email = '"+Object.email+"'";
		return db.executeSQL(sql);
	}

	// Updating users based on email ID
	public int update(Users Object) {
		String sql = "UPDATE Users set name = '"+Object.name+"', phone='"+Object.phone+"', address='"+Object.address+"', userType='"+Object.userType+"',userStatus='"+Object.userStatus+"' WHERE email = '"+Object.email+"'";
		return db.executeSQL(sql);
	}

	// Retrieving all data from Users table
	public List<Users> retrieve() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from Users";
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Users> users = new ArrayList<Users>();
		
		try {
			while(set.next()) {
				
				Users user = new Users();
				
				// Read the row from ResultSet and put the data into User Object
				user.userID = set.getInt("userID");
				user.name = set.getString("name");
				user.phone = set.getString("phone");
				user.email = set.getString("email");
				user.password = set.getString("password");
				user.address = set.getString("address");
				user.userStatus = set.getInt("userStatus");
				user.userType = set.getInt("userType");
				user.createdOn = set.getString("createdOn");
				
				users.add(user);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return users;
	}

	// Retrieving data from User table based on the sql query
	public List<Users> retrieve(String sql) {
		// TODO Auto-generated method stub
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Users> users = new ArrayList<Users>();
		
		try {
			while(set.next()) {
				
				Users user = new Users();
				
				// Read the row from ResultSet and put the data into User Object
				user.userID = set.getInt("userID");
				user.name = set.getString("name");
				user.phone = set.getString("phone");
				user.email = set.getString("email");
				user.password = set.getString("password");
				user.address = set.getString("address");
				user.userStatus = set.getInt("userStatus");
				user.userType = set.getInt("userType");
				user.createdOn = set.getString("createdOn");
				
				users.add(user);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return users;
	}

}
