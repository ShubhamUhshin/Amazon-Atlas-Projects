package com.amazon.internalclassifieds.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.internalclassifieds.model.Classifieds;

public class ClassifiedDAO implements DAO<Classifieds> {

	DB db = DB.getInstance();
	
	// Inserting into classifieds
	public int insert(Classifieds Object) {
		String sql = "INSERT INTO Classifieds (productName, headline, brand, description, status, condition, userID, categoryID, price, pictures) values ('"+Object.productName+"','"+Object.headline+"','"+Object.brand+"','"+Object.description+"',"+Object.status+",'"+Object.condition+"',"+Object.userID+","+Object.categoryID+","+Object.price+",'"+Object.pictures+"')";
		return db.executeSQL(sql);
	}

	//For Admin.
	// Deleting from classifieds table based on the classifiedID
	public int delete(Classifieds Object) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Classifieds where classifiedID = "+Object.classifiedID;
		return db.executeSQL(sql);
	}

	// Updating classified table based on the classifiedID
	public int update(Classifieds Object) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Classifieds set productName = '"+Object.productName+"', headline = '"+Object.headline+"', brand = '"+Object.brand+"', description = '"+Object.description+"', status = "+Object.status+", condition = '"+Object.condition+"', price = "+Object.price+", categoryID = "+Object.categoryID+", pictures = '"+Object.pictures+"' where classifiedID = "+Object.classifiedID;
		return db.executeSQL(sql);
	}

	// Retrieving all data from Classifieds table
	public List<Classifieds> retrieve() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from Classifieds";
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Classifieds> classifieds = new ArrayList<Classifieds>();
		
		try {
			while(set.next()) {
				
				Classifieds classified = new Classifieds();
				
				// Read the row from ResultSet and put the data into User Object
				classified.classifiedID = set.getInt("classifiedID");
				classified.productName = set.getString("productName");
				classified.brand = set.getString("brand");
				classified.categoryID = set.getInt("categoryID");
				classified.userID = set.getInt("userID");
				classified.description = set.getString("description");
				classified.headline = set.getString("headline");
				classified.price = set.getInt("price");
				classified.status = set.getInt("status");
				classified.lastUpdatedOn = set.getString("lastUpdatedOn");
				classified.pictures = set.getString("pictures");
				classified.condition = set.getString("condition");
				
				classifieds.add(classified);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return classifieds;
	}

	// Retrieving data from Classified table based on the sql query
	public List<Classifieds> retrieve(String sql) {
		// TODO Auto-generated method stub
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Classifieds> classifieds = new ArrayList<Classifieds>();
		
		try {
			while(set.next()) {
				
				Classifieds classified = new Classifieds();
				
				// Read the row from ResultSet and put the data into User Object
				classified.classifiedID = set.getInt("classifiedID");
				classified.productName = set.getString("productName");
				classified.brand = set.getString("brand");
				classified.categoryID = set.getInt("categoryID");
				classified.description = set.getString("description");
				classified.userID = set.getInt("userID");
				classified.headline = set.getString("headline");
				classified.price = set.getInt("price");
				classified.status = set.getInt("status");
				classified.lastUpdatedOn = set.getString("lastUpdatedOn");
				classified.pictures = set.getString("pictures");
				classified.condition = set.getString("condition");
				
				classifieds.add(classified);
			}
		} 
		
		catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}

		
		return classifieds;
	}

}
