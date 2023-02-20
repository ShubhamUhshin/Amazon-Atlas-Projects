package com.amazon.internalclassifieds;

//import com.amazon.internalclassifieds.controller.UserManagement;
import com.amazon.internalclassifieds.db.DB;

public class App 
{
	
    public static void main( String[] args )
    {
    	
    	 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println( "Welcome to Amazon Internal Classified Application" );
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         
        //DB db = DB.getInstance();
        //UserManagement manageUser = UserManagement.getInstance();
         
         // Checking if there is any filepath for database attributes
         if(args.length > 0) {
         	DB.FILEPATH = args[0];
         }

         //Displaying Main Menu
         new Menu().showMainMenu();
        //db.closeConnection();
    }
}
