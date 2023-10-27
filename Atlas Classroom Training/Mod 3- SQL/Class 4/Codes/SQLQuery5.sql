create table Bank --done
(
bank_code Integer primary key,
bank_name varchar(30),
bank_address varchar(100)
); 

create table Branch --done
(
branch# Integer,
bank_code Integer constraint bcode_fk references Bank(bank_code),
branch_name varchar(30),
branch_address varchar(30),
primary key(branch#, bank_code)
);

create table Customer --done
(
customer# Integer primary key,
customer_name varchar(30),
customer_address varchar(30),
customer_phone varchar(10)
);

create table Loan --done
(
loan# Integer primary key,
loan_type varchar(30),
branch# Integer,
bank_code Integer,
FOREIGN KEY (branch#, bank_code) references Branch(branch#, bank_code)
);

create table Account --done
(
account# Integer primary key,
account_type varchar (30),
branch# Integer,
bank_code Integer,
FOREIGN KEY (branch#, bank_code) references Branch(branch#, bank_code)
);

create table AccountHolder --done
(
account# Integer,
customer# Integer,
primary key (account#, customer#),
FOREIGN KEY (account#) REFERENCES Account(account#),
FOREIGN KEY (customer#) REFERENCES Customer(customer#)
);

create table LoanDetails --done
(
loan# Integer,
customer# Integer,
loan_amount money,
duration decimal(6,2),
date_of_sanction date,
interest_rate decimal(5,2),
primary key (loan#,customer#),
FOREIGN KEY (loan#) REFERENCES Loan(loan#),
FOREIGN KEY (customer#) REFERENCES customer(customer#)
);

--INSERTING VALUES--------------------------------
--in BANK TABLE

INSERT into Bank(bank_code, bank_name,bank_address)
VALUES(101, 'SBI', 'Patiala'),
		(102, 'HDFC', 'Ludhiana'),
		(103, 'ICICI', 'Jalandhar'),
		(104, 'Kotak', 'Sangrur'),
		(105, 'PNB', 'Moga');

select * from Bank;

--in Branch table
select * from branch;
INSERT into branch(branch#, bank_code, branch_name, branch_address)
VALUES(111, 101, 'SBI_Patiala', 'Baradari'),
		(112, 102, 'HDFC_Ludhiana', 'Near GNC'),
		(113, 101, 'SBI_Moga', 'Moga SBI'),
		(114, 104, 'Kotak_Patiala', 'Near chowk'),
		(115, 105, 'PNB_Sangrur', 'City Center');


--in account table
select * from account;

--in customer table

INSERT into customer
(customer#, customer_name, customer_address, customer_phone)
VALUES(210, 'Aman', 'Samana', '9876543210'),
		(211, 'Arjun', 'Patiala', '9598427593'),
		(212, 'Shweta', 'Sangrur', '9032784532'),
		(213, 'Arun', 'Barnala', '8990327832'),
		(214, 'Ajay', 'Sangrur', '9732675333');

-- 1.	Create a view called SALARY_VU based on the employee name, department name, salary, and salary grade for all employees. Label the columns Employee, Department, Salary, and Grade, respectively.

CREATE VIEW salary_vu
AS SELECT e.first_name "Employee",
d.department_id "Department",
e.salary "Salary",
j.grade_level "Grades"
FROM employees e,
join on 
departments d,
job_grades j
WHERE e.department_id = d.department_id
AND e.salary BETWEEN j.lowest_sal and j.highest_sal;

CREATE VIEW salary_vu1
AS SELECT e.first_name "Employee",
d.department_id "Department",
e.salary "Salary",
j.grade_level "Grades"
FROM employees e
join departments d
on e.department_id =d.department_id
join
job_grades j
on  e.salary BETWEEN j.lowest_sal and j.highest_sal; 

-- 2.	Create a view named DEPT20 that contains the employee number, first_name, and department number for all employees in department 20. Label the view column: empid, ename , deptid. Do not allow an employee to be reassigned to another department through the view. 

CREATE VIEW dept_20 AS
	SELECT employee_id empno, first_name employee,
	department_id deptno
	FROM employees
	WHERE department_id = 20
	WITH CHECK OPTION CONSTRAINT emp_dept_20;  


	CREATE Index empInd on employees(first_name ASC, last_name DESC);
	select * from employees;