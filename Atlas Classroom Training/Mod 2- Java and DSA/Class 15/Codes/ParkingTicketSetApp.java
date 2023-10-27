package com.amazon.atlas22.collections;

import java.util.Date;
import java.util.LinkedHashSet;

public class ParkingTicketSetApp {

	public static void main(String[] args) {
		
		ParkingTicket ticket1 = new ParkingTicket("KA10AB1234", new Date(), new Date(), "John");
		ParkingTicket ticket2 = new ParkingTicket("KA10AB1234", new Date(), new Date(), "John");
		
		LinkedHashSet<ParkingTicket> parkingSite = new LinkedHashSet<ParkingTicket>();
		parkingSite.add(ticket1);
		parkingSite.add(ticket2);
		
		
		for(ParkingTicket ticket : parkingSite) {
			System.out.println(ticket);
		}

	}

}
