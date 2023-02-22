package com.amazon.buspassmanagement.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.amazon.buspassmanagement.model.Stops;

public class StopsDAO implements DAO<Stops>{

	
	DB db = DB.getInstance();
	
	@Override
	// Inserting into Stops table
	public int insert(Stops object) {
		String sql = "INSERT INTO Stops (address,sequenceOrder,routeID,adminID) VALUES ('"+object.address+"','"+object.sequenceOrder+"','"+object.routeID+"',"+object.adminID+")";
		return db.executeSQL(sql);
	}

	@Override
	// Deleting from Stops
	public int delete(Stops object) {
		String sql = "DELETE FROM Stops WHERE routeID = '"+object.routeID+"'";
		return db.executeSQL(sql);
	}

	@Override
	// Updating into Stops
	public int update(Stops object) {
		String sql = "UPDATE Stops set address = '"+object.address+"', sequenceOrder='"+object.sequenceOrder+"' , routeID='"+object.routeID +"' , adminID='"+object.adminID +"' WHERE stopID = '"+object.stopID +"'";
		return db.executeSQL(sql);
	}

	@Override
	// Retrieving all data from Stops table
	public List<Stops> retrieve() {
		
		String sql = "SELECT * from Stops";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Stops> stop = new ArrayList<Stops>();
		
		try {
			while(set.next()) {
				
				Stops stops = new Stops();
				
				// Read the row from ResultSet and put the data into User Object
				
				stops.address = set.getString("address");
				stops.sequenceOrder = set.getInt("sequenceOrder");
				stops.routeID = set.getInt("routeID");
				stops.adminID = set.getInt("adminID");
				stops.createdOn = set.getString("createdOn");
				
				stop.add(stops);
			}
		}
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
			
		return stop;
	}

	@Override
	// Retrieving data from Stops table using SQL
	public List<Stops> retrieve(String sql) {
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Stops> stop = new ArrayList<Stops>();
		
		try {
			while(set.next()) {
				
				Stops stops = new Stops();
				
				// Read the row from ResultSet and put the data into User Object
				stops.stopID = set.getInt("stopID");
				stops.address = set.getString("address");
				stops.sequenceOrder = set.getInt("sequenceOrder");
				stops.routeID = set.getInt("routeID");
				stops.adminID = set.getInt("adminID");
				stops.createdOn = set.getString("createdOn");
				
				stop.add(stops);
			}
		}
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		
		return stop;
	}
}
