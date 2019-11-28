package mix_questions;

public class Coding_prac_00 {

	public static void main(String[] args) {

//	  sum_all_digits(213);
//    reverse_inteter_Number(123); 
//	  convert_string_to_integer_no_library("879");
	}

	public static void sum_all_digits(int num){

		int sum = 0; 

		while (num>0){
		  sum += num%10;
		  num /=10;
		}

		System.out.println("Summ of all digits : " + sum);
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
	
	public static void convert_string_to_integer_no_library(String num){

		int result = 0;
		
		for(int i=0;i<num.length();i++) {
			result = result * 10 + num.charAt(i) - '0';
		}

		System.out.println("Number is : " + result);
	}
}





