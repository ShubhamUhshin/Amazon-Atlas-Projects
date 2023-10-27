package com.amazon.atlas22.collections;

import java.util.Date;

public class ParkingTicket {

	String vehcileNumber;
	Date parkedTimeStamp;
	Date unParkTimeStamp;
	String nameOfVehicleOwner;
	
	public ParkingTicket() {
		
	}
	
	public ParkingTicket(String vehcileNumber, Date parkedTimeStamp, Date unParkTimeStamp, String nameOfVehicleOwner) {
		this.vehcileNumber = vehcileNumber;
		this.parkedTimeStamp = parkedTimeStamp;
		this.unParkTimeStamp = unParkTimeStamp;
		this.nameOfVehicleOwner = nameOfVehicleOwner;
	}

	@Override
	public String toString() {
		return "ParkingTicket [vehcileNumber=" + vehcileNumber + ", parkedTimeStamp=" + parkedTimeStamp
				+ ", unParkTimeStamp=" + unParkTimeStamp + ", nameOfVehicleOwner=" + nameOfVehicleOwner + "]";
	}
	
}
