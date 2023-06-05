package com.amazon.railwaycrossing;

public class menuFactory {
	
	public static Menu showMenu (int userType) {
		
		if (userType == 1)
			return adminMenu.getInstance();
		
		else if (userType == 2)
			return userMenu.getInstance();
		
		else
			return null;
	}
}
