package com.amazon.railwaycrossing.controller;

import java.util.List;
import com.amazon.railwaycrossing.UserSession;
import com.amazon.railwaycrossing.db.UserDAO;
import com.amazon.railwaycrossing.model.Users;

public class UserManagement {
	
	private static UserManagement manageUser = new UserManagement();
	
	public static UserManagement getInstance() {
		return manageUser;
	}
	
	UserDAO userDAO = new UserDAO();
	Users user = new Users();
	
	public UserManagement() {
		/*
		// Creating Admin
		Users adminUser = new Users();
		adminUser.name = "Shubham";
		adminUser.email = "srvshu@amazon.com";
		adminUser.password = "Admin123";
		adminUser.userType = 1;
		
		UserDAO userDAO = new UserDAO();
		int result = userDAO.insert(adminUser);
		System.out.println(result);
		*/
	}
	
	// For Admin and User
	// The function asks the user to enter his email id and password
	// Based on the detail, we search the table and return the corresponding value
	public boolean login() {
		
		user.getLoginCredentials(user);
		String sql = "SELECT * FROM Users WHERE emailID = '"+user.emailID+"' and password = '"+user.password+"'";
		List <Users> userDetails = userDAO.retrieve(sql);
			if (userDetails.size() > 0) {
			user.name = userDetails.get(0).name;
			user.userType = userDetails.get(0).userType;
			user.userID = userDetails.get(0).userID;
			UserSession.currentUser = user;
			return true;
		}
		return false;
	}
	
	// For User
	public boolean register() {
		user.getDetails(user);
		if (userDAO.insert(user)>0)
			return true;
		
		return false;
	}
}
