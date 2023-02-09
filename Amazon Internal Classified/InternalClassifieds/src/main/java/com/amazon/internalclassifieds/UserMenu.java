package com.amazon.internalclassifieds;

import java.util.Date;

import com.amazon.internalclassifieds.controller.ClassifiedManagement;
import com.amazon.internalclassifieds.controller.OrderManagement;
import com.amazon.internalclassifieds.controller.UserManagement;

//import java.util.Date;

public class UserMenu extends Menu{
	
	private static UserMenu userMenu = new UserMenu();
	
	public static UserMenu getInstance() {
		return userMenu;
	}
	
	UserManagement manageUser = UserManagement.getInstance();
	ClassifiedManagement manageClassified = ClassifiedManagement.getInstance();
	OrderManagement manageOrder = OrderManagement.getInstance();
	
	public void showMenu() {
		
		System.out.println("Navigating to User Menu...");
		System.out.println("^^^^^^^^^^^^^^^^^^^");
		System.out.println("Welcome to User App");
		System.out.println("Hello, "+userSession.user.name);
		System.out.println("Its: "+new Date());
		System.out.println("^^^^^^^^^^^^^^^^^^^");
		
		boolean quit = false;
		
		while(true) {
			try {
				System.out.println("1: Manage Profile");
				System.out.println("2: Post a Classified");
				System.out.println("3: View All Classified");
				System.out.println("4: View Your Classifieds");
				System.out.println("5: Modify your Classified");
				System.out.println("6: Connect to user and perform sell/buy");
				System.out.println("7: Log Out");
				System.out.println("Select an Option");
    	
				int choice = Integer.parseInt(scanner.nextLine());
    	
				switch (choice) {
					case 1:
						
						System.out.println("1. to View Your Profile");
						System.out.println("2. to Update your Profile");
						System.out.println("Enter your choice");
						int ch = Integer.parseInt(scanner.nextLine());
						
						if (ch == 1) {
							manageUser.displayUser();
							System.out.println("Do you want to see your classifieds?");
							System.out.println("1. for Yes \t 2. for no");
							if (Integer.parseInt(scanner.nextLine()) == 1)
								manageClassified.displayUserClassified();
						}
							
						else if (ch == 2)
							if (manageUser.updateUser())
								System.out.println("User Details updated");
							else 
								System.err.println("Some error occurred");
							
						else
							System.err.println("Invalid Input");
						
						break;
						
					case 2:
						if (manageClassified.postClassified())
							System.out.println("Classified Posted");
						else
							System.err.println("Some Error occurred");
						
						break;

					case 3:
						manageClassified.displayClassified();
							
						break;
				
					case 4:
						manageClassified.displayUserClassified();
						break;
						
					case 5:
						manageClassified.update();
						break;
						
					case 6:
						if(manageOrder.buyClassified())
							System.out.println("Classified bought");
						
						break;
					
					case 7:
						System.out.println("Thank You for Using User App !!");
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
