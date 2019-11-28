package array_question;

import java.util.ArrayList;
import java.util.Arrays;

public class Array_set_2 {

	public static void main(String[] args) {
//		find_duplicate_and_unique_elements_array(new int[] {6,5,1,2,2,3,3,4});
//		find_duplicate_new(new int[] {3,2,1,3,5,2});
//		find_duplicate_new_again(new int[] {3,2,1,3,5,2});
//		remove_duplicate_new(new int[] {3,2,1,3,5,2});
//		missing_more_elements_array(new int[] {2,6,9});	
//		missing_one_element(new int[] {3,1,0});
//		linear_search_max_element(new int[]{4,1,8,222,1});
//	    max_gap_two_element_array(new int[]{5,2,5});	
//		sum_two_element_array(new int[]{1,2,6},8);
//		left_rotate(new int[]{1,2,3,4,5,6},2,6);
		reverese_array_from_given_index(new int[] {1,2,3,4,5},1,4);
	
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
	
	public static void find_duplicate_new(int[] nums) {
		int count = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		Arrays.sort(nums);
        if (nums.length < 2) {
            count--;
        }
        int previous = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previous) {
                count++; list.add(nums[i]);
            }
            previous = nums[i];
        }
        if(count>1) { System.out.println("Array has duplicate elements "  ); list.stream().forEach(s->System.out.println(s));}
	}
	
	public static void find_duplicate_new_again(int[] nums) {
		int duplicate = -1;
		
		boolean[] result = new boolean[500];

        for (int i = 0; i < nums.length; i++) {
            if (result[nums[i]] == true) {
                duplicate = nums[i];
            }
            result[nums[i]] = true;
        }
        System.out.println("Duplicate element :  " + duplicate );
	}
	
	public static void remove_duplicate_new(int[] nums) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		Arrays.sort(nums);
       
		for(int i=0;i<nums.length;i++) {
			if(!list.contains(nums[i]))list.add(nums[i]);
			// no need of this, not sure why leet code people kept it?
			//nums[list.size()-1] = nums[i];
		}
		
		list.stream().forEach(s->System.out.println(s));
	}

	// here array needs to be sorted 
	public static void missing_more_elements_array(int[] nums) {
		
		Arrays.sort(nums);
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=nums[0];i<=nums[nums.length-1];i++)list.add(i);
		
		for(int j=0;j<nums.length;j++) {
			int index = list.indexOf(nums[j]);
			list.remove(index);
		}
		
		System.out.println("Missing elements");
		list.stream().forEach(s->System.out.println(s));
	}
	
	// it uses Gauss's formula
	public static void missing_one_element(int[] nums) {
		int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        System.out.println(expectedSum - actualSum); 
	}

	public static void linear_search_max_element(int[] arr){

		int max = arr[0];
		for(int i =0;i<arr.length;i++){
		  if(arr[i]>max)max=arr[i];
		}

		System.out.println("Maximum number : " + max);
	}

	public static void  max_gap_two_element_array(int[] arr){
		int max =arr[0], min=arr[0], diff = 0;

		for(int x : arr){
		  if(x>max)max=x;
		  if(x<min)min=x;
		  diff = max-min;
		}

		System.out.println("Largest difference is : " + diff);
	}

	public static void sum_two_element_array(int[] arr, int sum){
		  int num1 =0,num2=0;
		for(int i=0;i<arr.length;i++){
		  for(int j=i+1;j<arr.length;j++){
		      if(arr[i]+arr[j]==sum){
		          num1=arr[i];num2=arr[j];
		          System.out.println("sum of "+ num1 + " & " + num2 + " is :" + sum);
		          break;
		      }
		  }
		}

	}

	public static void left_rotate(int arr[], int d, int n) {
		for (int i = 0; i < d; i++)
		  leftRotatebyOne(arr, n);

		for(int x:arr)System.out.println(x);
	}

	public static void leftRotatebyOne(int arr[], int n) {
		int i, temp;
		temp = arr[0];
		for (i = 0; i < n - 1; i++)
		  arr[i] = arr[i + 1];
		arr[i] = temp;
	}

	public static void reverese_array_from_given_index(int arr[], int start, int end) {
		int temp;
		while (start < end){
		  temp = arr[start];
		  arr[start] = arr[end];
		  arr[end] = temp;
		  start++;
		  end--;
		}

		for(int x:arr)System.out.println(x);
	}
	
}
