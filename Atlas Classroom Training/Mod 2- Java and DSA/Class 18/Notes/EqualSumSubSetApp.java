package com.amazon.atlas22.dp;

import java.util.Arrays;

public class EqualSumSubSetApp {
	
	
	boolean canPartition(int[] set) {
		
		// Add all the Elements to check if sum is even or odd
		int sum = Arrays.stream(set).sum();
		System.out.println("For Set "+Arrays.toString(set)+" Sum is: "+sum);
		
		// Validation if we can solve the problem or not
		if(sum%2 != 0)
			return false;
		
		return canPartition(set, sum/2, 0);
	}
	
	// Overloading the method :)
	boolean canPartition(int[] set, int sum, int currentIdx) {

		if(sum == 0)
			return true; // :)
		
		if(set.length == 0 || currentIdx >= set.length)
			return false;
		
		if(set[currentIdx] <= sum) {
			// Include the Element :)
			if(canPartition(set, sum-set[currentIdx], currentIdx+1)) {
				return true; // finally we can return true in case the sum will be 0 at the end :)
			}
		}
		
		// Exclude the Element :)
		return canPartition(set, sum, currentIdx+1);
	}

	public static void main(String[] args) {

		int[] set1 = {1, 2, 3, 4}; 		// ->  {2, 3} AND {1, 4} -> TRUE :)
		int[] set2 = {2, 3, 4, 6};		// SUM is ODD -> FALSE
		int[] set3 = {1, 1, 3, 4, 7}; 	// -> {1, 3, 4} AND {1, 7} -> TRUE :)
		
		EqualSumSubSetApp app = new EqualSumSubSetApp();
		System.out.println("Can Set1 "+Arrays.toString(set1)+" be Partitioned: "+app.canPartition(set1)+"\n");
		System.out.println("Can Set2 "+Arrays.toString(set2)+" be Partitioned: "+app.canPartition(set2)+"\n");
		System.out.println("Can Set3 "+Arrays.toString(set3)+" be Partitioned: "+app.canPartition(set3)+"\n");
		

	}

}
