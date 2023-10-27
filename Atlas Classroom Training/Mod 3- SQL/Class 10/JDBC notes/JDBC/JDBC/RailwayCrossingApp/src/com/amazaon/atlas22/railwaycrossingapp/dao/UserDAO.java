package com.amazaon.atlas22.railwaycrossingapp.dao;

import java.sql.ResultSet;
import java.util.List;

import com.amazaon.atlas22.railwaycrossingapp.model.User;

public class UserDAO implements DAO<User>{

	DB db = DB.getDB();
	
	@Override
	public int insert(User object) {
        String sql = "INSERT INTO Users(name, email, password, userType) VALUES ('"+object.getName()+"', '"+object.getEmail()+"', '"+object.getPassword()+"', "+object.getUserType()+")"; 
		return db.executeSQL(sql);
	}

	@Override
	public int update(User object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(User object) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> query() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public User queryOne(User object) {
		
		User user = new User();
		
		String sql = "SELECT * from Users WHERE email = '"+object.getEmail()+"' AND password = '"+object.getPassword()+"'";
		ResultSet set = db.executeRetrieveQuery(sql);
		
		try {
			if(set.next()) {
				user.setName(set.getString("name"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setUserType(set.getInt("userType"));
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		
		return user;
		
	}
	

}
