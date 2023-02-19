package com.amazon.buspassmanagement.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.model.BusPass;
import com.amazon.buspassmanagement.model.Feedbacks;

public class BusPassManagement extends Management{

	private static BusPassManagement manageBusPass = new BusPassManagement();
	
	public static BusPassManagement getInstance() {
		return manageBusPass;
	}

	Scanner scanner = new Scanner (System.in);
	BusPass pass = new BusPass();
	public void manageBusPass() {
		//Admin
		while(true) {
			try {
				System.out.println("+++++++++++++++++++++++");
				System.out.println("1: View Pass Requests");
				System.out.println("2: View Pass Request By userID");
				System.out.println("3: Update Pass Request");
				System.out.println("4: Suspend Pass on Suspension Request");
				System.out.println("5: Delete Pass Request");
				System.out.println("6: Quit");
				System.out.println("Enter Your Choice: ");
				int passChoice = Integer.parseInt(scanner.nextLine());
	
				boolean quit = false;
				switch(passChoice) {
				case 1:
					viewPassRequests();
					break;
					
				case 2:
					
					System.out.println("Enter User ID: ");
					int userID = Integer.parseInt(scanner.nextLine());
					viewPassRequestsByUser(userID);
					break;
					
				case 3:
					approveRejectPassRequest();
					break;
	
				case 4:
					busPassService();
					break;
				case 5:
					deletePass();
					break;
					
				case 6:
					quit = true;
					break;
					
				default:
					System.err.println("Invalid choice");
				}
				
				if (quit)
					break;
			}
			catch (Exception e) {
				System.err.println("Invalid Input"+e);
			}
		} 	
	}
	
	public void getDetails() {
				
		System.out.println("Capturing Bus Pass Details....");
		
		System.out.println("Enter Route ID to apply for Bus Pass:");
		buspass.routeID = scanner.nextInt();

	}
	
	// Handler for the Bus Pass :)
		public void requestPass() {
			getDetails();
			
			// Add the User ID Implicitly.
			pass.userID = BusPassSession.user.id;
			
			// As initially record will be inserted by User where it is a request
			pass.status = 1; // initial status as requested :)
			
			int result = busPassdao.insert(pass);
			String message = (result > 0) ? "Pass Requested Successfully" : "Request for Pass Failed. Try Again.."; 
			System.out.println(message);
		}
		
		public void deletePass() {
			BusPass pass = new BusPass();
			System.out.println("Enter Pass ID to be deleted: ");
			pass.buspassID = Integer.parseInt(scanner.nextLine());
			int result = busPassdao.delete(pass);
			String message = (result > 0) ? "Pass Deleted Successfully" : "Deleting Pass Failed. Try Again.."; 
			System.out.println(message);
		}
		
		public void approveRejectPassRequest() {

	        System.out.println("Enter Bus Pass ID: ");
	        pass.buspassID = Integer.parseInt(scanner.nextLine());//scanner.nextInt();

	        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	        System.out.println("2: Approve");
	        System.out.println("3: Cancel");
	        System.out.println("Enter Approval Choice: ");
	        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	        pass.status = Integer.parseInt(scanner.nextLine());//scanner.nextInt();

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	        Calendar calendar = Calendar.getInstance();
	        Date date1 = calendar.getTime();
	        pass.approvedRejectedOn = dateFormat.format(date1);

	        if(pass.status == 2) {
	            calendar.add(Calendar.YEAR, 1);
	            Date date2 = calendar.getTime();
	            pass.validTill = dateFormat.format(date2);
	        }else {
	            pass.validTill = pass.approvedRejectedOn;
	        }

	        int result = busPassdao.update(pass);
	        String message = (result > 0) ? "Pass Request Updated Successfully" : "Updating Pass Request Failed. Try Again.."; 
	        System.out.println(message);
	    }
		
		public void viewPassRequests() {
			
			System.out.println("Enter Route ID to get All the Pass Reqeuests for a Route");
			System.out.println("Or 0 for All Bus Pass Requests");
			System.out.println("Enter Route ID: ");
			
			int routeID = Integer.parseInt(scanner.nextLine());
			
			List<BusPass> objects = null;
			
			if(routeID == 0) {
				objects = busPassdao.retrieve();
			}else {
				String sql = "SELECT * from BusPass where routeID = "+routeID;
				objects = busPassdao.retrieve(sql);
			}
			
			for(BusPass object : objects) {
				object.prettyPrint();
			}
		}
		
		public void viewPassRequestsByUser(int userID) {
			
			String sql = "SELECT * from BusPass where userID = "+userID;
			List<BusPass> objects = busPassdao.retrieve(sql);
			
			for(BusPass object : objects) {
				object.prettyPrint();
			}
		}

		
		public int busPassService() {
			//Retrieve suspension request from feedbacks 
			String sql = "Select * from Feedbacks where type =" +3;
			List <Feedbacks> feedback = new ArrayList<>();
			feedback = feedbackdao.retrieve(sql);
			int month=0;
			//Displaying the reuests to Admin
			feedback = feedbackdao.retrieve(sql);
			for (Feedbacks suspensionRequest : feedback) {
				suspensionRequest.prettyPrint();
			}
			if (feedback.size()>0) {
				System.out.println("Enter the feedback ID of the request you want to process");
				int  id = Integer.parseInt(scanner.nextLine());
				sql = "Select * from Feedbacks where feedbackID =" +id +"and type = "+3;
				feedback = feedbackdao.retrieve(sql);
				for (Feedbacks suspensionRequest : feedback) {
					suspensionRequest.prettyPrint();
					String description = suspensionRequest.description;
					String digits = description.replaceAll("[^0-9]", "");
					month = Integer.parseInt(digits);
					suspensionRequest.type = 4;
					feedbackdao.update(suspensionRequest);
				}
				
				System.out.println("Enter the UserID of the suspension request you want to modify:");
				int choice = Integer.parseInt(scanner.nextLine());
				
				sql = "Select * from BusPass where userID =" +choice;
				List <BusPass> buspass = new ArrayList<>();
				buspass = busPassdao.retrieve(sql);
				for (BusPass buspasses : buspass) {
					buspasses.prettyPrint();
				}
				// If a particular user has multiple buspasses, we ask for the buspass id to be modified.
				System.out.println("Enter the BusPassID of the suspension request you want to modify:");
				choice = Integer.parseInt(scanner.nextLine());
				sql = "Select * from BusPass where buspassID =" +choice;
				
				buspass = busPassdao.retrieve(sql);
				//Now we have the buspass on which we have to perform suspension..
				for (BusPass buspasses : buspass) {
					if (buspasses.status != 4) {
						System.out.println("Do you want to Approve or Reject the Suspension Request?");
						System.out.println("1 for Approval /n.2 for Rejection");
						choice = Integer.parseInt(scanner.nextLine());
						
						if (choice == 1) {
							//Approve
							String date1 = buspasses.validTill.substring(0,10);
							String addOn = buspasses.validTill.substring(11,21);
							buspasses.status = 4;
							LocalDate date = LocalDate.parse(date1);
							//Month monthString = date.getMonth();
							date = date.plusMonths(month);
							
							buspasses.validTill = date.toString()+" " +addOn;
							
							busPassdao.update(buspasses);
							System.out.println("Approved");
						}	
					
						else if (choice == 2) {
							break;
						}
					}
					
					else
						System.out.println("Already suspended");
				}
			}
			else 
				System.out.println("No Suspension Requests");
			return 0;
		}
		
		
}
