package com.amazon.railwaycrossing;

public class userMenu extends Menu{
	
	private static userMenu userMenu = new userMenu();
	
	public static userMenu getInstance() {
		return userMenu;
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
				System.out.println("5. QUIT");
				
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
