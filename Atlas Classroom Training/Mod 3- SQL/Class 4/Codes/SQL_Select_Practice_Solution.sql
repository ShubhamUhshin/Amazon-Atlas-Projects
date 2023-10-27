select * from employees

--1. Distinct job title from employee table
select distinct job_id from employees;

-- 2.	Create a query to display the name and salary of employees earning more than $28500.

select first_name, last_name, salary from employees 
where salary > 28500;


-- 3.	Display the name and salary for all employees whose salary is not in the range of $15000 and $28500

select first_name, last_name,salary from employees
where not(salary > 15000 and salary < 28500);

select first_name, last_name,salary from employees
where salary not between 15000 and 28500;


-- 4.	Display the employee full name and department number of all employees in departments 10 and 30 in alphabetical order by name.

select first_name, last_name, department_id from employees
where department_id between 10 and 30
order by first_name 

-- 5. 	Display the name and hire date of every employee who was hired in 2011.


select first_name, last_name, hire_date from employees
where hire_date like '2011%';

-- 6.	Display the name and job title of all employees who do not have a manager.

select first_name, last_name, job_id, manager_id from employees
where manager_id is NULL

-- 7.	Display the names of all employees where the third letter of their name is an A.

select first_name, last_name from employees
where first_name like '__A%'