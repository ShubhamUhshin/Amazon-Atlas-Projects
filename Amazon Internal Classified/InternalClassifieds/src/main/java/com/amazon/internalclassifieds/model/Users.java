package com.amazon.internalclassifieds.model;

import java.util.Scanner;

/*
   create table Users(
    userID INT IDENTITY(1,1),
    name NVARCHAR(50) NOT NULL,
    phone NVARCHAR(20) NOT NULL UNIQUE,
    email NVARCHAR(30) NOT NULL UNIQUE,
    password NVARCHAR(100) NOT NULL,
    address NVARCHAR(100),
    userType INT NOT NULL, --(1-Admin, 2-Buyer, 3-Seller)
    userStatus BIT NOT NULL,    --(1-Active, 0 Inactive)
    createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(userID));
*/

public class Users {
	//Attributes
	public int userID;
	public String name;
	public String phone;
	public String email;
	public String password;
	public String address;
	public int userType;
	public int userStatus;
	public String createdOn;
	
	public Users() {
		//default constructor
	}
	
	public Users(int userID, String name, String phone, String email, String password, String address, int userType, int userStatus,
			String createdOn) {
		this.userID = userID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
		this.userType = userType;
		this.userStatus = userStatus;
		this.createdOn = createdOn;
	}

	// Get details from the user
	public void getDetails(Users user) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the user Name");
		String name = scanner.nextLine();
		if (!name.isEmpty())
			user.name = name;
		
		System.out.println("Enter the user address");
		String address = scanner.nextLine();
		if (!address.isEmpty())
			user.address = address;
		
		System.out.println("Enter the user phone");
		String phone = scanner.nextLine();
		if (!phone.isEmpty())
			user.phone = phone;
		
		if (user.email == null) {
			String email;
			do {
				System.out.println("Enter the user email");
				email = scanner.nextLine();
			}
			while (email.isBlank() || email.isEmpty());
			
			user.email = email;
			
			String password;
			do {
			System.out.println("Enter the user password");
			password = scanner.nextLine();
			}
			while (password.isBlank() || password.isEmpty());
				
			user.password = password;
			
		}
		
	}
	// Admin and User will see different attributes
	// For Admin
	public void prettyPrintForAdmin(Users user) {
        System.out.println("~~~~~");
        System.out.println("UserID:\t\t"+user.userID);
        System.out.println("Name:\t\t"+user.name);
        System.out.println("Phone:\t\t"+user.phone);
        System.out.println("Email:\t\t"+user.email);
        System.out.println("Address:\t"+user.address);

        String statusText = "";

        if(user.userStatus == 1) {
            statusText = "Active";
        }else if (user.userStatus == 0) {
            statusText = "Inactive";
        }

        System.out.println("User Type:\t"+user.userType);
        System.out.println("Status:\t\t"+statusText);
        System.out.println("~~~~~");
    }

	// For User
    public void prettyPrintForUser(Users user) {
        System.out.println("~~~~~");
        System.out.println("Name:\t\t"+user.name);
        System.out.println("Phone:\t\t"+user.phone);
        System.out.println("Email:\t\t"+user.email);
        System.out.println("Address:\t"+user.address);

        String statusText = "";

        if(user.userStatus == 1) {
            statusText = "Active";
        }else if (user.userStatus == 0) {
            statusText = "Inactive";
        }

        System.out.println("Status:\t\t"+statusText);
        System.out.println("~~~~~");
    }
    
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", address=" + address + ", userType=" + userType + ", userStatus=" + userStatus
				+ ", createdOn=" + createdOn + "]";
	}	
}
