import java.util.Scanner;

interface AppleProduct{
	String getModel();
	String getMemory();
	String getColor();
	String getStorage();
	int getPrice();
}

class MacBook implements AppleProduct{

	@Override
	public String getModel() {
		return "Macbook Air Pro";
	}

	@Override
	public String getMemory()
	{
		return "8GB";
	}
	
	public String getColor()
	{
		return "Midnight";
	}
	
	@Override
	public String getStorage() {
		return "256GB SSD";
	}
	
	@Override
	public int getPrice() {
		return 300000;
	}
	
}

class IPhone implements AppleProduct{
	
	public String getModel() {
		return "IPHONE 14 Pro";
	}

	@Override
	public String getMemory()
	{
		return "8GB";
	}
	
	public String getColor()
	{
		return "Deep Purple";
	}
	
	@Override
	public String getStorage() {
		return "128 GB";
	}
	
	@Override
	public int getPrice() {
		return 150000;
	}
}

// Decorator Design Pattern
abstract class ProductDecorator implements AppleProduct{
	
	AppleProduct Product; // Has-A Relationship with FoodItem :)

	// Which FoodItem to be Decorated:)
	public ProductDecorator(AppleProduct Product) {
		this.Product = Product;
	}
	
	@Override // Returns the Description of Decorated FoodItem
	public String getModel() {
		return Product.getModel();
		}

		@Override
		public String getMemory()
		{
			return Product.getMemory();
		}
		
		public String getColor()
		{
			return Product.getColor();
		}
		
		@Override
		public String getStorage() {
			return Product.getStorage();
		}
		
		@Override
		public int getPrice() {
			return Product.getPrice();
		}
	}

class MacBook_16GB extends ProductDecorator{
	
	MacBook_16GB(AppleProduct Product){
		super(Product);
	}
	
	@Override
	public String getModel() {
		return "Macbook Air Pro";
	}

	@Override
	public String getMemory()
	{
		return "16 GB";
	}
	
	public String getColor()
	{
		return "Midnight";
	}
	
	@Override
	public String getStorage() {
		return "256GB SSD";
	}
	
	@Override
	public int getPrice() {
		return 315000;
	}
	
}

class MacBook_512GB_SSD extends ProductDecorator{
	
	MacBook_512GB_SSD(AppleProduct Product){
		super(Product);
	}
	
	@Override
	public String getModel() {
		return "Macbook Air Pro";
	}

	@Override
	public String getMemory()
	{
		return "16 GB";
	}
	
	public String getColor()
	{
		return "Midnight";
	}
	
	@Override
	public String getStorage() {
		return "512GB SSD";
	}
	
	@Override
	public int getPrice() {
		return 330000;
	}
	
}
/*
class VegWrapMeal extends FoodDecorator{
	
	VegWrapMeal(FoodItem item){
		super(item);
	}
	
	@Override
	public String getDescription() { 
		// Perform Decoration Here
		return item.getDescription()+"!! Your Veg Wrap Upgraded to a Meal with Coke and Potato Nuggets";
	}

	@Override
	public int getPrice() {	
		// Perform Decoration Here
		return item.getPrice()+80;
	}
}
*/

public class AppleStore {

	public static void main(String[] args) {
		
		MacBook Product = new MacBook();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Would you like to upgrade your Storage to 16 GB ? (yes/no)");
		String choice = scanner.nextLine();
		
		
		if(choice.equalsIgnoreCase("yes")) {
			System.out.println("Would you like to upgrade your HDD to 512 GB ? (yes/no)");
			String choice1 = scanner.nextLine();
			scanner.close();
			if(choice1.equalsIgnoreCase("yes")) {
				ProductDecorator MB_512GB = new MacBook_512GB_SSD(Product);
				System.out.println(MB_512GB.getModel());
				System.out.println(MB_512GB.getMemory()+" Unified Memory");
				System.out.println(MB_512GB.getStorage()+" Storage");
				System.out.println(MB_512GB.getColor()+" Color");
				System.out.println("Please Pay to Proceed....");
			}
			else {
				ProductDecorator MB8GB = new MacBook_16GB(Product);
				System.out.println(MB8GB.getModel());
				System.out.println(MB8GB.getMemory()+" Unified Memory");
				System.out.println(MB8GB.getStorage()+" Storage");
				System.out.println(MB8GB.getColor()+" Color");
				System.out.println("Please Pay to Proceed....");
		}
		}
			else
			{
				System.out.println(Product.getModel());
				System.out.println(Product.getMemory()+" Unified Memory");
				System.out.println(Product.getStorage()+" Storage");
				System.out.println(Product.getColor()+" Color");
				System.out.println("Please Pay to Proceed....");
			}
	}
}


