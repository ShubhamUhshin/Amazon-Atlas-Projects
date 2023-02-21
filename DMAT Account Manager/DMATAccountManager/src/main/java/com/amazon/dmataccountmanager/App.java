package com.amazon.dmataccountmanager;

import com.amazon.dmataccountmanager.db.DB;

public class App 
{
	private App(){
	}
	
    public static void main(String[] args) {
    	
        System.out.println("---------------------------------");
        System.out.println( "Welcome to DMAT Account Manager" );
        System.out.println("---------------------------------");
        
     // Checking if there is any filepath for database attributes
        if(args.length > 0) {
        	DB.FILEPATH = args[0];
        }
        
        // Displaying Main Menu
        new Menu().showMainMenu();
    }
}
