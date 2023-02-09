package com.amazon.internalclassifieds;

import java.util.Scanner;

import com.amazon.internalclassifieds.controller.UserManagement;
import com.amazon.internalclassifieds.db.DB;
import com.amazon.internalclassifieds.model.Users;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	
	UserManagement manageUser = UserManagement.getInstance();
	
	void showMainMenu() {
		// Initial Menu for the Application
        while(true) {
        	try {
				System.out.println("1: Register");
				System.out.println("2: Login");
				System.out.println("3: Quit");
				System.out.println("Select an Option");
				
				int choice = Integer.parseInt(scanner.nextLine());
				boolean result = false;
				Users user = new Users();
				boolean quit = false;
				switch (choice) {
				case 1:
					
					user.userType = 2;
					result = manageUser.register(user);
					System.out.println ("Successfully Registered!!!");
					System.out.println("Kindly Login to continue");
					
				case 2:
					System.out.println("Enter Your Email:");
					user.email = scanner.nextLine();
					
					System.out.println("Enter Your Password:");
					user.password = scanner.nextLine();
					
					result = manageUser.login(user);
					
					if(!result) {
						System.err.println("Invalid Credentials. Please Try Again !!");
					}
					else {
						System.out.println("Login Successful");
					
						userSession.user = user;
						try {
							MenuFactory.getMenu(user.userType).showMenu();
						}
						catch (Exception e) {
							System.out.println("[main] Error While showing the menu"+e);
						}
					}
					break;
					
				case 3:
					System.out.println("Thank You For using Amazon Internal Classifiedss App");
					DB db = DB.getInstance();
					db.closeConnection();
					quit = true;
					break;
					
				default:
					System.err.println("Invalid Input:");
				
				}
				if (quit == true)
					break;
        	}
        	catch (Exception e) {
				System.err.println("Invalid Input:" +e);
			}
        }
	}
	
	public void showMenu() {
		System.out.println("Showing the Menu...");
	}

}
