package com.amazon.dmataccountmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.amazon.dmataccountmanager.db.ShareDAO;
import com.amazon.dmataccountmanager.model.Shares;

public class ShareManagement {
	
	Scanner scanner = new Scanner(System.in);
	Shares share = new Shares();
	ShareDAO sharedao = new ShareDAO();
	
	// Creating object using Singleton design pattern
	private static ShareManagement manageShares = new ShareManagement();
	public static ShareManagement getInstance() {
		return manageShares;
	}
	
	private ShareManagement() {
	}

	// Displaying shares available in our database for trading
	public void displayShares() {
		
		// Retrieving each share from the share table and storing it in shareDetails object
		List<Shares> shareDetails = new ArrayList<Shares>();
		shareDetails = sharedao.retrieve();
		
		// Displaying each share
		for (Shares share : shareDetails)
			share.prettyPrint(share);
		
	}
	
	// This function is used for view report
	// Displaying transaction details based on shareID
	public void displaySharesForTransaction(int shareID) {
		
		String sql = "SELECT * from Shares where shareID = "+shareID;
		List<Shares> shareDetails = new ArrayList<Shares>();
		shareDetails = sharedao.retrieve(sql);
		
		for (Shares share : shareDetails)
			share.prettyPrintForTransaction(share);
		
	}
	
	// Dynamically setting up share prices
	public void dynamicShares() {
		
		// Retrieving each share from the share table
		List<Shares> shares = new ArrayList<Shares>();
		shares = sharedao.retrieve();
		// Using Random class to randomly pick a number between -100 and 100
		Random random = new Random();
		double min = -100.0;
	    double max = 100.0;
	    
	    // Randomly generating a number between -100 to 100 and adding it to share price
		for (Shares share : shares) {
			
			// Generating random number between -100 and 100 and adding it to share.price
			share.price += random.nextDouble(max - min + 1) + min;
			// updating the share table
			sharedao.update(share);
		}
		
	}
}
