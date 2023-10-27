

-- 2.	Create a report that displays the employee number, last name, and salary of all employees who earn more than the average salary. Sort the reesults in order of ascending salary.
select employee_id,last_name, salary from employees
	where salary > (select AVG (salary) from employees)
	ORDER by salary;


-- 3.	Display the last name, department number, and job ID of all employees whose department location ID is 1700.
select last_name, department_id, job_id
	from employees
	where department_id IN (select department_id from departments where location_id = 1700);