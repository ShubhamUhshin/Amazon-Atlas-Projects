package com.amazon.buspassmanagement.model;

/*
create table BusPass(
	buspassID INT IDENTITY(1,1),
	requestedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	approvedRejectedOn DATETIME,
	validTill DATETIME,
	status INT DEFAULT 1,
	userID INT constraint buspass_id_fk references Users(id),
	routeID INT constraint buspass_routeID_fk references Routes(routeID),
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(buspassID)); 
*/

public class BusPass {
	//Attributes
	public int buspassID;
	public String requestedOn;
	public String approvedRejectedOn;
	public String validTill;
	public int status;
	public int userID;
	public int routeID;
	public String createdOn;
	
	public BusPass() {
		
	}
	
	public BusPass(int buspassID, int userID, int routeID, String requestedOn, String approvedRejectedOn, String validTill,
			int status, String createdOn) {
		this.buspassID = buspassID;
		this.userID = userID;
		this.routeID = routeID;
		this.requestedOn = requestedOn;
		this.approvedRejectedOn = approvedRejectedOn;
		this.validTill = validTill;
		this.status = status;
		this.createdOn = createdOn;
	}

	public void prettyPrint() {
		System.out.println("~~~~~~~~~~~BusPass~~~~~~~~~~");
		System.out.println("buspass ID:\t\t"+buspassID);
		System.out.println("User ID:\t\t"+userID);
		System.out.println("Route ID:\t\t"+routeID);
		System.out.println("Updated On:\t\t"+approvedRejectedOn);
		System.out.println("Valid Till:\t\t"+validTill);
		
		String statusText = "";
		
		if(status == 1) {
			statusText = "Requested";
		}else if (status == 2) {
			statusText = "Approved";
		}else if (status == 3) {
			statusText = "Canceled";
		}else {
			statusText = "Suspended";
		}
		
		System.out.println("Status:\t\t\t"+statusText);
		System.out.println("Created On:\t\t"+createdOn);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public String toString() {
		return "BusPass [buspassID=" + buspassID + ", userID=" + userID + ", routeID=" + routeID + ", requestedOn=" + requestedOn
				+ ", approvedRejectedOn=" + approvedRejectedOn + ", validTill=" + validTill + ", status=" + status
				+ ", createdOn=" + createdOn + "]";
	}
}
