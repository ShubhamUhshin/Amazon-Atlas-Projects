import java.util.*;
public class test {
	
	public static Double mathCheck(String price) {
		String newPrice;
		if (price.contains(",")) {
			newPrice = price.replace(",", "");
		}
		
		else {
			newPrice = price;
		}
		
		return Math.floor(Double.parseDouble(newPrice));
		
		//return Math.floor(Double.parseDouble(price));
	}
	public static  void main(String args[]) {
		/*
		ArrayList <Integer> answer = new ArrayList<>();
	    int[] nums1 = {1,2,3,0,0,0};
	    int[] nums2 = {2,5,6};
	    int m = nums1.length;
	    int n = nums2.length;
		int index1 = 0;
	    int index2 = 0; 
	    Collections.synchronizedCollection(answer);
	    for (int i=0; i<m; i++){
	    	System.out.print(i);
	    	if (m == 0){
	    		answer.add(nums2[index2]);
	            index2++;
	        }
	        else if (n == 0){
	        	answer.add(nums1[index1]);
	            index1++;
	            }
	    	
	        else if (nums1[index1] > nums2[index2]){
	             answer.add(nums2[index2]);
	             index2++;
	         }
	
	         else if(nums1[index1] < nums2[index2]){
	             answer.add(nums1[index1]);
	             index1++; 
	         }
	     }
	     Collections.sort(answer);
	     System.out.print(answer+"\t works"); // \n -> new line \t -> tab
	*/
		/*
		StringBuilder sb = new StringBuilder("\033[1m");
        sb.append("Please Bold Ho ja").append("\033[0m");
        System.out.println(sb.toString());
        System.out.println("Please Bold Ho ja");
        
		
		int [][] a = new int [5][5];
		a[0] = new int [10];
		for(int i=0;i<2;i++)
			for (int j=0;j<2;j++)
				System.out.println(a[i][j]);
				*/
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		String number = scanner.nextLine();
		int num;
		if (!number.isBlank())
			num = Integer.parseInt(number);
		else
			num = 0;
		System.out.println(number);
		System.out.println(num);
		scanner.close();
		*/
		
		String price  = "1005.99";
		Double answer = mathCheck(price);
		System.out.println(answer);
		
	}
}
