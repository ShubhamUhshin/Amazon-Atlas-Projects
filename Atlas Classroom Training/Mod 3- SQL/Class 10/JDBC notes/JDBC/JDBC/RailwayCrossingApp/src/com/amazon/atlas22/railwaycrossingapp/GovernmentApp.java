package com.amazon.atlas22.railwaycrossingapp;

import java.util.Scanner;

public class GovernmentApp {
	
	Scanner scanner;
	
	private static GovernmentApp app;
	
	public static GovernmentApp getInstance() {
		if(app == null) {
			app = new GovernmentApp();
		}
		return app;
	}
	
	private GovernmentApp(){
		scanner = new Scanner(System.in);
	}
	
	
	void startGovernmentApp() {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome Admin User");
		System.out.println("Proceed to Login");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					
	}

}
