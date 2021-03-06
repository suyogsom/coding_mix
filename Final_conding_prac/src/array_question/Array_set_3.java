package array_question;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_set_3 {
	
	public static void main(String[] args) {
		
//		finding_leader_in_array(new int[] {16,17,4,3,5,2});
//		reverse_array_in_groups(new int[] {1,2,3,4},2);
//		find_kth_smallest_element_unsorted_array(new int[] {5,4,2,8,6,3},2);
//		rotate_array_right_by_some_rotations(new int[] {1,2,3,4,5,6},2);
		rotate_array_left_by_some_rotations(new int[] {1,2,3,4,5,6},2);
	}


	// Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements to its right side. 
	// And the rightmost element is always a leader.
	static void finding_leader_in_array(int[] nums) {
		
		ArrayList<Integer> list = new ArrayList<>();
		int j=0;
		
		for(int i=1;i<nums.length;i++) {			
			if(nums[i]>nums[j]) list.add(nums[i]);
				
			j++;
			
			// right most number is always a leader
			if(i==nums.length-1)list.add(nums[nums.length-1]);
		}		
		list.stream().forEach(s->System.out.println(s));
	}
	
	// Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
	// ex. [1,2,3,4] group k = 2 then output = [1,2], [3,4]
	// it is same as that of rotating array by some index 
	static void reverse_array_in_groups(int[] nums, int k) {
		int n= nums.length;
		for (int i = 0; i < n; i += k)  { 
            int left = i; 
      
            // to handle case when k is not multiple 
            // of n you can use Math.min(i+k-1, n-1)
            int right = i+ (k -1); 
            int temp; 
              
            // reverse the sub-array [left, right] 
            while (left < right) { 
                temp=nums[left]; 
                nums[left]=nums[right]; 
                nums[right]=temp; 
                left++; 
                right--; 
            } 
        } 
		Arrays.stream(nums).forEach(s->System.out.println(s));
	}

	
	static void find_kth_smallest_element_unsorted_array(int[] nums,int k) {

		Arrays.sort(nums);
		
		System.out.println(k+" th smallest element is : "+nums[k-1]);
		
	}
	
	// rotate array to right with given number of rotations
	static void rotate_array_right_by_some_rotations(int[] nums, int numOfRotations) {
		 //Rotate the given array by n times toward right
        for(int i = 0; i < numOfRotations; i++){
            int j, last;
            //Stores the last element of array
            last = nums[nums.length-1];

            for(j = nums.length-1; j > 0; j--){
                //Shift element of array by one
                nums[j] = nums[j-1];
            }
            //Last element of array will be added to the start of array.
            nums[i] = last;
        }
        System.out.println("After rotation");
        Arrays.stream(nums).forEach(s->System.out.print(s + " "));
	}
	
	// rotate array to right with given number of rotations
		static void rotate_array_left_by_some_rotations(int[] nums, int numOfRotations) {
			 //Rotate the given array by n times toward right
	        for(int i = 0; i < numOfRotations; i++){
	            int j, first;
	            //Stores the first element of array
	            first = nums[0];

	            for(j = 0; j < nums.length-1; j++){
	                //Shift element of array by one
	                nums[j] = nums[j+1];
	            }
	            //First element of array will be added to the end of array.
	            nums[nums.length-1] = first;
	        }
	        System.out.println("After rotation");
	       // System.out.println(Arrays.toString(nums));
	        Arrays.stream(nums).forEach(s->System.out.print(s + " "));
		}		
}
