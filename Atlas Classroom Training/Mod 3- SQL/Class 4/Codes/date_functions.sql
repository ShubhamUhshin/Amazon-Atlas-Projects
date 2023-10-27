select current_timestamp;

select GETDATE();

select SYSDATETIME();
select SYSDATETIMEOFFSET();

select datename(day,getdate());
select datename(weekday,getdate());
select datename(year,getdate());
select datepart(second,getdate());
select datepart(month,getdate());

select datepart(day, hire_date), hire_date from employees;

select day(getdate());
select month(getdate());
select year(getdate());

select datediff(day,'2022-07-25',getdate()) as number_of_days;

select datediff(month,'2021-07-25',getdate()) as number_of_month;

select datediff(year,'2021-07-25',getdate()) as number_of_year;

select dateadd(day,1,getdate()) as new_date;
select dateadd(month,1,getdate()) as new_date;
select dateadd(MINUTE,10,getdate()) as new_date;

select EOMONTH(getdate());
select eomonth(hire_date), hire_date from employees;

--help
select  switchoffset (CONVERT(datetimeoffset, GETDATE()), '-04:00');   
SELECT TODATETIMEOFFSET (getdate(), '-07:00');  



SELECT DATEFROMPARTS( 2010, 12, 31 ) AS Result;  

--DATETIME2FROMPARTS ( year, month, day, hour, minute, seconds, fractions, precision ) 
SELECT DATETIME2FROMPARTS ( 2010, 12, 31, 23, 59, 59, 0, 0 ) AS Result;   
--DATETIMEOFFSETFROMPARTS ( year, month, day, hour, minute, seconds, fractions, hour_offset, minute_offset, precision ) 
SELECT DATETIMEOFFSETFROMPARTS ( 2010, 12, 31, 14, 23, 23, 0, 12, 0, 7 ) AS Result; 
--TIMEFROMPARTS ( hour, minute, seconds, fractions, precision )
SELECT TIMEFROMPARTS ( 23, 59, 59, 0, 0 ) AS Result;  

SET DATEFORMAT mdy;  
--system variable 
SELECT ISDATE('04/15/2008'); --Returns 1. 

SELECT ISDATE('15/04/2008'); --Returns 0.  

SET DATEFORMAT dmy;  
SELECT ISDATE('15/04/2008'); --Returns 1.  

select substring('abcdef',2,2);
select last_name, substring(last_name, 4,2) as subpart from employee;






salary : money
		number