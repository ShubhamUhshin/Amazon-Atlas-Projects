// This class is created for assignment 3 Question 4
public class Dish 
{
	String dishName;
	double dishRating;
	int dishPrice;
	int dishQuantity;
	int button;
	static int totalQuantity=0;
	static int count=0;
	
	public Dish()
	{
		dishName = "Na";
		dishRating = 0;
		dishPrice = 0;
		dishQuantity = 0;
		button = 0;	
		
	}

	public Dish(String dishName, double dishRating, int dishPrice, int  dishQuantity, int button)
	{
		this.dishName=dishName;
		this.dishRating = dishRating;
		this.dishPrice = dishPrice;
		this.dishQuantity = dishQuantity;
		this.button = button;
		
		if (this.button == 1)
		{
			this.count++;
			this.totalQuantity+=this.dishQuantity; 
		}
		if (this.button == 0)
		{
			count--;
			totalQuantity-= dishQuantity;
		}
		
	}
	

	public void showOrder()
	{

		System.out.println("Order Details");
		System.out.println("~~~~~~~~~~~~~~");
		System.out.println("Dish Name="+dishName);
		System.out.println("Dish rating="+dishRating);
		System.out.println("Dish Price="+dishPrice);
		System.out.println("Dish quantity="+dishQuantity);
		System.out.println("Number of items="+count);
		System.out.println("Total quantity="+totalQuantity);
		System.out.println("~~~~~~~~~~~~~~");
				
	}
	
}
