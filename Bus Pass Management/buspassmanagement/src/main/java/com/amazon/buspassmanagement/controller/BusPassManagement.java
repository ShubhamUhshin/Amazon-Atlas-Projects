package com.amazon.buspassmanagement.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.db.BusPassDAO;
import com.amazon.buspassmanagement.db.FeedbacksDAO;
import com.amazon.buspassmanagement.model.BusPass;
import com.amazon.buspassmanagement.model.Feedbacks;
import com.amazon.buspassmanagement.duplicatePass;

public class BusPassManagement{

	private static BusPassManagement manageBusPass = new BusPassManagement();
	
	Scanner scanner = new Scanner(System.in);
	BusPass buspass = new BusPass();
	BusPassDAO busPassdao = new BusPassDAO();
	FeedbacksDAO feedbackdao = new FeedbacksDAO();
	
	// Singleton design pattern to create object
	public static BusPassManagement getInstance() {
		return manageBusPass;
	}

	BusPass pass = new BusPass();
	
	public void manageBusPass() {
		// Admin
		while(true) {
			try {
				System.out.println("+++++++++++++++++++++++");
				System.out.println("1: View Pass Requests");
				System.out.println("2: View Pass Request By userID");
				System.out.println("3: View Pass Request for a date range");
				System.out.println("4: View Expired Pass");
				System.out.println("5: Update Pass Request");
				System.out.println("6: Suspend Pass on Suspension Request");
				System.out.println("7: Delete Pass Request");
				System.out.println("8: Quit");
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
					viewPassRequestsForDate();
					break;
				case 4:
					viewExpiredPass();
					break;
				case 5:
					approveRejectPassRequest();
					break;
				case 6:
					busPassService();
					break;
				case 7:
					deletePass();
					break;
					
				case 8:
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
	// For creating new bus pass
	public void getDetails() {
				
		System.out.println("Capturing Bus Pass Details....");
		
		System.out.println("Enter Route ID to apply for Bus Pass:");
		buspass.routeID = scanner.nextInt();

	}
	
	// Handler for the Bus Pass :)
	public void requestPass() throws duplicatePass{
		
		getDetails();
		
		// Add the User ID Implicitly.
		pass.userID = BusPassSession.user.id;
		
		// As initially record will be inserted by User where it is a request
		pass.status = 1; // initial status as requested :)
		
		String sql = "SELECT * from BusPass where userID = "+pass.userID;
		
		List<BusPass> buspass = busPassdao.retrieve(sql);
		boolean passAvailable = false;
		for (BusPass passDetail : buspass)
			if (passDetail.routeID == pass.routeID && passDetail.status!=3) {
				passAvailable = true;
				break;
			}
		
		if (passAvailable)
			throw new duplicatePass(pass.routeID);
		else {
			int result = busPassdao.insert(pass);
			String message = (result > 0) ? "Pass Requested Successfully" : "Request for Pass Failed. Try Again.."; 
			System.out.println(message);
		}
	}
	
	// To delete a pass
	public void deletePass() {
		BusPass pass = new BusPass();
		System.out.println("Enter Pass ID to be deleted: ");
		pass.buspassID = Integer.parseInt(scanner.nextLine());
		int result = busPassdao.delete(pass);
		String message = (result > 0) ? "Pass Deleted Successfully" : "Deleting Pass Failed. Try Again.."; 
		System.out.println(message);
	}
	
	// For Admin
	public void approveRejectPassRequest() {

        System.out.println("Enter Bus Pass ID: ");
        pass.buspassID = Integer.parseInt(scanner.nextLine());//scanner.nextInt();

        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("2: Approve");
        System.out.println("3: Cancel");
        System.out.println("Enter Approval Choice: ");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        pass.status = Integer.parseInt(scanner.nextLine());//scanner.nextInt();

        // Using SimpleDateFormat for the desired format for timestamp of approvedrejected on
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // Getting current time stamp
        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();
        // formatting the current datetime into desired format
        pass.approvedRejectedOn = dateFormat.format(date1);
        // If the pass is approved, it would be valid for a year.
        if(pass.status == 2) {
        	// Getting the time stamp of currentyear+1
            calendar.add(Calendar.YEAR, 1);
            Date date2 = calendar.getTime();
            // Formatting and adding in validTill
            pass.validTill = dateFormat.format(date2);
        }else {
        	// If the pass is rejected, the validTill would be of the same day
            pass.validTill = pass.approvedRejectedOn;
        }
        // Updating the bus pass
        int result = busPassdao.update(pass);
        String message = (result > 0) ? "Pass Request Updated Successfully" : "Updating Pass Request Failed. Try Again.."; 
        System.out.println(message);
    }
	// For Admin
	public void viewPassRequests() {
		// Admin can see the pass request for all bus passes or for a specific route
		System.out.println("Enter Route ID to get All the Pass Reqeuests for a Route");
		System.out.println("Or 0 for All Bus Pass Requests");
		System.out.println("Enter Route ID: ");
		
		int routeID = Integer.parseInt(scanner.nextLine());
		
		List<BusPass> objects = null;
		// If routeID input by user is 0, displaying buspass request for all routes
		if(routeID == 0) {
			objects = busPassdao.retrieve();
		}else {
			String sql = "SELECT * from BusPass where routeID = "+routeID+" and status = "+1;
			objects = busPassdao.retrieve(sql);
		}
		
		for(BusPass object : objects) {
			object.prettyPrint();
		}
	}
	
	public void viewPassRequestsByUser(int userID) {
		
		String sql = "SELECT * from BusPass where userID = "+userID+" and status ="+1;
		List<BusPass> objects = busPassdao.retrieve(sql);
		
		for(BusPass object : objects) {
			object.prettyPrint();
		}
	}

	
	public int busPassService() {
		// Retrieve suspension request from feedbacks 
		String sql = "Select * from Feedbacks where type =" +3;
		List <Feedbacks> feedback = new ArrayList<>();
		feedback = feedbackdao.retrieve(sql);
		int month=0;
		// Displaying the requests to Admin
		feedback = feedbackdao.retrieve(sql);
		for (Feedbacks suspensionRequest : feedback) {
			suspensionRequest.prettyPrint();
		}
		// If there is any suspension request
		if (feedback.size()>0) {
			System.out.println("Enter the feedback ID of the request you want to process");
			int  id = Integer.parseInt(scanner.nextLine());
			sql = "Select * from Feedbacks where feedbackID =" +id +"and type = "+3;
			feedback = feedbackdao.retrieve(sql);
			for (Feedbacks suspensionRequest : feedback) {
				suspensionRequest.prettyPrint();
				
				// Scraping number of months the suspension is requested for
				String description = suspensionRequest.description;
				String digits = description.replaceAll("[^0-9]", "");
				month = Integer.parseInt(digits);
				suspensionRequest.type = 4;
				feedbackdao.update(suspensionRequest);
			}
			
			// Retrieving the buspass of the user
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
			// Now we have the buspass on which we have to perform suspension..
			for (BusPass buspasses : buspass) {
				if (buspasses.status != 4) {
					System.out.println("Do you want to Approve or Reject the Suspension Request?");
					System.out.println("1 for Approval /n.2 for Rejection");
					choice = Integer.parseInt(scanner.nextLine());
					
					if (choice == 1) {
						// Approve
						// dividing date into two parts, date and time.
						String date1 = buspasses.validTill.substring(0,10);
						String addOn = buspasses.validTill.substring(11,21);
						buspasses.status = 4;
	
						LocalDate date = LocalDate.parse(date1);
						// Month monthString = date.getMonth();
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
	// Pass request based on date	
	public void viewPassRequestsForDate() {
		System.out.println("Enter from date range in yyyy-MM-dd");
		String date1 = scanner.nextLine();
		
        String dateFormat = "yyyy-MM-dd"; // expected date format
        // Checking whether the date is in the correct format
        // Taking care of unwanted exception
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // enforce strict parsing
        
        try {
            Date date = sdf.parse(date1);
        } catch (Exception e) {
            System.out.println(date1 + " is not a valid date in " + dateFormat + " format.");
            return;
        }
        
        // Checking whether the date is in the correct format
        // Taking care of unwanted exception	
		System.out.println("Enter to date YYYY-MM-DD");
		String date2 = scanner.nextLine();
		
		sdf.setLenient(false); // enforce strict parsing
        
        try {
            Date date = sdf.parse(date2);
        } catch (Exception e) {
            System.out.println(date2 + " is not a valid date in " + dateFormat + " format.");
            return;
        }
        
        // Retrieving buspass which are requested after a given date
		String sql = "SELECT * from BusPass where requestedOn between '"+date1+"' and '"+date2+"' and status ="+1;
		List<BusPass> objects = null;
		objects = busPassdao.retrieve(sql);
		
		for(BusPass object : objects) {
			object.prettyPrint();
		}
	}
	
	// View expired passes
	public void viewExpiredPass() {
		Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
	    String str = formatter.format(date);
		String sql = "SELECT * from BusPass where validTill < '"+str+"'";
		List<BusPass> objects = busPassdao.retrieve(sql);
		
		for(BusPass object : objects) {
			object.prettyPrint();
		}
	}
		
}
