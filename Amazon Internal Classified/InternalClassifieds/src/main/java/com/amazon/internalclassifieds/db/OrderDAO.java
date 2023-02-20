package com.amazon.internalclassifieds.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.amazon.internalclassifieds.model.Orders;

public class OrderDAO implements DAO <Orders>{

	DB db = DB.getInstance();
	
	// Inserting into Orders table
	public int insert(Orders Object) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Orders (classifiedID, fromUserID, toUserId, proposedPrice, status) VALUES ("+Object.classifiedID+", "+Object.fromUserID+", "+Object.toUserID+", "+Object.proposedPrice+", "+Object.status+")";
		return db.executeSQL(sql);
	}

	// Deleting from Orders table
	// This function is a dummy function as we have implemented DAO.
	// This function is never used
	public int delete(Orders Object) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Orders where classifiedID = "+Object.classifiedID;
		return db.executeSQL(sql);
	}

	// This function is a dummy function as we have implemented DAO.
	// This function is never used
	public int update(Orders Object) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Retrieving all data from Orders table
	public List<Orders> retrieve() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from Orders";
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Orders> orders = new ArrayList<Orders>();
		
		try {
			while(set.next()) {
				
				Orders order = new Orders();
				
				// Read the row from ResultSet and put the data into User Object
				order.classifiedID = set.getInt("classifiedID");
				order.orderID = set.getInt("orderID");
				order.fromUserID = set.getInt("fromUserID");
				order.toUserID = set.getInt("toUserID");
				order.proposedPrice = set.getInt("proposedPrice");
				order.status = set.getInt("status");
				order.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				orders.add(order);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return orders;
	}

	// Retrieving data from Classified table based on the sql query
	public List<Orders> retrieve(String sql) {
		// TODO Auto-generated method stub

		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Orders> orders = new ArrayList<Orders>();
		
		try {
			while(set.next()) {
				
				Orders order = new Orders();
				
				// Read the row from ResultSet and put the data into User Object
				order.classifiedID = set.getInt("classifiedID");
				order.orderID = set.getInt("orderID");
				order.fromUserID = set.getInt("fromUserID");
				order.toUserID = set.getInt("toUserID");
				order.proposedPrice = set.getInt("proposedPrice");
				order.status = set.getInt("status");
				order.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				orders.add(order);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return orders;
	}

}
