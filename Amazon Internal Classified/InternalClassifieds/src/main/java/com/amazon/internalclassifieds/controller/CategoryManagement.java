package com.amazon.internalclassifieds.controller;

import java.util.List;
import java.util.Scanner;


import com.amazon.internalclassifieds.db.CategoryDAO;
import com.amazon.internalclassifieds.model.Categories;


public class CategoryManagement {
	
	Scanner scanner = new Scanner(System.in);
	Categories category = new Categories();
	CategoryDAO categorydao = new CategoryDAO();
	
	// Creating object using Singleton design pattern
	private static CategoryManagement manageCategories = new CategoryManagement();
	public static CategoryManagement getInstance() {
		return manageCategories;
	}
	
	private CategoryManagement() {
	}
	
	//For Admin
	public void manageCategory() {
		
		while(true) {
			// For incorrect input, try will avoid the control from going back to main menu
			try {
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("1: List all Classifieds Categories available");
				System.out.println("2: Add a new Classified Category");
				System.out.println("3: Update title of an existing Classified Category");
				System.out.println("4: Delete an existing Classified Category");
				System.out.println("5: Quit Managing Classified Categories");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("Enter Your Choice: ");
				int choice = Integer.parseInt(scanner.nextLine());
				// using a boolean variable to terminate the infinite loop
				boolean quit = false;
				// Calling the respective function based on the user choice
				switch(choice) {
				case 1:
					displayCategory();
					break;
					
				case 2:
					addCategory(category);
					break;
					
				case 3:
					updateCategory();
					break;
					
				case 4:
					deleteCategory(category);
					break;
					
				case 5:
					// Changing the value of quit to true when the Admin wants to quit
					quit = true;
					break;
					
				default:
					
				}
				
				// If the user has selected 5, i.e. Quit, terminating the infinite loop
				if (quit)
					break;
			} catch (Exception e) {
				System.err.println("Invalid Input"+e);
			}
		}
	}
	
	//For Admin/User
	public void displayCategory() {

        //Fetch Categories Detail
        List <Categories> categoryDetail = categorydao.retrieve();

        //Display the Details
        for (Categories categories : categoryDetail) {
        	category.prettyPrint(categories);
		}
    }
	

	//For Admin
	public boolean addCategory(Categories category) {
		
		// Add Details
		category.getDetails(category);
		
		//Insert the added data in database
		if (categorydao.insert(category)>0) {
			System.out.println("Classified Category Added Successfully.");
			return true;
		}
		else {
			System.out.println("Classified Category Insertion Failed...");
			return false;
		}
	}
		
	//For Admin
	private boolean deleteCategory(Categories category) {
		
		// Displaying the category details
		displayCategory();
		
		// Enter the category title you want to delete
		System.out.println("Enter the category title to be deleted");
		category.title = scanner.nextLine();

		// Deleting the Category based on the title
		if (categorydao.delete(category)>0) {
			System.out.println("Classified Category Deleted Successfully.");
			return true;
		}
		else {
			System.out.println("Classified Category Deletion Failed...");
			return false;
		}
	}
	
	
	//For Admin
	private boolean updateCategory() {
		
		// Enter the category title to be updated
		String title = "";
		System.out.println("Enter the Classified Category title for which you want to update the title: ");
		title = scanner.nextLine();
		
        // Fetch Category Detail
        String sql = "Select * from Category where title= '"+title+"'";
        List <Categories> categoryDetail = categorydao.retrieve(sql);

        // Ask the user to update the details
        category.getDetails(categoryDetail.get(0));

        // Update the details in SQL.
        if (categorydao.update(categoryDetail.get(0))>0) {
        	System.out.println("Classified Category Updated Successfully");
        	return true;
        }
        else {
			System.err.println("Classified Category Update Failed...");
			return false;
		}
    }
	
}
