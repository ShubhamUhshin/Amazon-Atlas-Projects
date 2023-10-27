--The HR department needs a list of countries that have no departments located in them. Display the country ID and the name of the countries. Use the set operators to create this report. 

select department_id from departments
MINUS
select department_id from employees
where job_id = 'ST_CLERK';

--The HR department needs a list of countries that have no departments located in them. Display the country ID and the name of the countries. Use the set operators to create this report. 

SELECT country_id,country_name
	FROM countries
	except
	SELECT l.country_id,c.country_name
	FROM locations l, countries c
	WHERE l.country_id = c.country_id;



