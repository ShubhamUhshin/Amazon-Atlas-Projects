package com.amazon.dmataccountmanager.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.dmataccountmanager.model.Users;

public class UserDAO implements DAO<Users> {
	
	DB db = DB.getInstance();
	passEncryption encrypt = passEncryption.getInstance();

	public int insert(Users object) {
		String sql = "INSERT INTO Users (userName, accountNumber, password, accountBalance) VALUES ('"+object.userName+"', '"+object.accountNumber+"', '"+encrypt.encryptor(object.password)+"', '"+object.accountBalance+"')";
		return db.executeSQL(sql);
	}

	public int update(Users object) {
		String sql = "UPDATE Users SET accountBalance = '"+object.accountBalance+"' WHERE accountNumber = '"+object.accountNumber+"'";
		return db.executeSQL(sql);
	}

	public int delete(Users object) {
		String sql = "DELETE FROM Users WHERE accountNumber = '"+object.accountNumber+"'";
		return db.executeSQL(sql);
	}

	public List<Users> retrieve() {
		String sql = "SELECT * FROM Users";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Users> users = new ArrayList<Users>();
		
		try {
			while(set.next()) {
				
				Users user = new Users();
				
				// Read the row from ResultSet and put the data into User Object
				user.userID = set.getInt("userID");
				user.userName = set.getString("userName");
				user.accountNumber = set.getString("accountNumber");
				user.password = set.getString("password");
				user.accountBalance = set.getDouble("accountBalance");
				user.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				users.add(user);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return users;
	}

	public List<Users> retrieve(String sql) {
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Users> users = new ArrayList<Users>();
		
		try {
			while(set.next()) {
				
				Users user = new Users();
				
				// Read the row from ResultSet and put the data into User Object
				user.userID = set.getInt("userID");
				user.userName = set.getString("userName");
				user.accountNumber = set.getString("accountNumber");
				user.password = set.getString("password");
				user.accountBalance = set.getInt("accountBalance");
				user.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				users.add(user);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return users;
	}
}
