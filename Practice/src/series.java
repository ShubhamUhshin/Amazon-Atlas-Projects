
public class series {
	
	public void series1(){
		double sum = 0;
		for (double i=1; i<=20; i++) {
			sum = sum+(1/i);
		}
		
		System.out.println("sum= "+sum);
		
	}
	public static void main(String args[]) {
		series object = new series();
		object.series1();
	}
}
