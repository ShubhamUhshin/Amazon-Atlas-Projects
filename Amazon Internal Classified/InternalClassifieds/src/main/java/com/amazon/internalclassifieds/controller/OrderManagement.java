package com.amazon.internalclassifieds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazon.internalclassifieds.userSession;
import com.amazon.internalclassifieds.db.ClassifiedDAO;
import com.amazon.internalclassifieds.db.OrderDAO;
import com.amazon.internalclassifieds.model.Classifieds;
import com.amazon.internalclassifieds.model.Orders;

public class OrderManagement {
	
	// Creating object using Singleton design pattern
	private static OrderManagement manageOrder = new OrderManagement();
	public static OrderManagement getInstance() {
		return manageOrder;
	}
	
	ClassifiedManagement manageClassified = ClassifiedManagement.getInstance();

	ClassifiedDAO classifieddao = new ClassifiedDAO();
	Classifieds classified = new Classifieds();
	
	OrderDAO orderdao = new OrderDAO();
	Orders order = new Orders();
	
	Scanner scanner = new Scanner(System.in);
	
	// For User
	public boolean transaction() {
		
		// Ask the user for payment confirmation
		System.out.println("Confirm Payment? 1. Yes \t 2. No");
		int choice  = Integer.parseInt(scanner.nextLine());
		
		if (choice == 1)
			return true;
		
		else if (choice == 2)
			return false;
		
		else
			System.err.println("Invalid Input");
		
		return false;
		
	}
	
	// For User
	public boolean buyClassified() {
		
		// Set the price for Apartment
		manageClassified.setPrice();
		
		// Retrieve the Classifieds which are available for sale
		List<Classifieds> classifiedDetail = new ArrayList<Classifieds>();
		String sql = "SELECT * from Classifieds where status = " +1;
		classifiedDetail = classifieddao.retrieve(sql);
		if (!classifiedDetail.isEmpty()) {
			// Display the Classifieds available to be bought.
			for (Classifieds classified : classifiedDetail) {
				classified.prettyPrintForUser(classified);
			}
			
			// Input the classifiedID of the classified the user wants to buy
			System.out.println("Enter the Classified ID you want to buy");
			int classifiedID = Integer.parseInt(scanner.nextLine());
			sql = "SELECT * fROM Classifieds WHERE classifiedID ="+classifiedID;
			
			// Retrieve the Classified detail user wants to buy
			classifiedDetail.clear();
			classifiedDetail = classifieddao.retrieve(sql);
			
			if (!classifiedDetail.isEmpty()) {
				// Confirmation on whether user wants to buy or not
				System.out.println("Do you want to buy this Classified?");
				System.out.println("1. for Yes \t 2. for No");
				int choice = Integer.parseInt(scanner.nextLine());
				
				// If user selected to buy
				if (choice == 1) {
					if (transaction()) {
						System.out.println("Congratulations on your new Purchase Respected "+userSession.user.name);
						
						// Adding the transaction in Order Table
						order.classifiedID = classifiedDetail.get(0).classifiedID;
						order.fromUserID = classifiedDetail.get(0).userID;
						order.proposedPrice = classifiedDetail.get(0).price;
						order.toUserID = userSession.user.userID;
						order.status = 1;
						orderdao.insert(order);
						
						// Changing the product status in Classified table
						classifiedDetail.get(0).status = 3;
						classifieddao.update(classifiedDetail.get(0));
							
						return true;
							
					}
					
					else {
						System.out.println("Transaction Declined by user");
						return false;
					}
				}
				
				else {
					System.out.println("Purchase Declined by user");
					return false;
				}
			}
			else {
				System.err.println("No Classified with that ID");
				return false;
			}
		}
		else {
			System.out.println("No Classifeid currently available to buy");
			return false;
		}
		
	}
	
	// Order summary
	public void orderReport() {
		
		// Retrieve the order
		List<Orders> orderList = new ArrayList<Orders>();
		orderList = orderdao.retrieve();
		
		// Display each order
		for (Orders orderDetail : orderList)
			orderDetail.prettyPrint(orderDetail);
	}
}
