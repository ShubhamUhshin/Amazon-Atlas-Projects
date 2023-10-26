// Atlas muffin Question

import java.util.*;
public class MuffinTime {
	
	public int solve_function(int k, int[] muffins) {
		int count = 0;
		int i=0;
		
		while (muffins[k]!=0){
			if (i== muffins.length)
				i=0;
			
			if (muffins[i] == 0)
				i++;
			
			else {
				count++;
				muffins[i]-=1;
				i++;
			}
		}
		
		
		return count;
	}
	
	public static void main(String args[]) {
		/*int k = 2;
		int [] arr = {2,3,2};
		int time = 0;
		MuffinTime Time = new MuffinTime();
		time = Time.solve_function(k,arr);
		System.out.println(time);
		*/
		byte num= (byte)0b000_1000;

		if (num >> 1 > 6 || true)

		System.out.print(num);

		else

		System.out.println(num>>1);

	}

}
