package com.amazon.railwaycrossing.db;

//Only Admin can use this

import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

import com.amazon.railwaycrossing.model.RailwayEmployees;

public class RailwayEmployeesDAO implements DAO <RailwayEmployees> {

	DB db = DB.getInstance();
	public int insert(RailwayEmployees Object) {
		// TODO Auto-generated method stub
		String sql = "Insert into RailwayEmployees (name, shiftTiming, crossingID) Values ('"+Object.name+"','"+Object.shiftTime+"','"+Object.crossingID;
		return db.executeSQL(sql);
	}

	// The Admin can remove the employee based on the employee ID
	public int delete(RailwayEmployees Object) {
		// TODO Auto-generated method stub
		String sql = "Delete from RailwayEmployees where employeeID =" +Object.employeeID;
		return db.executeSQL(sql);
	}

	public int update(RailwayEmployees Object) {
		// TODO Auto-generated method stub
		String sql = "Update RailwayEmployees set name = '"+Object.name+"', shiftTiming = '"+Object.shiftTime+"', crossingID = '"+Object.crossingID +"' where employeeID ="+Object.employeeID;
		return db.executeSQL(sql);
	}

	public List<RailwayEmployees> retrieve() {
		// TODO Auto-generated method stub
		
		String sql = "Select * from RailwayEmployees";
		ResultSet employeeList = db.executeQuery(sql);
		
		List <RailwayEmployees> railwayEmployees = new ArrayList<RailwayEmployees>();
		
		try {
			while (employeeList.next()) {
				
				RailwayEmployees employee = new RailwayEmployees();
				
				employee.crossingID = employeeList.getInt("crossingID");
				employee.employeeID = employeeList.getInt("employeeID");
				employee.name = employeeList.getString("name");
				employee.shiftTime = employeeList.getString("shiftTime");
				
				railwayEmployees.add(employee);
			}
		}
		catch(Exception e) {
			System.err.println("Unable to Fetch EmployeeList");
		}
		
		return railwayEmployees;
	}

	public List<RailwayEmployees> retrieve(String sql) {
		// TODO Auto-generated method stub
		
		ResultSet employeeList = db.executeQuery(sql);
		
		List <RailwayEmployees> railwayEmployees = new ArrayList<RailwayEmployees>();
		
		try {
			while (employeeList.next()) {
				
				RailwayEmployees employee = new RailwayEmployees();
				
				employee.crossingID = employeeList.getInt("crossingID");
				employee.employeeID = employeeList.getInt("employeeID");
				employee.name = employeeList.getString("name");
				employee.shiftTime = employeeList.getString("shiftTime");
				
				railwayEmployees.add(employee);
			}
		}
		catch(Exception e) {
			System.err.println("Unable to Fetch EmployeeList");
		}
		
		return railwayEmployees;
	}

}
