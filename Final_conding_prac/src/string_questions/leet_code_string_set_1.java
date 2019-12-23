package string_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class leet_code_string_set_1 {
	
	public static void main(String[] args) {
//		reverse_vowels_string("hello");
//		remove_the_vowel_string("hello");
//		flip_game("++++");
//		System.out.println("Longest common prefix : " + longest_common_prefix(new String[] {"flower","flow","flight"}));
//		System.out.println("Is given string valid palindrome? " + valid_palindrome_can_delete_at_most_one_character("ada"));
//		System.out.println("Is ransom note possible? " + ransom_note_and_magazine("aa","aab"));
//		reverse_string("hello");
//		System.out.println("Is given string valid Anagram?" + valid_anagram("car", "rac"));
//		System.out.println("Is given string valid Anagram?" + valid_anagram_new("scar", "rsac"));
//		first_unique_character_string("leetcode");
//		first_unique_character_string_new("leetcode");
//		best_time_to_buy_and_sell_stock(new int[]{7,1,5,3,6,4});
//		fizz_buzz(15);
	}

	// reverse the vowel in the pair of 2 or multiple of two
	// return string back
	static void reverse_vowels_string(String str) {
		 
		    char[] arr = str.toCharArray();
		 
		    int i=0; 
		    int j=str.length()-1;
		 
		    // compare each characters until two pointers cross over
		    while(i<j){
		        if(!is_vowel(arr[i])){
		            i++; continue;		            
		        }
		 
		        if(!is_vowel(arr[j])){
		            j--; continue;		           
		        }
		 
		        // swap characters if vowel found at both of the pointers
		        char temp = arr[i];
		        arr[i++]=arr[j];
		        arr[j--]=temp;
		    }
		
		System.out.println("Reversed string :" + new String(arr));
	}

	// remove vowels and return string back
	static void remove_the_vowel_string(String str) {
		
		StringBuilder result = new StringBuilder();
		
		// iterate through string, if character is not a vowel then just append it to string builder
		for(char c: str.toCharArray()) {
			if(!is_vowel(c)) result.append(c);
		}
		
		System.out.println(result);
	}
	
	static boolean is_vowel(char c) {
		
		String vowel = "AEIOUaeiou";
		
		// iterate through set of vowels, if character is vowel return true else return false
		for(char v: vowel.toCharArray()) {
			if(v==c) return true;
		}
		
		return false;
	}

	// replace  ++ with -- and return all possible combinations of those replacement
	// you can do only one replacement in one step
	static void flip_game(String str) {
		
		ArrayList<String> possibleStates = new ArrayList<>();
		
		int i = 0;
		
		while(i <str.length()) {
			
			// determining the index of next move of (++) signs from the beginning of i'th position 
			int nextMove = i ==0? str.indexOf("++"): str.indexOf("++",i); 
			
			// if next move is -1 then just break it off
			if(nextMove == -1) break;
			
			// add everything before any move first then replacement of -- then add the part after replaced -- sign
			String nextState = str.substring(0, nextMove) + "--" + str.substring(nextMove + 2);
			possibleStates.add(nextState);
			i = nextMove + 1;
		}
		
		possibleStates.stream().forEach(s->System.out.println(s));
	}
	
	// find out longest common prefix
	// we are keeping first string of array as a reference and then checking other characters of index 1 onwards
	static String longest_common_prefix(String[] strArr) {
		String logestCommonPrefix = "";
		
		// if array is null or length is zero then just return empty string
		if((strArr==null) || (strArr.length == 0))return logestCommonPrefix;

		int index =0;
		
		// we have to check each character of each string
		// starting with first character of first string outer loop then goes inside		
		for(char c: strArr[0].toCharArray()) {
			
			// it starts with second string because we have already started with first string above
			for(int i=1;i<strArr.length;i++) {
				
				// inside loop will take care that length of next string is not out of bound or its character is not matching with character of first string 
				if(index>=strArr[i].length() || c!=strArr[i].charAt(index)) {
					return logestCommonPrefix;
				}
			}
			
			// else if character of first string and other string is matching then just add it, increase index
			logestCommonPrefix += c; index++;
		}
		return logestCommonPrefix;
	}

	static boolean valid_palindrome_can_delete_at_most_one_character(String str) {
		
		int i=0, j=str.length()-1;
		
		// using two pointers check char at i and j are equal or not
		// if not equal then remove one char and again check that string is palindrome or not
		while(i<j) {
			if(str.charAt(i)!=str.charAt(j)) {
				return isPalindrome(str,i+1,j) || isPalindrome(str, i, j-1);
			}
			i++;j--;
		}
		
		return true;
	
	}
	
	static boolean isPalindrome(String str, int i, int j) {
		while(i<j) {
			if(str.charAt(i++)!=str.charAt(j--)) {
				return false;
			}	
		}
		return true;
	}

	// here we have to make ransom note from the characters of the magazine
	static boolean ransom_note_and_magazine(String ransomNote, String magazine) {
		HashMap<Character, Integer> counts = new HashMap<>();
		
		// put all the characters of magazine in hash map and increment the count
		for(char c: magazine.toCharArray()) {
			counts.put(c, counts.getOrDefault(c, 0)+1);
		}
		
		// 2 possibilities of false conditions
		// 1. hash map does not contain the char from ransom note OR
		// 2. the count of char from hash map is equal or less than zero, means not enough chars available
		for(char c: ransomNote.toCharArray()) {
			if(!counts.containsKey(c)||counts.get(c)<=0) return false;
		
			// update the hash map by decreasing the counter of corresponding char from ransom note
			counts.put(c, counts.get(c)-1);
		}		
		return true;
	}

	static void reverse_string(String str) {
		char[] characters = str.toCharArray();
		
		int i=0, j=str.length()-1;
		
		while(i<j) {
			char temp = characters[i];
			characters[i++] = characters[j];
			characters[j--] = temp;
		}
		
		System.out.println("Reversed string : " + new String(characters));
	}

	// anagram means both string have same characters in count but their order of arrangement is different 
	static boolean valid_anagram(String str1, String str2) {
		
		char[] set1 = str1.toCharArray();
		char[] set2 = str2.toCharArray();
		
		Arrays.sort(set1); Arrays.sort(set2);
		
		if(str1.length()!=str2.length()) return false;		
		else if(set1.length==set2.length) {
				for(int index=0;index<set1.length;index++) {
						if(set1[index]!=set2[index]) return false;
			}
		}		
		return true;
	}

	// logic is subtract value of a from present character and increment the default value at that index
	// then for next string just do opposite means subtract the value of a from present character and decrement value at that index
	// then if array will have all values to zero, if not then its not anagram 
	static boolean valid_anagram_new(String str1, String str2) {
		if(str1.length()!=str2.length()) return false;
		
		// here assumption is we are only considering lower case letters which will be ONLY 26 in count
		int[] counts = new int[26];
		for(int i=0;i<str1.length();i++) {
			counts[str1.charAt(i) - 'a']++;
			counts[str2.charAt(i) - 'a']--;
		}
		
		for(int i: counts) {
			if(i!=0) return false;
		}
		
		return true;
	}

	static void first_unique_character_string(String str) {
		char unique = str.charAt(0);
		
		for(int i=0;i<str.length();i++) { int count=0; 
			for(int j=0;j<str.length();j++) {
				if(i!=j && str.charAt(i)!=str.charAt(j)) {
					count++;
					if(count==1)unique= str.charAt(j);
				}
			}
		}
		
		System.out.println("First unique char in string is " + unique);
	}

	static void first_unique_character_string_new(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			char current = str.charAt(i);
			if(!map.containsKey(current)) 
				map.put(current, i);
			 else 
				map.put(current, -1);			
		}
		
		int min = Integer.MAX_VALUE;
		for(char c: map.keySet()){
			if(map.get(c) > -1 && map.get(c) < min) {
				min = map.get(c);
			}
		}
		System.out.println("First unique character : " + (min == Integer.MAX_VALUE ? -1:min));
	}

	static void best_time_to_buy_and_sell_stock(int[] nums) {
		
		int profit = 0, min = Integer.MAX_VALUE;
		
		for(int i =0;i<nums.length;i++) {
			// assign min if we see less value than current min
			if(nums[i]< min)  min = nums[i];
			// else get the max from profit and subtraction of current value and min
			else profit = Math.max(profit, nums[i]-min);
		}
		System.out.println("Maximum profit will be :" + profit);
	}
	
	static void fizz_buzz(int n) {
		
		for(int i=1;i<=n;i++) {	
			if(i%15==0)System.out.println("FizzBuzz");		
			else if(i%3==0) System.out.println("Fizz");
			else if(i%5==0) System.out.println("Buzz");
			else System.out.println(i);			
		}
	}
}
