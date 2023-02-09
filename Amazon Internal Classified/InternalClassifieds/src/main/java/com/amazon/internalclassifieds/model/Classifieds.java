package com.amazon.internalclassifieds.model;

import java.util.Scanner;

/*
	classifiedID INT IDENTITY(1,1),
	userID INT constraint classifieds_userID_fk references Users(userID)
	categoryID INT constraint classifieds_categoryID_fk references Category(categoryID), 
	status INT NOT NULL, 
	headline NVARCHAR(100) NOT NULL, 
	productName NVARCHAR(50) NOT NULL, 
	brand NVARCHAR(25) NOT NULL, 
	condition NVARCHAR(50), 
	description NVARCHAR(100), 
	price INT NOT NULL, 
	pictures NVARCHAR(100), 
	lastUpdatedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(classifiedID));
 */
public class Classifieds {
	
	//Attributes
	public int userID;
	public int classifiedID;
	public int categoryID;
	public int status;
	public String headline;
	public String productName;
	public String brand;
	public String condition;
	public String description;
	public int price;
	public String pictures;
	public String lastUpdatedOn;
	
	public Classifieds() {
		
	}
	
	
	
public Classifieds(int userID, int classifiedID, int categoryID, int status, String headline, String productName,
			String brand, String condition, String description, int price, String pictures, String lastUpdatedOn) {
		this.userID = userID;
		this.classifiedID = classifiedID;
		this.categoryID = categoryID;
		this.status = status;
		this.headline = headline;
		this.productName = productName;
		this.brand = brand;
		this.condition = condition;
		this.description = description;
		this.price = price;
		this.pictures = pictures;
		this.lastUpdatedOn = lastUpdatedOn;
	}



public void getDetails(Classifieds classified) {
		
	   Scanner scanner = new Scanner(System.in);

       classified.status = 2;

       System.out.println("Enter Headline: ");
       String headline = scanner.nextLine();
       if (!headline.isEmpty())
           classified.headline = headline;

       System.out.println("Enter Product Name: ");
       String productName = scanner.nextLine();
       if (!productName.isEmpty())
           classified.productName = productName;

       System.out.println("Enter Brand: ");
       String brand = scanner.nextLine();
       if (!brand.isEmpty())
           classified.brand = brand;

       System.out.println("Enter Product's Condition: ");
       String condition = scanner.nextLine();
       if (!condition.isEmpty())
           classified.condition = condition;

       System.out.println("Enter Product's Description: ");
       String description = scanner.nextLine();
       if (!description.isEmpty())
           classified.description = description;

       System.out.println("Enter Product's Picture URL: ");
       String pictures = scanner.nextLine();
       if (!description.isEmpty())
           classified.pictures = pictures;

       System.out.println("Enter Product's Price: ");
       String price = scanner.nextLine();
       if (!description.isEmpty())
           classified.price = Integer.parseInt(price);
       
		}

	public void prettyPrintForAdmin(Classifieds classifieds) {
       
		System.out.println("~~~~~");
        System.out.println("User ID:\t"+classifieds.userID);
        System.out.println("Classified ID:\t"+classifieds.classifiedID);
        System.out.println("Category ID:\t"+classifieds.categoryID);
        System.out.println("Headline:\t"+classifieds.headline);
        System.out.println("Product Name:\t"+classifieds.productName);
        System.out.println("Description:\t"+classifieds.description);
        System.out.println("Brand:\t\t"+classifieds.brand);
        System.out.println("Condition:\t"+classifieds.condition);
        System.out.println("Price:\t\t"+classifieds.price);
        System.out.println("Pictures:\t"+classifieds.pictures);
        
        if (classifieds.status == 1)
        	System.out.println("Status:\t\tApproved");
        else if (classifieds.status == 0)
        	System.out.println("Status:\t\tRejected");
        else if(classifieds.status == 2)
        	System.out.println("Status:\t\tPending for Admin Approval");
        
        System.out.println("~~~~~");
    }
	
	public void prettyPrintForUser(Classifieds classifieds) {
        System.out.println("~~~~~");
        System.out.println("Classified ID:\t"+classifieds.classifiedID);
        System.out.println("Category ID:\t"+classifieds.categoryID);
        System.out.println("Headline:\t"+classifieds.headline);
        System.out.println("Product Name:\t"+classifieds.productName);
        System.out.println("Description:\t"+classifieds.description);
        System.out.println("Brand:\t\t"+classifieds.brand);
        System.out.println("Condition:\t"+classifieds.condition);
        System.out.println("Price:\t\t"+classifieds.price);
        System.out.println("Pictures:\t"+classifieds.pictures);
        
        if (classifieds.status == 1)
        	System.out.println("Status:\t\tUp For Sale");
        else if (classifieds.status == 0)
        	System.out.println("Status:\t\tRejected");
        else if (classifieds.status == 2)
        	System.out.println("Status:\t\tPending for Admin Approval");
        else if (classifieds.status == 3)
        	System.out.println("Status:\t\tSold");
        
        System.out.println("~~~~~");
    }

	@Override
	public String toString() {
		return "Classifieds [userID=" + userID + ", classifiedID=" + classifiedID + ", categoryID=" + categoryID
				+ ", status=" + status + ", headline=" + headline + ", productName=" + productName + ", brand=" + brand
				+ ", condition=" + condition + ", description=" + description + ", price=" + price + ", pictures="
				+ pictures + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}	
}
