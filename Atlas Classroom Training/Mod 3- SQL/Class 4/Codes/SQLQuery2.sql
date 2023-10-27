-- select distinct * from employees;

-- select first_name, last_name, salary from employees where salary > 28500;

-- select first_name, last_name, salary from employees where salary < 28500 and salary > 15000;

-- select first_name, last_name, department_id from employees where department_id between 10 and 30 order by first_name ASC;

-- select first_name, last_name, hire_date from employees where hire_date like '2011%';

-- select first_name, last_name, job_id from employees where manager_id is NULL;

select first_name, last_name from employees where first_name like '__A%';