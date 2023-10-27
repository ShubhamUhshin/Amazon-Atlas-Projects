package com.amazon.atlas22.queries;

class Perumtation{
	
	void permute() {
		
	}
}

public class Recursion {

	public static void main(String[] args) {
		
		String text = "ABC";
		// -> n! permutations :)
		// ABC, ACB, BAC, BCA, CBA, CAB
		
		/*
		 				ABC						Step1 -> Original String
		 				
		 		Pick A and Swap with All
		
   Swap A with A    Swap A with B	Swap A with C
		 	ABC			BAC			CBA			Step2 -> Did some swap Operation :)

		 	
		ABC 	ACB	  BAC	BCA		CBA	  CAB	Step3 -> Did some swap Operation :)
		AB		AC	  BA    BC		CB	  CA 	-> no more further swap
		 
		 */

	}

}
