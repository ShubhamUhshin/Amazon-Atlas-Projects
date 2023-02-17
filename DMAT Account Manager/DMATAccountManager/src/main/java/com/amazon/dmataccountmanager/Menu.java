package com.amazon.dmataccountmanager;

import java.util.Date;
import java.util.Scanner;

import com.amazon.dmataccountmanager.controller.TransactionManagement;
import com.amazon.dmataccountmanager.controller.UserManagement;
import com.amazon.dmataccountmanager.db.DB;
import com.amazon.dmataccountmanager.model.Users;


public class Menu {

	Scanner scanner = new Scanner(System.in);
	UserManagement userService = UserManagement.getInstance();
	TransactionManagement transactionService = TransactionManagement.getInstance();
	
	void showMainMenu() {
		// Initial Menu for the Application
        while(true) {
        	try {
            	System.out.println("1: Create New DMAT Account");
            	System.out.println("2: Login");
            	System.out.println("3: Quit");
            	System.out.println("Select an Option");
            	String ch = scanner.nextLine();
            	ch = ch.trim();
            	if (!ch.isBlank()) {
            		
	            	int choice = Integer.parseInt(ch);
	        		boolean result = false, quit = false;
	        		Users user = new Users();
	            	
	            	switch(choice) {
	            	
	            	case 1:
	            		
	        			result = userService.register(user);
	        			
	        			System.out.println();
	        			System.out.println ("Successfully Registered!!!");
	        			System.out.println("Kindly Login to Continue: ");
	        			System.out.println();
	        			
	            	case 2:
	            		System.out.println("Enter Your DMAT Account Number: ");
	                    user.accountNumber = scanner.nextLine();
	
	                    System.out.println("Enter Your Password: ");
	                    user.password = scanner.nextLine();
	                    
	        			result = userService.login(user);
	        			
	        			if(!result) {
	        				System.err.println("Invalid Credentials. Please Try Again !!");
	        			}
	        			else {
	        				System.out.println("Login Successful");
	        				
	        				userSession.user = user; 
	        				
	                		try {
	            				showMenu();
	            			}
	            			catch (Exception e) {
	            				System.out.println("[Main] Error while showing the menu"+e);
	            			}
	        			}	
	            		break;
	            	
	            	case 3:
	            		scanner.close();
	            		DB db = DB.getInstance();
	            		db.closeConnection();
	            		System.out.println("Thank You For using DMAT Account Manager");
	            		quit = true;
	            		break;
	            		
	            	default:
	            		System.err.println("Invalid Input");
	            	}
            	
		        	if(quit) {
		        		break;
		        	}
            	
            	}
            }
        	catch (Exception e) {
				System.err.println("Invalid Input: "+e);
			}
        }
	}

	public void showMenu() {
		
		System.out.println("Showing Menu...");
		
		System.out.println("*********************");
		System.out.println("Hello, "+userSession.user.userName);
		System.out.println("Its: "+new Date());
		System.out.println("*********************");
		
		boolean quit = false;
		
		while(true) {
			try {
	        	System.out.println("0: LogOut");
	        	System.out.println("1: Display DMAT Account Details");
	        	System.out.println("2: Deposit Money");
	        	System.out.println("3: Withdraw Money");
	        	System.out.println("4: Buy Transactions");
	        	System.out.println("5: Sell Transactions");
	        	System.out.println("6: View Transaction Report");
	        	System.out.println("Select an Option");
	        	String ch = scanner.nextLine();
	        	ch = ch.trim();
	        	if (!ch.isBlank()) {
	        		
		        	int choice = Integer.parseInt(ch);
		        	
		        	switch (choice) {
						case 0:
							System.out.println("Thank You for using the App !!");
							quit = true;
							break;
							
						case 1:
							userService.displayAccount();
							break;
							
						case 2:
							userService.depositMoney();
							break;
							
						case 3:
							userService.withdrawMoney();
							break;
							
						case 4:
							transactionService.buyTransaction();
							break;
							
						case 5:
							transactionService.sellTransaction();
							break;
							
						case 6:
							userService.viewReport();
							break;
			
						default:
							System.err.println("Invalid Choice...");
							break;
						}
	        		}
		        	
	        	if(quit) {
	        		break;
	        	}
			}
			catch (Exception e) {
				System.err.println("Invalid Input:" +e);
			}
        }
	}
}
