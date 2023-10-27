package com.amazon.atlas22.competitive;

public class AnotherBrickInTheWall {

	/*
	 	
	 	John & Jack construct wall of n bricks..
	 	
	 	Consider n is 9, i.e. John and Jack has to create a wall of 9 bricks..
	 	
	 			Brick Placed		Total Bricks
	 	John	1					1
	 	Jack	1*2 = 2				3
	 	John	2					5
	 	Jack	2*2 = 4				9
	 	
	 	Who placed the last brick => Jack
	 	How many bricks were placed in the last => 4
	 	
	 	---------------
	 	
	 	Consider n is 13, i.e. John and Jack has to create a wall of 13 bricks..
	
	 			Brick Placed		Total Bricks
	 	John	1					1
	 	Jack	1*2 = 2				3
	 	John	2					5
	 	Jack	2*2 = 4				9
	 	John	3					12
	 	Jack	3*2 = 6	| 1			13			
	 	
	 	Who placed the last brick => Jack
	 	How many bricks were placed in the last => 1
	 	
	 	
	 */
	
	static int[] placeBricks(int numOfBricks) {
		//		0th index:	John(1), Jack(2)
		//		1st index:	last bricks placed
		int[] result = {2, 1};
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] result = placeBricks(13);
		System.out.println("Last Brick Placed by: "+result[0]);
		System.out.println("Last Bricks Placed: "+result[1]);

	}

}
