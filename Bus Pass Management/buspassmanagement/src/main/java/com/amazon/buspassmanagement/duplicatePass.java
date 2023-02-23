package com.amazon.buspassmanagement;

@SuppressWarnings("serial")
public class duplicatePass extends Exception {
	
	public duplicatePass(int routeID) {
		System.err.println("A bus Pass for the route "+routeID+" is already there for you "+BusPassSession.user.name);
	}

}
