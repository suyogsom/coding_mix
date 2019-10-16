

import java.io.*;
import java.util.*;
import javax.swing.*;

public class Product 
{
	// declaring variables
	static String[] cusName = new String[50];
	static double[] cusPrice = new double[50];
	static String output;
	
	public static void main(String[] args) throws IOException 
	{	
		JOptionPane.showMessageDialog(null,"Original file information");
		readFromFile("src\\products.txt");				
		sortArray(cusName, cusPrice);		
		writeToFile(cusName,cusPrice);
		JOptionPane.showMessageDialog(null,"Sorted file information");
		readFromFile("src\\sortedProducts.txt");
	}

	// sorting array
    public static void sortArray(String[] cusName, double[] cusPrice) 
	{		
		Sort sorting = new Sort();
		sorting.selSort(cusName, cusPrice);		
	}
	
    
	// read input from file
	public static void readFromFile(String path)
	{
		File file1 = new File(path);
		String[] pathInfo = new String[cusName.length];
		String result =""; 
		int count = 0; 
		
		try {
			Scanner trial = new Scanner(file1);
			while(trial.hasNextLine()) 
			{
				pathInfo[count] = trial.nextLine();
				count ++;
			}
			for(int i = 0; i < (cusName.length); i ++) 
				{
				 cusName[i] = pathInfo[i].split(",")[0];
				 cusPrice[i] = Double.parseDouble(pathInfo[i].split(",")[1]);				
				}

			for(int j=0; j < cusName.length ; j++)
			{
				result += cusName[j]+","+cusPrice[j]+"\n";

			}
			
			JOptionPane.showMessageDialog(null,result);
			
			} 
		
		catch (FileNotFoundException e)
				{	e.printStackTrace();	}			
						
					
	}
	
		
	
    // write to file
    public static void writeToFile(String[] cusName, double[] cusPrice) throws IOException 
	{
		FileWriter write = new FileWriter("src\\sortedProducts.txt");
		    PrintWriter print = new PrintWriter(write);
		    for(int i = 0; i < cusName.length; i++) 
		    {
		    	print.print(cusName[i] + "," + cusPrice[i] + "\n");
		    }
		    print.close();
	}
	
}


// sort class
class Sort
{
	
	public void selSort(String[] cusName, double[] cusPrice) 
	{
		
		for(int i = 0; i < cusPrice.length - 1; i++)
		{
			double curMin = cusPrice[i];
			String curMinName = cusName[i];
			int curMinIndex = i;
			
			for(int j = i+1; j<cusPrice.length;j++) 
			{
				if(curMin > cusPrice[j]) {
					curMin = cusPrice[j];
					curMinName = cusName[j];
					curMinIndex = j;
				}
			}
			
			if(curMinIndex != i) 
			{
				cusPrice[curMinIndex] = cusPrice[i];
				cusName[curMinIndex] = cusName[i];
				cusPrice[i] = curMin;
				cusName[i] = curMinName;
				
			}
		}
		
	}
}


