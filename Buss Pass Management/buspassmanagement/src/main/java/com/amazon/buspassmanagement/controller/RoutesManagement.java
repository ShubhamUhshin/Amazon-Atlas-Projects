package com.amazon.buspassmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import com.amazon.buspassmanagement.model.Routes;
import com.amazon.buspassmanagement.model.Stops;
import com.amazon.buspassmanagement.model.Vehicles;
import com.amazon.buspassmanagement.BusPassSession;


public class RoutesManagement extends Management{

	
	public RoutesManagement(){
		// TODO Auto-generated constructor stub
	}
	private static  RoutesManagement manageRoutes = new RoutesManagement();
	
	public static RoutesManagement getInstance() {
		return manageRoutes;
	}
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
	
	public void addDetails() {
		//scanner.nextLine();
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
	
	public boolean createRoute() {
		
        addDetails();
		if (credao.insert(routes) > 0) {
			List<Routes> getRoute = new ArrayList<Routes>();
			String sql = "Select * from Routes where title = '"+routes.title +"'"; 
			getRoute = credao.retrieve(sql);
			for (Routes route : getRoute)
				stops.routeID = route.routeID;
			
			stops.adminID = routes.adminID;
			manageStops.insertStop(stops);
			return true;
		}
		else
			return false;
		
	}
	
	public void retrieveRoute() {
		
		//scanner.nextLine();
		
		System.out.println("Do you want to see all routes or a particular route?");
		System.out.println("1. All Routes");
		System.out.println("2. Specific Route");
		int choice = Integer.parseInt(scanner.nextLine());
		
		if (choice == 1) {
			List<Routes> getRoutes = new ArrayList<>();
			getRoutes = credao.retrieve();
			
			for (Routes route : getRoutes) {
				routes.prettyPrintForAdmin(route);
			}
		}
		else if (choice == 2){
			//scanner.nextLine();
			System.out.println("Enter the Route Title you want to search");
			routes.title = scanner.nextLine();
			String sql = "SELECT * FROM Routes WHERE title = '"+routes.title+"'";
			List<Routes> getRoutes = new ArrayList<>();
			getRoutes = credao.retrieve(sql);
			for (Routes route : getRoutes) {
				routes.prettyPrintForAdmin(route);
				manageStops.retrieveStops(route);
				manageVehicle.retrieveVehicles(route);
			}
		}
		
		else
			System.err.println("Wrong Choice");
	}
	
	public void displayRoutes() {
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
		sql = "SELECT * FROM Stops WHERE routeID = "+routeID;
		List <Stops> getStops = new ArrayList<>();
		getStops = stopsdao.retrieve(sql);
		for (Stops stop : getStops) {
			stops.prettyPrintForUser(stop);
		}
		
		sql = "SELECT * FROM Vehicles WHERE routeID = "+routeID;
		List <Vehicles> getVehicle = new ArrayList<>();
		getVehicle = vehiclesDAO.retrieve(sql);
		for (Vehicles vehicle : getVehicle) {
			vehicles.prettyPrintForUser(vehicle);
		}
	}
	
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
		routes.description = routeDetail.description;
		routes.title = routeDetail.title;
		
		addDetails();
		
		System.out.println("Title : " +routes.title);
		System.out.println("Description : "+routes.description);
		System.out.println("Route ID : "+routes.routeID);
		System.out.println("Do you wish to update? \n 1: Yes 2: No");
		int choice = Integer.parseInt(scanner.nextLine());
		//scanner.nextLine();
		if (choice == 1)
			if (credao.update(routes) > 0)
				return 1;
			else 
				return 2;
		
		else
			return 10;
	}
	
	public boolean deleteRoute() {
		//scanner.nextLine();
		List <Routes> routeList= new ArrayList<>();
		routeList = credao.retrieve();
		
		for (Routes route : routeList) {
			routes.prettyPrintForAdmin(route);
		}
		
		System.out.println("Enter the route ID:");
        routes.routeID = Integer.parseInt(scanner.nextLine());
        buspass.routeID = vehicles.routeID = stops.routeID = routes.routeID;
        
        System.out.println("This will delete the Stops, vehicles running on this route and BusPasses created for this Route");
        System.out.println("Do you wish to continue Deleting this route /n1. Yes 2. No");
        int choice = Integer.parseInt(scanner.nextLine());
        //scanner.nextLine();
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