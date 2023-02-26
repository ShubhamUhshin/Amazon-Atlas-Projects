package com.amazon.buspassmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.db.FeedbacksDAO;
import com.amazon.buspassmanagement.model.Feedbacks;


public class FeedbacksManagement {

	Scanner scanner = new Scanner(System.in);
	Feedbacks feedbacks = new Feedbacks();
	FeedbacksDAO feedbackdao = new FeedbacksDAO();
	
	private FeedbacksManagement() {
	}
	
	// Create it as a Singleton 
		private static FeedbacksManagement manageFeedbacks = new FeedbacksManagement();
		
		public static FeedbacksManagement getInstance() {
			return manageFeedbacks;
		}
		
		public void manageFeedback() {
			
			while(true) {
				try {
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("1: View Feedbacks");
					System.out.println("2: View Feedbacks by User");
					System.out.println("3: Delete Feedbacks");
					System.out.println("4: Quit Managing Feedbacks");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("Enter Your Choice: ");
					int choice = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
					boolean quit = false;
					switch(choice) {
					case 1:
						viewFeedbacks();
						break;
					case 2:
						System.out.println("Enter User ID: ");
						int userID = Integer.parseInt(scanner.nextLine());//scanner.nexInt();
						viewFeedbacksByUser(userID);
						break;
					case 3:
						deleteFeedback();
						break;
					case 4:
						// if Admin wants to quit
						quit = true;
						break;
						
					default:
						System.err.println("Invalid Choice");
					}
					// using admin choice to terminate infinite loop
					if(quit)
						break;
				}
				catch (Exception e) {
					System.err.println("Invalid Input"+e);
				}
			} 	
		}
		
		// Getting Feedback details
		// For User
		public void getDetails() {
			
			System.out.println("Capturing Feedback Details....");
			
			System.out.println("1: Suggestion");
			System.out.println("2: Complaint");
			System.out.println("3: BusPass Suspension");
			System.out.println("Select Type of Feedback:");
			feedbacks.type = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
			
			if(feedbacks.type == 1) {
				feedbacks.title = "Suggestion";
			}else if(feedbacks.type == 2) {
				feedbacks.title = "Complaint";
			}else if(feedbacks.type == 3) {
				feedbacks.title = "BusPass Suspension";
			}else {
				feedbacks.title = "";
			}
			
			System.out.println("Enter Description:");
			String description = scanner.nextLine();
			
			if (description.isBlank() || description.isEmpty()) {
				feedbacks.description = "Suspend pass for 0 months";
			}
			else {
				feedbacks.description = description;
			}

		}
		// Handler for the Feedback
		// For user
		public void createFeedback() {
			
			getDetails();
			
			// Add the User ID Implicitly.
			feedbacks.userID = BusPassSession.user.id;
			feedbacks.raisedBy = BusPassSession.user.email;
			
			int result = feedbackdao.insert(feedbacks);
			String message = (result > 0) ? "Feedback Created Successfully" : "Creating Feedback Failed. Try Again.."; 
			System.out.println(message);
		}
		
		// For Admin
		public void deleteFeedback() {
			
			// Display feedback
			viewFeedbacks();
			
			// Deleting feedback based on feedback ID
			System.out.println("Enter Feedback ID to be deleted: ");
			feedbacks.feedbackID = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
			int result = feedbackdao.delete(feedbacks);
			String message = (result > 0) ? "Feedback Deleted Successfully" : "Deleting Feedback Failed. Try Again.."; 
			System.out.println(message);
		}
		
		// Display all Feedbacks
		// For Admin
		public void viewFeedbacks() {
			List<Feedbacks> feedbacks = feedbackdao.retrieve();
			for(Feedbacks object : feedbacks) {
				object.prettyPrint();
			}
		}
		
		// Display feedbacks of a specific user
		// For Admin
		public void viewFeedbacksByUser(int userID) {
			
			String sql = "SELECT * from Feedbacks where userID = "+userID;
			
			List<Feedbacks> feedbacks = feedbackdao.retrieve(sql);
			
			for(Feedbacks object : feedbacks) {
				object.prettyPrint();
			}
		}
}
