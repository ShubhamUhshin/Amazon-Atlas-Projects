//This is the class for Assignment 3 Question 1
import java.lang.String;
public class Employee
{
	String empID;
	String empName;
	int empSalary;
	public Employee()
	{
		empID = "";
		empName = "";
		empSalary=0;
	}
	/*
	{
		System.out.println("Employee ID \t Employee Name \t Employee Salary");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	*/
	public Employee(String empName, int empSalary)
	{
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	void showEmployeeDetails()
	{
		empID = empName.substring(0,4);
		System.out.println(empID+" \t "+empName+" \t "+empSalary);
	}
}