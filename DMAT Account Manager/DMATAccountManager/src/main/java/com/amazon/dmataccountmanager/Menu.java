package com.amazon.dmataccountmanager;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.amazon.dmataccountmanager.controller.ShareManagement;
import com.amazon.dmataccountmanager.controller.TransactionManagement;
import com.amazon.dmataccountmanager.controller.UserManagement;
import com.amazon.dmataccountmanager.db.DB;
import com.amazon.dmataccountmanager.model.Users;


public class Menu {

	Scanner scanner = new Scanner(System.in);
	UserManagement userService = UserManagement.getInstance();
	TransactionManagement transactionService = TransactionManagement.getInstance();
	ShareManagement manageShare = ShareManagement.getInstance();
	
	ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
	void showMainMenu() {
		
		// Function to populate random price to shares 
		
		shareRandomizer();
		
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
	            	// Based on the choice, executing respective function
	        		boolean result = false, quit = false;
	        		Users user = new Users();
	            	
	            	switch(choice) {
	            	
	            	case 1:
	            		// Registering DMAT Account
	        			result = userService.register(user);
	        			
	        			System.out.println();
	        			System.out.println ("Successfully Registered!!!");
	        			System.out.println("Kindly Login to Continue: ");
	        			System.out.println();
	        			// The break is missing on purpose. So that after register, the user has to log in. Just like in facebook etc.
	        			
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
	        				// Storing the user data in user Session object if the login is successful.
	        				userSession.user = user; 
	        				
	                		try {
	                			// Displaying menu
	            				showMenu();
	            			}
	            			catch (Exception e) {
	            				System.out.println("[Main] Error while showing the menu"+e);
	            			}
	        			}	
	            		break;
	            	
	            	case 3:
	            		// Closing scanner
	            		scanner.close();
	            		
	            		// Closing database connection
	            		DB db = DB.getInstance();
	            		db.closeConnection();
	            		// Shutting down dynamic stock scheduler
	            		scheduler.shutdown();
	            		System.out.println("Thank You For using DMAT Account Manager");
	            		// If the user wants to quit, we change the value of quit
	            		quit = true;
	            		break;
	            		
	            	default:
	            		System.err.println("Invalid Input");
	            	}
	            	// Using quit to stop the infinite while loop
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
		// Showing user menu
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
		        	// Based on the user choice performing respective function
		        	switch (choice) {
						case 0:
							System.out.println("Thank You for using the App !!");
							// If the user wants to quit, we change the value of quit
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
	        	// Using quit to stop the infinite while loop	
	        	if(quit) {
	        		break;
	        	}
			}
			catch (Exception e) {
				System.err.println("Invalid Input:" +e);
			}
        }
	}
	
	// Randomizing Shares price
	// Using scheduler to Randomize the share price
	public void shareRandomizer() {
		
		// Using scheduleAtFixedRate function, calling dynamicShares function at fixed intervals
		// ScheduleAtFixedRate is a scheduler function that executes at fixed intervals.
		
		scheduler.scheduleAtFixedRate(new Runnable() {
			
            public void run() {
                // Calling dynamic shares function where we update the share prices randomly
                manageShare.dynamicShares();
                
            }
        }, 0, 10, TimeUnit.SECONDS);//Initial delay, Interval, timeUnit
		// When the app execution starts, after 20 seconds, the dunamicShares function is called
		// After initial call, it is scheduled to be called at every 120 seconds.
		
		// Add a shutdown hook to stop the scheduler
	}
	
}
