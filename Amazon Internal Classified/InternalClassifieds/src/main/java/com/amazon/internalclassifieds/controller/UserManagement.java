package com.amazon.internalclassifieds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazon.internalclassifieds.userSession;
import com.amazon.internalclassifieds.db.UserDAO;
import com.amazon.internalclassifieds.db.passwordEncryptor;
import com.amazon.internalclassifieds.model.Users;

public class UserManagement {
	
	UserDAO userdao = new UserDAO();
	Users user = new Users();
	Scanner scanner = new Scanner(System.in);
	passwordEncryptor encryptor = passwordEncryptor.getInstance();
	
	private static UserManagement manageUser = new UserManagement();
	
	public static UserManagement getInstance() {
		return manageUser;
	}
	private UserManagement(){
		
		/*
		Users user1 = new Users();
		
		user1.name = "Shubham";
		user1.email = "srvshu@amazon.com";
		user1.password = "Admin123";
		user1.address = "WTC";
		user1.phone = "+91 1234567890";
		user1.userStatus = 1;
		user1.userType = 1;
		
		//userDAO insert to database
		
		Users user2 = new Users();
		
		user2.name = "Jeff Bezos";
		user2.email = "jb@example.com";
		user2.password = "jb123";
		user2.address = "Space";
		user2.phone = "12345 67890";
		user2.userStatus = 0;
		user2.userType = 2;
		
		userdao.insert(user1);
		userdao.insert(user2);
		*/
	}
	
	//For Admin
	public boolean activateUser() {

        List <Users> users = new ArrayList<Users>();
        users = userdao.retrieve();
        for (Users userDetails : users) {
            user.prettyPrintForAdmin(userDetails);
        }

        System.out.println("Enter the UserID of the User to Activate/Deactivate: ");
        int userID = Integer.parseInt(scanner.nextLine());

        String sql = "Select * From Users Where userID = "+userID;
        List <Users> usertoActivate = new ArrayList<Users>();
        usertoActivate = userdao.retrieve(sql);
        user = usertoActivate.get(0);

        System.out.println("\n 1-Activate \n 0-Deactivate");
        int status = Integer.parseInt(scanner.nextLine());
        user.userStatus=(status==1) ? 1 : 0;

        if(userdao.update(user)>0)
            return true;
        else
            return false;
    }

	
	// To check if the user is active or not using session
	// For User
	// If the user is Inactive, he won't be able to post a classified or buy or sell.
    public boolean checkUserStatus() {

        if(userSession.user.userStatus == 1) 
            return true;
        else 
            return false;
    }
    
    /*
    //Check the status of User
	public boolean checkUserStatus(Users user) {

        String sql = "Select * From Users Where userID = "+userSession.user.userID;
        List <Users> usertoActivate = new ArrayList<Users>();
        usertoActivate = userdao.retrieve(sql);
        user = usertoActivate.get(0);

        if(user.userStatus==1)
            return true;
        else {
            return false;
        }
    }
	*/
    
	//For User
	public boolean register(Users user) {
		
		user.getDetails(user);
		user.userType = 2;
		if (userdao.insert(user)>0)
			return true;
		
		return false;
	}
	
	//For User
	public void displayUser() {
		
		//Fetch User Detail
		String sql = "Select * from Users where email= '"+userSession.user.email+"'";
		List <Users> userDetail = userdao.retrieve(sql);
		
		//Display the Details
		user.prettyPrintForUser(userDetail.get(0));
	}

	//For User
	public boolean updateUser() {
		
		//Fetch User Detail
		String sql = "Select * from Users where email= '"+userSession.user.email+"'";
		List <Users> userDetail = userdao.retrieve(sql);
		
		//Ask the user to update the details
		user.getDetails(userDetail.get(0));
		
		//Update the details in SQL.
		if (userdao.update(userDetail.get(0))>0)
			return true;
		
		return false;
	}
	
	//There is an error with the logic, while insert, the email is duplicate which creates violation of query as email should be unique
	public boolean passwordReset() {
		
		String sql = "Select * from Users where email = '"+userSession.user.email+"'";
		List <Users> userDetail = userdao.retrieve(sql);
		
		//Ask the user to update the details
		System.out.println("Enter the old password");
		String password = scanner.nextLine();
		
		if (userDetail.get(0).password.equals(encryptor.encryptor(password))) {
			System.out.println("Enter the new password:");
			password = scanner.nextLine();
			System.out.println("Confirm Password:");
			String password1 = scanner.nextLine();
			
			if (password.equals(password1)) {
				userDetail.get(0).password = password1;
				if (userdao.insert(userDetail.get(0))>0) {
					
					userSession.user = userDetail.get(0);
					System.out.println("Password updated successfully");
					return true;
				}
			}
		}
		return false;
	}
	
	//For both Admin and User
		public boolean login(Users user) {
			
			String sql = "Select * from Users where email = '" +user.email +"' and password = '"+encryptor.encryptor(user.password) +"'";
			List <Users> userDetail = userdao.retrieve(sql);
			if(userDetail.size() > 0) {
				Users user1 = userDetail.get(0);
				user.name = user1.name;
				user.userType = user1.userType;
				user.userID = user1.userID;
				user.userStatus = user1.userStatus;
				return true;
			}
			
			return false;
		}
}
