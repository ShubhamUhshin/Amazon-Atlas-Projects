select employee_id, hire_date, salary*12 as 'annual salary'
from employees;
select * from employee;

condition

column  operator expression (column, constant value, formula)

select * from employees
where department_id = 90;

select * from employees
where hire_date >'2005-12-31';

select * from employees
where job_id='sa_rep';

select first_name, salary , salary*12 as annual_sal
from employees 
where salary*12>20000;

select * from employees
where first_name=last_name;


Select * from employees 
where department_id=80
AND
salary>8000;

a+b /c

select * from employees 
where salary>=20000 and salary<=25000;

select* from employees
where salary between 2501 and 9999;

select * from employees
where hire_date >='2005-01-01' and hire_date <='2005-12-31';

select * from employees
where hire_date between '2005-01-01' and '2005-12-31';

select * from employees
where department_id =10 or department_id =30 or department_id =80;

select * from employees
where department_id not IN(10,30,80);

SELECT first_name, last_name
from employees
where first_name like 'A%';

select first_name, last_name 
from employees
where last_name like '%n';

select first_name, last_name 
from employees
where last_name like '%e%';

select first_name, last_name 
from employees
where last_name not like '__e%';

select * from employees 
where hire_date  not like '%-10-%';

select * from employees
where commission_pct is not null;

select job_id, salary from employees
where (job_id='sa_rep' or job_id ='ad_pres' )and salary>15000;


select first_name , last_name, salary, hire_date , 
salary+isnull(commission_pct,0) as total_sal
from employees
order by 1 asc,2 desc;









