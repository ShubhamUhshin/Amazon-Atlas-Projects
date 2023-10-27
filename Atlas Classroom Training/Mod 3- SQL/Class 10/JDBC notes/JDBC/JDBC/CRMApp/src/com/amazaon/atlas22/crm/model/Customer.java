package com.amazaon.atlas22.crm.model;

// MODEL
// POJO : Plain Old Java Object :)

/*
 	
 	ORM:
 	
 	CREATE TABLE Customer(
 		cid INT PRIMARY KEY IDENTITY(1,1),
 		name NVARCHAR(256),
 		phone NVARCHAR(20),
 		email NVARCHAR(256),
 		cashBack INT
 	)

	 INSERT INTO Customer(name, phone, email, cashback) VALUES('John', '+91 99999 11111', 'john@example.com', 10)
	 SELECT * FROM Customer
 	
 */

public class Customer {

	// Attributes
	public Integer cid;
	public String name;
	public String phone;
	public String email;
	public Integer cashBack;
	
	public Customer() {
		
	}

	public Customer(Integer cid, String name, String phone, String email, Integer cashBack) {
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.cashBack = cashBack;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCashBack() {
		return cashBack;
	}

	public void setCashBack(Integer cashBack) {
		this.cashBack = cashBack;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", cashBack="
				+ cashBack + "]";
	}
}
