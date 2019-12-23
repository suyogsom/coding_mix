package string_questions;

import java.util.ArrayList;
import java.util.Arrays;

public class string_set_1 {
	
	public static void main(String[] args) {
		
//		string_has_uniques_characters("leetcode");
		first_uniques_character_string_new("leetcode");
//		string_permutations("nope","pone");
//		string_permutations_anotherWay("nope","pone");
//		palindrome_permutation("code");
//		URLify_string("Mr John Smith ");
//		one_edit_away_string("ple","ale");
//		print_all_permutations_string("","anup");
//		rotate_string_by_k_index("anuppatil",2);
//		string_compression("aabbccttt");
//		string_rotation_in_antoher_string("water","erwao");		
	}
	
	// assumption is characters are ASCII
	public static void string_has_uniques_characters(String str) {		
			int count = 0; ArrayList<Character> list = new ArrayList<>();
			boolean[] char_set = new boolean[128];
			
			for(int i =0;i<str.length();i++) {
				int val = str.charAt(i);
				
				if(char_set[val]) { count++;list.add(str.charAt(i));}
				char_set[val]= true;
				
				//if(char_set[val]==val) {count++;list.add(str.charAt(i));}
				//else {char_set[val]=val;}
			}		
			if(count>0) {
				System.out.println("String has duplicate characters count : " + count); 
				list.stream().forEach(s->System.out.println(s));
			}
		}
	
	public static void first_uniques_character_string_new(String str) {
		
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
		
	
		// assumption is characters are ASCII
	public static void string_permutations(String a, String b) {
			
			System.out.print("Do String have same character set? " + (sort(a).equals(sort(b))) );	
		}
		
	public static String sort(String str) {
			
			char[] set = str.toCharArray();
			
			Arrays.sort(set);
			
			return new String(set);
			
		}
		
		// assumption is characters are ASCII
	public static void string_permutations_anotherWay(String a, String b) {	
			char[] set = a.toCharArray();
			int[] letter = new int[128];
			
			for(char c:set)letter[c]++;
			
			for(int i=0;i<b.length();i++) {
				int c = (int) b.charAt(i);
				letter[c]--;
				if(letter[c]<0)System.out.print("String does not have equal characters" );	
			}	
		}

		// so here two observations are important
		// palindrome means forward and backward String will be equal, permutation means any combination, not required to be present in the dictionary
		// here, if character length is even and all characters present should be multiples of 2 then that is palindrome permutation
		// if character length is odd then all characters present should be multiple of 2 except ONLY one character  then its palindrome permutation else not
	public static void palindrome_permutation(String str) {
			int[] arr = new int[128];
			
			// getting the count of the characters and putting it into array
	        for (int i = 0; i < str.length(); i++) {
	            arr[str.charAt(i)]++; // increment the value of element 
	          //  System.out.println(str.charAt(i)+ " " +arr[str.charAt(i)]);
	        }
	        int count = 0;
	        for (int key = 0; key < arr.length && count <= 1; key++) {
	            count += arr[key] % 2; 
	        } 
	        System.out.println("Is there any palindrome permutation? " + (count <= 1));   
		}

		// add %20 to each space
	public static void URLify_string(String String) {

			char[] str = String.toCharArray();
			
	        // count spaces and find current length 
	        int space_count = 0, strLength = str.length; 
	        for (int m = 0; m < str.length; m++) 
	            if (str[m] == ' ') 
	                space_count++; 
	  
	        // Find new length, because we need to add %20, we have place for blank space so space_count *2
	        int new_length = strLength + space_count * 2;      

	        // Start filling character from end 
	        int index = new_length - 1; 
	  
	        char[] new_str = str; 
	        str = new char[new_length]; 
	  
	        // Fill rest of the string from end, traverse through main string  
	        for (int j = strLength - 1; j >= 0; j--)  {   
	            // inserts %20 in place of space 
	            if (new_str[j] == ' ') { 
	                str[index] = '0'; 
	                str[index - 1] = '2'; 
	                str[index - 2] = '%'; 
	                index = index - 3; 
	            }  
	              
	            else { 
	                str[index] = new_str[j]; 
	                index--; 
	            } 
	        }        
	        for(char c:str)System.out.println(c);
		}

	public static void one_edit_away_string(String str1, String str2) {
			
			boolean result = true;
			
			if(Math.abs(str1.length()-str2.length())>1) result =false;
			
			// find shorter and longer String
			String s1 = str1.length() < str2.length()? str1: str2;
			String s2 = str1.length() < str2.length()? str2: str1;
			
			int index1 = 0, index2 = 0;
			boolean foundResult = false;
			
			while(index1< s1.length() && index2< s2.length()) {
				// if not matching return false
				if(s1.charAt(index1)!=s2.charAt(index2)) {
					if(foundResult) result = false;
						
					foundResult = true;
				
					// this checks replacement as well
					if(s1.length()==s2.length())index1++;
				}
				// if not matching then move shorter pointer
				else index1++;
				
				// always move big pointer
				index2++;
			}		
			System.out.print("Is String one edit away? " + result);
		}
		
	public static void print_all_permutations_string(String prefix , String str) {
			
			    if (str.length() == 0) System.out.println(prefix);
			    else {
			        for (int i = 0; i < str.length(); i++)
			        	print_all_permutations_string(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
			    }
		}	
		
	public static void rotate_string_by_k_index(String str, int index) {
			
			String clockwise = str.substring(index,str.length()) + str.substring(0,index);

			System.out.println("Clockwise = " + clockwise);
		}
		
		// given the count of repeating character in return, if length of compressed string is less than original then return original string
	public static void string_compression(String str) {
			
			StringBuilder compressed = new StringBuilder();
			int countConsecutive = 0;
			
			for(int i=0;i<str.length();i++) {
				countConsecutive++;
				
				if(i+1 >= str.length()|| str.charAt(i)!= str.charAt(i+1)) {
					compressed.append(str.charAt(i));
					compressed.append(countConsecutive);
					countConsecutive = 0;
				}
			}
			System.out.print("Result : " +  (compressed.length() <= str.length()? compressed.toString() : str));
		}

	public static void string_rotation_in_antoher_string(String original, String rotation) {
			boolean result = false;
			
			if (original.length() != rotation.length()) {
				return;	
			    }
			else {
				  String concatenated = original + original;

			    if (concatenated.indexOf(rotation) != -1) {
			      result = true;
			    }		    	    
			}
			System.out.println("string = " + result);	
		}
}
