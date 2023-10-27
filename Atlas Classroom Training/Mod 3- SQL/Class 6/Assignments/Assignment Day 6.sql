-- Create a block that selects the maximum department ID in the departments table and stores it in the v_max_deptno variable. Display the maximum department ID.

	begin
		declare @v_max_deptno int;
		select @v_max_deptno =  max(department_id) from departments;
		print @v_max_deptno;
	end

-- 2 a. Declare two variables: v_dept_name of type departments.department_name and v_dept_id of type NUMBER

	begin
		declare @v_dept_name varchar(30);
		declare @v_dept_id int;
	end

-- 2 b. Assign 'Education' to v_dept_name in the declarative section.
	set @v_dept_name = 'Education';

-- 2 c. You have already retrieved the current maximum department number from the departments table. Add 10 to it and assign the result to v_dept_id.
	begin
		declare @v_max_deptno int;
		declare @v_dept_id int;
		select @v_max_deptno =  max(department_id) from departments;
		set @v_dept_id = @v_max_deptno + 10;
		print @v_dept_id
	end

-- 2 d. Include an INSERT statement to insert data into the department_name, department_id, and location_id columns of the departments table.
--	 e. Use values in dept_name and dept_id for department_name and department_id, respectively, and use NULL for location_id.
	begin
		declare @v_dept_name varchar(30);
		declare @v_dept_id int;
		declare @v_max_deptno int;
		select @v_max_deptno =  max(department_id) from departments;
		set @v_dept_name = 'Education';
		set @v_dept_id = @v_max_deptno + 10;
		insert into departments (department_name, department_id, location_id)
		values (@v_dept_name,@v_dept_id,null)
	end

-- 3. Create a block which selects the salary of a given employee_id and raise the salary on the basis of following table:
	BEGIN
		declare @v_emp_id int;
		declare @v_emp_salary int;
		set @v_emp_id = 110;
		select @v_emp_salary = salary from employees where employee_id = @v_emp_id;
		if @v_emp_salary >= 1000 and @v_emp_salary <= 5000
			set @v_emp_salary = @v_emp_salary * 0.1 + @v_emp_salary;
		else if @v_emp_salary > 5000 and @v_emp_salary <= 10000
			set @v_emp_salary = @v_emp_salary * 0.08 + @v_emp_salary;
		else if @v_emp_salary > 10000 and @v_emp_salary <= 15000
			set @v_emp_salary = @v_emp_salary * 0.06 + @v_emp_salary;
		else if @v_emp_salary > 15001 and @v_emp_salary <= 20000
			set @v_emp_salary = @v_emp_salary * 0.05 + @v_emp_salary;
		else
			set @v_emp_salary = @v_emp_salary;
		update employees 
		set salary = @v_emp_salary where employee_id = @v_emp_id;
	END

	select * from employees;

--PROCEDURE

	-- 1. Create a procedure called ADD_JOB to insert a new job into the JOBS table. Provide the ID and job title using two parameters.
create procedure addJob
@jobID varchar(10),
@jobTitle varchar(35)  
as
begin
	insert into JOBS (job_id,job_title) values(@jobID, @jobTitle)
end

exec addJob 'CashDouble', 'LaxmiChitFund' 
select * from jobs

-- 2. Create a procedure called GET_EMPLOYEE to query the EMPLOYEES table, provided with the EMPLOYEE_ID and returns SALARY and JOB_ID.
create procedure GET_EMPLOYEE
@empID int
as
BEGIN
	select salary,job_id from EMPLOYEES where employee_id = @empID
END

exec GET_EMPLOYEE 102

select * from employees


-- Function
	--1. Create a function called GET_ANNUAL_COMP to return the annual salary computed from an employee’s monthly salary and commission passed as parameters.
		--a) Create the GET_ANNUAL_COMP function, which accepts parameter values for the monthly salary and commission. Either or both values passed can be NULL, but the function should still return a non-NULL annual salary. Use the following basic formula to calculate the annual salary: (salary*12) + (commission_pct*salary*12)
Create FUNCTION GET_ANNUAL_COMP 
(@monthly_Sal int NULL, @commission_Sal decimal (8,2) NULL)
returns decimal (8,2)
as 
Begin
	declare @f_monthlySal int
	declare @f_commissionSal decimal (8,2)
	declare @f_annualSal decimal (8,2)

	set @f_monthlySal = @monthly_Sal
	set @f_commissionSal = @commission_Sal
	

	if (@monthly_Sal is NULL)
	BEGIN
		set @f_monthlySal = 150;
	END

	if (@commission_Sal is NULL)
	BEGIN
		set @f_commissionSal = 0.2;
	END


	set @f_annualSal = (@f_monthlySal*12) + (@f_commissionSal*@f_monthlySal*12);
	return @f_annualSal
END


declare @annualSal decimal (8,2)
SET @annualSal = dbo.GET_ANNUAL_COMP(NULL,0.1)
print @annualSal

	-- b. Use the function in a SELECT statement against the EMPLOYEES table for employees in department 30.
select dbo.GET_ANNUAL_COMP (salary, commission_pct) from EMPLOYEES where department_id = 30;

--TRIGGERS
	--1. Create a table with following script: CREATE TABLE DML_LOG ( log_date DATE , action VARCHAR(50));
CREATE TABLE DML_LOG ( log_date DATE , action VARCHAR(50));

-- 2. Create a trigger, EVAL_CHANGE_TRIGGER, which adds a row to the table DML_LOG whenever an INSERTor DELETE statement changes the DEPARTMENTS table. Note: log_date column stores the date of DML operation and action column stores the event name (INSERT or DELETE).
CREATE TRIGGER EVAL_CHANGE_TRIGGER  
    ON departments  
    AFTER INSERT, DELETE  
AS  
BEGIN  
  
    IF NOT EXISTS(SELECT * FROM INSERTED)  
        -- DELETE  
        INSERT into DML_LOG(log_date,action) values (GETDATE(),'DELETE');  
    ELSE  
    BEGIN  
        IF NOT EXISTS(SELECT * FROM DELETED)  
            -- INSERT  
            INSERT into DML_LOG(log_date,action) values (GETDATE(),'INSERT');  
    END  
END; 
