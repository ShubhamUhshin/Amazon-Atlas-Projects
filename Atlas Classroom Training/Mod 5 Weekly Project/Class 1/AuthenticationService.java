package com.amazon.buspassmanagement.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;

import com.amazon.buspassmanagement.model.User;

public class AuthenticationService {
	
	private static AuthenticationService service = new AuthenticationService();

	// Dummy DataBase in RAM
	LinkedHashMap<Integer, User> users = new LinkedHashMap<Integer, User>();
	
	private AuthenticationService(){
		
		User user1 = new User();
		user1.id = 1;
		user1.name = "John Watson";
		user1.email = "john@example.com";
		user1.password = "admin123";
		user1.type = 1;	
		
		User user2 = new User();
		user2.id = 2;
		user2.name = "Fionna Flynn";
		user2.email = "fionna@example.com";
		user2.password = "fionna123";
		user2.type = 2;	
		
		// Dummy Users in the HashMap :)
		users.put(user1.id, user1);
		users.put(user2.id, user2);
		
		System.out.println("DataBase Details:");
		System.out.println(users);
	}
	
	static public AuthenticationService getInstance() {
		return service;
	}
	
	public boolean loginUser(User user) {
		
		boolean result = false;
		
		
		Iterator<Integer> itr = users.keySet().iterator();
		while(itr.hasNext()) {
			Integer key = itr.next();
			
			User u = users.get(key);
			// Select * from User where email = '' and password = ''
			if(u.email.equals(user.email) && u.password.equals(user.password)) {
				// user will now point to a new Object i.e. referred by u
				user.name = u.name;
				user.type = u.type; 
				result = true;
				break;
			}
		
		}
		return result;
	}
	
}
