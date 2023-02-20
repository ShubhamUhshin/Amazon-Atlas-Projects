package com.amazon.internalclassifieds;

import java.util.Date;

import com.amazon.internalclassifieds.controller.CategoryManagement;
import com.amazon.internalclassifieds.controller.ClassifiedManagement;
import com.amazon.internalclassifieds.controller.OrderManagement;
import com.amazon.internalclassifieds.controller.UserManagement;

public class AdminMenu extends Menu {
	
	// Creating singleton design pattern
	private static AdminMenu adminMenu = new AdminMenu();
	public static AdminMenu getInstance() {
		return adminMenu;
	}
	
	UserManagement manageUser = UserManagement.getInstance();
	ClassifiedManagement manageClassified = ClassifiedManagement.getInstance();
	CategoryManagement manageCategory = CategoryManagement.getInstance();
	OrderManagement manageOrder = OrderManagement.getInstance();
	
	// Displaying Admin Menu
	public void showMenu() {
		
		System.out.println("*********************");
		System.out.println("Welcome to Admin App");
		System.out.println("Hello, "+userSession.user.name);
		System.out.println("Its: "+new Date());
		System.out.println("*********************");
		
		boolean quit = false;
		
		while(true) {
			// If the Admin enters incorrect data, try block will stop the control to go back to the main menu
			try {
				System.out.println("*********************");
	        	System.out.println("1: Approve/Reject Classifieds");
	        	System.out.println("2: Manage User");
	        	System.out.println("3: Add/Remove Classified");
	        	System.out.println("4: Manage Type/Categories of Classified");
	        	System.out.println("5: View Transactions Report");
	        	System.out.println("6: Log Out");
	        	System.out.println("Select an Option");
	        	
	        	int choice = Integer.parseInt(scanner.nextLine());
	        	// Based on the user choice, calling the respective function
	        	switch (choice) {
					case 1:
						manageClassified.approvalOfClassified();
						break;
						
					case 2:
						manageUser.activateUser();
						break;
	
					case 3:
						System.out.println("1. to post a classified");
						System.out.println("2. to remove a classified");
						System.out.println("Enter your choice");
						int ch = Integer.parseInt(scanner.nextLine());
						
						if (ch == 1)
							manageClassified.postClassified();
						else if (ch == 2)
							manageClassified.removeClassified();
						else
							System.err.println("Invalid Input");
						
						break;
						
					case 4:
						manageCategory.manageCategory();
						
						break;
						
					case 5:
						manageOrder.orderReport();
						
						break;
					
					case 6:
						//If the user wants to quit, we will break the infinite loop
						System.out.println("Thank You for Using Admin App !!");
						quit = true;
						break;
				
					default:
						System.err.println("Invalid Choice...");
						break;
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
