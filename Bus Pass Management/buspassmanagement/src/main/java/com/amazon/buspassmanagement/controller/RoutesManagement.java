package com.amazon.buspassmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazon.buspassmanagement.model.BusPass;
import com.amazon.buspassmanagement.model.Routes;
import com.amazon.buspassmanagement.model.Stops;
import com.amazon.buspassmanagement.model.Vehicles;
import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.db.BusPassDAO;
import com.amazon.buspassmanagement.db.RoutesDAO;
import com.amazon.buspassmanagement.db.StopsDAO;
import com.amazon.buspassmanagement.db.VehiclesDAO;


public class RoutesManagement {

	Scanner scanner = new Scanner(System.in);
	
	StopsManagement manageStops = StopsManagement.getInstance();
	VehicleManagement manageVehicle = VehicleManagement.getInstance();
	
	BusPass buspass = new BusPass();
	Routes routes = new Routes();
	Stops stops = new Stops();
	Vehicles vehicles = new Vehicles();
	
	BusPassDAO busPassdao = new BusPassDAO();
	RoutesDAO credao = new RoutesDAO();
	StopsDAO stopsdao = new StopsDAO();
	VehiclesDAO vehiclesDAO = new VehiclesDAO();
	
	public RoutesManagement(){
		// TODO Auto-generated constructor stub
	}
	
	// Singleton design pattern to create object
	private static  RoutesManagement manageRoutes = new RoutesManagement();
	public static RoutesManagement getInstance() {
		return manageRoutes;
	}
	
	// For Admin
	public void manageRoute() {
		
		while(true) {
			try {
				System.out.println("+++++++++++++++++++++++");
				System.out.println("1. Create new Route");
				System.out.println("2. Retrieve a Route");
				System.out.println("3. Update a route");
				System.out.println("4. Remove a route");
				System.out.println("5. QUIT");
				System.out.println("Enter your choice :");
				int ch = Integer.parseInt(scanner.nextLine());
				// Based on the Admin choice we perform the respective function
				boolean quit = false;
				switch(ch) {
				case 1:
					if (createRoute())
						System.out.println("Route Added");
					else 
						System.err.println("Something went wrong");
					break;
					
				case 2:
					retrieveRoute();
					break;
					
				case 3:
					int update = updateRoute();
					if (update == 1)
						System.out.println("Route updated");
					
					else if (update == 2)
						System.err.println("Something went wrong");
					
					else
						System.out.println("Discarded Operation");
					
					break;
	
				case 4:
					if (deleteRoute())
						System.out.println("Deleted Route");
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
			catch(Exception e) {
				System.err.println("Invalid Input"+e);
			}
		}
	}
	
	// Adding the route details
	public void addDetails() {
		
		System.out.println("Enter the route title:");
		String title = scanner.nextLine();
		if (!title.isEmpty())
			routes.title = title;
		System.out.println("Enter route description");
		String description = scanner.nextLine();
		if (!description.isEmpty())
			routes.description = description;
		routes.adminID = BusPassSession.user.id;
	}
	
	//// Creating a new Route
	public boolean createRoute() {
		
        addDetails();
		if (credao.insert(routes) > 0) {
			List<Routes> getRoute = new ArrayList<Routes>();
			// The route title is unique as per the model
			String sql = "Select * from Routes where title = '"+routes.title +"'";
			// Retrieving RouteId to add stops
			getRoute = credao.retrieve(sql);
			for (Routes route : getRoute)
				// Saving the route ID in the stop object
				stops.routeID = route.routeID;
			// Adding the Admin ID in the stop
			stops.adminID = routes.adminID;
			
			// Inserting the stop in stop table
			manageStops.insertStop(stops);
			return true;
		}
		else
			return false;
		
	}
	
	// Retrieving  route
	// For Admin
	public void retrieveRoute() {
		
		//scanner.nextLine();
		
		System.out.println("Do you want to see all routes or a particular route?");
		System.out.println("1. All Routes");
		System.out.println("2. Specific Route");
		int choice = Integer.parseInt(scanner.nextLine());
		// Based on the choice, retrieving route
		if (choice == 1) {
			// Retrieving all route
			List<Routes> getRoutes = new ArrayList<>();
			getRoutes = credao.retrieve();
			// Displaying the route
			for (Routes route : getRoutes) {
				routes.prettyPrintForAdmin(route);
			}
		}
		else if (choice == 2){
			//scanner.nextLine();
			// Retrieving route based on the Title
			System.out.println("Enter the Route Title you want to search");
			routes.title = scanner.nextLine();
			String sql = "SELECT * FROM Routes WHERE title = '"+routes.title+"'";
			// Retrieving route based on the title given by Admin
			List<Routes> getRoutes = new ArrayList<>();
			getRoutes = credao.retrieve(sql);
			// Displaying Route, Stop and Vehicle on the route
			for (Routes route : getRoutes) {
				routes.prettyPrintForAdmin(route);
				manageStops.retrieveStops(route);
				manageVehicle.retrieveVehicles(route);
			}
		}
		
		else
			System.err.println("Wrong Choice");
	}
	
	// For User
	public void displayRoutes() {
		
		// Displaying route based on the Title
		System.out.println("Enter the Route Title you want to search");
		routes.title = scanner.nextLine();
		String sql = "SELECT * FROM Routes WHERE title = '"+routes.title+"'";
		List<Routes> getRoutes = new ArrayList<>();
		getRoutes = credao.retrieve(sql);
		int routeID = 0;
		for (Routes route : getRoutes) {
			routeID = route.routeID;
			routes.prettyPrintForUser(route);
		}
		// Displaying stops of the route
		sql = "SELECT * FROM Stops WHERE routeID = "+routeID;
		List <Stops> getStops = new ArrayList<>();
		getStops = stopsdao.retrieve(sql);
		for (Stops stop : getStops) {
			stops.prettyPrintForUser(stop);
		}
		
		// Displaying Vehicles on the route
		sql = "SELECT * FROM Vehicles WHERE routeID = "+routeID;
		List <Vehicles> getVehicle = new ArrayList<>();
		getVehicle = vehiclesDAO.retrieve(sql);
		for (Vehicles vehicle : getVehicle) {
			vehicles.prettyPrintForUser(vehicle);
		}
	}
	
	// Update Route
	// For Admin
	public int updateRoute() {
		
		//display the routes table
		List<Routes> getRoutes = new ArrayList<>();
		getRoutes = credao.retrieve();
		
		for (Routes route : getRoutes) {
			routes.prettyPrintForAdmin(route);
		}
		
		System.out.println("Enter the Route ID you want to modify");
		routes.routeID = Integer.parseInt(scanner.nextLine());
		String sql = "Select * from Routes where routeID = "+routes.routeID;
		List<Routes> route =  credao.retrieve(sql);
		Routes routeDetail = new Routes();
		routeDetail = route.get(0);
		// Storing the route details so if the Admin doesn't want to update the detail, older value gets retained
		routes.description = routeDetail.description;
		routes.title = routeDetail.title;
		// Adding the route details
		addDetails();
		
		// Displaying the detail before updating
		System.out.println("Title : " +routes.title);
		System.out.println("Description : "+routes.description);
		System.out.println("Route ID : "+routes.routeID);
		System.out.println("Do you wish to update? \n 1: Yes 2: No");
		int choice = Integer.parseInt(scanner.nextLine());
		// updating based on the admin choice
		if (choice == 1)
			if (credao.update(routes) > 0)
				return 1;
			else 
				return 2;
		
		else
			return 10;
	}
	
	// Deleting the route
	public boolean deleteRoute() {
		
		// Displaying route before deletion
		List <Routes> routeList= new ArrayList<>();
		routeList = credao.retrieve();
		
		for (Routes route : routeList) {
			routes.prettyPrintForAdmin(route);
		}
		
		// Deleting based on routeId
		System.out.println("Enter the route ID:");
		
        routes.routeID = Integer.parseInt(scanner.nextLine());
        buspass.routeID = vehicles.routeID = stops.routeID = routes.routeID;
        
        System.out.println("This will delete the Stops, vehicles running on this route and BusPasses created for this Route");
        System.out.println("Do you wish to continue Deleting this route /n1. Yes 2. No");
        int choice = Integer.parseInt(scanner.nextLine());
        // Deleting stops and vehicle 
        if (choice == 1) {
	        busPassdao.delete(buspass);
	        vehiclesDAO.delete(vehicles);
	        stopsdao.delete(stops);
	        if (credao.delete(routes) > 0)
	        	return true;
	        else
				return false;
		}
        else
        	System.out.println("Cancelled by Admin");
        
        return false;
	}
}