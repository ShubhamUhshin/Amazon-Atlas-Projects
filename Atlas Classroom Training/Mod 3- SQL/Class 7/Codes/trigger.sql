use hr
create table audit_employee
(details nvarchar(200))

CREATE TRIGGER tr_employee_for_insert
ON Employees
FOR INSERT
AS
BEGIN
	--select * from inserted
	Declare @id int
	Select @id=employee_id from inserted
	insert into audit_employee
	values('Employee added with employee_id ='+
			Cast(@id as nvarchar(5))+ 'is added at'+
			cast(Getdate() as nvarchar(20))
		)
END
delete from employees where employee_id =200;
INSERT INTO employees VALUES 
        ( 200
        , 'Diana'
        , 'Lorentz'
        , 'DLORENTZ'
        , '590.423.5567'
        , '07-02-2007'
        , 'IT_PROG'
        , 4200
        , NULL
        , 103
        , 60
        );
SELECT * FROM audit_employee
select * from employees

create TRIGGER tr_employee_for_delete
ON Employees
FOR DELETE
AS
BEGIN
	
	Declare @id int
	--select * from deleted
	Select @id=employee_id from deleted
	insert into audit_employee
	values('Employee deleted with employee_id ='+
			Cast(@id as nvarchar(5))+ 'is deleted at'+
			cast(Getdate() as nvarchar(20))
		)
END

DELETE FROM EMPLOYEEs WHERE EMPLOYEE_ID =100;


 ALTER TRIGGER tr_employee_for_insert
ON Employees
FOR INSERT
AS
BEGIN
	--select * from inserted
	Declare @jid int
	declare @sal decimal(18,0)
	declare @minsal smallint
	declare @maxsal smallint
	select @jid=job_id, @sal =salary from inserted
	Select @minsal = min_sal, @maxsal =max_sal from job_grade
	where job_id =@jid
	if @sal not between @minsal and @maxsal
		begin
			print 'salary not in range'
		end		
END
select * from job_grade;
select * from employee;
INSERT INTO EMPLOYEE VALUES(9001,'kamal','kishore',667,7839,'2018-04-01',13000,NULL,10)


 