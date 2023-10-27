create procedure spGetEmpDetails
as
BEGIN
	SELECT FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES
END
EXECUTE spGetEmpDetails
EXEC spGetEmpDetails
spGetEmpDetails



Create proc spGetEmpDeptDetails
@p_department_id int
as
begin
	select employee_id, department_id, salary
	from employees 
	where department_id =@p_department_id
end

exec spGetEmpDeptDetails 50
exec spGetEmpDeptDetails '60'
exec spGetEmpDeptDetails 'abc' --error

/* 1. create a procedure that takes the department_name 
from the user and shows the first_name, last_name, department_id ,
salary of all the employees working in that department.
*/

--answer 1

create procedure spGetEmpDeptDetails
@p_Department_name varchar(20)
as
Begin
select last_name, first_name, e.department_id, Salary
from employees e
join departments d
on e.department_id = d.department_id
where department_name = @v_Department_name 
End
EXEC spGetEmpDeptDetails

--better answer 1
create procedure spDeptName
@v_dept_name varchar(50)
as
BEGIN
select e.first_name, e.last_name, e.department_id, e.salary
from employees e where e.department_id = 
	(select d.department_id from departments d 
	where d.department_name = @v_dept_name);
END 

exec spDeptName 'Executive'


create procedure spTotoal_Emp
@Departmentid int,--variable, constant
@Empcount int output--variable
as
begin
	select @Empcount=count(employee_id)from employees
	where department_id=@Departmentid
end

declare @empct int
exec spTotoal_Emp 10,@empct output
print @empct

declare @empct int
declare @deptid int= 20
exec spTotoal_Emp @deptid, @empct output
print @empct


/*2.Create a procedure which takes a 
number from the user and returns the ten times 
of the same number. with encryption */

 create procedure spTimes10withOutput
@p_num smallint ,
@p_num_out int output
with encryption
as
BEGIN
set @p_num_out=@p_num*10
print @p_num_out
END 


Declare @op_num_out smallint
EXEC spTimes10withOutput 10, @op_num_out output 

sp_helptext spTimes10withOutput
sp_help spTimes10withOutput


create procedure EmpDeptCityWise
	@deptname varchar(30),
	@city varchar(20)
as
begin
	select * from employees
	where department_id =(select department_id	
							from departments where 
							department_name =@deptname
							and location_id = (select location_id
							from locations where city
							= @city));
end

--positional calling
exec EmpDeptCityWise 'Administration', 'Seattle'
--named calling
exec EmpDeptCityWise @city='Seattle', @deptname='Administration'
-- mix mode calling
exec EmpDeptCityWise 'Administration', @city='Seattle'

--text of procedure
sp_helptext EmpDeptCityWise
alter procedure EmpDeptCityWise

sp_depends employees 

create procedure add_dept
@deptid int,
@deptname varchar(30),
@manager_id int,
@location_id int
as 
begin
	insert into departments(department_id,department_name,manager_id, location_id)
	values (@deptid, @deptname,@manager_id,@location_id);
end

select * from departments 
exec add_dept 300,'abc',100,1700
select * from departments;


create a procedure that will 
update the salary of a given employee_id 

