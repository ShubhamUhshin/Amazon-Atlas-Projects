package com.amazon.dmataccountmanager.model;


public class Shares {

/*
 MSSQL:
 create table Shares(
	shareID INT IDENTITY(1,1),
	SYMBOL NVARCHAR(10) NOT NULL UNIQUE,
	companyName NVARCHAR(50) NOT NULL,
	price INT NOT NULL, 
	lastUpdatedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(shareID));
*/
	public int shareID;
	public String symbol;
	public String companyName;
	public double price; 
	public String lastUpdatedOn;
	
	public Shares() {
	}

	public Shares(int shareID, String symbol, String companyName, double price, String lastUpdatedOn) {
		this.shareID = shareID;
		this.symbol = symbol;
		this.companyName = companyName;
		this.price = price;
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
	// Displaying Share details
	public void prettyPrint(Shares share) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("ShareID:\t"+share.shareID);
		System.out.println("SYMBOL:\t\t"+share.symbol);
		System.out.println("Company Name:\t"+share.companyName);
		System.out.println("Share Price:\t"+share.price);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	// This function is called when view report function is executed 
	// Displaying share details based on the shareID
	public void prettyPrintForTransaction(Shares share) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Company Name:\t\t"+share.companyName);
		System.out.println("SYMBOL:\t\t\t"+share.symbol);	
	}
	
	@Override
	public String toString() {
		return "Shares [shareID=" + shareID + ", SYMBOL=" + symbol + ", companyName=" + companyName + ", price=" + price
				+ ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}
}
