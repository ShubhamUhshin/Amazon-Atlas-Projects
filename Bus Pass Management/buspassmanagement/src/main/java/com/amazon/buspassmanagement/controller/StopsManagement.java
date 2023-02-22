package com.amazon.buspassmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.db.RoutesDAO;
import com.amazon.buspassmanagement.db.StopsDAO;
import com.amazon.buspassmanagement.model.Routes;
import com.amazon.buspassmanagement.model.Stops;

public class StopsManagement {
	
	Scanner scanner = new Scanner(System.in);
	
	RoutesManagement manageRoutes = RoutesManagement.getInstance();
	Routes routes = new Routes();
	Stops stops = new Stops();
	RoutesDAO credao = new RoutesDAO();
	StopsDAO stopsdao = new StopsDAO();

	// Using singleton design pattern
	private static StopsManagement manageStops = new StopsManagement();
	public static StopsManagement getInstance() {
		return manageStops;
	}
	
	// For Admin
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
	// Adding Stop
	public void addStop() {
		// Starting the sequence from 0
		int sequence = 0;
		int choice = 1;
		System.out.println("Enter routeID");
		stops.routeID = Integer.parseInt(scanner.nextLine());
		stops.adminID = BusPassSession.user.id;
		String sql = "SELECT * from Stops where routeID ="+stops.routeID;
		// Checking if we already have stop on the route
		// If the route has no stop
		if (stopsdao.retrieve(sql).isEmpty())
		{
			while(true) {
				if (choice == 2)
					break;
				System.out.println("Enter Stop Address :");
				stops.address = scanner.nextLine();
				// Incrementing sequence before inserting
				sequence++;
				stops.sequenceOrder = sequence;
				try {
					stopsdao.insert(stops);
					
				} catch (Exception e) {
					System.err.println("Something went Wrong"+e);
				}
				// Asking the Admin whether he wants to add more stop
				System.out.println("Do you wish to add more stops? /n 1.Yes 2. No");
				choice  = Integer.parseInt(scanner.nextLine());
				//scanner.nextLine();			
			}
		}
		// If the stop already exists for the route already
		// Asking the admin to add more stops 
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
	
	// Inserting stops
	// This function is called when we add a new stop
	public void insertStop(Stops stops) {
		// Initializing sequence as 0
		int sequence = 0;
		int choice = 0;
		while(true) {
	
			if (choice == 2)
				break;
			System.out.println("Enter Stop Address :");
			stops.address = scanner.nextLine();
			// Incrementing sequence before using it
			sequence++;
			stops.sequenceOrder = sequence;
			try {
				stopsdao.insert(stops);
				
			} catch (Exception e) {
				System.err.println("Something went Wrong"+e);
			}
			// Asking the admin whether he wants to add more stops
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
		
		// Asking the Admin whether he wants to update all stops or a specific stop
		System.out.println("Do you want update all the stops of a route or change a particular stop");
		System.out.println("1. for All Stops \n2. for changing Particular Stop");
		int choice = Integer.parseInt(scanner.nextLine());
		displayStops();
		if (choice == 1) {
			// If admin wants to update all stops, deleting stops and inserting new stops for the route
			stopsdao.delete(stops);
			addStop();
		}
		else {
			// Updating stops based on stop ID
			System.out.println("Enter stop ID of the stop to be updated:");
			stops.stopID = Integer.parseInt(scanner.nextLine());
			List <Stops> stop = new ArrayList<>();
			// Finding sequence order
			// For the stop to be updated, the sequence ID would be calculated based on the sequenceOrder of the previous stop
			// Rather than adding a new insert or update function, using logic to calculate stop.
			int id = stops.stopID -1;
			String sql="Select * from Stops where stopID = " +id;
			stop = stopsdao.retrieve(sql);
			for (Stops stopsDetails : stop) {
				// Storing the sequence Order
				stops.sequenceOrder = stopsDetails.sequenceOrder + 1;
			}
			System.out.println("Enter the stop Address: ");
			//scanner.nextLine();
			stops.address = scanner.nextLine();
			stops.adminID = BusPassSession.user.id;
			stopsdao.update(stops);
		}
	}
	
	// Deleting stop
	public boolean deleteStop() {
		//scanner.nextLine();
		
		System.out.println(stopsdao.retrieve());
		
		// Deleting stops based on the route ID
		System.out.println("Enter the route ID:");
        stops.routeID = Integer.parseInt(scanner.nextLine());
       
        
        if (stopsdao.delete(stops) > 0)
        	return true;
        else
			return false;
	}
	
	// Retrieving stops based on the RouteID
	public void retrieveStops(Routes routes) {
		
		String sql = "SELECT * FROM Stops WHERE routeID = '"+routes.routeID+"'";
		List<Stops> getStops = new ArrayList<>();
		getStops = stopsdao.retrieve(sql);
		//why need loop, try without loop
		for (Stops stop : getStops) {
			stops.prettyPrintForAdmin(stop);
		}
		
	}
	
	// Displaying stops based on the routeID
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
