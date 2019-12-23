package mix_questions;

public class leet_code_mix_set1 {

	public static void main(String[] args) {
		reverse_integer(123);

	}
	
	static void reverse_integer(int num) {
		int rev =0;
		while(num>0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		
	   System.out.println("Reverses number is :" + rev);
	
	}
}
