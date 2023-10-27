CREATE VIEW	empvu30
AS SELECT	employee_id, last_name, salary  FROM	employees
WHERE	department_id = 30;  

CREATE VIEW	salvu50
AS 
SELECT	employee_id ID_NUMBER, last_name NAME,  salary*12 ANN_SALARY
FROM	employees
WHERE	department_id = 50;  

SELECT *
FROM	salvu50;



CREATE VIEW dept_sum_vu
(name, minsal, maxsal, avgsal)
AS SELECT	d.department_name, MIN(e.salary),  MAX(e.salary),AVG(e.salary)
FROM	employees e, departments d
WHERE	e.department_id = d.department_id  GROUP BY	d.department_name;

--nonupdatable view
CREATE VIEW EMP_DEPT_VIEW
AS
SELECT employee_id, last_name, salary,department_name
from employees
join 
departments
on employees.department_id=departments.department_id;
select * from EMP_DEPT_VIEW;

Update EMP_DEPT_VIEW
SET salary = salary *.01, department_name = 'IT'
WHERE Salary <5000;
--Error:
--View or function 'EMP_DEPT_VIEW' is not --updatable because the modification affects --multiple base tables.

insert into emp_dept_view(employee_id, last_name, salary, dname)
values (111,'Roger',10000,'IT');
--Error:
--View or function 'EMP_DEPT_VIEW' is not 
--updatable because the modification affects 
--multiple base tables.

--with check option

drop view empvu20;
CREATE VIEW empvu20  AS 
SELECT	*
FROM	employees
WHERE	department_id = 20
with check option;

select * from empvu20;

update empvu20
set department_id=30
where employee_id =202;




Update employee set department_id =30
where department_id =20;

--The attempted insert or update failed because 
--the target view either specifies WITH CHECK OPTION 

--alter view

ALTER VIEW EMP_DEPT_VIEW
AS
SELECT employee_id, last_name, salary,hire_date,dname
from employee
join 
department
on employee.department_id=department.department_id;


--DROP VIEW 

DROP VIEW EMP_DEPT_VIEW











