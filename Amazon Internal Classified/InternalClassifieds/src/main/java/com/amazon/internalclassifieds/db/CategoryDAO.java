package com.amazon.internalclassifieds.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.amazon.internalclassifieds.model.Categories;

public class CategoryDAO implements DAO<Categories>{
	
	DB db = DB.getInstance();

	// Inserting into category
	public int insert(Categories object) {
		String sql = "INSERT INTO Category (title) VALUES ('"+object.title+"')";
		return db.executeSQL(sql);
	}

	// Updating categories based on categoryID
	public int update(Categories object) {
		String sql = "UPDATE Category set title = '"+object.title+"' WHERE categoryID = '"+object.categoryID+"'";
		return db.executeSQL(sql);
	}

	// Deleting category based on title
	public int delete(Categories object) {
		String sql = "DELETE FROM Category WHERE title = '"+object.title+"'";
		return db.executeSQL(sql);
	}

	// Retrieving all data from category table
	public List<Categories> retrieve() {
		
		String sql = "SELECT * from Category";
		
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Categories> categories = new ArrayList<Categories>();
		
		try {
			while(set.next()) {
				
				Categories category = new Categories();
				
				// Read the row from ResultSet and put the data into Categories Object
				category.categoryID = set.getInt("categoryID");
				category.title = set.getString("title");
				category.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				categories.add(category);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return categories;
	}

	// Retrieving data from Category table based on the sql query
	public List<Categories> retrieve(String sql) {
		ResultSet set = db.executeQuery(sql);
		
		ArrayList<Categories> categories = new ArrayList<Categories>();
		
		try {
			while(set.next()) {
				
				Categories category = new Categories();
				
				// Read the row from ResultSet and put the data into Categories Object
				category.categoryID = set.getInt("categoryID");
				category.title = set.getString("title");
				category.lastUpdatedOn = set.getString("lastUpdatedOn");
				
				categories.add(category);
			}
		} catch (Exception e) {
			System.err.println("Something Went Wrong: "+e);
		}
		return categories;
	}

}
