package mix_questions;

import java.util.*;

public class Coding_prac_00 {

	public static void main(String[] args) {

//	  find_max_min_element_array(new Integer[]{1,8,6,8,9});
//	  linear_search_max_element(new int[]{4,1,8,222,1});
//    max_gap_two_element_array(new int[]{5,2,5});	
//	  sum_all_digits(-213);
//	  sum_two_element_array(new int[]{1,2,6},8);
//	  left_rotate(new int[]{1,2,3,4,5,6},2,6);
		
//    remove_vowels("anup");
//	  checkig_vowels_string("anup patil");
//	  getting_unique_character_string("anup patil ");
//    string_splitter("anup patil");
//	  System.out.println("Is string palindrome? " + isStringPalindrome("anna"));
//    reverse_inteter_Number(123);
//    reverse_string("anup");
//    reverse_string_manual("pankaj");      
	   	
	}

	public static void remove_vowels(String name){
		//StringBuffer str = new StringBuffer(name);
		// can use var from java 10 onwards
		StringBuffer str = new StringBuffer(name);

		for(int i=0;i<str.length();i++){
		  if(isVowel(str.charAt(i)))str.deleteCharAt(i);
		}

		System.out.println("Before removing vowels: " + name);
		System.out.println("After removal of vowels " + str.toString());
	}
	
	public static boolean isVowel(char c ){
		String vowels = "AEIOUaeiou";

		for(int i=0;i<vowels.length();i++){
		  if(vowels.charAt(i)==c)return true;
		}

		return false;
	}

	public static void  reverse_inteter_Number(int num){
		long res = 0;
		while (num > 0) {
		  res = res * 10 + num % 10;
		  num = num / 10;
		}

		if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
		  System.out.println(0);
		} else {
		  System.out.println((int)res);
		}
	}

	public static void reverse_string(String str){
		System.out.println(new StringBuilder(str).reverse().toString());
	}

	public static void reverse_string_manual(String str){
		StringBuilder stringBuilder = new StringBuilder("");

		for(int i=str.length()-1;i>=0;i--){
		  stringBuilder.append(str.charAt(i));
		}

		System.out.println(stringBuilder.toString());
	}

	public static void find_max_min_element_array(Integer[] arr){

		//Set<Integer> set = new HashSet<>();
		//
		//for(int x:arr){
		//set.add(x);
		//}
		//
		//System.out.println("Maximum : " + Collections.max(set) + "\nMinimum : " + Collections.min(set));

		System.out.println("Max : " + Collections.max(Arrays.asList(arr)));
		}

	public static void getting_unique_character_string(String str){
		Map<Character,Integer> map = new HashMap<>();

		int count = 0;

		for(int i=0;i<str.trim().length();i++){
		  if(!map.containsKey(str.charAt(i))){count = 1;}
		  if(map.containsKey(str.charAt(i))){ count = map.get(str.charAt(i)); count++; }
		  map.put(str.charAt(i),count);
		}

		System.out.println("Key   " + map.keySet().toString() + "\nvalues"+map.values().toString());
		System.out.println("max value count is " + Collections.max(map.values()));

		Set<Character> set = map.keySet();

		for(Character c:set){
		  int count1 = map.get(c);
		  if(count1>1){
		      System.out.println("Duplicate character : " + c);
		  }
		}

	}

	public static void linear_search_max_element(int[] arr){

		int max = arr[0];
		for(int i =0;i<arr.length;i++){
		  if(arr[i]>max)max=arr[i];
		}

		System.out.println("Maximum number : " + max);
	}

	public static void string_splitter(String str){

		String[] names = str.split(" ");

		for(String s : names) System.out.println("String after splitting by ' ' : " + s);
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

	public static void sum_all_digits(int num){

		int sum = 0; int count = 0;

		if(num<0){ num *=(-1);count++; };

		while (num>0){
		  sum += num%10;
		  num /=10;
		}
		if(count>0)sum *=(-1);
		System.out.println("Summ of all digits : " + sum);
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

	public static Boolean isStringPalindrome(String str) {
		if (str.length() < 2)
		  return true;

		if (str.charAt(0) == str.charAt(str.length() - 1)) {
		  return isStringPalindrome(str.substring(1, str.length() - 1));
		} else
		  return false;
	}

	public static void checkig_vowels_string(String str){
		int count = 0;
		for(int i=0;i<str.length();i++){
		  if(isVowel(str.charAt(i))){count++;}
		}

		System.out.println("Total vowels :" + count);
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

	public static void rvereseArray(int arr[], int start, int end) {
		int temp;
		while (start < end)
		{
		  temp = arr[start];
		  arr[start] = arr[end];
		  arr[end] = temp;
		  start++;
		  end--;
		}

		for(int x:arr)System.out.println(x);
	}
	
}





