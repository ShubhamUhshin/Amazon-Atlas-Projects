package com.amazon.buspassmanagement.model;

/*
create table Vehicles(
    vehicleID INT IDENTITY(1,1),
    regNo NVARCHAR (20) NOT NULL,
    type int NOT NULL,
    filledSeats INT,
    totalSeats INT NOT NULL,
    startPickUpTime NVARCHAR (50),
    startDropOffTime NVARCHAR (50),
    vehicleAvailability bit NOT NULL,
    driverID INT NOT NULL,
    routeID INT constraint vehicle_routeID_fk references Routes(routeID),
    adminID INT constraint vehicle_id_fk references Users(id),
    createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(vehicleID));
*/

public class Vehicles {
	
	//Attributes
	public int vehicleID;
	public String regNo;
	public int type;
	public int filledSeats;
	public int totalSeats;
	public String startPickUpTime;
	public String startDropOffTime;
	public int vehicleAvailability; //0 -> for not available. 1 for available
	public int driverID;
	public int routeID;
	public int adminID;
	public String createdOn;
	
	public Vehicles() {	
	}

	public Vehicles(int vehicleID, String regNo, int type, int filledSeats, int totalSeats, String startPickUpTime,
			String startDropOffTime, int vehicleAvailability, int driverID, int routeID, int adminID,
			String createdOn) {
		this.vehicleID = vehicleID;
		this.regNo = regNo;
		this.type = type;
		this.filledSeats = filledSeats;
		this.totalSeats = totalSeats;
		this.startPickUpTime = startPickUpTime;
		this.startDropOffTime = startDropOffTime;
		this.vehicleAvailability = vehicleAvailability;
		this.driverID = driverID;
		this.routeID = routeID;
		this.adminID = adminID;
		this.createdOn = createdOn;
	}

	public void prettyPrintForAdmin(Vehicles vehicles) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Vehicle ID:\t\t"+vehicles.vehicleID);
		System.out.println("Vehicle RegdNo:\t\t"+vehicles.regNo);
		
		String vehicleType ="";
		if (vehicles.type == 1)
			vehicleType = "Bus";
		if (vehicles.type == 2)
			vehicleType = "Innova";
		
		System.out.println("Vehicle Type:\t\t"+vehicleType);
		System.out.println("Filled Seats:\t\t"+vehicles.filledSeats);
		System.out.println("Total Seats:\t\t"+vehicles.totalSeats);
		System.out.println("Available Seats:\t"+(vehicles.totalSeats-vehicles.filledSeats));
		System.out.println("Start Pickup Time:\t"+vehicles.startPickUpTime);
		System.out.println("Drop Off Time:\t\t"+vehicles.startDropOffTime);
		
		String vehicleAvailable;
		if (vehicles.vehicleAvailability == 1)
			vehicleAvailable = "Available";
		else
			vehicleAvailable = "Not Available";

		System.out.println("Vehicle Availability:\t"+vehicleAvailable);
		System.out.println("Driver ID:\t\t"+vehicles.driverID);
		System.out.println("Route ID:\t\t"+vehicles.routeID);
		System.out.println("Admin ID:\t\t"+vehicles.adminID);
		System.out.println("Created On:\t\t"+vehicles.createdOn);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void prettyPrintForUser(Vehicles vehicles) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Vehicle RegdNo:\t\t"+vehicles.regNo);
		
		String vehicleType ="";
		if (vehicles.type == 1)
			vehicleType = "Bus";
		if (vehicles.type == 2)
			vehicleType = "Innova";
		System.out.println("Vehicle Type:\t\t"+vehicleType);
		System.out.println("Filled Seats:\t\t"+vehicles.filledSeats);
		System.out.println("Total Seats:\t\t"+vehicles.totalSeats);
		System.out.println("Available Seats:\t"+(vehicles.totalSeats-vehicles.filledSeats));
		System.out.println("Start Pickup Time:\t"+vehicles.startPickUpTime);
		System.out.println("Drop Off Time:\t\t"+vehicles.startDropOffTime);
		
		String vehicleAvailable;
		if (vehicles.vehicleAvailability == 1)
			vehicleAvailable = "Available";
		else
			vehicleAvailable = "Not Available";

		System.out.println("Vehicle Availability:\t"+vehicleAvailable);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public String toString() {
		return "Vehicles [vehicleID=" + vehicleID + ", regNo=" + regNo + ", type=" + type + ", filledSeats="
				+ filledSeats + ", totalSeats=" + totalSeats + ", startPickUpTime=" + startPickUpTime
				+ ", startDropOffTime=" + startDropOffTime + ", vehicleAvailability=" + vehicleAvailability
				+ ", driverID=" + driverID + ", routeID=" + routeID + ", adminID=" + adminID + ", createdOn="
				+ createdOn + "]";
	}
}
