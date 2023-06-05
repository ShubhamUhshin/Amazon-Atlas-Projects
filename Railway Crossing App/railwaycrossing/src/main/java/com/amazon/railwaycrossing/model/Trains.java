package com.amazon.railwaycrossing.model;

/*
 * create table Trains(
		trainNumber varchar (5), -- 5 digit train number
		name nvarchar (30) not null,

		Primary Key(trainNumber)
	);
 */

public class Trains {
	
	public String trainNumber;
	public String name;
	
	public Trains() {
		// Default Constructor
	}
	
	public Trains(String trainNumber, String name) {
		this.trainNumber = trainNumber;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Trains [trainNumber=" + trainNumber + ", name=" + name + "]";
	}
}
