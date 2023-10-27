-- creating table miniProject
create database miniProject

-- creating table users
create table users
(
userid int IDENTITY(1,1) primary key,
email varchar(30) NOT NULL,
name varchar(30) NOT NULL,
userType int NOT NULL,
pwd varchar(30) NOT NULL,
constraint uni_email UNIQUE(email)
);

-- creating table railwayCrossing
create table railwayCrossing
(
	railCrossId int IDENTITY(1,1) constraint pk_rail primary key,
	name varchar(30) NOT NULL,
	address varchar(50) NOT NULL,
	status int NOT NULL,
	rail_from varchar(30) NOT NULL,
	rail_to varchar(30) NOT NULL,
	inCharge varchar(30) NOT NULL,
	constraint uni_name UNIQUE(name)
);