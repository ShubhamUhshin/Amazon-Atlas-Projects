package com.amazon.railwaycrossing.model;

/*
 * create table trainSchedule(
		scheduleID int IDENTITY(1,1),
		crossingID int CONSTRAINT trainSchedule_CID_FK REFERENCES RailwayCrossing(crossingID),
		trainNumber varchar (5) CONSTRAINT trainSchedule_TrnNo_FK REFERENCES Trains(trainNumber),
		Primary Key (scheduleID)
	);
 */

public class trainSchedule {
	
	public int scheduleID;
	public int crossingID;
	public String trainNumber;
	
	public trainSchedule() {
		// Default Constructor
	}
	
	public trainSchedule(int scheduleID, int crossingID, String trainNumber) {
		this.scheduleID = scheduleID;
		this.crossingID = crossingID;
		this.trainNumber = trainNumber;
	}

	@Override
	public String toString() {
		return "trainSchedule [scheduleID=" + scheduleID + ", crossingID=" + crossingID + ", trainNumber=" + trainNumber
				+ "]";
	}
}
