package array_question;

import java.util.ArrayList;
import java.util.List;

public class leet_code_array_set_1 {

	public static void main(String[] args) {
		
		// this logic can be use to move any elements to end or front depending on situation
		// this will be done without creating new array
//		move_zeroes_to_end(new int[] {0,1,2,0,11});
//		move_zeroes_to_end_new(new int[] {0,1,2,0,11});
//		move_zeroes_to_front(new int[] {0,1,2,0,11});
//		majority_element(new int[] {3,2,3});
//		maximum_subarray_sum(new int[] {-2,1,-3,4,-1,2,1,-5,4});
//		pascal_triangle(5);
//		valid_mountain_array(new int[] {0,5,4,1});
//		valid_mountain_array_new(new int[] {3,5,4});
//		duplicate_value_array(new int[] {1,2,3,1});
//		power_of_two(4);
//		two_sum(new int[] {2,7,11,15},9);

	}
	
	// move all zeroes to end of the array
	static void move_zeroes_to_end(int[] nums) {
	       int s = 0;
	        for (int i=0; i < nums.length; i++) {
	            if (nums[i] != 0) {
	                if (nums[s] == 0) {
	                    int tmp = nums[i];
	                    nums[i] = 0;
	                    nums[s] = tmp;
	                }
	                s++;
	           }
	      }
	     
	     for(int x: nums)System.out.println(x);
	 }
	
	// logic is if value at current index is not zero then replace it to indexed value
	// and once done with that just add zeros to remaining indices  
	static void move_zeroes_to_end_new(int[] nums) {
		int index = 0;
		for(int i=0;i<nums.length;i++) 
			 if(nums[i]!=0)
			    nums[index++] = nums[i];
		
		
		for(int i=index; i<nums.length;i++)nums[i]=0;
		
		for(int x: nums)System.out.println(x);
	}
	
	// move all zeroes to front of the array
	static void move_zeroes_to_front(int[] nums) {
	       int s = nums.length-1;
	        for (int i=nums.length-1; i >=0 ; i--) {
	            if (nums[i] != 0) {
	                if (nums[s] == 0) {
	                    int tmp = nums[i];
	                    nums[i] = 0;
	                    nums[s] = tmp;
	                }
	                s--;
	           }
	      }
	     
	     for(int x: nums)System.out.println(x);
	 }
	
	// Boyer-Moore Voting Algorithm
	// find out an element which appears more than (n/2) times in an array
	static void majority_element(int[] nums) {
		 int count = 0, candidate = 0;

	        for(int i: nums){
				// new candidate once count is zero
	            if(count == 0)
	                candidate = i;
	            
	           // if element is same as candidate increase count
	           // if element is not candidate then decrease count
	            count += (candidate == 1) ? 1 : -1 ;
	        }

	        System.out.println(candidate);
	}
	
	// Given an integer array nums, 
	// find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	static void maximum_subarray_sum(int[] nums) {
		
		int currMax=nums[0], maxSoFar=nums[0];
        
		for(int i=1; i<nums.length; i++){
			currMax = Math.max(nums[i], currMax+nums[i]);
			maxSoFar = Math.max(currMax, maxSoFar);
		}
		System.out.println(maxSoFar); 
	}
	
	// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
	static void pascal_triangle(int numRows) {
		List<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();

        // First base case; if user requests zero rows, they get zero rows.
        if (numRows == 0) {
            return;
        }

        // Second base case; first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
        	ArrayList<Integer> row = new ArrayList<>();
        	ArrayList<Integer> prevRow = triangle.get(rowNum-1);

            // The first row element is always 1.
            row.add(1);

            // Each triangle element (other than the first and last of each row)
            // is equal to the sum of the elements above-and-to-the-left and
            // above-and-to-the-right.
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // The last row element is always 1.
            row.add(1);

            triangle.add(row);
        }
        
        triangle.stream().forEach(s->System.out.println(s));
	}

	// two criteria, 1. nums.length>=3 and array will be first increasing and then decreasing 
	// here assumption is that increasing and decreasing elements are same in number
	// time complexity is n^2
	static void valid_mountain_array(int[] nums) {
		boolean result = true; int count1=0, count2=0;
		
		if(nums.length<3) result = false;
		
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]<nums[j])count1++;
				else if(nums[i]>nums[j])count2++;
			}
		}
		
		if(count1!=count2) result = false;		
		
		System.out.println("Is valid mountain array? " + result);
	}
	
	// here time complexity is O(n) and space complexity also O(n)
	static void valid_mountain_array_new(int[] nums) {
		int index=0; boolean result = true;
		
		// checking all increasing elements
		while(index< nums.length && index+1 < nums.length && nums[index] < nums[index+1])index++;
		
		// making sure element is not zero or not out of range of array length
		if(index==0 || index+1>=nums.length) result = false;
		
		// once we came at a point where increasing elements are finished then start looking for decrement
		while(index< nums.length && index+1 < nums.length) {
			if(nums[index] <= nums[index++ +1]) {
				result = false;
			}
		}
		
		// after checking all these combinations we can return true else one of the condition will be false
		
		System.out.println("Is valid mountain array? " + result);
	}
	
	static void duplicate_value_array(int[] nums) {
		boolean[] availability = new boolean[500];
		boolean result = false;
		
		for(int i: nums) {
			if(availability[i]==true) result = true;
			else availability[i]=true;
		}		
		System.out.println("Is there any duplicate: " + result);
	}

	static void power_of_two(int num) {
		int i=1;
		
		while(i<num) i *=2;	

		System.out.println("Number is power of 2 ? " + (i==num));
	}

	// give the index of two numbers those sum is required
	static void two_sum(int[] nums, int target) {
		
		int i=0, j=nums.length-1;
		
		while(i<=j && i+1<=j) {
			if(nums[i+1]==target-nums[i]) { System.out.println("The sum is at the indeces of " + i + " and " + (i+1)); break;}
		}
	}

}
