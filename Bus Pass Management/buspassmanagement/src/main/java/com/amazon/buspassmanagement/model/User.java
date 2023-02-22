package com.amazon.buspassmanagement.model;

/*
create table Users(
	id INT IDENTITY(1,1),
	name NVARCHAR(50) not null,
	phone NVARCHAR(20),
	email NVARCHAR(30) UNIQUE,
	password NVARCHAR(100),
	address NVARCHAR(100),
	department NVARCHAR(30),
	type INT,
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id));
*/

public class User {

	// Attributes
		public int id;
		public String name;
		public String phone;
		public String email;
		public String password;
		public String address;
		public String department;
		public int type;
		public String createdOn;
		
		public User() {
			
		}
		
		public User(int id, String name, String phone, String email, String password, String address, String department,
				int type, String createdOn) {
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.email = email;
			this.password = password;
			this.address = address;
			this.department = department;
			this.type = type;
			this.createdOn = createdOn;
		}

		// Displaying user details
		public void prettyPrint() {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Name:\t\t"+name);
			System.out.println("Phone:\t\t"+phone);
			System.out.println("Email:\t\t"+email);
			System.out.println("Address:\t"+address);
			System.out.println("Department:\t"+department);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", password=" + password
					+ ", address=" + address + ", department=" + department + ", type=" + type + ", createdOn=" + createdOn
					+ "]";
		}
		
}
