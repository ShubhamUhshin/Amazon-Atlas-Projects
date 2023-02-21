package com.amazon.dmataccountmanager.controller;

import java.util.List;
import java.util.Scanner;

import com.amazon.dmataccountmanager.db.passEncryption;
import com.amazon.dmataccountmanager.userSession;
import com.amazon.dmataccountmanager.db.TransactionDAO;
import com.amazon.dmataccountmanager.db.UserDAO;
import com.amazon.dmataccountmanager.model.Transactions;
import com.amazon.dmataccountmanager.model.Users;


public class UserManagement {
	
	Scanner scanner = new Scanner(System.in);
	Users user = new Users();
	UserDAO userdao = new UserDAO();
	TransactionDAO transactiondao = new TransactionDAO();
	Transactions transaction = new Transactions();
	passEncryption encrypt = passEncryption.getInstance();
	ShareManagement manageShare = ShareManagement.getInstance();
	
	// Creating object using Singleton design pattern
	private static UserManagement manageUsers = new UserManagement();
	public static UserManagement getInstance() {
		return manageUsers;
	}
	
	private UserManagement() {
	}
	
	PortfolioManagement managePortfolio = PortfolioManagement.getInstance();
	
	// Login Function
	public boolean login(Users user) {

		String sql = "SELECT * FROM Users WHERE accountNumber = '"+user.accountNumber+"' AND password = '"+encrypt.encryptor(user.password)+"'";
		List<Users> users = userdao.retrieve(sql);
		// If the user exists, we populate the user details
		if(users.size() > 0) {
			Users u = users.get(0);
			user.userID = u.userID;
			user.userName = u.userName;
			user.accountNumber = u.accountNumber;
			user.password = u.password;
			user.accountBalance = u.accountBalance;
			user.lastUpdatedOn = u.lastUpdatedOn;
			return true;
		}
		return false;
	}
	// Register
	public boolean register(Users user) {
		
		// Asking the user to input details
		user.getDetails(user);
		
		// Inserting into the user table
		if (userdao.insert(user)>0)
			return true;
		
		return false;	
	}
	
	// For User
	public void displayAccount() {

        // Fetch User Detail
        String sql = "SELECT * FROM Users WHERE accountNumber= '"+userSession.user.accountNumber+"'";
        List <Users> userDetail = userdao.retrieve(sql);

        // Display the Details
        user.prettyPrint(userDetail.get(0));
        
        // Display portfolio
        managePortfolio.displayPortfolio();
    }
	
	// For User
	public boolean update() {

        // Fetch User Details
        String sql = "SELECT * FROM Users WHERE accountNumber= '"+userSession.user.accountNumber+"'";
        List <Users> userDetail = userdao.retrieve(sql);

        // Ask the user to update the details
        user.getDetails(userDetail.get(0));

        // Update the details in Database.
        if (userdao.update(userDetail.get(0))>0) {
        	System.out.println("User Profile Updated Successfully");
        	return true;
        }
        else {
			System.err.println("User Profile Update Failed...");
			return false;
		}
    }
	
	// Deposit Money without parameter
	// This function is called when the user wants to withdraw money
	public boolean withdrawMoney() {
		
		// Entering Amount
		System.out.println("Enter the Amount to be withdrawn: ");
		double amount = Double.parseDouble(scanner.nextLine());
        
		// Checking if the amount user wants to withdraw is more than his account balance
		if(amount<=userSession.user.accountBalance) {
			// Withdrawing the amount
			userSession.user.accountBalance-=amount;
			// Updating the Database
			if(userdao.update(userSession.user)>0) {
				System.out.println("Money Withdrawn Successfully");
				return true;
			}
		}
		else {
			System.out.println("Transaction Failed");
			return false;
		}
		
		return false;
	}
	
	// Withdraw Money Overridden with parameter
	// This function is called when the User buys a share
	public boolean withdrawMoney(double amount) {
        
		// Withdrawing amount from user's account to buy the share
		userSession.user.accountBalance-=amount;
		
		// Updating the new amount in the database
		if(userdao.update(userSession.user)>0) {
			System.out.println("Money Withdrawn Successfully");
			return true;
		}
		else {
			System.out.println("Transaction Failed");
			return false;
		}
	}
	
	//Deposit Money without parameter
	public boolean depositMoney() {
		
		// Asking the user to enter the amount he wants to deposit
		System.out.println("Enter the Amount to be deposited: ");
		String amt = scanner.nextLine();
		amt = amt.trim();
		if (!amt.isBlank()) {
			double amount = Double.parseDouble(scanner.nextLine());
	        
			// Adding the amount in the account balance
			userSession.user.accountBalance+=amount;
			
			// Updating the database
			if(userdao.update(userSession.user)>0) {
				System.out.println("Money Deposited Successfully");
				return true;
			}
			else {
				System.out.println("Transaction Failed");
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	// Deposit Money Overridden with parameter
	// This function is called when user sells a share
	public boolean depositMoney(double amount) {
	
		// Adding the money in the user account
		userSession.user.accountBalance+=amount;
		
		// Updating the database
		if(userdao.update(userSession.user)>0) {
			System.out.println("Money Deposited Successfully");
			return true;
		}
		else {
			System.out.println("Transaction Failed");
			return false;
		}
	}
	
	// Viewing report of transactions made by a user
	// Displaying report based on user choice
	// Displaying report of all transactions, based on a given date range or given share
	public void viewReport() {
		
        System.out.println("1. View a report of all transactions");
		System.out.println("2. view a report of all transactions between a given date range");
		System.out.println("3. view a report of all transactions for a given share");
		// Displaying report based on user choice
		String choice = scanner.nextLine();
		choice.trim();
		
		int userChoice = Integer.parseInt(choice);
		String sql="";
		
		// To check if the user has given correct input choice
		boolean display = true;
		
		if (userChoice == 1) {
			// If choice is 1, storing the query to display all transactions of the user
			sql = "Select * from Transactions where userID = "+userSession.user.userID;
	        
		}
		
		else if (userChoice == 2) {
			// If choice is 2, displaying based on the date based string
			System.out.println("Enter the date range in the format YYYY-MM-DD");
			System.out.println("Enter From Date");
			String Date1 = scanner.nextLine();
			System.out.println("Enter to Date");
			String Date2 = scanner.nextLine();
			// Storing the query to display transactions in date range
			sql = "Select * from Transactions where userID = "+userSession.user.userID+" and transactedOn between '"+Date1+"' and '"+Date2+"'";		
		
		}
		
		else if (userChoice == 3) {
			// If choice is 3, displaying based on the shareID
			System.out.println("Enter the shareID");
			String shareID = scanner.nextLine();
			shareID.trim();
			if (!shareID.isBlank()) {
				int shareDetail = Integer.parseInt(shareID);
				sql = "Select * from Transactions where userID = "+userSession.user.userID+" and shareID = "+shareDetail;
			}
		}
			
		else {
			System.out.println("Invalid choice");
			display = false;
		}
		
		// If the choice is 1,2 or 3, display is true and the code shall retrieve data
		if (display) {
			
			// Retrieving data from transaction table based on the SQL query
			List <Transactions> transactionDetail = transactiondao.retrieve(sql);
			if (!transactionDetail.isEmpty()) {
				
				// Displaying share name and shareID based on the shareID
				manageShare.displaySharesForTransaction(transactionDetail.get(0).shareID);
				// Displaying transaction details
				for (Transactions transaction : transactionDetail)
		        	transaction.prettyPrint(transaction);
				
			}
			
			else {
				System.out.println("Nothing to display");
			}
		}
	}
}
