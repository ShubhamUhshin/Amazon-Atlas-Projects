package com.amazon.buspassmanagement;

import java.util.Date;
import java.util.Scanner;

import com.amazon.buspassmanagement.controller.AuthenticationService;
import com.amazon.buspassmanagement.model.User;

public class App {
	
	AuthenticationService auth = AuthenticationService.getInstance(); 
	
	private App() {
	   	
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println( "Welcome to Bus Pass Management Application" );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
	}
	
	Scanner scanner = new Scanner(System.in);
	
	void showMainMenu() {
		// Initial Menu for the Application
        while(true) {
        	
        	System.out.println("1: Admin");
        	System.out.println("2: User");
        	System.out.println("3: Quit");
        	System.out.println("Select an Option");
        	
        	int choice = scanner.nextInt();
        	
        	if(choice == 1) {
        		System.out.println("Navigating to Admin Menu...");
        		showAdminMenu();
        	}else if (choice == 2) {
        		System.out.println("Navigating to User Menu...");
        		showUserMenu();
        	}else if (choice == 3) {
        		System.out.println("Thank You For using Bus Pass Management App");
        		break;
        	}	
        	else {
        		System.err.println("Invalid Choice...");
        	}
        	
        }
	}
	
	void showAdminMenu() {
		
		// Login Code should come before the Menu becomes Visible to the Admin
		User adminUser = new User();
		
		// An empty scanner.nextLine as we are reading string after int :)
		scanner.nextLine();
		
		System.out.println("Enter Your Email:");
		adminUser.email = scanner.nextLine();
		
		System.out.println("Enter Your Password:");
		adminUser.password = scanner.nextLine();
		
		boolean result = auth.loginUser(adminUser);
		
		if(result && adminUser.type == 1) {
		
		
			System.out.println("*********************");
			System.out.println("Welcome to Admin App");
			System.out.println("Hello, "+adminUser.name);
			System.out.println("Its: "+new Date());
			System.out.println("*********************");
			
			boolean quit = false;
			
			while(true) {
	        	System.out.println("1: Manage Routes");
	        	System.out.println("2: Manage Stops");
	        	System.out.println("3: Manage Vehicles");
	        	System.out.println("4: Manage Bus Pass");
	        	System.out.println("5: Manage Feedbacks");
	        	System.out.println("6: Quit Admin App");
	        	System.out.println("Select an Option");
	        	
	        	int choice = scanner.nextInt();
	        	
	        	switch (choice) {
					case 1:
						
						break;
						
					case 2:
						
						break;
	
					case 3:
						
						break;
						
					case 4:
						
						break;
						
					case 5:
						
						break;
						
					case 6:
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
		}else {
			System.err.println("Invalid Credentials. Please Try Again !!");
		}
	}
	
	void showUserMenu() {
		
		// ToDo: User Must Login Before to Access the Menu 
		
		System.out.println("^^^^^^^^^^^^^^^^^^^");
		System.out.println("Welcome to User App");
		System.out.println("Its: "+new Date());
		System.out.println("^^^^^^^^^^^^^^^^^^^");
		
		boolean quit = false;
		
		while(true) {
        	
        	System.out.println("1: View Routes");
        	System.out.println("2: Apply For Bus Pass");
        	System.out.println("3: My Bus Pass");
        	System.out.println("4: Request Pass Update");
        	System.out.println("5: Write Feedback");
        	System.out.println("6: My Profile");
        	System.out.println("7: Quit User App");
        	System.out.println("Select an Option");
        	
        	int choice = scanner.nextInt();
        	
        	switch (choice) {
				case 1:
					
					break;
					
				case 2:
					
					break;

				case 3:
					
					break;
					
				case 4:
					
					break;
					
				case 5:
					
					break;
					
				case 6:
					
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
	}
	
	
    public static void main( String[] args ){
    	
        App app = new App();
        app.showMainMenu();
     
    }
    
}
