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