package com.amazon.buspassmanagement.model;

/*
create table Routes(
		routeID INT IDENTITY(1,1),
		title NVARCHAR(50) not null,
		description NVARCHAR(100),
		adminID INT constraint routes_id_fk references Users(id),
		createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
		PRIMARY KEY(routeID));
*/

public class Routes {

	//Attributes
	public int routeID;
	public String title;
	public String description;
	public int adminID;
	public String createdOn;

	public Routes() {
		
	}
	
	public Routes(int routeID, String title, String description, int adminID, String createdOn) {
		
		this.routeID = routeID;
		this.title = title;
		this.description = description;
		this.adminID = adminID;
		this.createdOn = createdOn;
		
	}
	
	public void prettyPrintForAdmin(Routes routes) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Route ID:\t\t"+routes.routeID);
		System.out.println("Route Title:\t\t"+routes.title);
		System.out.println("Route Description:\t"+routes.description);
		System.out.println("Admin ID:\t\t"+routes.adminID);
		System.out.println("Created On:\t\t"+routes.createdOn);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void prettyPrintForUser(Routes routes) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Route ID:\t\t"+routes.routeID);
		System.out.println("Route Title:\t\t"+routes.title);
		System.out.println("Route Description:\t"+routes.description);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}
	@Override
	public String toString() {
		return "Route [routeID = " +routeID + ", title = " +title +", Description = " +description +", AdminID = "+adminID +",createdON = "+createdOn + "]";
	}
}
