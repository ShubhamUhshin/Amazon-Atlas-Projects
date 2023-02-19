package com.amazon.buspassmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.model.Routes;
import com.amazon.buspassmanagement.model.Stops;

public class StopsManagement extends Management{
	
	private static StopsManagement manageStops = new StopsManagement();
	
	public static StopsManagement getInstance() {
		return manageStops;
	}
	
	public void manageStops() {
		
		while(true) {
			try {
				System.out.println("+++++++++++++++++++++++");
				System.out.println("1. Create Stops");
				System.out.println("2. Retrieve Stops");
				System.out.println("3. Update a Stop");
				System.out.println("4. Remove a Stop");
				System.out.println("5. QUIT");
				System.out.println("Enter your choice :");
				int ch = Integer.parseInt(scanner.nextLine());
				boolean quit = false;
				switch(ch) {
				case 1:
					addStop();
					break;
					
				case 2:
					displayStops();
					break;
					
				case 3:
					updateStops();
					System.out.println("Stops updated");
					break;
	
				case 4:
					if (deleteStop())
						System.out.println("Deleted Stops");
					else
						System.err.println("Something went wrong");
					break;
					
				case 5:
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
	
	public void addStop() {
		int sequence = 0;
		int choice = 1;
		System.out.println("Enter routeID");
		stops.routeID = Integer.parseInt(scanner.nextLine());
		stops.adminID = BusPassSession.user.id;
		String sql = "SELECT * from Stops where routeID ="+stops.routeID;
		if (stopsdao.retrieve(sql).isEmpty())
		{
			while(true) {
				if (choice == 2)
					break;
				System.out.println("Enter Stop Address :");
				stops.address = scanner.nextLine();
				//scanner.nextLine();
				sequence++;
				stops.sequenceOrder = sequence;
				try {
					stopsdao.insert(stops);
					
				} catch (Exception e) {
					System.err.println("Something went Wrong"+e);
				}
			
				System.out.println("Do you wish to add more stops? /n 1.Yes 2. No");
				choice  = Integer.parseInt(scanner.nextLine());
				//scanner.nextLine();			
			}
		}
		
		else {
			System.out.println("We already have stops for this route");
			System.out.println("Do you want to update it:");
			System.out.println("1. for Yes 2. for NO");
			int ch = Integer.parseInt(scanner.nextLine());
			if (ch == 1)
				updateStops();
			else {
				System.err.println("Stops already added for this Route..");
			}
		}
	}
	
	public void insertStop(Stops stops) {
		int sequence = 0;
		int choice = 0;
		while(true) {
	
			if (choice == 2)
				break;
			scanner.nextLine();
			System.out.println("Enter Stop Address :");
			stops.address = scanner.nextLine();
			sequence++;
			stops.sequenceOrder = sequence;
			try {
				stopsdao.insert(stops);
				
			} catch (Exception e) {
				System.err.println("Something went Wrong"+e);
			}
			
			System.out.println("Do you wish to add more stops? /n 1.Yes 2. No");
			choice  = Integer.parseInt(scanner.nextLine());		
		}
	}
	public void updateStops() {
		// 1. Ask Admin whether he wants to change the whole route or remove a particular stop
		// 2. If whole route then,
		//		2.1 delete the whole stop using RouteID.
		//		2.2 Run the addStop() function.
		
		// 3. else
		//		
		
		System.out.println("Do you want update all the stops of a route or change a particular stop");
		System.out.println("1. for All Stops \n2. for changing Particular Stop");
		int choice = Integer.parseInt(scanner.nextLine());
		displayStops();
		if (choice == 1) {
			stopsdao.delete(stops);
			addStop();
		}
		else {
			System.out.println("Enter stop ID of the stop to be updated:");
			stops.stopID = Integer.parseInt(scanner.nextLine());
			List <Stops> stop = new ArrayList<>();
			int id = stops.stopID -1;
			String sql="Select * from Stops where stopID = " +id;
			stop = stopsdao.retrieve(sql);
			for (Stops stopsDetails : stop) {
				stops.sequenceOrder = stopsDetails.sequenceOrder + 1;
			}
			System.out.println("Enter the stop Address: ");
			//scanner.nextLine();
			stops.address = scanner.nextLine();
			stops.adminID = BusPassSession.user.id;
			stopsdao.update(stops);
		}
	}
	
	public boolean deleteStop() {
		//scanner.nextLine();
		
		System.out.println(stopsdao.retrieve());
		
		System.out.println("Enter the route ID:");
        stops.routeID = Integer.parseInt(scanner.nextLine());
        
        //scanner.nextLine();
        
        if (stopsdao.delete(stops) > 0)
        	return true;
        else
			return false;
	}
	public void retrieveStops(Routes routes) {
		
		String sql = "SELECT * FROM Stops WHERE routeID = '"+routes.routeID+"'";
		List<Stops> getStops = new ArrayList<>();
		getStops = stopsdao.retrieve(sql);
		//why need loop, try without loop
		for (Stops stop : getStops) {
			stops.prettyPrintForAdmin(stop);
		}
		
	}
	
	public void displayStops() {
		//scanner.nextLine();
		System.out.println("Enter the Route ID for the stops you want to search");
		stops.routeID = Integer.parseInt(scanner.nextLine());
		String sql = "SELECT * FROM Stops WHERE routeID = '"+stops.routeID+"'";
		List <Stops> getStop =  new ArrayList<>();
		getStop = stopsdao.retrieve(sql);
		//System.out.println(stopsdao.retrieve(sql));
		System.out.println("stopID \t\t address \t sequenceOrder \t routeID \t adminID \t createdOn");
		for (Stops stops : getStop) {
			System.out.print(stops.stopID+"\t\t"+stops.address+"\t\t"+stops.sequenceOrder+"\t"+stops.routeID+"\t"+stops.adminID+"\t"+stops.createdOn);
			System.out.println();
		}
	}
}
