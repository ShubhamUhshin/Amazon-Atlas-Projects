package com.amazon.railwaycrossing.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
// This will be used by ADMIN only to add a new Railway Crossing or Delete a Railway Crossing which is closed
import java.util.List;

import com.amazon.railwaycrossing.model.RailwayCrossing;

public class RailwayCrossingDAO implements DAO<RailwayCrossing> {

	DB db = DB.getInstance();
	public int insert(RailwayCrossing Object) {
		// TODO Auto-generated method stub
		String sql = "Insert into RailwayCrossing (address, name, landmark, status, personInCharge) VALUES ('"+Object.address +"','"+Object.name +"','"+Object.landmark +"'," +Object.status +","+Object.personInCharge +")"; 
		return db.executeSQL(sql);
	}
;
	// Admin can Delete a railway crossing on the basis of crossingID
	public int delete(RailwayCrossing Object) {
		// TODO Auto-generated method stub
		String sql = "Delete from RailwayCrossing where crossingID = "+Object.crossingID; 
		return db.executeSQL(sql);
	}

	// Admin can update the Address, name, status for a crossingID
	public int update(RailwayCrossing Object) {
		// TODO Auto-generated method stub
		String sql = "UPDATE RailwayCrossing set address = '"+Object.address+"', name = '"+Object.name+"', landmark = '"+Object.landmark +"', status = " +Object.status +" where crossingID = "+Object.crossingID;
		return db.executeSQL(sql);
	}

	public List<RailwayCrossing> retrieve() {
		// TODO Auto-generated method stub
		String sql = "Select * from RailwayCrossing";
		
		List <RailwayCrossing> crossingList = new ArrayList<RailwayCrossing>();
		
		ResultSet crossing = db.executeQuery(sql);
		
		try {
			while (crossing.next()) {
				
				RailwayCrossing railwayCrossing = new RailwayCrossing();
				
				railwayCrossing.crossingID = crossing.getInt("crossingID");
				railwayCrossing.address = crossing.getString("address");
				railwayCrossing.landmark = crossing.getString("landmark");
				railwayCrossing.name = crossing.getString("name");
				railwayCrossing.personInCharge = crossing.getInt("personInCharge");
				railwayCrossing.status = crossing.getInt("status");
				
				crossingList.add(railwayCrossing);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error in Fetching Data");
		}
		
		return crossingList;
	}

	public List<RailwayCrossing> retrieve(String sql) {
		// TODO Auto-generated method stub
		
		ResultSet crossing = db.executeQuery(sql);
		
		List <RailwayCrossing> crossingList = new ArrayList<RailwayCrossing>();
		
		try {
			while (crossing.next()) {
				
				RailwayCrossing railwayCrossing = new RailwayCrossing();
				
				railwayCrossing.crossingID = crossing.getInt("crossingID");
				railwayCrossing.address = crossing.getString("address");
				railwayCrossing.landmark = crossing.getString("landmark");
				railwayCrossing.name = crossing.getString("name");
				railwayCrossing.personInCharge = crossing.getInt("personInCharge");
				railwayCrossing.status = crossing.getInt("status");
				
				crossingList.add(railwayCrossing);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error in Fetching Data");
		}
		
		return crossingList;
	}
}
