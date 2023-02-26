package com.amazon.buspassmanagementDebug;

import com.amazon.buspassmanagementDebug.controller.AuthenticationService;
import com.amazon.buspassmanagementDebug.db.DB;

public class App {
	
    public static void main( String[] args ){
       
    	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println( "Welcome to Bus Pass Management Application" );
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    	
    	Menu menu = new Menu();
        //Menu menu = null;
        
        if(args.length > 0) {
        DB.FILEPATH = args[0];
        }
        // AuthenticationService.getInstance();
        menu.showMainMenu();
		
    }
    
}
