package com.amazon.railwaycrossing.model;

/*
 * Create table RailwayCrossing(
		crossingID int IDENTITY (1,1),
		address nvarchar(50),
		name nvarchar (20) NOT null,
		landmark nvarchar (20),
		status bit DEFAULT (0),
		PersonInCharge int CONSTRAINT RailwayCrossing_PIC_FK REFERENCES RailwayEmployees(employeeID),
		Primary Key (crossingID)
	);
 */

import java.util.Scanner;

public class RailwayCrossing {

	public int crossingID;
	public String address;
	public String name;
	public String landmark;
	public int status;
	public int personInCharge;
	
	public RailwayCrossing() {
		// Default Constructor
	}
	
	public RailwayCrossing(int crossingID, String address, String name, String landmark, int status, int personInCharge) {
		this.crossingID = crossingID;
		this.address = address;
		this.name = name;
		this.landmark = landmark;
		this.status = status;
		this.personInCharge = personInCharge;
	}

	Scanner scanner = new Scanner (System.in);
	// For Admin to Get Details of a crossing
	public void getDetails (RailwayCrossing crossing) {
		
		System.out.println("Enter Crossing Address");
		String address = scanner.nextLine();
		if (address != null)
			crossing.address = address;
		System.out.println("Enter Crossing Name");
		String name = scanner.nextLine();
		if (name != null)
		crossing.name = name;
		System.out.println("Enter Crossing Landmark");
		String landmark = scanner.nextLine();
		crossing.landmark = landmark;
		System.out.println("Enter crossing Status");
		String status = scanner.nextLine();
		if (!status.isBlank())
		crossing.status = Integer.parseInt(status);
		// Displaying Person In Charge Details
		
		System.out.println("Enter the person Incharge");
		crossing.personInCharge = Integer.parseInt(scanner.nextLine());	
	}
	
	public void displayCrossingDetails(RailwayCrossing crossing) {
		
		System.out.print(crossing.crossingID+"\t");
		System.out.print(crossing.name+"\t");
		String status = (crossing.status == 0) ? "closed" : "Open";
		System.out.print(status+"\t");
		System.out.print(crossing.personInCharge+"\t");
		System.out.print(crossing.address);
		
	}
	
	public void displayStatus (RailwayCrossing crossing) {
		
		
	}
	@Override
	public String toString() {
		return "RailwayCrossing [crossingID=" + crossingID + ", address=" + address + ", name=" + name + ", landmark="
				+ landmark + ", status=" + status + ", personInCharge=" + personInCharge + "]";
	}
}
