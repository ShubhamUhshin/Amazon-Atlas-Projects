package com.amazon.buspassmanagement.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.buspassmanagement.model.Routes;

public class RoutesDAO implements DAO<Routes> {

	public RoutesDAO() {
		// TODO Auto-generated constructor stub
	}
	
	DB db = DB.getInstance();
	
	@Override
	// Insert into Routes
	public int insert(Routes object) {
		String sql = "INSERT INTO Routes (title,description,adminID) VALUES ('"+object.title+"','"+object.description+"',"+object.adminID+")";
		return db.executeSQL(sql);
	}

	@Override
	// Deleting from Routes
	public int delete(Routes object) {
		String sql = "DELETE FROM Routes WHERE routeID = '"+object.routeID+"'";
		return db.executeSQL(sql);
	}

	@Override
	// Updating into Routes
	public int update(Routes object) {
		String sql = "UPDATE Routes set title = '"+object.title+"', description='"+object.description+"' , adminID='"+object.adminID +"' WHERE routeID = '"+object.routeID +"'";
		return db.executeSQL(sql);
	}

	@Override
	// Retrieving all data from Routes table 
	public List<Routes> retrieve() {
		String sql = "SELECT * from Routes";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Routes> route = new ArrayList<Routes>();
		
		try {
			while(set.next()) {
				
				Routes routes = new Routes();
				
				// Read the row from ResultSet and put the data into User Object
				routes.routeID = set.getInt("routeID");
				routes.title = set.getString("title");
				routes.description = set.getString("description");
				routes.adminID = set.getInt("adminID");
				routes.createdOn = set.getString("createdOn");
				
				route.add(routes);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		return route;
	}

	@Override
	// Retrieving data from Routes based on SQL query
	public List<Routes> retrieve(String sql) {
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Routes> route = new ArrayList<Routes>();
		
		try {
			while(set.next()) {
				
				Routes routes = new Routes();
				
				// Read the row from ResultSet and put the data into User Object
				routes.routeID = set.getInt("routeID");
				routes.title = set.getString("title");
				routes.description = set.getString("description");
				routes.adminID = set.getInt("adminID");
				routes.createdOn = set.getString("createdOn");
				
				route.add(routes);
			}
		}
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return route;
	}

}
