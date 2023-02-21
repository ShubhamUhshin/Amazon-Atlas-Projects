package com.amazon.dmataccountmanager.model;

public class Portfolios {
/*
MSSQL:
	create table Portfolios(
			portfolioID INT IDENTITY(1,1),
			userID INT constraint usershares_userID_fk references Users(userID),
			shareID INT constraint usershares_shareID_fk references Shares(shareID),
			transactionID INT constraint portfolios_transactionID_fk references Transactions(transactionID),
			companyName NVARCHAR(50) NOT NULL,
			shareCount INT NOT NULL, 
			PRIMARY KEY(portfolioID));
 */
	
	public int portfolioID;
	public int userID;
	public int shareID;
	public int transactionID;
	public String companyName;
	public int shareCount;
	
	public Portfolios() {
	}

	
	
	public Portfolios(int portfolioID, int userID, int shareID, int transactionID, String companyName, int shareCount) {
		this.portfolioID = portfolioID;
		this.userID = userID;
		this.shareID = shareID;
		this.transactionID = transactionID;
		this.companyName = companyName;
		this.shareCount = shareCount;
		
	}

	// Displaying portfolio details
	public void prettyPrint(Portfolios portfolio) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("PortfolioID:\t"+portfolio.portfolioID);
		System.out.println("UserID:\t\t"+portfolio.userID);
		System.out.println("ShareID:\t"+portfolio.shareID);
		System.out.println("TransactionID:\t"+portfolio.transactionID);
		System.out.println("Company Name:\t"+portfolio.companyName);
		System.out.println("Share Count:\t"+portfolio.shareCount);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}



	@Override
	public String toString() {
		return "Portfolios [portfolioID=" + portfolioID + ", userID=" + userID + ", shareID=" + shareID
				+ ", transactionID=" + transactionID + ", companyName=" + companyName + ", shareCount=" + shareCount
				+ "]";
	}
}
	
