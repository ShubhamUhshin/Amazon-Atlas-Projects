package com.amazon.buspassmanagement;

public class MenuFactory {

	public static Menu getMenu(int type) {
		// If the choice is 1, Admin menu object is returned
		if(type == 1) {
			return AdminMenu.getInstance();
		}
		// If the choice is 2, User menu object is returned
		else if (type == 2) {
			return UserMenu.getInstance();
		}
			
		return null;
	}
		
}
