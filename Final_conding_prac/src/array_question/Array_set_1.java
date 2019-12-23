package array_question;

import java.util.Arrays;

public class Array_set_1 {
	
	public static void main(String[] args) {
				
//		find_subarray_sum(new int[] {-5,-6,-2,4},-8);
//		find_triplet_soThat_sumOfTwo_equalsToThird(new int[] {1,2,3,4,5,6});
//		merge_two_unsorted_arrays(new int[] {4,2,0},new int[] {5,3,1});
//		merge_two_unsorted_arrays_new(new int[] {4,2,0},new int[] {5,3,1});
//		rearrange_max_min_alternative(new int[] {5,6,3,4,2,1});
//		get_inversion_count(new int[] {1,20,4,30});
//		find_a_pair(new int[] {5,2},new int[] {3,5,6,8});
//		sort_array_012(new int[] {2,2,1,1,0,0,2,2,1,1});
//		array_equilibrium(new int[] {-2,1,1,2,-3 });
	}

	// sub array means it is continuous, it can be a single element BUT NOT discrete elements	
	public static void find_subarray_sum(int[] arr, int sum) {
		int count =0, first = 0, last =0;
		
		// sliding window approach O(n^2), start from one end 
		for(int i=0;i<arr.length;i++) {
			int curSum = arr[i]; if(curSum==sum) {System.out.println("At index  " + i );count++;}
			// go to another end
			for(int j =i+1;j<arr.length;j++) {
			curSum += arr[j];
			if(curSum == sum) { first = i; last =j; System.out.println("Between index  " + first + " and " + last); count++;}				
			}
		}		
		System.out.println("Total number of subarrays are " + count); 
	}
	
	
	// Given an array of integers you have to find three numbers such that sum of two elements equals the third element
	public static void find_triplet_soThat_sumOfTwo_equalsToThird(int[] arr) {
		// sort the array 
        Arrays.sort(arr); 
  
        // for every element in arr 
        // check if a pair exist(in array) whose 
        // sum is equal to arr element 
        for (int i = arr.length - 1; i >= 0; i--) { 
            int j = 0; 
            int k = i - 1; 
            while (j < k) { 
                if (arr[i] == arr[j] + arr[k]) { 
  
                    // pair found 
                    System.out.println("numbers are " + arr[i] + " " + arr[j] + " " + arr[k]); 
  
                    return; 
                } 
                else if (arr[i] > arr[j] + arr[k]) 
                    j += 1; 
                else
                    k -= 1; 
            } 
        } 
  
        // no such triplet is found in array 
        System.out.println("No such triplet exists"); 
	}
	
	 // Merge arr1[0..n1-1] and arr2[0..n2-1]  
    // into arr3[0..n1+n2-1] 
    public static void merge_two_unsorted_arrays(int[] arr1, int[] arr2) { 
        int i = 0, j = 0, k = 0; 
      
        Arrays.sort(arr1);Arrays.sort(arr2);
        int[] arr3 = new int[arr1.length+arr2.length];
        
        // Traverse both array 
        while (i<arr1.length && j <arr2.length)  { 
            // Check if current element of first 
            // array is smaller than current element 
            // of second array. If yes, store first 
            // array element and increment first array 
            // index. Otherwise do same with second array 
            if (arr1[i] < arr2[j]) 
                arr3[k++] = arr1[i++]; 
            else
                arr3[k++] = arr2[j++]; 
        } 
      
        // Store remaining elements of first array 
        while (i < arr1.length) 
            arr3[k++] = arr1[i++]; 
      
        // Store remaining elements of second array 
        while (j < arr2.length) 
            arr3[k++] = arr2[j++]; 
        
       Arrays.stream(arr3).forEach(s->System.out.println(s));
    } 
    
    public static void merge_two_unsorted_arrays_new(int[] nums1, int[] nums2) { 
    	int k =0;	
        int m = nums1.length, n = nums2.length;
        Arrays.sort(nums1);Arrays.sort(nums2);
        int[] arr3 = new int[nums1.length+nums2.length];
        
        while(n + m > 0){
            if(n == 0 || m == 0)
                 break;
 				
             if(nums1[m - 1] > nums2[n - 1]){
                 arr3[k++] = nums1[m - 1];
                 m--;
             }
             else{
                 arr3[k++] = nums2[n - 1];
                 n--;
             }
         }
        
       Arrays.stream(arr3).forEach(s->System.out.println(s));
    } 
    
    
    // Prints max at first position, min at second position 
    // second max at third position, second min at fourth 
    // position and so on. 
    public static void rearrange_max_min_alternative(int[] arr) { 
       
    	Arrays.sort(arr);
    	// Auxiliary array to hold modified array 
        int temp[] = new int[arr.length]; 
      
        // Indexes of smallest and largest elements 
        // from remaining array. 
        int small=0, large=arr.length-1; 
      
        // To indicate whether we need to copy rmaining 
        // largest or remaining smallest at next position 
        boolean flag = true; 
      
        // Store result in temp[] 
        for (int i=0; i<arr.length; i++) 
        { 
            if (flag) 
                temp[i] = arr[large--]; 
            else
                temp[i] = arr[small++]; 
      
            flag = !flag; 
        } 
      
        // Copy temp[] to arr[] 
        arr = temp.clone(); 
        
        Arrays.stream(arr).forEach(s->System.out.println(s));
    } 
    
    // For each element, count number of elements which are on right side of it and are smaller than it.
    public static void get_inversion_count(int[] arr){ 
        int inv_count = 0; 
        // there is no point of going till last element of an array, because there is no right element for last element
        for (int i = 0; i < arr.length - 1; i++) 
            for (int j = i + 1; j < arr.length; j++) 
                if (arr[i] > arr[j]) 
                    inv_count++; 
  
        System.out.print(inv_count);  
    } 
    
    // Given two arrays X[] and Y[] of positive integers, find number of pairs such that x^y > y^x where x is an element from X[] and y is an element from Y[].
    public static void find_a_pair(int[] arr1, int[]arr2){
    	double x,y;
    	
    	for (int i = 0; i < arr1.length; i++) {
    		for(int j=0;j<arr2.length;j++) {
    			x = Math.pow(arr1[i], arr2[j]);
    			y = Math.pow(arr2[j], arr1[i]);  
    			if(x>y) System.out.println(arr1[i]+"^"+ arr2[j] + " is greater than " + arr2[j]+"^"+ arr1[i]);
    		  }		
    		} 
    }
    
    
    public static void sort_array_012(int arr[])  { 
        int lo = 0; 
        int hi = arr.length - 1; 
        int mid = 0, temp = 0; 
        while (mid <= hi) { 
            switch (arr[mid]) { 
            case 0: { 
                temp = arr[lo]; 
                arr[lo] = arr[mid]; 
                arr[mid] = temp; 
                lo++; 
                mid++; 
                break; 
            } 
            case 1: 
                mid++; 
                break; 
            case 2: { 
                temp = arr[mid]; 
                arr[mid] = arr[hi]; 
                arr[hi] = temp; 
                hi--; 
                break; 
            } 
          } 
        } 
        
        Arrays.stream(arr).forEach(s->System.out.println(s));
    } 
    
    // Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes
    public static void array_equilibrium(int arr[]) { 
        int sum = 0; // initialize sum of whole array 
        int leftsum = 0; // initialize left sum 
  
        // Find sum of the whole array 
        for (int i = 0; i < arr.length; ++i) 
            sum += arr[i];
  
        for (int i = 0; i < arr.length; ++i) { 
            sum -= arr[i]; // sum is now right sum for index i 
  
            if (leftsum == sum)  { System.out.println("Equilibrium found at " + i); break; } 
  
            leftsum += arr[i]; 
        }  
    } 
}
