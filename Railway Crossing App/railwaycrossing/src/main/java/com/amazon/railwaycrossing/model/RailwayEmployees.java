package com.amazon.railwaycrossing.model;
/*
 * create table RailwayEmployees(
		employeeID int IDENTITY (1,1),
		name nvarchar (30) not null,
		shiftTiming datetime,
		crossingID int not null,
		Primary Key (employeeID)
	);
 */

public class RailwayEmployees {
	
	public int employeeID;
	public String name;
	public String shiftTime;
	public int crossingID;
	
	public RailwayEmployees() {
		// Default Constructor
	}
	
	public RailwayEmployees(int employeeID, String name, String shiftTime, int crossingID) {
		this.employeeID = employeeID;
		this.name = name;
		this.shiftTime = shiftTime;
		this.crossingID = crossingID;
	}

	@Override
	public String toString() {
		return "RailwayEmployees [employeeID=" + employeeID + ", name=" + name + ", datetime=" + shiftTime
				+ ", crossingID=" + crossingID + "]";
	}
}
