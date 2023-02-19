package com.amazon.buspassmanagement.controller;

import java.util.ArrayList;
import java.util.List;
import com.amazon.buspassmanagement.BusPassSession;
import com.amazon.buspassmanagement.model.Routes;
import com.amazon.buspassmanagement.model.Vehicles;

public class VehicleManagement extends Management {
	
	private static VehicleManagement manageVehicle = new VehicleManagement();
	
	public static VehicleManagement getInstance() {
		return manageVehicle;
	}
	
	public void manageVehicle() {
		
		while(true) {
			try {
				System.out.println("+++++++++++++++++++++++");
				System.out.println("1. Add new Vehicle");
				System.out.println("2. Display Vehicle Details");
				System.out.println("3. Update a Vehicle Information");
				System.out.println("4. Remove a Vehicle Service");
				System.out.println("5. QUIT");
				System.out.println("Enter your choice :");
				int ch = Integer.parseInt(scanner.nextLine());
				boolean quit = false;
				switch(ch) {
				case 1:
					if (addVehicle())
						System.out.println("Vehicle Added to service");
					else {
						System.err.println("Some Error occured");
					}
					break;
					
				case 2:
					displayVehicles();
					break;
					
				case 3:
					if (updateVehicle())
						System.out.println("Vehicle updated");
					
					else
						System.err.println("Something went wrong");
					break;
	
				case 4:
					if (deleteVehicle())
						System.out.println("Deleted Vehicle");
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

	public void addVehicleDetails(Vehicles vehicles) {
		//scanner.nextLine();
		
		System.out.println("Enter Vehicle Registration Number: ");
		String regNo = scanner.nextLine();
		if (!regNo.isEmpty())
		vehicles.regNo = regNo; 
		System.out.println("Enter Vehicle type: ");
		String type = scanner.nextLine();
		if (!type.isEmpty())
			vehicles.type = Integer.parseInt(type);
		System.out.println("Enter filled Seats ");
		String filledSteats = scanner.nextLine();
		if (!filledSteats.isEmpty())
			vehicles.filledSeats = Integer.parseInt(filledSteats);
		System.out.println("Enter Total Number of Seats: ");
		String totalSeats = scanner.nextLine();
		if (!totalSeats.isEmpty())
			vehicles.totalSeats = Integer.parseInt(totalSeats);
		//scanner.nextLine();
		System.out.println("Enter Start Pickup Time: ");
		String startPickupTime = scanner.nextLine();
		if (!startPickupTime.isEmpty())
			vehicles.startPickUpTime = startPickupTime;
		System.out.println("Enter Start Drop Off Time: ");
		String startDropOffTime = scanner.nextLine();
		if (!startDropOffTime.isEmpty())
			vehicles.startDropOffTime = startDropOffTime;
		System.out.println("Enter Vehicle Availability /n 0. In Maintainence /t 1. Available");
		String vehicleAvailability = scanner.nextLine();
		if (!vehicleAvailability.isEmpty())
			vehicles.vehicleAvailability = Integer.parseInt(vehicleAvailability);
		System.out.println("Enter Driver ID: ");
		String driverID = scanner.nextLine();
		if (!driverID.isEmpty())
			vehicles.driverID = Integer.parseInt(driverID);
		System.out.println("Enter the Route ID: ");
		String routeID = scanner.nextLine();
		if (!routeID.isEmpty())
			vehicles.routeID = Integer.parseInt(routeID);
	}
	

	public boolean addVehicle() {
		vehicles.adminID = BusPassSession.user.id;;
		addVehicleDetails(vehicles);
		return vehiclesDAO.insert(vehicles) > 0;
	}
	
	public void displayVehicles() {
		List <Vehicles> vehicle = new ArrayList<>();
		vehicle = vehiclesDAO.retrieve();
		for (Vehicles vehiclesDetail : vehicle) {
			vehicles.prettyPrintForAdmin(vehiclesDetail);
		}
	}
	
	public void retrieveVehicles(Routes routes) {
		List <Vehicles> vehicle = new ArrayList<>();
		String sql = "select * from Vehicles where routeID = '"+routes.routeID+"'";
		vehicle = vehiclesDAO.retrieve(sql);
		for (Vehicles vehiclesDetail : vehicle) {
			vehicles.prettyPrintForAdmin(vehiclesDetail);
		}
	}
	public boolean updateVehicle() {
		displayVehicles();
		System.out.println("Enter Vehicle ID to be updated: ");
		vehicles.vehicleID = Integer.parseInt(scanner.nextLine());
		String sql = "Select * from Vehicles where vehicleID = "+vehicles.vehicleID;
		List<Vehicles> vehicleDetail = vehiclesDAO.retrieve(sql);
		Vehicles vehicle = new Vehicles();
		vehicle = vehicleDetail.get(0);
		vehicles = vehicle;
		addVehicleDetails(vehicles);
		vehicles.adminID = BusPassSession.user.id;;
		return vehiclesDAO.update(vehicles) > 0;
	}
	
	public boolean deleteVehicle() {
		scanner.nextLine();
		displayVehicles();
		System.out.println("Enter Vehicle Registration Number of vehicle you want to delete: ");
		vehicles.regNo = scanner.nextLine();
		return vehiclesDAO.delete(vehicles) > 0;
	}
	
}

