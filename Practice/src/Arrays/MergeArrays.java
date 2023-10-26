package Arrays;

import java.util.Arrays;

public class MergeArrays {
    public static void main (String args[]){
        int arr1[] = {1,3,6,8,10};
        int arr2[] = {2,4,5,7,9};
        int mergedarr[] = new int[10];
        
       /*
       	code having array out of bound exception in line 15
        int i =0, j=0, k=0;
        while(i<arr1.length && j<arr2.length){
            if (i < arr1.length && arr1[i] <= arr2[j]){
                mergedarr[k] = arr1[i];
                i++;
            }
            else{
                if(j< arr2.length){
                mergedarr[k] = arr2[j];
                  j++;
                }
            }
            k++;
        }
        
        if (i<arr1.length)
        	mergedarr[k] = arr1[i];
        
        if (j<arr2.length)
        	mergedarr[k] = arr2[j];
        
       for (int l=0; l<mergedarr.length; l++){
           System.out.println(mergedarr[l]);
       }   
        */
        
        /*
        Approach 1:
        We copy all the data from arr1 and arr2 into mergedarr
        We sort the mergedarr
        TC: Onlogn, where n = arr1.length + arr2.length
        int i,k=0;
        for (i=0;i<arr1.length;i++) {
        	mergedarr[k] = arr1[i]; 
        	k++;
        }
        
        for (i = 0; i < arr2.length; i++) {
        	mergedarr[k] = arr2[i]; 
        	k++;
        }
        
        Arrays.sort(mergedarr);
        
        for (i = 0; i < mergedarr.length; i++)
            System.out.println(mergedarr[i]);
        */
        
        /*
        Approach 2
        Using while loop we add the array elements in the mergedarr
        TC: O(n), where n = arr1.length + arr2.length
        int i = 0, k = 0, j = 0;
        while (i < arr1.length || j < arr2.length) {
        	
        	// If both the arrays still have elements left
        	if (i<arr1.length && j < arr2.length) {
        		
        		// Checking if ith arr1 element is less than or greater than arr2 element.
        		if (arr1[i] <= arr2[j]){
                    mergedarr[k] = arr1[i];
                    i++;
                }
                else{  
                    mergedarr[k] = arr2[j];
                      j++;
                   
                }
        	}
        	
        	else if (i<arr1.length) {
        		mergedarr[k] = arr1[i];
                i++;
        	}
        	
        	else {
        		mergedarr[k] = arr2[j];
                j++;
			}
        	k++;
        }
        
        */
    }
}

