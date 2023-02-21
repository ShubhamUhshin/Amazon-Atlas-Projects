package com.amazon.dmataccountmanager.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.dmataccountmanager.model.Shares;

public class ShareDAO implements DAO<Shares>{
	
	DB db = DB.getInstance();
	
	// Shares are hard-coded in the database
	// This is a dummy function as ShareDAO implements DAO interface
	public int insert(Shares object) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// Shares are updated using scheduler.
	// This method is automatically called and prices are randomly changed
	public int update(Shares object) {
		// TODO Auto-generated method stub
		String sql = "Update Shares SET price ="+object.price+" where ShareID = "+object.shareID;
		return db.executeSQL(sql);
	}
	
	// Shares table data is never deleted
	// This is a dummy function as ShareDAO implements DAO interface
	public int delete(Shares object) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Retrieving all data from Orders table
	public List<Shares> retrieve() {
		String sql = "SELECT * FROM Shares";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Shares> shares = new ArrayList<Shares>();
		
		try {
			while(set.next()) {
				
				Shares share = new Shares();
				
				// Read the row from ResultSet and put the data into Shares Object
				share.shareID = set.getInt("shareID");
				share.symbol = set.getString("symbol");
				share.companyName = set.getString("companyName");
				share.price = set.getInt("price");
				share.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				shares.add(share);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return shares;
	}

	// Retrieving data from Classified table based on the sql query
	public List<Shares> retrieve(String sql) {
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Shares> shares = new ArrayList<Shares>();
		
		try {
			while(set.next()) {
				
				Shares share = new Shares();
				
				// Read the row from ResultSet and put the data into Shares Object
				share.shareID = set.getInt("shareID");
				share.symbol = set.getString("symbol");
				share.companyName = set.getString("companyName");
				share.price = set.getDouble("price");
				share.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				shares.add(share);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return shares;
	}

}
