/*
+ Accessibility (Access Specifier) of a function/Method:
Private, Public, Protected, default
	Public -> Can be Accessed from anywhere
	Protected -> Can be Accessed within same package and subclass in different package
	Private -> Cannot be accessed outside the class 
	Default -> Can be Accessed within same package
	
+ Static and Non Static Methods	
	Static Methods -> Belongs to class
	Non Static -> belongs to object 
	
+ Return Type
	Void
	int,float etc.
	
+ Function/Method Overloading
	Different functions with same name but different datatypes, order or number of parameters.
	Also known as compile time Polymorphism.
	
+ Function Overriding
	These are Methods with same name in different classes, so when we call a function, the derived class is given precedence, for using method/variable of parent class, super keyword is used. 
	
/*
	 * Class A								-> Parent/Super/Base
	 * 		Method sum, difference
	 * 		Variable (String) name
	 * 
	 * Class B -> Inherits Class A			-> Child/sub/derived
	 * 		Method sum.
	 * 		Variable (String) name
	 *
	 * 
	 * + Call sum() in class B, 
	 * 		derived class (SubClass) sum will be used.
	 * 		sum of Class A -> super.sum()
	 * 		super.name;
	 */
//	+ public static void main ->
	
/*
	 * Class A								-> Parent/Super/Driver/Base
	 * 		Method sum, difference
	 * 		Variable (String) name
	 * Class B -> Inherits Class A			-> Child/sub/derived
	 * 		Method sum.
	 * 		Variable (String) name
	 *
	 * 
	 * + Call sum() in class B, 
	 * 		derived class (SubClass) sum will be used.
	 * 		sum of Class A -> super.sum()
	 * 		super.name;
	 
*/

public class Functions{
	
	
	int x;	//Global Variable/Parameter
	int y;
	
	public static void method1() {
		System.out.println("Static method");
		
	}
	
	public void method2() {
		System.out.println("Non Static void function");
		}
	
	public int method3 () {
		System.out.println("This method will return a value");
		return 1;
	}
	
	public int sum (int a, int b) {//Local variable/parameter
		return (a+b);
	}
	
	public double sum (double a, double b) {
		return (a+b);
	}
	
	public double sum (double a, int b) {
		return (a+b);
	}
	
	public double sum (int a, double b) {
		return (a+b);
	}
	
	public static void main(String args[]) {
		
		method1(); //static
		
		Functions ob = new Functions();
		
		ob.method2(); //non static void does not return anything
		
		int val;
		val = ob.method3(); // non static return type
		
		System.out.println(val);
		
		int sum1=0;
		double sum2=0,sum3=0,sum4=0;
		
		sum1 = ob.sum(5,10);
		sum2 = ob.sum(5.0,10.0);
		sum3 = ob.sum(5.0,10);
		sum4 = ob.sum(5,10.0);
		
		System.out.println("sum1 "+sum1);
		System.out.println("sum2 "+sum2);
		System.out.println("sum3 "+sum3);
		System.out.println("sum4 "+sum4);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
