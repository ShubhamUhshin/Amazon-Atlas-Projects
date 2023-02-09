create database classifiedsdb;

-----------------------------------------------------------------------------------------

create table Users(
	userID INT IDENTITY(1,1),
	name NVARCHAR(50) NOT NULL,
	phone NVARCHAR(20) NOT NULL UNIQUE,
	email NVARCHAR(30) NOT NULL UNIQUE,
	password NVARCHAR(100) NOT NULL,
	address NVARCHAR(100),
	userType INT NOT NULL, --(1-Admin, 2-User)
	userStatus BIT NOT NULL, --(1-Active, 0 InActive)
	createdOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(userID));
	
drop table Users;

select * from Users; 

-----------------------------------------------------------------------------------------

create table Category(
	categoryID INT IDENTITY(100,1),
	title NVARCHAR(20) NOT NULL UNIQUE,
	lastUpdatedOn DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY(categoryID));

drop table Category;

select * from Category;

--Trigger to update "lastUpdatedOn" column on any updation.
CREATE TRIGGER tgrAfterUpdateCategory ON Category
AFTER UPDATE 
AS
  UPDATE Category set lastUpdatedOn=CURRENT_TIMESTAMP 
  FROM 
  Category
  INNER JOIN INSERTED  
  ON Category.title = INSERTED.title;

DROP TRIGGER tgrAfterUpdateCategory

-----------------------------------------------------------------------------------------

create table Classifieds(
	classifiedID INT IDENTITY(1,1), 
	categoryID INT constraint classifieds_categoryID_fk references Category(categoryID),
	userID INT constraint classifieds_userID_fk references Users(userID),
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

drop table Classifieds;

select * from Classifieds;

--Trigger to update "lastUpdatedOn" column on any updation.
CREATE TRIGGER tgrAfterUpdateClassifieds ON Classifieds
AFTER UPDATE 
AS
  UPDATE Classifieds set lastUpdatedOn = CURRENT_TIMESTAMP 
  FROM 
  Classifieds
  INNER JOIN INSERTED 
  ON Classifieds.classifiedID = INSERTED.classifiedID;

DROP TRIGGER tgrAfterUpdateClassifieds

-----------------------------------------------------------------------------------------

create table Orders(
	orderID INT IDENTITY(1,1),
	classifiedID INT constraint orders_classifiedID_fk references Classifieds(classifiedID),
	fromUserID INT constraint orders_sellerUserID_fk references Users(userID), 
	toUserId INT constraint orders_buyerUserID_fk references Users(userID),
	proposedPrice INT NOT NULL,
	status INT NOT NULL, 
	lastUpdatedOn DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(orderID));

drop table Orders;

select * from Orders;

--Trigger to update "lastUpdatedOn" column on any updation.
CREATE TRIGGER tgrAfterUpdateOrders ON Orders
AFTER UPDATE 
AS
  UPDATE Orders set lastUpdatedOn = CURRENT_TIMESTAMP 
  FROM 
  Orders
  INNER JOIN INSERTED 
  ON Orders.orderID = INSERTED.orderID;

DROP TRIGGER tgrAfterUpdateOrders

-----------------------------------------------------------------------------------------