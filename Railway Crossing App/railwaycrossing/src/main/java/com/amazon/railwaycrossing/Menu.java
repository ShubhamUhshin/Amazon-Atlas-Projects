package com.amazon.railwaycrossing;

import java.util.Scanner;

import com.amazon.railwaycrossing.controller.UserManagement;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	UserManagement manageUser = UserManagement.getInstance();
	public Menu() {
		// Default Constructor
	}

	public void showMainMenu() {
		
		System.out.println("__________________________________________");
		System.out.println();
		System.out.println("     Welcome to RailwayCrossing App");
		System.out.println();
		System.out.println("__________________________________________");
		
		while (true) {
			try {
				
				boolean quit  = false;
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Continue as Guest");
				System.out.println("4. Quit");
				int choice = Integer.parseInt(scanner.nextLine());
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				boolean result;
				switch (choice) {
				
				case 1:
					
					// Using user register code to register
					result = manageUser.register();
					if (result)
						System.out.println("Registered Successfully");
					else {
						System.out.println("Unable to register. Please try again");
					}

						
				case 2:
					
					// Using login code to login
					result = manageUser.login();
					if (result) {
						System.out.println("Login Successful");
						
						// If Login is successfull we display the admin or user menu based on the user type
						System.out.println("Hello "+UserSession.currentUser.name);
						
						// Code for Admin Menu or User Menu based on menu factory code 
						try {
							// Menu factory has a showMenu function that returns object depending on the userType.
							// We display the menu accordingly.
							menuFactory.showMenu(UserSession.currentUser.userType).showMenu();
						}
						
						
						catch(Exception e) {
							System.err.println("[Menu] Our servers are currently down... Kindly ty again Later");
						}
							
					}
					else {
						System.out.println("Invalid Credentials");
					}
					break;	

					
				case 3:
					// Guest Menu
					System.out.println("Welcome Guest!");
					guestMenu.getInstance().showMenu();
					break;
				
				case 4:
					// Using quit flag to terminate the infinite loop
					quit = true;
					break;
				
				default:
					System.out.println("Andha hai kya?");
				
				}
				
				if (quit) {
					System.out.println("Thank you for using the app");
					break;
				}
					
			}
			
			catch (Exception e) {
				System.out.println("Invalid Choice");
			}
		}
	}
	
	public void showMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
