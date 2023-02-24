package com.amazon.dmataccountmanager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.amazon.dmataccountmanager.userSession;
import com.amazon.dmataccountmanager.db.PortfolioDAO;
import com.amazon.dmataccountmanager.db.ShareDAO;
import com.amazon.dmataccountmanager.db.TransactionDAO;
import com.amazon.dmataccountmanager.model.Portfolios;
import com.amazon.dmataccountmanager.model.Shares;
import com.amazon.dmataccountmanager.model.Transactions;

public class TransactionManagement {
	
	double transactionCharge = 0.5/100;
	double sttCharges = 0.1/100;
	int minTransCharge = 100;
	
	Scanner scanner = new Scanner(System.in);
	Shares share = new Shares();
	Transactions transaction = new Transactions();
	Portfolios portfolio = new Portfolios();
	ShareDAO sharedao = new ShareDAO();
	TransactionDAO transactiondao = new TransactionDAO();
	PortfolioDAO portfoliodao = new PortfolioDAO();
	UserManagement userService = UserManagement.getInstance();
	PortfolioManagement portfolioService = PortfolioManagement.getInstance();
	
	
	// Creating object using Singleton design pattern
	private static TransactionManagement manageTransactions = new TransactionManagement();
	public static TransactionManagement getInstance() {
		return manageTransactions;
	}
	
	
	ShareManagement manageShares = ShareManagement.getInstance();
	UserManagement manageUser = UserManagement.getInstance();
	
	private TransactionManagement() {
	}

	public void sellTransaction() {
		// displaying the Portfolio for the user..
		portfolioService.displayPortfolio();
		String sql = "Select * from Portfolios where userID="+userSession.user.userID;
		
		if (portfoliodao.retrieve(sql).isEmpty()) {
			System.out.println("No Shares to sell");
			return;
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter the Share ID: ");
		int shareID = Integer.parseInt(scanner.nextLine());
		// Entering number of stock
		System.out.println("Enter the No.of Shares");
		int numberOfShares = Integer.parseInt(scanner.nextLine());		
		
		double totalStockPrice = 0;
		
		// Fetching the share user wants to sell
		sql = "Select * from Portfolios where shareID="+shareID;
		List<Portfolios> portfolioToUpdate = new ArrayList<Portfolios>();
		portfolioToUpdate = portfoliodao.retrieve(sql);
		if (portfolioToUpdate.isEmpty()) {
			System.err.println("No shares to sell");
			return;
		}
		
		portfolio = portfolioToUpdate.get(0);
		
		// Checking if user wants to sell all shares or some of it
		if(portfolio.shareCount >=numberOfShares) {
			// Fetching share details
			sql = "Select * from Shares where shareID="+shareID;
			List<Shares> shareDetail = new ArrayList<Shares>();
			shareDetail = sharedao.retrieve(sql);
			share = shareDetail.get(0);
			
			// Calculating tax
			double pricePerShare = share.price;
			double tax = 0;
			
			double transactionValue = 0;
			
			transactionValue = pricePerShare*numberOfShares;
			
			// condition: minimum transaction charge is Rs.100.
			if((transactionValue*transactionCharge)<=100) {
				tax = 100;
			}
			else {
				tax = transactionValue*transactionCharge;
			}
			
			// total tax including transaction charges and sttCharges
			tax = tax + (sttCharges*transactionValue);
			
			totalStockPrice = transactionValue + tax;
			
			// amount credited into user account
			userService.depositMoney(totalStockPrice);
			// Updating shareCount
			portfolio.shareCount = portfolio.shareCount - numberOfShares;
			
			// Portfolio - update function - updating shareCount in Portfolio
			if (portfolio.shareCount>0)
				if(portfoliodao.update(portfolio)>0) {
					System.out.println("Portfolio updated");
				}
				else {
					System.out.println("Something went wrong in updating the portfolio");
				}
			
			// If user sells all the stocks, we delete the share detail from his portfolio
			else {
				if (portfoliodao.delete(portfolio)>0)
					System.out.println("Portfolio updated");
				
				else {
					System.out.println("Something went wrong in updating the portfolio");
				}
			}
			
			
			// update transaction table
			
			transaction.shareID = shareID; //input from user
			transaction.shareCount = numberOfShares; //no.of shares sold
			transaction.pricePerShare = pricePerShare;
			transaction.transactionCharges = transactionCharge*transactionValue;
			transaction.sttCharges = sttCharges*transactionValue;
			transaction.type = 0;
			transaction.userID = userSession.user.userID;
			
			if(transactiondao.insert(transaction)>0) {
				System.out.println("Transaction details inserted");
			}
			else {
				System.out.println("Something went wrong while inserting the transaction details");
			}
			
			
		}else {
			System.out.println("Insufficient No.of shares to Sell");
		}
	}
	
	
	public void buyTransaction() {
		
		//displaying the Shares in the market..
		manageShares.displayShares();
		// Taking share ID as input
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter the Share ID: ");
		int shareID = Integer.parseInt(scanner.nextLine());
		// Taking number of shares as input
		System.out.println("Enter the No.of Shares");
		int numberOfShares = Integer.parseInt(scanner.nextLine());		
		
		// Retrieving share details based on shareID
		String sql = "Select * from Shares where shareID="+shareID;
		List<Shares> share = new ArrayList<Shares>();
		
		share = sharedao.retrieve(sql);
		// Calculating share price
		double totalStockPrice = share.get(0).price * numberOfShares;
			
		share = sharedao.retrieve(sql);
		
		double pricePerShare = share.get(0).price;
		double tax = 0;
		
		double transactionValue = 0;
		
		transactionValue = pricePerShare*numberOfShares;
		
		// condition: minimum transaction charge is Rs.100.
		if((transactionValue*transactionCharge)<=100) {
			tax = 100;
		}
		else {
			tax = transactionValue*transactionCharge;
		}
			
		// total tax including transaction charges and sttCharges
		tax = tax + (sttCharges*transactionValue);
		
		totalStockPrice = transactionValue + tax;
		
		// Checking if the account balance is more than tax inclusive price 
		if (userSession.user.accountBalance >= totalStockPrice){
			
			// Withdrawing money from user attack
			userService.withdrawMoney(totalStockPrice);
			
			//update transaction table
			
			transaction.shareID = shareID; //input from user
			transaction.shareCount = numberOfShares; //no.of shares sold
			transaction.pricePerShare = pricePerShare;
			transaction.transactionCharges = transactionCharge*transactionValue;
			transaction.sttCharges = sttCharges*transactionValue;
			transaction.type = 1;
			transaction.userID = userSession.user.userID;
			
			// Inserting into transaction table
			if(transactiondao.insert(transaction)>0) {
				System.out.println("Transaction details inserted");
			}
			else {
				System.out.println("Something went wrong while inserting the transaction details");
			}
			
			// Retrieving Portfolio details with the shareID.
			// If the user already has shares of the company, we are adding the shareCount
			sql = "Select * from Portfolios where userID ="+userSession.user.userID+" and shareID ="+shareID;
			List<Portfolios> portfolioToUpdate = new ArrayList<Portfolios>();			
			portfolioToUpdate = portfoliodao.retrieve(sql);
		
			if (!portfolioToUpdate.isEmpty()) {
				portfolioToUpdate.get(0).shareCount += numberOfShares;
				
				// Portfolio - update function - updating shareCount in Portfolio
				if(portfoliodao.update(portfolioToUpdate.get(0))>0) {
					System.out.println("Portfolio updated");
				}
				else {
					System.out.println("Something went wrong in updating the portfolio");
				}
			}
			
			// If the user doesn't have that particular share in his portfolio
			else {
				
				sql = "Select * from Transactions where shareID="+shareID;
				List<Transactions> transactionDetail = new ArrayList<Transactions>();
				transactionDetail = transactiondao.retrieve(sql);
				
				Portfolios portfolio = new Portfolios();
				portfolio.companyName = share.get(0).companyName;
				portfolio.shareCount = numberOfShares;
				portfolio.shareID = shareID;
				portfolio.userID = userSession.user.userID;
				portfolio.transactionID = transactionDetail.get(0).transactionID;
				
				if (portfoliodao.insert(portfolio)>0)
						System.out.println("Portfolio updated");
				
				else {
					System.out.println("Something went wrong in updating the portfolio");
				}
			}	
		}
		
		else {
			System.out.println("Insufficient Amount");
		}
	}
}