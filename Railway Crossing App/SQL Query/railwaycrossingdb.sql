-- Creating DATABASE
CREATE DATABASE railwaycrossingdb;

-- Creating Table User
	Create table Users(
		userID int IDENTITY(1,1),
		name nvarchar (30),
		emailID nvarchar (20) NOT null UNIQUE,
		password nvarchar (20) not null,
		userType int, -- 1 for Admin, 2 for User
		Primary Key (userID)
	);

	drop table Users;
	select * from Users;

-- Creating Table RailwayEmployees
-- This table contains details of people in charge for all RailwayCrossing
	create table RailwayEmployees(
		employeeID int IDENTITY (1,1),
		name nvarchar (30) not null,
		shiftTiming datetime,
		crossingID int not null,
		Primary Key (employeeID)
	);

	drop table RailwayEmployees
	select * from RailwayEmployees
	


-- Creating Table Railway Crossing
-- This table contains RailwayCrossing details
	Create table RailwayCrossing(
		crossingID int IDENTITY (1,1),
		address nvarchar(50),
		name nvarchar (20) NOT null,
		landmark nvarchar (20),
		status int, -- 1 for Open, 2 for Closed, 3 for Under Maintenence
		PersonInCharge int CONSTRAINT RailwayCrossing_PIC_FK REFERENCES RailwayEmployees(employeeID),
		Primary Key (crossingID)
	);

	drop table RailwayCrossing;
	select * from RailwayCrossing;

-- Creating Table Trains
-- This table contains the train details
	create table Trains(
		trainNumber varchar (5), -- 5 digit train number
		name nvarchar (30) not null,

		Primary Key(trainNumber)
	);

	drop table Trains;
	select * from Trains;

-- Creating Table Schedule
-- This table contains train schedule for all trains along with the railway crossings they cross with the time they cross that particular crossing.

	create table trainSchedule(
		scheduleID int IDENTITY(1,1),
		crossingID int CONSTRAINT trainSchedule_CID_FK REFERENCES RailwayCrossing(crossingID),
		trainNumber varchar (5) CONSTRAINT trainSchedule_TrnNo_FK REFERENCES Trains(trainNumber),
		Primary Key (scheduleID)
	);

	drop table trainSchedule;
	select * from trainSchedule;





