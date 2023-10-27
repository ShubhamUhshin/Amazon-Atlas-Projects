import java.util.Scanner;

public class Assignment2_Q2 
{
	
	static void calculateFair(String source, String dest, int distance, String cab, int duration) {
		
		if(source.equalsIgnoreCase(dest)) {
			System.out.println("Source and destination shouldn't be same");
		}
		else {
			if(cab.equalsIgnoreCase("bike")) {
				double baseFair = 15;
				int km = 10;
				double min = 0.25;
				double amount = baseFair+(km*distance)+(min*duration);
				System.out.println("fair to be paid is: "+amount);
			}
			else if(cab.equalsIgnoreCase("auto")) {
				double baseFair = 20;
				int km = 15;
				double min = 0.5;
				double amount = baseFair+(km*distance)+(min*duration);
				System.out.println("fair to be paid is: "+amount);
			}
			else if(cab.equalsIgnoreCase("mini")) {
				double baseFair = 30;
				int km = 20;
				double min = 1;
				double amount = baseFair+(km*distance)+(min*duration);
				System.out.println("fair to be paid is: "+amount);
			}
			else if(cab.equalsIgnoreCase("sedan")) {
				double baseFair = 50;
				int km = 30;
				double min = 2;
				double amount = baseFair+(km*distance)+(min*duration);
				System.out.println("fair to be paid is: "+amount);
			}
			else {
				System.out.println("The following are supported \n bike \n auto \n mini \n sedan");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the Source Area: ");
		String source = scanner.nextLine();
		
		System.out.println("Enter your destination: ");
		String dest = scanner.nextLine();
		
		System.out.println("Enter the distance: ");
		int distance = scanner.nextInt();
		
		scanner.nextLine();
		System.out.println("Enter the type of cab: ");
		String cab = scanner.nextLine();
		
		System.out.println("Enter the duration of the trip in minutes: ");
		int duration = scanner.nextInt();
		
		Assignment2_Q2.calculateFair(source,dest,distance,cab,duration);

	}

}
