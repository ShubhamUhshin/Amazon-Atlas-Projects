package com.amazon.dmataccountmanager.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.dmataccountmanager.model.Shares;

public class ShareDAO implements DAO<Shares>{
	
	DB db = DB.getInstance();
	
	//Shares are hard-coded in the database
	public int insert(Shares object) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Shares will not be updated in the database as Share prices are fixed
	public int update(Shares object) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Shares table data is fixed
	public int delete(Shares object) {
		// TODO Auto-generated method stub
		return 0;
	}

	
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
