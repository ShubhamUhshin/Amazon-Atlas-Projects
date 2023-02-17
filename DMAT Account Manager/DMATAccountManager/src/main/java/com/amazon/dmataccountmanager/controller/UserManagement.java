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
	
	private static UserManagement manageUsers = new UserManagement();
	
	public static UserManagement getInstance() {
		return manageUsers;
	}
	
	private UserManagement() {
	}
	
	PortfolioManagement managePortfolio = PortfolioManagement.getInstance();
	
	public boolean login(Users user) {

		String sql = "SELECT * FROM Users WHERE accountNumber = '"+user.accountNumber+"' AND password = '"+encrypt.encryptor(user.password)+"'";
		List<Users> users = userdao.retrieve(sql);
		
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
	
	public boolean register(Users user) {
		
		user.getDetails(user);
		
		if (userdao.insert(user)>0)
			return true;
		
		return false;	
	}
	
	//For User
	public void displayAccount() {

        //Fetch User Detail
        String sql = "SELECT * FROM Users WHERE accountNumber= '"+userSession.user.accountNumber+"'";
        List <Users> userDetail = userdao.retrieve(sql);

        //Display the Details
        user.prettyPrint(userDetail.get(0));
        
        managePortfolio.displayPortfolio();
    }
	
	//For User
	public boolean update() {

        //Fetch User Detail
        String sql = "SELECT * FROM Users WHERE accountNumber= '"+userSession.user.accountNumber+"'";
        List <Users> userDetail = userdao.retrieve(sql);

        //Ask the user to update the details
        user.getDetails(userDetail.get(0));

        //Update the details in SQL.
        if (userdao.update(userDetail.get(0))>0) {
        	System.out.println("User Profile Updated Successfully");
        	return true;
        }
        else {
			System.err.println("User Profile Update Failed...");
			return false;
		}
    }
	
	//Deposit Money without parameter
	public boolean withdrawMoney() {
		
		System.out.println("Enter the Amount to be withdrawn: ");
		double amount = Double.parseDouble(scanner.nextLine());
        
		if(amount<=userSession.user.accountBalance) {
			userSession.user.accountBalance-=amount;
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
	
	//Withdraw Money Overrided with parameter
	public boolean withdrawMoney(double amount) {
        
		if(amount<=userSession.user.accountBalance) {
			userSession.user.accountBalance-=amount;
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
	
	//Deposit Money without parameter
	public boolean depositMoney() {
		
		System.out.println("Enter the Amount to be deposited: ");
		String amt = scanner.nextLine();
		amt = amt.trim();
		if (!amt.isBlank()) {
			double amount = Double.parseDouble(scanner.nextLine());
	        
			userSession.user.accountBalance+=amount;
			
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
	
	//Deposit Money Overrided with parameter
	public boolean depositMoney(double amount) {
	
		userSession.user.accountBalance+=amount;
		
		if(userdao.update(userSession.user)>0) {
			System.out.println("Money Deposited Successfully");
			return true;
		}
		else {
			System.out.println("Transaction Failed");
			return false;
		}
	}
	
	
	public void display() {
		
		List <Users> userDetail = userdao.retrieve();
		for (Users user : userDetail) {
			user.printTable(user);
		}
	}
	
	
	public void viewReport() {

		// Need to fix as per requirement
		//a. A user should be able to view a report of all transactions between a given
		//date range.
		//b. A user should be able to view a report of all transactions for a given share
		//(company name or ID).
        System.out.println("1. View a report of all transactions");
		System.out.println("2. view a report of all transactions between a given date range");
		System.out.println("3. view a report of all transactions for a given share");
		
		String choice = scanner.nextLine();
		choice.trim();
		
		int userChoice = Integer.parseInt(choice);
		String sql="";
		
		boolean display = true;
		
		if (userChoice == 1) {
			
			sql = "Select * from Transactions where userID = "+userSession.user.userID;
	        
		}
		
		else if (userChoice == 2) {
			
			System.out.println("Enter the date range in the format YYYY-MM-DD");
			System.out.println("Enter From Date");
			String Date1 = scanner.nextLine();
			System.out.println("Enter to Date");
			String Date2 = scanner.nextLine();
			
			sql = "Select * from Transactions where userID = "+userSession.user.userID+" and transactedOn between '"+Date1+"' and '"+Date2+"'";		
		
		}
		
		else if (userChoice == 3) {
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
		
		if (display) {
			
			List <Transactions> transactionDetail = transactiondao.retrieve(sql);
			if (!transactionDetail.isEmpty()) {
				
				manageShare.displaySharesForTransaction(transactionDetail.get(0).shareID);
				
				for (Transactions transaction : transactionDetail)
		        	transaction.prettyPrint(transaction);
				
			}
			
			else {
				System.out.println("Nothing to display");
			}
		}
	}
}
