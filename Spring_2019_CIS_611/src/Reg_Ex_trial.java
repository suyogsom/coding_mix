import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg_Ex_trial {
	
	public static void main(String[]args)
	{
		
		List<String> input = new ArrayList<String>();
		input.add("123-45-6789");
		input.add("9876-5-4321");
		input.add("987-65-4321 (attack)");
		input.add("987-65-4321 ");
		input.add("192-83-7465");


	/*	^		match the beginning of the line
		() 		group everything within the parenthesis as group 1
		\d{n}		match n digits, where n is a number equal to or greater than zero
		-?		optionally match a dash
		$		match the end of the line*/
		
		/*
		for (String ssn : input) {
			if (ssn.matches("^(\\d{3}-?\\d{2}-?\\d{4})$")) {
				System.out.println("Found good SSN: " + ssn);
			}
		}*/
		
		String address = "I lost my wallet, i lost my car, i lost my:bike";
		
		String regExp = ".m.";
		
		regX(regExp ,address);
	}
	
	public static void regX(String regExp, String address)
	{
		Pattern pattern = Pattern.compile(regExp);
		
		Matcher matcher = pattern.matcher(address);
		
		while(matcher.find()) {
			if(matcher.group().length()!=0)
			{
				System.out.println(matcher.group().trim());
			}
			else
				System.out.println("wrong search input");
		}
			
	}
	
	// useful links for reg expression
	// https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
	// https://www.ocpsoft.org/opensource/guide-to-regular-expressions-in-java-part-1/
	
	// oracle docs
	// https://docs.oracle.com/javase/tutorial/essential/regex/index.html
	// for fun // https://www.geeksforgeeks.org/regular-expressions-in-java/
	
	

}
