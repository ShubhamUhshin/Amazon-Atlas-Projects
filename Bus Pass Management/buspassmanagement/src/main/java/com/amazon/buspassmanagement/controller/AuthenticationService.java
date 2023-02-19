package com.amazon.buspassmanagement.controller;

import com.amazon.buspassmanagement.db.passwordEncryptor;

//import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.List;
import com.amazon.buspassmanagement.model.User;

public class AuthenticationService extends Management{

	private static AuthenticationService service = new AuthenticationService();
	passwordEncryptor encryptor = passwordEncryptor.getInstance();
	// Dummy DataBase in RAM
	//LinkedHashMap<Integer, User> users = new LinkedHashMap<Integer, User>();
	
	private AuthenticationService(){
		/*
		User user1 = new User();
		user1.id = 1;
		user1.name = "Shubham";
		user1.email = "srvshu@amazon.com";
		user1.password = "srvshu123";
		user1.address = "Saggitarius A";
		user1.phone = "+99999 1111";
		user1.department = "Admin";
		user1.type = 1;	
		
		User user2 = new User();
		user2.id = 2;
		user2.name = "John Wick";
		user2.email = "john@example.com";
		user2.password = "john123";
		user2.address = "121 Mill Neck";
		user2.phone = "+99999 2222";
		user2.department = "Hitman";
		user2.type = 2;
		
		UserDAO dao = new UserDAO();
		dao.insert(user1);
		dao.insert(user2);
		System.out.println("Users added in Database :)");
		// Dummy Users in the HashMap :)
		//users.put(user1.id, user1);
		//users.put(user2.id, user2);
		
		//System.out.println("DataBase Details:");
		//System.out.println(users);
		*/
	}
	
	public static AuthenticationService getInstance() {
		return service;
	}
	

	public boolean loginUser(User user) {
			
		String sql = "SELECT * FROM Users WHERE email = '"+user.email+"' AND password = '"+encryptor.encryptor(user.password)+"'";
		List<User> users = dao.retrieve(sql);
			
		if(users.size() > 0) {
			User u = users.get(0);
			user.name = u.name;
			user.type = u.type;
			user.id = u.id;
			return true;
		}
			
		return false; 
	}
	
	public boolean registerUser(User user) {
		
		return dao.insert(user) > 0;
	}
	
	public boolean updateUser(User user) {
		return dao.update(user) > 0;
	}
	
	public boolean deleteUser (User user) {
		return dao.delete(user) > 0;
	}

}

