-- CASE STUDY 2

-- CREATING DATABASE

-- Creating DataBase TennisClub
create database TennisClub;

-- 1. CREATING TABLES

	-- Creating Table PLAYERS
	create table PLAYERS
	(
		PLAYERNO smallint primary key,
		NAME varchar(30),
		INITIALS varchar(30),
		BIRTH_DATE date,
		SEX varchar(1),
		JOINED smallint,
		STREET varchar(50),
		HOUSENO varchar(5),
		POSTCODE varchar(10),
		TOWN varchar (20),
		PHONENO varchar (10),
		LEAGUENO smallint,
		CONSTRAINT check_year CHECK (JOINED>=1970),
		CONSTRAINT check_dot CHECK (INITIALS NOT LIKE '%.%'),
		CONSTRAINT check_space CHECK (CHARINDEX (' ',INITIALS) < 1) -- check for space, it returns the position of the search character in the string.
		);
		
	-- Creating Table TEAMS
	create table TEAMS
	(
		TEAMNO smallint primary key,
		PLAYERNO smallint CONSTRAINT fk_PLAYERNO_TEAMS references PLAYERS(PLAYERNO),
		DIVISION varchar (10)
	);
	-- Creating Table MATCHES
	create table MATCHES
	(
		MATCHNO smallint primary key,
		TEAMNO smallint CONSTRAINT fk_TEAMNO references TEAMS(TEAMNO),
		PLAYERNO smallint CONSTRAINT fk_PLAYERNO_MATCHES references PLAYERS(PLAYERNO),
		WON smallint,
		LOST smallint
	);

	-- Creating Table PENALTIES
	create table PENALTIES
	(
		PAYMENTNO smallint primary key,
		PLAYERNO smallint CONSTRAINT fk_PLAYERNO_PENALTIES references PLAYERS(PLAYERNO),
		PAYMENT_DATE date CONSTRAINT check_Payment_Year CHECK (PAYMENT_DATE>='1970-01-01'),
		AMOUNT money
	);

	-- Creating Table COMMITTEE_MEMBERS
	create table COMMITTEE_MEMBERS
	(
		PLAYERNO smallint CONSTRAINT fk_PLAYERNO_COMMITTEE_MEMBERS references PLAYERS(PLAYERNO),
		BEGIN_DATE date CONSTRAINT check_Begin_Date CHECK (BEGIN_DATE>='1990-01-01'),
		END_DATE date, -- CONSTRAINT check_End_Date CHECK (END_DATE>=BEGIN_DATE),
		POSITION varchar (20)
		CONSTRAINT PK_COMMITTEE_MEMBERS primary key(PLAYERNO, BEGIN_DATE)
	);
	-- Adding CONSTRAINT check_End_Date CHECK (END_DATE>=BEGIN_DATE) or null
	ALTER TABLE COMMITTEE_MEMBERS
	ADD CONSTRAINT chk_end_date CHECK ((END_DATE >= BEGIN_DATE) OR (END_DATE IS NULL));
	
/*
	DELETE FROM PLAYERS
	Drop Table COMMITTEE_MEMBERS
	Drop Table PENALTIES
	Drop Table MATCHES
	Drop Table TEAMS
	Drop Table PLAYERS
*/

-- 2. POPULATING DATA INTO TABLES

	--INSERTING INTO PLAYERS TABLE
	INSERT INTO PLAYERS
	VALUES(2,'Everett','R','1948-09-01','M',1975,'Stoney Road','43','3575NH','Stratford','070-237893',2411),
	(6,'Parmenter','R','1964-06-25','M',1977,'Haseltine Lane','80', '1234KK', 'Stratford', '070-476537',8467),
	(7, 'Wise', 'GWS', '1963-05-11', 'M', 1981, 'Edgecombe Way','39', '9758VB', 'Stratford', '070-347689',NULL),
	(8, 'Newcastle', 'B', '1962-07-08', 'F', 1980, 'Station Road', '4', '6584RO', 'Inglewood', '070-458458',2983),
	(27,'Collins','DD','1964-12-28','F',1983,'Long Drive','804','8457DK','Eltham','079-234857',2513),
	(28,'Collins','C','1963-06-22','F',1983,'Old Main Road','10','1294QK','Midhurst','071-659599',NULL),
	(39,'Bishop','D','1956-10-29','M',1980,'Eaton Square','78','9629CD','Stratford','070-393435',NULL),
	(44,'Baker','E','1963-01-09','M',1980,'Lewis Street','23','4444LJ','Inglewood','070-368753',1124),
	(57,'Brown','M','1971-08-17','M',1985,'Edgecombe Way','16','4377CB','Stratford','070-473458',6409),
	(83,'Hope','PK','1956-11-11','M',1982,'Magdalene Road','16A','1812UP','Stratford','070-353548',1608),
	(95,'Miller','P','1963-05-14','M',1972,'High Street','33A','5746OP','Douglas','070-867564',NULL),
	(100,'Parmenter','P','1963-02-28','M',1979,'Haseltine Lane','80','1234KK','Stratford','070-494593',6524),
	(104,'Moorman','D','1970-05-10','F',1984,'Stout Street','65','9437AO','Eltham','079-987571',7060),
	(112,'Bailey','IP','1963-10-01','F',1984,'Vixen Road','8','6392LK','Plymouth','010-548745',1319);

	--INSERTING INTO TEAMS TABLE
	INSERT INTO TEAMS
	VALUES(1,6,'first'),
	(2,27,'second');

	--INSERTING INTO MATCHES
	INSERT INTO MATCHES
	VALUES(1,1,6,3,1),
	(2,1,6,2,3), (3,1,6,3,0), (4,1,44,3,2),
	(5,1,83,0,3), (6,1,2,1,3), (7,1,57,3,0),
	(8,1,8,0,3), (9,2,27,3,2), (10,2,104,3,2),
	(11,2,112,2,3), (12,2,112,1,3), (13,2,8,0,3);

	--INSERTING INTO PENALTIES
	INSERT INTO PENALTIES
	VALUES(1,6,'1980-12-08', 100.00),
	(2, 44, '1981-05-05', 75.00),
	(3, 27, '1983-09-10', 100.00),
	(4, 104, '1984-12-08', 50.00),
	(5, 44, '1980-12-08', 25.00),
	(6, 8, '1980-12-08', 25.00),
	(7, 44, '1982-12-30', 30.00),
	(8, 27, '1984-11-12', 75.00);

	--INSERTING INTO COMMITTEE_MEMBERS
	INSERT INTO COMMITTEE_MEMBERS
	VALUES(2,'1990-01-01','1992-12-31','Chairman'),
	(2,'1994-01-01',null,'Member'),
	(6,'1990-01-01', '1990-12-31', 'Secretary'),
	(6, '1991-01-01', '1992-12-31', 'Member'),
	(6, '1992-01-01', '1993-12-31', 'Treasurer'),
	(6, '1993-01-01',null, 'Chairman'),
	(8, '1990-01-01', '1990-12-31', 'Treasurer'),
	(8, '1991-01-01', '1991-12-31', 'Secretary'),
	(8, '1993-01-01', '1993-12-31', 'Member'),
	(8, '1994-01-01', null, 'Member'),
	(27, '1990-01-01', '1990-12-31', 'Member'),
	(27, '1991-01-01', '1991-12-31', 'Treasurer'),
	(27, '1993-01-01', '1993-12-31', 'Treasurer'),
	(57, '1992-01-01', '1992-12-31', 'Secretary'),
	(95, '1994-01-01', null, 'Treasurer'),
	(112, '1992-01-01', '1992-12-31', 'Member'),
	(112, '1994-01-01', null, 'Secretary');

	select * from PLAYERS
	select * from TEAMS
	select * from MATCHES
	select * from PENALTIES
	select * from COMMITTEE_MEMBERS


-- 3. Querying Tables

	-- 1. Get the number, the name, and the date of birth of each player resident in Stratford; sort the result in alphabetical order of name. (Note that Stratford starts with an uppercase letter.)
	select PLAYERNO, NAME, BIRTH_DATE from PLAYERS 
	where TOWN = 'Stratford'
	ORDER BY NAME;


	-- 2. Get the number of each player who joined the club after 1980 and is resident in Stratford; order the result by player number
	select PLAYERNO from PLAYERS 
	where TOWN = 'Stratford' and JOINED > 1980
	ORDER BY PLAYERNO;

	-- 3. Get all the information about each penalty.
	select * from PENALTIES;

-- 4. Updating and Deleting Rows

	-- 1. Change the amount of each penalty incurred by player 44 to $200.
	UPDATE PENALTIES
	set AMOUNT = 200
	where PLAYERNO = 44;

	-- 2. Remove each penalty for which the amount is greater than $100. (We assume the changed contents of the PENALTIES table.)
	delete from PENALTIES
	where AMOUNT > 100;

-- 5. Optimizing Query Processing with Indexes

	-- 1. Create an index on the AMOUNT column of the PENALTIES table.
	create index AMOUNT_INDEX on PENALTIES(AMOUNT);

-- 6. Views

	-- 1. Create a view in which the difference between the number of sets won and the number of sets lost are recorded for each match.
	Create VIEW MATCH_VIEW
	as 
	select MATCHNO, TEAMNO, PLAYERNO,(WON - LOST) SCORE
	from MATCHES;

	select * from MATCH_VIEW

-- 7. Deleting Database Objects

	-- 1. Delete the MATCHES table.
	 Drop table MATCHES;

	-- 2. Delete the view NUMBER_SETS.
	DROP view MATCH_VIEW;

	-- 3. Delete the PENALTIES_AMOUNT index.
	DROP index PENALTIES.AMOUNT_INDEX;

	-- 4. Delete the TENNIS database.
	Drop Database TennisClub;

-- 8. Querying and Updating Data

	-- 1. Get the match number and the difference between sets won and sets lost for each match of which the numbers of sets won equals the number of sets lost plus 2.
	select MATCHNO, SCORE from MATCH_VIEW
	where SCORE = 2

	-- 2. Get the number and the division for each team.
	select TEAMNO, DIVISION from TEAMS;

	-- 3. Get for each team the number and the division, and use the full names.
	select TEAMNO, DIVISION from TEAMS T
	JOIN
	PLAYERS P
	on P.PLAYERNO = T.PLAYERNO;

	-- 4. For each penalty, get the payment number and the penalty amount in cents.
	select PAYMENTNO, (AMOUNT*100) from PENALTIES;

	-- 5. Change the league number of the player with number 2 to the NULL value.
	UPDATE PLAYERS
	set LEAGUENO = NULL
	where PLAYERNO = 2

	-- 6. For each team, get the number followed by the NULL value.
	select * FROM PLAYERS
	ORDER BY LEAGUENO DESC;
			/* DOUBT */

-- 9. The Aggregation Function and the Scalar Subquery

	-- 1. Find the number of each team.
	select TEAMNO from TEAMS;

	-- 2. Get the team number and the name of the captain of each team.
	select NAME from PLAYERS P
	JOIN 
	TEAMS T
	on P.PLAYERNO = T.PLAYERNO;

	-- 3. For each penalty, get the payment number, the amount of the penalty, the player number, and the name and initials of the player who incurred the penalty.
	select PT.PAYMENTNO, PT.AMOUNT, PT.PLAYERNO, P.NAME, P.INITIALS from PENALTIES PT
	JOIN
	PLAYERS P
	on PT.PLAYERNO = P.PLAYERNO;

-- 10. JOINS

	-- 1. Get the numbers of the captains who have incurred at least one penalty.
	select T.PLAYERNO from TEAMS T
	join
	PENALTIES P
	on P.PLAYERNO = T.PLAYERNO;

	-- 2. Get the numbers of the captains who have incurred at least one penalty. Remove the duplicate numbers.
	select DISTINCT T.PLAYERNO from TEAMS T
	join
	PENALTIES P
	on P.PLAYERNO = T.PLAYERNO;

	-- 3. Get the numbers of the players who are older than R. Parmenter; in this example, we assume that the combination of name and initials is unique.
	select count (PLAYERNO) from PLAYERS 
	WHERE BIRTH_DATE >  (SELECT BIRTH_DATE FROM PLAYERS where NAME = 'Parmenter'and INITIALS = 'R');

	-- 4. For all the players, find the player number, the name, and the penalties incurred by him or her; order the result by player number.
	select PE.PLAYERNO, P.NAME,PE.AMOUNT from PENALTIES PE
	join
	PLAYERS P
	on P.PLAYERNO = PE.PLAYERNO
	ORDER BY PLAYERNO;

	-- 5. For each penalty, get the payment number and the name of the player
	select PE.PAYMENTNO, P.NAME from PENALTIES PE
	join
	PLAYERS P
	on P.PLAYERNO = PE.PLAYERNO;

-- 11. Comparison Operators with Subqueries

	-- 1. Get the number and name of the player who captains team 1.
	select PLAYERNO, NAME from PLAYERS
	where PLAYERNO = (select PLAYERNO from TEAMS 
	where TEAMNO = 1);

-- 12. Aggregation Functions

	-- 1. How many league numbers are there?
	select count (LEAGUENO) as LEAGUECOUNT from PLAYERS;
	
	-- 2. What is the highest penalty?
	select MAX (AMOUNT) from PENALTIES;

	-- 3. What is the total amount of penalties incurred by players from Inglewood?
	select SUM(AMOUNT) from PENALTIES
	WHERE PLAYERNO IN (select PLAYERNO from PLAYERS where TOWN = 'INGLEWOOD');

	select SUM(AMOUNT) 
	from PENALTIES pt
	join PLAYERS pl
	on pt.PLAYERNO=pl.PLAYERNO
	where pl.TOWN='Inglewood';

	-- 4. Get the variance of all penalties incurred by player 44.
	select VAR(AMOUNT) as SUBVAR from PENALTIES
	where PLAYERNO = 44;

-- 13. Group by clause

	-- 1. For each year present in the PENALTIES table, get the number of penalties paid.
	Select count(PAYMENTNO) as YEARCOUNT, YEAR(PAYMENT_DATE) from PENALTIES
	GROUP BY YEAR(PAYMENT_DATE);

	-- 2. Get the list with the different penalty amounts in cents.
	select DISTINCT (AMOUNT * 100) as AMOUNT_IN_CENT from PENALTIES;

	-- 3. What is the average total amount of penalties for players who live in Stratford and Inglewood?
	select AVG(AMOUNT) from PENALTIES
	WHERE PLAYERNO IN (select PLAYERNO from PLAYERS where TOWN in ('INGLEWOOD','Stratford'));

	-- 4. For each player, find the sum of all his or her penalties, plus the sum of all penalties.
	select SUM(Select SUM(AMOUNT)) from PENALTIES; 

	-- 5. Get the number of each player who has incurred more than one penalty.
	select PLAYERNO from PENALTIES
	group by PLAYERNO
	having count(PLAYERNO) > 1;

-- 14. Set operators

	-- 1. Get the player number and the town of each player from Inglewood and Plymouth.
	select PLAYERNO, TOWN from PLAYERS where TOWN = 'Inglewood' OR TOWN = 'Plymouth';

	select PLAYERNO, TOWN from PLAYERS where TOWN = 'Inglewood'
	UNION ALL
	select PLAYERNO, TOWN from PLAYERS where TOWN = 'Plymouth';

	-- 2. Get the player number and the date of birth of each player who is living in Stratford and who was born after 1960.
	select PLAYERNO, BIRTH_DATE, TOWN from PLAYERS where TOWN = 'Stratford'
	INTERSECT
	select PLAYERNO, BIRTH_DATE, TOWN from PLAYERS where YEAR(BIRTH_DATE) > 1960;
	
-- 15. Index

	-- 1. Get all information about player 44. (We assume that there is an index defined on the PLAYERNO column.)
	create INDEX idx_PLAYERNO on PLAYERS(PLAYERNO)
	select * from PLAYERS where PLAYERNO = 44;

	-- 2. Create an index on the POSTCODE column of the PLAYERS table.
	create INDEX idx_POSTCODE on PLAYERS(POSTCODE);

	-- 3. Remove the three indexes that have been defined in the previous examples.
	drop INDEX PLAYERS.idx_PLAYERNO, PLAYERS.idx_POSTCODE, PENALTIES.AMOUNT_INDEX;

	-- 4. Create a multitable index on the PLAYERNO columns of the PLAYERS and MATCHES table.

			/* DOUBT */

-- 16. View

	-- 1. Create a view that holds all town names from the PLAYERS table, and show the virtual contents of this new view.
	create view TownView
	as select TOWN 
	from PLAYERS;

	-- 2. Create a view that holds the player number, name, initials, and date of birth of each player who lives in Stratford.
	create view Town_Stratford
	as select PLAYERNO, NAME, INITIALS, BIRTH_DATE 
	from PLAYERS
	WHERE TOWN = 'Stratford';

	select * from Town_Stratford;

	-- 3. Create a view that holds all players born before 1960.
	create view Before1960
	as SELECT * from PLAYERS
	where year(BIRTH_DATE) < 1960;

	select * from Before1960;

-- 17. Stored Procedures
	
	-- 1. Create a stored procedure that removes all matches played by a specific player.
	create procedure deleteMatch
	@v_playerNo int
	as
	BEGIN
		delete from MATCHES
		where PLAYERNO = @v_playerNo;
		print 'removed'
	END 

	EXEC deleteMatch 2
	

	-- 2. Create a stored procedure that calculates the total of the penalties of a certain player. After that, call the procedure for player 27.
	create procedure totalPenalties
	@v_penalties int
	as
	begin
		declare @countpenalties int
		select @countpenalties = sum(AMOUNT) from PENALTIES
		where PLAYERNO = @v_penalties;
		print @countpenalties
	end

	
	EXEC totalPenalties 27

	-- 3. Create a stored procedure with which an existing team number is entered.
	create procedure existsTeam
	@v_teamno int
	as
	begin
		declare @teamCount int
		set @teamCount = 0
		select @teamCount = count(TEAMNO) from TEAMS where TEAMNO = @v_teamno;
		if @teamCount > 0
		begin
			print 'Team Number valid'
		end
		else
		begin
			print 'Team Number Invalid'
		end
	end

	EXEC existsTeam 1
	-- 4. Create a stored procedure that counts the number of rows in the PLAYERS table.
	create procedure countRow
	as
	begin
		declare @v_count int
		select @v_count = count(PLAYERNO) from PLAYERS;
		print @v_count
	end

	EXEC countRow

	-- 5. Develop a stored procedure that adds a new team.
	create procedure addTeam
	@v_teamNo smallint,
	@v_playerNo smallint,
	@v_division varchar(10)
	as
	begin
		INSERT INTO TEAMS
		VALUES(@v_teamNo,@v_playerNo,@v_division)
		print 'inserted'
	end

	EXEC addTeam 3,2,'third'
	-- 6. Remove the DELETE_PLAYER procedure.
	drop procedure deleteMatch
	

-- 17. Stored Functions
	-- 1. Create a stored function that returns the American dollar value of the penalty amounts. After that, get for each penalty the payment number and the euro and dollar value of each penalty amount.
	create function empSalary
	(@emp_sal money)
	returns money
	as
	begin
		declare @emp_sal_in_euro money
		select @emp_sal_in_euro = @emp_sal *1.01 from PENALTIES
		return @emp_sal_in_euro
	end

	select AMOUNT,dbo.empSalary(AMOUNT) from PENALTIES

	-- 2. Create two stored functions that determine, respectively, the number of penalties and the number of matches of a certain player. After that, get the numbers, names, and initials of those players whose number of penalties is greater than the number of matches.
	create function numPenalties
	(@v_penalties int)
	returns int
	as
	begin
		declare @countpenalties int
		select @countpenalties = count(PLAYERNO) from PENALTIES
		where PLAYERNO = @v_penalties;
		return @countpenalties
	end

	-- 2. Create two stored functions that determine, respectively, the number of penalties and the number of matches of a certain player. After that, get the numbers, names, and initials of those players whose number of penalties is greater than the number of matches.



-- 18. Triggers
-- 1. Create the trigger that updates the CHANGES table automatically when rows from the PLAYERS table are removed.
	create table CHANGES
	(log_date DATE,
	log_action VARCHAR(50), id smallint);


	CREATE TRIGGER delete_tr
	ON PLAYERS
	FOR DELETE
	AS
	BEGIN
		declare @id int
		select @id = PLAYERNO from deleted
		insert into CHANGES
		VALUES(GETDATE(),'DELETE', @id)
	END

	--SELECT * FROM CHANGES
	--select * from players;
	INSERT INTO PLAYERS(PLAYERNO, NAME, INITIALS) VALUES(210, 'ABC', 'A')
	DELETE FROM PLAYERS WHERE PLAYERNO = 210
	
-- 2. Create the UPDATE_PLAYER2 trigger that updates the CHANGES table automatically if the LEAGUENO column is changed.
	CREATE TRIGGER update_tr
	ON PLAYERS
	FOR UPDATE
	AS
	BEGIN
		declare @league int
		select @league = LEAGUENO FROM inserted
		insert into CHANGES
		VALUES(GETDATE(),'UPDATE', @league)
	END

	UPDATE PLAYERS SET LEAGUENO = 8567 WHERE PLAYERNO=6

-- 3. Create a trigger on the PLAYERS table that makes sure that if a new player is added, he or she is also added to the PLAYERS_MAT table.
	create table PLAYERS_MAT
	(log_date DATE,
	log_action VARCHAR(50), id smallint);

	create TRIGGER add_player
	ON PLAYERS
	FOR INSERT
	AS
	BEGIN
		declare @pl_id int
		select @pl_id = PLAYERNO FROM inserted
		insert into PLAYERS_MAT
		VALUES(GETDATE(),'INSERT', @pl_id)
	END
	
	INSERT INTO PLAYERS(PLAYERNO, NAME, INITIALS) VALUES(210, 'ABC', 'A')