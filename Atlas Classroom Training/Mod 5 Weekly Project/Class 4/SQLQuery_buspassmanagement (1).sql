create database buspassdb;

-----------------------------------------------------------------------------------------

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
	

select * from Users;

-----------------------------------------------------------------------------------------

create table Routes(
	routeID INT IDENTITY(1,1),
	title NVARCHAR(50) not null,
	description NVARCHAR(100),
	adminID INT constraint routes_id_fk references Users(id),
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(routeID));



select * from Routes;

-----------------------------------------------------------------------------------------

create table Stops(
	stopID INT IDENTITY(1,1),
	address NVARCHAR(50) NOT NULL,
	sequenceOrder INT NOT NULL,
	routeID INT constraint stops_routeID_fk references Routes(routeID),
	adminID INT constraint stops_id_fk references Users(id),
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(stopID));



select * from Stops;

-----------------------------------------------------------------------------------------

create table Vehicles(
    vehicleID INT IDENTITY(1,1),
    regNo NVARCHAR (20) NOT NULL,
    type int NOT NULL,
    filledSeats INT,
    totalSeats INT NOT NULL,
    startPickUpTime NVARCHAR (50),
    startDropOffTime NVARCHAR (50),
    vehicleAvailability bit NOT NULL,
    driverID INT NOT NULL,
    routeID INT constraint vehicle_routeID_fk references Routes(routeID),
    adminID INT constraint vehicle_id_fk references Users(id),
    createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(vehicleID));




select * from Vehicles;

-----------------------------------------------------------------------------------------

create table BusPass(
	buspassID INT IDENTITY(1,1),
	requestedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	approvedRejectedOn DATETIME,
	validTill DATETIME,
	status INT DEFAULT 1,
	userID INT constraint buspass_id_fk references Users(id),
	routeID INT constraint buspass_routeID_fk references Routes(routeID),
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(buspassID));



select * from BusPass;

-----------------------------------------------------------------------------------------

create table Feedbacks(
	feedbackID INT IDENTITY(1,1),
	userID INT constraint feedbacks_id_fk references Users(id),
	raisedBy NVARCHAR(256),
	type INT,
	title NVARCHAR(256),
	description NVARCHAR(2048),
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(feedbackID));



select * from Feedbacks;


--drop table Users;
--drop table Routes;
--drop table Stops;
--drop table Vehicles;
--drop table BusPass;
--drop table Feedbacks;