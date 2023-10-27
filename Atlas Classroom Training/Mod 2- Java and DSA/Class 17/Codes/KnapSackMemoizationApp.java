package com.amazon.atlas22.dynamicprogramming;

public class KnapSackMemoizationApp {

	int knapSack(int[] profits, int[] weights, int capacity) {
		// 2D Array to store computation results
		// We have 2 values which gets modified with each recursive call
		// 	1. Index
		//  2. Capacity
		//												[4][8]
		Integer[][] cache = new Integer[profits.length][capacity+1];
		
		return knapSackRecursiveSoln(cache, profits, weights, capacity, 0);
	}
	
	int knapSackRecursiveSoln(Integer[][] cache, int[] profits, int[] weights, int capacity, int currentIdx) {
		
		// Base Condition
		if(capacity <=0 || currentIdx>=profits.length)
			return 0;
		
		
		// Check if the data is available in the Cache or not
		if(cache[currentIdx][capacity] != null) {
			return cache[currentIdx][capacity];
		}
		
		int profit1=0, profit2=0;
		
		// Case of Inclusion i.e. Select Element
		if(weights[currentIdx] <= capacity) {
			// we can keep moving to the next element and jeep on decreasing the capacity as well
			profit1 = profits[currentIdx] + knapSackRecursiveSoln(cache, profits, weights, capacity-weights[currentIdx], currentIdx+1);
		}
		
		// Case of Exclusion i.e. Skip Element
		// Proceed without the element at the index
		profit2 = knapSackRecursiveSoln(cache, profits, weights, capacity, currentIdx+1);
		
		// Return Maximum Profit
		// Store the Data in the Cache before we return it :)
		cache[currentIdx][capacity] = (profit1 > profit2) ? profit1 : profit2; 
		return cache[currentIdx][capacity];
	}
	
	public static void main(String[] args) {
		
		int[] profits = {1, 6, 10, 16};
		int[] weights = {1, 2, 3, 5};
		
		Item item1 = new Item('A', 1, 1);
		Item item2 = new Item('B', 6, 2);
		Item item3 = new Item('C', 10, 3);
		Item item4 = new Item('D', 16, 5);
		
		Item[] items = {item1, item2, item3, item4};
		
		int capacity = 7;
				
		KnapSackBruteForceRecursionApp app = new KnapSackBruteForceRecursionApp();
		
		int maxProfit = app.knapSack(profits, weights, capacity);
		
		//int maxProfit = app.knapSack(items, capacity);
		System.out.println("Max Profit: "+maxProfit); // 22
	}

}
