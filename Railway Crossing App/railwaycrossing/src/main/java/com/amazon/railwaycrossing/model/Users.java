package com.amazon.railwaycrossing.model;

import java.util.Scanner;

/*Create table Users(
	userID int IDENTITY(1,1),
	name varchar (30),
	emailID varchar (20) NOT null UNIQUE,
	password varchar (20) not null,
	userType int -- 1 for Admin, 2 for User
	);
 */

public class Users {
	
	public int userID;
	public String name;
	public String emailID;
	public String password;
	public int userType;
	
	public Users(){
		
	}

	public Users(int userID, String name, String email, String password, int userType) {
		this.userID = userID;
		this.name = name;
		this.emailID = email;
		this.password = password;
		this.userType = userType;
	}
	
	public void getLoginCredentials(Users user) {
		
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter your email ID");
			String emailID = scanner.nextLine();
			if (!emailID.isBlank())
				user.emailID = emailID;
		}while (emailID.isBlank());
		
		do {
			System.out.println("Enter your password");
			String password = scanner.nextLine();
			if (!password.isBlank())
				user.password = password;
		}while (password.isBlank());
		
	}
	public void getDetails(Users user) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scanner.nextLine();
		user.name = name;
		
		if (user.emailID.isBlank()) {
			// Checking if the user's emailID is empty
			// If the userID is not empty, then the function is called for data update, so we don't let him update the email id and password
			do {
				System.out.println("Enter your email ID");
				String emailID = scanner.nextLine();
				if (!emailID.isBlank())
					user.emailID = emailID;
			}while (emailID.isBlank());
			
			do {
				System.out.println("Enter your password");
				String password = scanner.nextLine();
				if (!password.isBlank())
					user.password = password;
			}while (password.isBlank());
			
			user.userType = 2;
			
		}	
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", name=" + name + ", email=" + emailID + ", password=" + password
				+ ", userType=" + userType + "]";
	}
	
	
	

}
