package com.amazon.dmataccountmanager.model;

import java.util.Scanner;
import java.lang.reflect.Field;

public class Users {

/*
MSSQL:
create table Users(
	userID INT IDENTITY(1,1),
	userName NVARCHAR(50) NOT NULL,
	accountNumber NVARCHAR(20) NOT NULL UNIQUE,
	password NVARCHAR(100) NOT NULL,
	accountBalance INT NOT NULL, 
	lastUpdatedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(userID));
*/	
	
	public int userID;
	public String userName;
	public String accountNumber;
	public String password;
	public double accountBalance;
	public String lastUpdatedOn;
	
	
	public Users() {
	}

	
	public Users(int userID, String userName, String accountNumber, String password, double accountBalance,
			String lastUpdatedOn) {
		this.userID = userID;
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.password = password;
		this.accountBalance = accountBalance;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	
	public void prettyPrint(Users user) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("UserID:\t\t\t"+user.userID);
		System.out.println("Name:\t\t\t"+user.userName);
		System.out.println("Account Number:\t\t"+user.accountNumber);
		System.out.println("Account Balance:\t"+user.accountBalance);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	// User Input for account details
	public void getDetails(Users user) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Name: ");
		String name = scanner.nextLine();
		if (!name.isEmpty())
			user.userName = name;
		
		// If it is an update function, accountNumber won't be null
		// So this part of the code only works for register
		if (user.accountNumber == null) {
			
            String accountNumber;
            do {
                System.out.println("Enter your DMAT Account Number: ");
                accountNumber = scanner.nextLine();
            }
            while (accountNumber.isBlank() || accountNumber.isEmpty());
            user.accountNumber = accountNumber;

            
            String password;
            do {
            System.out.println("Enter your Password: ");
            password = scanner.nextLine();
            }
            while (password.isBlank() || password.isEmpty());
            user.password = password;
        }
		
		System.out.println("Enter your Account Balance: ");
		String accountBalance = scanner.nextLine();
		if (!accountBalance.isEmpty())
			user.accountBalance = Integer.parseInt(accountBalance);

	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userName=" + userName + ", accountNumber=" + accountNumber + ", password="
				+ password + ", accountBalance=" + accountBalance + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}
}
