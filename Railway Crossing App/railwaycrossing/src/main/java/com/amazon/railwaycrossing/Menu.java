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
		
		System.out.println("Welcome to RailwayCrossing App");
		
		while (true) {
			try {
				
				boolean quit  = false;
				
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Continue as Guest");
				System.out.println("4. Quit");
				int choice = Integer.parseInt(scanner.nextLine());
				
				if (choice == 1) {
					
					boolean result = manageUser.register();
					if (result)
						System.out.println("Registered Successfully");
					else {
						System.out.println("Unable to register. Please try again");
					}
				}
						
				else if (choice == 2) {
					boolean result = manageUser.login();
					if (result) {
						System.out.println("Login Successful");
						System.out.println("Hello "+UserSession.currentUser.name);
						
						// Code for Admin Menu or User Menu based on menu factory code 
							
					}
					else {
						System.out.println("Invalid Credentials");
					}
						
				}
					
				else if (choice == 3)
					// Guest Menu
					System.out.println();
				
				else if (choice == 4) {
					quit = true;
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
}
