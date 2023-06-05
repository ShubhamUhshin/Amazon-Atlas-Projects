package com.amazon.railwaycrossing.db;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import com.amazon.railwaycrossing.model.Trains;

public class TrainsDAO implements DAO <Trains>{

	DB db = DB.getInstance();
	
	public int insert(Trains Object) {
		// TODO Auto-generated method stub
		String sql ="Insert into Trains (trainNumber, name) values ('"+Object.trainNumber+"','"+Object.name+"')";
		return db.executeSQL(sql);
	}

	public int delete(Trains Object) {
		// TODO Auto-generated method stub
		String sql = "Delete from Trains where trainNumber = '"+Object.trainNumber+"'";
		return db.executeSQL(sql);
	}

	public int update(Trains Object) {
		// TODO Auto-generated method stub
		String sql = "Update Trains set name = '"+Object.name+" where trainNumber = '"+Object.trainNumber+"'";
		return db.executeSQL(sql);
	}

	public List<Trains> retrieve() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * from Trains";
		
		ResultSet trainList = db.executeQuery(sql);
		
		List <Trains> trains = new ArrayList<Trains>();
		
		try {
			while (trainList.next()) {
				
				Trains trainDetails = new Trains();
				
				trainDetails.name = trainList.getString("name");
				trainDetails.trainNumber = trainList.getString("trainNumber");
				
				trains.add(trainDetails);
			}
		}
		
		catch(Exception e) {
			System.err.println("Error while fetching Data");
		}
		
		return trains;
	}

	public List<Trains> retrieve(String sql) {
		// TODO Auto-generated method stub
		ResultSet trainList = db.executeQuery(sql);
		
		List <Trains> trains = new ArrayList<Trains>();
		
		try {
			while (trainList.next()) {
				
				Trains trainDetails = new Trains();
				
				trainDetails.name = trainList.getString("name");
				trainDetails.trainNumber = trainList.getString("trainNumber");
				
				trains.add(trainDetails);
			}
		}
		
		catch(Exception e) {
			System.err.println("Error while fetching Data");
		}
		
		return trains;
	}

}
