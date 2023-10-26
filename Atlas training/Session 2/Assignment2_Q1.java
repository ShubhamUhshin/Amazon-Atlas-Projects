import java.util.Scanner;

public class Assignment2_Q1
{
	static void PromoCode(String EnteredPromoCode, double amount) 
	{	
		switch(EnteredPromoCode) 
		{
			case "HUNGRY":
				if(amount>=150) {
					double discount = 0.18*amount;
					
					if(discount>=40) {
						discount = 40;
					}
					System.out.println("Discount is: "+discount);
					System.out.println("Amount to be paid is: "+(amount-discount));
				}
				else {
					System.out.println("Items should be of worth atleast Rs.150");
				}
				break;
			case "WEEKEND":
				if(amount>=200) {
					double discount = 30;
					System.out.println("Flat Discount is: "+discount);
					System.out.println("Amount to be paid is: "+(amount-discount));
				}
				else {
					System.out.println("Items should be of worth atleast Rs.200");
				}
				break;
			case "FOODIE":
				if(amount>=300)  {
					double discount = 0.3*amount;
					if(discount>=70) {
						discount=70;
					}
					System.out.println("Applied discount is: "+discount);
					System.out.println("Amount to be paid is: "+(amount-discount));
				}
				else {
					System.out.println("Items should be of worth atleast Rs.300 for this code");
				}
				break;
			default:
				System.out.println("Invalid PromoCode");
		}
	}
	
	public static void main(String[] args) 
	{	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Promocode: ");
		String promocode = scanner.nextLine();	
		System.out.println("Enter the amount: ");
		double amount = scanner.nextDouble();
		scanner.close();
		Assignment2_Q1.PromoCode(promocode, amount);				
	}
}
