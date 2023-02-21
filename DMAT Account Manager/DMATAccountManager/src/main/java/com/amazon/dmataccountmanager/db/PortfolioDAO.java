package com.amazon.dmataccountmanager.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.dmataccountmanager.model.Portfolios;

public class PortfolioDAO implements DAO<Portfolios>{
	
	DB db = DB.getInstance();

	// Inserting into Portfolios table
	public int insert(Portfolios object) {
		String sql = "INSERT INTO Portfolios (userID, shareID, transactionID, companyName, shareCount) VALUES ('"+object.userID+"', '"+object.shareID+"', '"+object.transactionID+"', '"+object.companyName+"',"+object.shareCount+")";
		return db.executeSQL(sql);
	}
	
	// Updating Portfolio
	// This function is used when user buys or sells some of his shares
	public int update(Portfolios object) {
		String sql = "UPDATE Portfolios SET shareCount = "+object.shareCount+" WHERE shareID = '"+object.shareID+"'";
		return db.executeSQL(sql);
	}

	// Deleting from Portfolios table
	public int delete(Portfolios object) {
		String sql = "DELETE FROM Portfolios WHERE userID = "+object.userID+" and shareID = "+object.shareID;
		return db.executeSQL(sql);
	}

	// Retrieving all data from Portfolio table
	public List<Portfolios> retrieve() {
		String sql = "SELECT * FROM Portfolios";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Portfolios> portfolios = new ArrayList<Portfolios>();
		
		try {
			while(set.next()) {
				
				Portfolios portfolio = new Portfolios();
				
				// Read the row from ResultSet and put the data into Portfolios Object
				portfolio.portfolioID = set.getInt("portfolioID");
				portfolio.userID = set.getInt("userID");				
				portfolio.shareID = set.getInt("shareID");
				portfolio.transactionID = set.getInt("transactionID");
				portfolio.companyName = set.getString("companyName");
				portfolio.shareCount = set.getInt("shareCount");
				
				portfolios.add(portfolio);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return portfolios;
	}

	// Retrieving data from Portfolio table based on the sql query
	public List<Portfolios> retrieve(String sql) {
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Portfolios> portfolios = new ArrayList<Portfolios>();
		
		try {
			while(set.next()) {
				
				Portfolios portfolio = new Portfolios();
				
				// Read the row from ResultSet and put the data into Portfolios Object
				portfolio.portfolioID = set.getInt("portfolioID");
				portfolio.userID = set.getInt("userID");				
				portfolio.shareID = set.getInt("shareID");
				portfolio.transactionID = set.getInt("transactionID");
				portfolio.companyName = set.getString("companyName");
				portfolio.shareCount = set.getInt("shareCount");
				
				portfolios.add(portfolio);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return portfolios;
	}

}
