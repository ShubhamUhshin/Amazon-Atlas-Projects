select employees.first_name, employees.last_name, employees.salary,
		departments.department_name, departments.department_id
from employees
inner join
departments 
on employees.department_id =departments.department_id;

select e.first_name, e.last_name, e.salary,
		d.department_name, d.department_id
from employees e
inner join
departments d
on e.department_id =d.department_id;

select e.first_name, e.last_name, e.salary,
		d.department_name, d.department_id
from employees e
 join
departments d
on e.department_id =d.department_id
and salary >10000;

select e.first_name, e.last_name, e.salary,
		d.department_name, d.department_id
from employees e
 join
departments d
on e.department_id =d.department_id
where  salary >10000;

select e.first_name, e.last_name, e.salary,
		d.department_name, l.city
from departments d
 join
employees e
on e.department_id =d.department_id
join 
locations l
on l.location_id =d.location_id;

--non-equijoin /theta join
select e.first_name, e.last_name, e.salary, sg.grade_id
from employees e
join 
salary_grade sg
on e.salary between sg.lower_sal and sg.upper_sal;

--left outer join
select e.first_name, e.salary, d.department_id, d.department_name
from departments d
 left outer join
employees e
on d.department_id =e.department_id


select e.first_name, e.salary, d.department_id, d.department_name
from departments d
right  join
employees e
on d.department_id =e.department_id
order by 4;

select e.first_name, e.salary, d.department_id, d.department_name
from departments d
full outer  join
employees e
on d.department_id =e.department_id
order by 3;

select emp.employee_id as emp_id , emp.first_name emp_name,
		emp.manager_id manager_id, manager.first_name as manager_name
from employees emp
join 
employees  manager
on emp.manager_id=manager.employee_id;

select e.employee_id, e.department_id, d.department_id, d.department_name
from employees e
cross join departments d
where e.department_id =d.department_id
order by 1;

select e.employee_id, e.department_id, d.department_id, d.department_name
from employees e
join departments d
on e.department_id =d.department_id
order by 1;