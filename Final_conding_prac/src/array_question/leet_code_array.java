package array_question;

import java.util.ArrayList;
import java.util.List;

public class leet_code_array {

	public static void main(String[] args) {
		
		// this login can be use to move any elements to end or front depending on situation
		// this will be done without creating new array
//		move_zeroes_to_end(new int[] {0,1,2,0,11});
//		move_zeroes_to_front(new int[] {0,1,2,0,11});
//		majority_element(new int[] {3,2,3});
//		maximum_subarray_sum(new int[] {-2,1,-3,4,-1,2,1,-5,4});
//		pascal_triangle(5);

	}
	
	// move all zeroes to end of the array
	public static void move_zeroes_to_end(int[] nums) {
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
	
	// move all zeroes to front of the array
	public static void move_zeroes_to_front(int[] nums) {
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
	public static void majority_element(int[] nums) {
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
	public static void maximum_subarray_sum(int[] nums) {
		
		int currMax=nums[0], maxSoFar=nums[0];
        
		for(int i=1; i<nums.length; i++){
			currMax = Math.max(nums[i], currMax+nums[i]);
			maxSoFar = Math.max(currMax, maxSoFar);
		}
		System.out.println(maxSoFar); 
	}
	
	// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
	public static void pascal_triangle(int numRows) {
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

	
}
