package com.amazon.buspassmanagement.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.buspassmanagement.model.Feedbacks;

public class FeedbacksDAO implements DAO<Feedbacks> {

	
	DB db = DB.getInstance();
	
	public int insert(Feedbacks object) {
		String sql = "INSERT INTO Feedbacks (userID, title, description, type, raisedBy) "
				+ "VALUES ( "+object.userID+", '"+object.title+"', '"+object.description+"', "+object.type+", '"+object.raisedBy+"')";
		return db.executeSQL(sql);
	}
	
	// Since it is not required.
	// Feedbacks cannot be altered.
	public int update(Feedbacks object) {
		String sql = "UPDATE Feedbacks set type = '"+object.type+"'WHERE feedbackID = '"+object.feedbackID +"'";
		return db.executeSQL(sql);
	}

	public int delete(Feedbacks object) {
		String sql = "DELETE from Feedbacks WHERE feedbackID = "+object.feedbackID;
		return db.executeSQL(sql);
	}

	public List<Feedbacks> retrieve() {
		String sql = "SELECT * from Feedbacks";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Feedbacks> feedbacks = new ArrayList<Feedbacks>();
		
		try {
			while(set.next()) {
				
				Feedbacks feedback = new Feedbacks();
				
				// Read the row from ResultSet and put the data into Object
				feedback.feedbackID = set.getInt("feedbackID");
				feedback.userID = set.getInt("userID");
				feedback.raisedBy = set.getString("raisedBy");
				feedback.type = set.getInt("type");
				feedback.title = set.getString("title");
				feedback.description = set.getString("description");
				feedback.createdOn = set.getString("createdOn");
				
				feedbacks.add(feedback);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return feedbacks;
	}

	public List<Feedbacks> retrieve(String sql) {
				
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Feedbacks> feedbacks = new ArrayList<Feedbacks>();
		
		try {
			while(set.next()) {
				
				Feedbacks feedback = new Feedbacks();
				
				// Read the row from ResultSet and put the data into Object
				feedback.feedbackID = set.getInt("feedbackID");
				feedback.userID = set.getInt("userID");
				feedback.raisedBy = set.getString("raisedBy");
				feedback.type = set.getInt("type");
				feedback.title = set.getString("title");
				feedback.description = set.getString("description");
				feedback.createdOn = set.getString("createdOn");
				
				feedbacks.add(feedback);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return feedbacks;
	}

}
 