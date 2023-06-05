package com.amazon.railwaycrossing;

public class guestMenu extends Menu {
	
	private static guestMenu guestMenu= new guestMenu();
	
	public static guestMenu getInstance() {
		return guestMenu;
	}
	
	public void showMenu() {
		boolean quit = false;
		
		while (true) {
			try {
				
				System.out.println("------------------------------------");
				System.out.println("1. Display Railway Crossing");
				System.out.println("2. Display Crossing Status");
				System.out.println("3. Search Railway Crossing");
				System.out.println("4. Sort Crossing");
				System.out.println("5. Register or Login");
				System.out.println("6. QUIT");
				
				int choice = Integer.parseInt(scanner.nextLine());
				
				System.out.println("------------------------------------");
				
				switch (choice) {
				
				case 1:
					// Add Railway crossing function
					break;
					
				case 2:
					// Delete Railway Crossing Function
					break;
					
				case 3:
					// Search Railway Crossing Function
					break;
					
				case 4:
					// Update Status of Railway Crossing
				
				case 5:
					System.out.println("1. Register");
					System.out.println("2. Login");
					int choice1 = Integer.parseInt(scanner.nextLine());
					boolean result;
					switch (choice1) {
					
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
						
						break;
						
					default:
						System.out.println("Invalid Choice");
					}
				case 6:
					quit = true;
					break;
					
				default:
					System.out.println("Sach me andha hai kya?");
					
				}
			
			if (quit)
				break;
			}
			catch (Exception e) {
				System.err.println("Server under Maintenence");
			}
			
		}
		
	}

}
