package string_questions;

public class string_set_2 {

	public static void main(String[] args) {
//	    remove_vowels("anup");
//		System.out.println("Is string palindrome? " + isStringPalindrome("anna"));
		System.out.println("Is string palindrome? " + isStringPalindrome_new("anna"));
//	    reverse_string("anup");
//		reverse_words_in_string("anup dinesh patil");
//		longest_palindrome("abaaccd");		
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

	public static void reverse_string(String str){
		StringBuilder stringBuilder = new StringBuilder("");

		for(int i=str.length()-1;i>=0;i--){
		  stringBuilder.append(str.charAt(i));
		}

		System.out.println(stringBuilder.toString());
	}
	
	public static Boolean isStringPalindrome(String str) {
		if (str.length() < 2)
		  return true;

		if (str.charAt(0) == str.charAt(str.length() - 1)) {
		  return isStringPalindrome(str.substring(1, str.length() - 1));
		} 
		else return false;	  
	}
	
	public static Boolean isStringPalindrome_new(String str) {
		if (str.length() < 2)
			  return true;

		int j=0;
		
		for(int i=str.length()-1;i>=0;i--) {
			if(str.charAt(i)!=str.charAt(j++)) {
				return false;
			}				
		}
		
		return true;
	}
	
	public static void reverse_words_in_string(String str) {
		String[] strArr = str.split(" ");
		
		for(int i = strArr.length-1;i>=0;i--)System.out.println(strArr[i]);
	}
	
	public static void longest_palindrome(String str) {
		    
		 int start = 0, end = 0;
		 for (int i = 0; i < str.length(); i++) {
		      int len1 = expandAroundCenter(str, i, i);
		      int len2 = expandAroundCenter(str, i, i + 1);
		      int len = Math.max(len1, len2);
		      if (len > end - start) {
		          start = i - (len - 1) / 2;
		          end = i + len / 2;
		      }
		  }
		  System.out.println("Longest palindrome = " + str.substring(start, end + 1));
	}

	public static int expandAroundCenter(String s, int left, int right) {
		  int L = left, R = right;
		  while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
		      L--;  R++;    
		  }
		  return R - L - 1;
	}
	
}
