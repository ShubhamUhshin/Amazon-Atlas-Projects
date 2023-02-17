package com.amazon.dmataccountmanager.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.dmataccountmanager.model.Transactions;

public class TransactionDAO implements DAO<Transactions>{
	
	DB db = DB.getInstance();

	public int insert(Transactions object) {
		String sql = "INSERT INTO Transactions (shareID, userID, shareCount, pricePerShare, transactionCharges, sttCharges, type) VALUES ('"+object.shareID+"', '"+object.userID+"', '"+object.shareCount+"', '"+object.pricePerShare+"',"+object.transactionCharges+","+object.sttCharges+","+object.type+")";
		return db.executeSQL(sql);
	}
	
	//Transaction table will not be updated as its just like order history
	public int update(Transactions object) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Transactions object) {
		String sql = "DELETE FROM Transactions WHERE transactionID = '"+object.transactionID+"'";
		return db.executeSQL(sql);
	}

	public List<Transactions> retrieve() {
		String sql = "SELECT * FROM Transactions";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Transactions> transactions = new ArrayList<Transactions>();
		
		try {
			while(set.next()) {
				
				Transactions transaction = new Transactions();
				
				// Read the row from ResultSet and put the data into Transactions Object
				transaction.transactionID = set.getInt("transactionID");
				transaction.shareID = set.getInt("shareID");
				transaction.userID = set.getInt("userID");
				transaction.shareCount = set.getInt("shareCount");
				transaction.pricePerShare = set.getDouble("pricePerShare");
				transaction.transactedOn = set.getString("transactedOn");
				transaction.transactionCharges = set.getDouble("transactionCharges");
				transaction.sttCharges = set.getDouble("sttCharges");
				transaction.type = set.getInt("type");
				
				transactions.add(transaction);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return transactions;
	}

	public List<Transactions> retrieve(String sql) {
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Transactions> transactions = new ArrayList<Transactions>();
		
		try {
			while(set.next()) {
				
				Transactions transaction = new Transactions();
				
				// Read the row from ResultSet and put the data into Transactions Object
				transaction.transactionID = set.getInt("transactionID");
				transaction.shareID = set.getInt("shareID");
				transaction.userID = set.getInt("userID");
				transaction.shareCount = set.getInt("shareCount");
				transaction.pricePerShare = set.getDouble("pricePerShare");
				transaction.transactedOn = set.getString("transactedOn");
				transaction.transactionCharges = set.getDouble("transactionCharges");
				transaction.sttCharges = set.getDouble("sttCharges");
				transaction.type = set.getInt("type");
				
				transactions.add(transaction);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return transactions;
	}

}
