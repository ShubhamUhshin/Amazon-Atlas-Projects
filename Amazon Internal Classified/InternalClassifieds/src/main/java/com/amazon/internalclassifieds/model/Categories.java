package com.amazon.internalclassifieds.model;

import java.util.Scanner;

public class Categories {

/*
 MSSQL:
 	create table Category(
	categoryID INT IDENTITY(100,1),
	title NVARCHAR(20) NOT NULL UNIQUE,
	lastUpdatedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(categoryID));
 */
	
	public int categoryID;
	public String title;
	public String lastUpdatedOn;
	
	public Categories() {
	}

	public Categories(int categoryID, String title, String lastUpdatedOn) {
		this.categoryID = categoryID;
		this.title = title;
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
	public void prettyPrint(Categories category) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Category ID:\t"+category.categoryID);
		System.out.println("Title:\t\t"+category.title);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void getDetails(Categories category) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Category Title: ");
		String title = scanner.nextLine();
		if (!title.isEmpty())
			category.title = title;
	}

	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", title=" + title + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}
		
}

