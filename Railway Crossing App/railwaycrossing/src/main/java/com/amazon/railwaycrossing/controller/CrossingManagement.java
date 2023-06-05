package com.amazon.railwaycrossing.controller;

import com.amazon.railwaycrossing.db.RailwayCrossingDAO;
import com.amazon.railwaycrossing.model.RailwayCrossing;

import java.util.List;
import java.util.Scanner;

public class CrossingManagement {
	
	// Singleton Design Pattern to create and call object
	private static CrossingManagement manageCrossing = new CrossingManagement();
	
	public static CrossingManagement getInstance() {
		return manageCrossing;
	}
	
	RailwayCrossingDAO railwayCrossingDAO = new RailwayCrossingDAO();
	RailwayCrossing crossing = new RailwayCrossing();
	
	Scanner scanner = new Scanner(System.in);
	
	// Adding a new Railway Crossing
	// Admin can access this
	public void addCrossing () {
		
		// Using the getDetails function in RailwayCrossing Model to get the user Details.
		crossing.getDetails(crossing);
		// Adding the Details in the Database
		if (railwayCrossingDAO.insert(crossing)>0)
			System.out.println("Crossing Added Successfully");
		else {
			System.err.println("[addCrossing] Under Maintenence Currently. Kindly wait until further notice");
		}
	}
	
	// Deleting Railway Crossing
	// Admin can delete a crossing
	public void deleteCrossing() {
		
		
		System.out.println("Enter the Crossing ID to be deleted");
		int crossingID = Integer.parseInt(scanner.nextLine());
		// Displaying all Railway Crossing
		displayCrossing();
		
		// Before Deleting Railway Crossing, delete trainSchedule of the Crossing
		// deleteSchedule(crossingID);
		
		crossing.crossingID = crossingID;
		
		if (railwayCrossingDAO.delete(crossing)> 0)
			System.out.println("Deleted crossing");
		
		else {
			System.err.println("No such Crossing");
		}
	}
	
	// For Admin to update crossing details
	public void updateCrossing() {
		
		displayCrossing();
		
		System.out.println("Enter the crossing ID to change the status");
		int id = Integer.parseInt (scanner.nextLine());
		
		String sql = "Select * from RailwayCrossing where id = "+id;
		
		List<RailwayCrossing> crossing = railwayCrossingDAO.retrieve(sql);
		
		if (!crossing.isEmpty()) {
			this.crossing.getDetails(crossing.get(0));
			if (railwayCrossingDAO.update(crossing.get(0)) > 0)
				System.out.println("Updated");
			else {
				System.err.println("Error while updating");
			}
		}	
	}
	
	// For Admin to update Status of a crossing
	public void updateCrossingStatus() {
		displayCrossing();
		
		System.out.println("Enter the crossing ID to change the status");
		int id = Integer.parseInt (scanner.nextLine());
		
		String sql = "Select * from RailwayCrossing where crossingID = "+id;
		
		List<RailwayCrossing> crossing = railwayCrossingDAO.retrieve(sql);
		
		if (!crossing.isEmpty()) {
			System.out.println("Current Status = "+crossing.get(0).status);
			System.out.println("Change Status? Y/N?");
			char choice = scanner.next().charAt(1);
			if (choice == 'Y' || choice == 'y') {
				crossing.get(0).status = (crossing.get(0).status == 0) ? 1 : 0;
				if (railwayCrossingDAO.update(crossing.get(0))>0)
					System.out.println("Updated");
				else {
					System.err.println("Error while updating Crossing");
				}
			}
		}
	}
	
	// For Admin, User and Guest
	public void searchCrossing() {
		System.out.println("Enter the Crossing ID or name to be Searched");
		String input = scanner.nextLine();
		String sql;
		if (Character.isDigit(input.charAt(0))) {
			sql = "Select * from RailwayCrossing where crossingID ="+input.charAt(0);
			}
		
		else {
			sql = "Select * from RailwayCrossing where name = '"+input+"'";
		}
		
		List <RailwayCrossing> crossing = railwayCrossingDAO.retrieve(sql);
		
		System.out.println("ID \t Name \t Status \t Person In Charge \t Address");
		for (RailwayCrossing crossingDetail : crossing) {
			this.crossing.displayCrossingDetails(crossingDetail);			
		}
	}
	
	// For User
	// Displaying Crossing
	public void displayCrossing() {
		
		List<RailwayCrossing> crossings = railwayCrossingDAO.retrieve();
		
		System.out.println("ID \t Name \t Status \t Person In Charge \t Address");
		for (RailwayCrossing crossing : crossings) {
			crossing.displayCrossingDetails(crossing);
		}
	}
	
	// For User and Guest
	// Display Status based on the crossing ID
	public void displayStatus() {
		
		System.out.println("1. For all Crossings");
		System.out.println("2. For Specific Crossing");
		int choice = Integer.parseInt(scanner.nextLine());
		if (choice == 1) {
			
			String sql = "Select * from RailwayCrossing";
			
			List <RailwayCrossing> crossing = railwayCrossingDAO.retrieve(sql);
			
			if (!crossing.isEmpty()) {
				System.out.println("CrossingID \t Status");
				for (RailwayCrossing crossingDetail : crossing)
					System.out.println(crossingDetail.crossingID+" \t "+crossingDetail.status);
			}
		}
			
		else {
			
			System.out.println("Enter crossing ID to check status");
			int id = Integer.parseInt(scanner.nextLine());
			
			String sql = "Select * from RailwayCrossing where crossingID = "+id;
			
			List <RailwayCrossing> crossing = railwayCrossingDAO.retrieve(sql);
			
			if (!crossing.isEmpty()) {
				System.out.println(crossing.get(0).status);
			}	
		}	
	}
	
	// For User
	// To display the crossings based on time.
	public void displayCrossingBasedOnTime() {
		
	}
}
