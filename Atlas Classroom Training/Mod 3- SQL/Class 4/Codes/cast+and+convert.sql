--cast and convert functions
--syntax
--CAST(expression AS datatype [length])
select concat (first_name, cast(hire_date as varchar)) from employees;
select cast(hire_date as nvarchar) from employees;
select cast(hire_date as nvarchar(4)) from employees;
select cast(hire_date as date) from employees;--extracting date part


--CONVERT(data_type(length), expression, style)
select employee_id, last_name, first_name, hire_date
from copy_emp;


select convert(nvarchar,hire_date ) from employees;
select convert(nvarchar,hire_date,1 ) from employees; --third argument is style with various constant values
select convert(nvarchar,hire_date,100 ) from employees;
select convert (date,getdate()) ;
select convert (time,getdate()) ;
select getdate();

select * from employee;
select last_name + cast(employee_id as nvarchar)as [name-id] from employee;

select last_name + ' %%%%' + first_name as 'full name' from employee;

SELECT CAST('2017-08-25' AS datetime);

/*DIFFERENCE BETWEEN CAST AND CONVERT
1. CAST is based on ANSI standards and CONVERT is specific to 
SQL SERVER,
So if portability is a concern and if you want to use the script with
other database application use CAST().
2. CONVERT() provides more flexibility than CAST. For example, it's
possible to control how you want DateTime datatype to be converted
using styles with CONVERT() function.
*/

select upper() ;

parameter , argument

function 

program :name
