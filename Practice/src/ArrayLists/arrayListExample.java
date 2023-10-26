package ArrayLists;
/*
 	Why ArrayList?
 		Example, in a class a new student joins in mid term,
 		if we use arrays, we have to create a new array and
 		copy the values. For large number of data, this is not
 		feasible. So, we use Arraylist, where the size is
 		dynamic.
 -> Size not fixed, i.e. dynamic allocation.
 -> Non Continuous memory.
 
 -> It works on wrapper class of collection Framework.
*/

import java.util.ArrayList;
import java.util.Collections;

public class arrayListExample {
	public static void main(String[]  args) {
		
		ArrayList <Integer> list = new ArrayList<>();
		// Array -> int, double, string and objects.
		// ArrayList -> wrapper classes -> Integer
		ArrayList <Integer> list2 = new ArrayList<>();
		
		//add into the arrayList
		list.add(5);
		list.add(35);
		list.add(20);
		list.add(12);
		list.add(3,6);//list.add(index,value);
		System.out.println(list);
		list2.add(101);
		list2.addAll(list);
		//list.addAll(list2); suppose list2 is another ArrayList.
		//This method adds list2 at the end of list.
		
		ArrayList <Integer> list3 = new ArrayList<Integer>(list.subList(1,4));
		System.out.println("list 3 = "+list3);
		
		//get a value
		int element = list.get(1);//list.get(index)
		System.out.println(element);
		
		System.out.println(list.subList(1,3));
		//sublist -> substring(from(inclusive),to(exclusive))
		
		// set a value
		list.set(2, 15); //list.set(index,value)
		System.out.println(list);
		//Remove a value
		list.remove(2);//list.remove(index)
		System.out.println(list);
		list.clear();//deletes every value
		System.out.println(list);
		System.out.println(list2);
		Collections.sort(list);
		System.out.println(list2.contains(101));
		/*
		// Size of an arraylist
		int length = list.size();
		System.out.println(length);
		//looping
		for (int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// Sorting
		Collections.sort(list,Collections.reverseOrder());
		//Descending order
		System.out.println(list);
		Collections.sort(list);
		//By Default it is in Ascending order
		System.out.println(list);
		*/
	}

}
