
public class Company extends Employee
{
	String  companyName;
	Employee employee[];
	static int empCount=0;
	static int compCount=0;
	
	public Company()
	{
		companyName="null";
	}
	
	public Company(String companyName)
	{
		this.companyName=companyName;
		empCount=0;
		compCount+=1;
	}

	void setEmployee(Employee[] employee)
	{
		this.employee = employee;
	}
	public void companyDetails()
	{
		System.out.println("Company Name: "+companyName);
		System.out.println("Employee ID \t Employee Name \t Employee Salary");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		for (Employee emp : employee)
		{
			emp.showEmployeeDetails();
			empCount+=1;
		}
		System.out.println("Number of employee currently working are "+empCount);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Company:"+compCount);
	}
}
