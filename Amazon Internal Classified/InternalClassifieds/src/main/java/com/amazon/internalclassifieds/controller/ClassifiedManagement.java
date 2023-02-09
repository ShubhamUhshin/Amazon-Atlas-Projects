package com.amazon.internalclassifieds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazon.internalclassifieds.userSession;
import com.amazon.internalclassifieds.db.CategoryDAO;
import com.amazon.internalclassifieds.db.ClassifiedDAO;
import com.amazon.internalclassifieds.model.Categories;
import com.amazon.internalclassifieds.model.Classifieds;

public class ClassifiedManagement {
	
	private static ClassifiedManagement manageClassified = new ClassifiedManagement();
	
	public static ClassifiedManagement getInstance() {
		return manageClassified;
	}
	
	ClassifiedDAO classifieddao = new ClassifiedDAO();
	Classifieds classified = new Classifieds();
	
	CategoryDAO categorydao = new CategoryDAO();
	
	CategoryManagement manageCategory = CategoryManagement.getInstance();
	Categories categories = new Categories();
	
	Scanner scanner = new Scanner(System.in);
	
	// For Admin
	public boolean approvalOfClassified() {

		// Retrieve all classifieds which are in pending state
        List <Classifieds> classifieds = new ArrayList<Classifieds>();
        String sql = "Select * from Classifieds where status = " +2;
        classifieds = classifieddao.retrieve(sql);
        
        // Display all the Classifieds that are in pending state
        for (Classifieds classifiedDetails : classifieds) {
            classified.prettyPrintForAdmin(classifiedDetails);
        }
        
        // Asking for the Classified ID to be deleted
        System.out.println("Enter the Classified ID to Activate/Deactivate: ");
        int classifiedID = Integer.parseInt(scanner.nextLine());

        // Retrieving the particular Classified
        sql = "Select * From Classifieds Where classifiedID = "+classifiedID;
        List <Classifieds> classifiedtoActivate = new ArrayList<Classifieds>();
        classifiedtoActivate = classifieddao.retrieve(sql);
        
        classified = classifiedtoActivate.get(0);

        // Ask the Admin for Approval or Rejection
        System.out.println("\n 1-Approve \n 0-Reject");
        int status = Integer.parseInt(scanner.nextLine());
        
        // Change the status of the Classified
        classified.status=(status==1) ? 1 : 0;

        // Update the Classified
        if(classifieddao.update(classified)>0)
            return true;
        else
            return false;
    }
	
	// For Admin
	public boolean removeClassified() {
		
		System.out.println("Do you want to remove all rejected classified or a particular classified");
		System.out.println("1. for All Rejected Classifieds");
		System.out.println("2. for a particular Classified");
		int choice = Integer.parseInt(scanner.nextLine());
		
		boolean deletion = true;
		
		// Delete all Rejected Classifieds
		if (choice == 1) {
			
			// Retrieve the classified which has been rejected.
			List<Classifieds> classified = new ArrayList<Classifieds>();
			String sql = "Select * from Clssifieds where status = " +0;
			classified = classifieddao.retrieve(sql);
			
			// Remove all rejected Classifieds one by one
			for (Classifieds classifiedToBeDeleted : classified)
				if (classifieddao.delete(classifiedToBeDeleted)<=0)
					deletion = false;
		}
		
		// Delete a particular Classified
		else  if (choice == 2) {
			
			List<Classifieds> classified = new ArrayList<Classifieds>();
			classified = classifieddao.retrieve();
			// Display each classified
			for (Classifieds classifiedInfo : classified)
				classifiedInfo.prettyPrintForAdmin(classifiedInfo);
			
			// Input the Classified ID to be deleted
			System.out.println("Enter the Classified ID you want to delete");
			int classifiedID = Integer.parseInt(scanner.nextLine());
			
			// Retrieve the Classified to be deleted
			String sql = "Select * from Clssifieds where classifiedID = " +classifiedID;
			List<Classifieds> classifieds = new ArrayList<Classifieds>();
			classifieds = classifieddao.retrieve(sql);
			
			// Remove the Classifieds
			if (classifieddao.delete(classifieds.get(0))<=0)
				deletion = false;
		}
		
		return deletion;
		
	}
	
	// For User
	public boolean update() {
	
		// Retrieving all the classified from a certain user
		String sql = "SELECT * from Classifieds where userID = "+userSession.user.userID;
		List<Classifieds> classifiedList = classifieddao.retrieve(sql);
		// Display the classifieds using pretty print
		for (Classifieds classified : classifiedList)
			classified.prettyPrintForUser(classified);
		
		// Ask the user for the classified he wants to update
		System.out.println("Enter the Classified ID");
		int classifiedID = Integer.parseInt(scanner.nextLine());
		
		// Fetch the classified based on the classified ID
		sql = "Select * from Classifieds where classifiedID = " +classifiedID;
		List <Classifieds> classifiedDetail = classifieddao.retrieve(sql);
		
		if (classifiedDetail.get(0).status == 3) {
			System.err.println("You can't modify a Classified already Sold");
			return false;
		}
		//Ask the user to update the details
		classified.getDetails(classifiedDetail.get(0));
		
		//Update the details in SQL.
		if (classifieddao.update(classifiedDetail.get(0))>0)
			return true;
		
		return false;
	}
	
	// For User.
	// User can see all the classified which have been approved and is available for transaction
	public void displayClassified() {
		
		//Fetch User Detail
		String sql = "Select * from Classifieds where status= "+1;
		List <Classifieds> classifiedList = classifieddao.retrieve(sql);
		
		//Display the Details
		for (Classifieds classified : classifiedList) {
			classified.prettyPrintForUser(classified);
		}
	}
	
	// Display User's Classified
	public void displayUserClassified() {
		String sql = "Select * from Classifieds where userID= "+userSession.user.userID;
		List <Classifieds> classifiedList = classifieddao.retrieve(sql);
		
		//Display the Details
		for (Classifieds classified : classifiedList) {
			classified.prettyPrintForUser(classified);
		}
	}
	
	// For both Admin and User
	public boolean postClassified() {
		
		// Getting the user ID of current user
		classified.userID = userSession.user.userID;
		
		UserManagement manageUser = UserManagement.getInstance();
		
		// Check if the user is active or not.
		// Only Active Users can post a classified. 
		if (manageUser.checkUserStatus()) {
		
		// Asking the user to add the classified details
			classified.getDetails(classified);
			
			//-----------------------------------------------------------------------
			
     		List<Categories> categories = new ArrayList<Categories>();
     		categories = categorydao.retrieve();
     		
     		for (Categories displayCategory : categories) {
     			System.out.print("{ ");
     			System.out.print(displayCategory.categoryID+":"+displayCategory.title);
     			System.out.println(" }");
     		}
			
     		System.out.println("Enter the CategoryID for your Product: ");
    		String categoryID = scanner.nextLine();
    		if (!categoryID.isEmpty())
    			classified.categoryID = Integer.parseInt(categoryID);
    		
    		//-----------------------------------------------------------------------
			// Adding the classified to table
			if (classifieddao.insert(classified)>0)
				return true;
			else 
				return false;	
		}
		else {
			System.out.println("You can't post a classified as you're not Active");
			return false;
		}	
	}
	
	// To set the price of apartment to 20000
	public void setPrice() {
		
		// Setting up price for houses for rent
		// Retrieving classifieds which are houses
		String sql = "select * from classifieds where productName LIKE '%House%' OR productName LIKE '%Apartment%' OR headline LIKE '%House%' OR headline LIKE '%Apartment%' OR description LIKE '%House for rent%' OR description LIKE '%Apartment for rent%'";
		List <Classifieds> classifiedList = new ArrayList<Classifieds>();
		classifiedList = classifieddao.retrieve(sql);
		
		// Change the price of each house to 20000
		for (Classifieds classified : classifiedList) {
			classified.price = 20000;
			classifieddao.update(classified);
		}
	}
}
