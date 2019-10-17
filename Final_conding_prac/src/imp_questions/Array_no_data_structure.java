package imp_questions;

import java.util.ArrayList;

public class Array_no_data_structure {

	public static void main(String[] args) {
//		find_duplicate_and_unique_elements_array(new int[] {6,5,1,2,2,3,3,4});
		missing_elements_array(new int[] {2,6,9});

	}
	
	// array need not to be sorted, if sorted it will help but no t required
	// ONLY problem with this solution is, if number is big like 100 then we have to reserve that index
	// to avoid this problem with given solution we will have to find largest number and make that size of array, then it will work 
	public static void find_duplicate_and_unique_elements_array(int [] arr) {
		ArrayList<Integer> duplicateList = new ArrayList<Integer>();
		ArrayList<Integer> mixedList = new ArrayList<Integer>();
        int[] sorted = new int[arr.length];
        
        for (int i = 0; i< arr.length; i++){
            if (sorted[arr[i]] == arr[i])duplicateList.add(arr[i]);                
            else { sorted[arr[i]] = arr[i]; mixedList.add(arr[i]);  }   
        }
       
        System.out.println("ONLY Duplicate elements :");
        duplicateList.stream().forEach(s->System.out.println(s));
        
        System.out.println("Mixed elements :");
        mixedList.stream().forEach(s->System.out.println(s));
        
        for(int i =0; i<duplicateList.size();i++) {
        	int index = mixedList.indexOf(duplicateList.get(i));
        	mixedList.remove(index);
        }
   
        System.out.println("Unique elements :");
        mixedList.stream().forEach(s->System.out.println(s));
	}

	// here array needs to be sorted 
	public static void missing_elements_array(int[] nums) {
		
/*		int expectedSum = ((nums.length+1)*(nums[0]+nums[nums.length-1]))/2;
        
		int actualSum = 0;
        for (int num : nums) actualSum += num;

        System.out.println("Missing element is : " + (expectedSum - actualSum));*/
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=nums[0];i<=nums[nums.length-1];i++)list.add(i);
		
		for(int j=0;j<nums.length;j++) {
			int index = list.indexOf(nums[j]);
			list.remove(index);
		}
		
		System.out.println("Missing elements");
		list.stream().forEach(s->System.out.println(s));
	}
	
	
}
