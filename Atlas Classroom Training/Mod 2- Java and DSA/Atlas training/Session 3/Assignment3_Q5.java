public class Assignment3_Q5
{
	public static void main(String args[])
	{
		Company Amazon = new Company("Amazon");
		Employee employee[] = new Employee[2];
		employee[0] = new Employee("Shubham Srivastava",2000000);
		employee[1] = new Employee("Rashmika Mandanna",2100000);
		Amazon.setEmployee(employee);
		Amazon.companyDetails();
		
		Company Microsoft = new Company("Microsoft");
		Employee employee1[] = new Employee[1];
		employee1[0] = new Employee("Nishant Kumar",2000000);
		Microsoft.setEmployee(employee1);
		Microsoft.companyDetails();
	}
}