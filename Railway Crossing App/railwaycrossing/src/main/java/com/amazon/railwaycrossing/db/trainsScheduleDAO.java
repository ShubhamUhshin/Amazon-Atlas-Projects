package com.amazon.railwaycrossing.db;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.amazon.railwaycrossing.model.trainSchedule;

public class trainsScheduleDAO implements DAO<trainSchedule> {

	DB db = DB.getInstance();
	
	public int insert(trainSchedule Object) {
		// TODO Auto-generated method stub
		String sql = "Insert into trainSchedule (crossingID, trainNumber) values ("+Object.crossingID+",'"+Object.trainNumber+"')";
		return db.executeSQL(sql);
	}

	public int delete(trainSchedule Object) {
		// TODO Auto-generated method stub
		String sql = "Delete from trainSchedule where scheduleID = "+Object.scheduleID;
		return db.executeSQL(sql);
	}

	public int update(trainSchedule Object) {
		// TODO Auto-generated method stub
		String sql = "Update trainSchedule set crossingID = "+Object.crossingID +" and trainNumber = "+Object.trainNumber +"where scheduleID ="+Object.scheduleID;
		return db.executeSQL(sql);
	}

	public List<trainSchedule> retrieve() {
		// TODO Auto-generated method stub
		String sql = "Select * from trainSchedule";
		
		ResultSet schedule = db.executeQuery(sql);
		
		List <trainSchedule> train = new ArrayList<trainSchedule>();
		
		try {
			while (schedule.next()) {
				
				trainSchedule trainDetail = new trainSchedule();
				
				trainDetail.crossingID = schedule.getInt("crossingID");
				trainDetail.scheduleID = schedule.getInt("scheduleID");
				trainDetail.trainNumber = schedule.getString("trainNumber");
				
				train.add(trainDetail);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error in fetching train Schedule, please try again");
		}
		
		return train;
	}

	public List<trainSchedule> retrieve(String sql) {
		// TODO Auto-generated method stub
		ResultSet schedule = db.executeQuery(sql);
		
		List <trainSchedule> train = new ArrayList<trainSchedule>();
		
		try {
			while (schedule.next()) {
				
				trainSchedule trainDetail = new trainSchedule();
				
				trainDetail.crossingID = schedule.getInt("crossingID");
				trainDetail.scheduleID = schedule.getInt("scheduleID");
				trainDetail.trainNumber = schedule.getString("trainNumber");
				
				train.add(trainDetail);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error in fetching train Schedule, please try again");
		}
		
		return train;
	}

}
