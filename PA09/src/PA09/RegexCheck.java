package PA09;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class RegexCheck {

public static void main(String[] args) throws IOException {
		
		// define pattern and matcher objects
		
		String itemRegex = "title=\"(.*?)\"(.*?)(Suggested Retail Price:\\s\\$(\\d*).(\\d*))";
		Pattern itemPattern = Pattern.compile(itemRegex);
		Matcher itemMatcher = null;
		
		// define print writer to store data into file
		File file = new File("U:\\611 workspace\\PA09\\src\\PA09\\matcherout.txt");
		PrintWriter output = new PrintWriter(file);
		
		// use scanner to import data from file
		Scanner scanner = new Scanner(new File("U:\\611 workspace\\PA09\\src\\PA09\\RetailStore.txt"));
		
		// read the whole document and store it into one string only
		
		
		// declare variables
		int countMatcheItem = 0;
		String strOutput = "Scraper program output = \n";
		String strLine = "";
		
		// create one string input of the file content
		while(scanner.hasNext())
		{
			strLine += scanner.nextLine();
		}
		
		// instantiate matcher object
		itemMatcher = itemPattern.matcher(strLine);
		
		// search and store matches into the matcher objects
		while(itemMatcher.find()) {
			strOutput += "\nTitle =" + itemMatcher.group(1) + "\tSuggested retail price = " + itemMatcher.group(3);
			countMatcheItem ++;
		}
			
		// write data output to the file
		output.print(strOutput + "\n" + "Number of items" + countMatcheItem );
		
		// close file
		scanner.close();
		output.close();
		
		// display the output
		JOptionPane.showMessageDialog(null, new JTextArea(strOutput + "\nNumber of output = " + countMatcheItem ));

	}

	
}
