--1.	In a block, declare the following variables:

begin

-- a.	v_today and v_tomorrow of type DATE. Initialize today with system date.

	declare @v_today Date
	declare @v_tomorrow Date
	
	set @v_today = GETDATE()


	-- b.	Initialize the v_tomorrow variable with an expression, which calculates tomorrow’s date (add one to the value in today)
	
	set @v_tomorrow = GETDATE() + 1


	-- c.	Print the value of v_today and tomorrow. 

	print @v_today
	print @v_tomorrow


	--d.	Declare two additional variables: v_fname of type VARCHAR and size 15, and v_emp_sal of type DECIMAL and size 10

	declare @v_fname varchar (15)
	declare @v_emp_sal decimal(10)


	--e.	Include the a SELECT statement which retrieves the first_name and salary of employee_id 110 into respective variables.

	select v_fname = first_namec, v_emp_sal = salary from employees where employee_id = 110


	--f.	Calculate the contribution of the employee towards provident fund (PF). PF is 12% of the basic salary, and the basic salary is 45% of the salary. Use local variables for the calculation. 

	set @v_pf=(0.12*(0.45*@v_emp_sal))


	--g.	Print the employee’s salary and his or her contribution toward PF

	print @v_emp_sal
	print @v_pf

end


--2.	Create a block that selects the salary and department_id of employee_id 107. If the salary is less than 5000 than write an update statement which will increment the salary with 10% of the same employee. 
begin

	declare @dept_id Integer
	declare @emp_sal decimal
	select @emp_sal = salary, @dept_id = department_id from employees
	where employee_id = 107

	if (@emp_sal < 5000)
	begin
		Update employees
		set salary=(0.10*Salary + Salary) where employee_id = 107;
		print 'Salary incremented'
	end


end

		
--3.	Create a block which print a multiplication table of any number on the screen.

declare @multiple int, 
declare @number int
set @multiple = 1
set @number = 5
while (@multiple<=10)

begin
	
	print (@number * @multiple)
	set @multiple = @multiple + 1
	
end