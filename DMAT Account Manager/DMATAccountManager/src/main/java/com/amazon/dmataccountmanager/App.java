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
        
        if(args.length > 0) {
        	DB.FILEPATH = args[0];
        }
        
        new Menu().showMainMenu();
    }
}
