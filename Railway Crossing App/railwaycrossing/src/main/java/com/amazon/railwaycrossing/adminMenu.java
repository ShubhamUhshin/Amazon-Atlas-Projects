package com.amazon.railwaycrossing;

public class adminMenu extends Menu {
	
	private static adminMenu adminMenu = new adminMenu();
	
	public static adminMenu getInstance() {
		return adminMenu;
	}
	
	public void showMenu() {
		boolean quit = false;
		
		while (true) {
			try {
				
				System.out.println("------------------------------------");
				System.out.println("1. Add Railway Crossing");
				System.out.println("2. Delete Railway Crossing");
				System.out.println("3. Search Railway Crossing");
				System.out.println("4. Update Railway Crossing Status");
				System.out.println("5. LogOut");
				
				int choice = Integer.parseInt(scanner.nextLine());
				
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
