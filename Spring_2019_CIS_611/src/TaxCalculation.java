
import javax.swing.JOptionPane;

public class TaxCalculation 
{

	public static void main(String[] args) 
	{
		
		// take user input
		String income =JOptionPane.showInputDialog("Please enter your income : ");
		
		// convert this into double value
		double incomeDo =Double.parseDouble(income);
		
		// take status of a person
		String status =JOptionPane.showInputDialog("Please enter status like Single, or Married.");
		
		int statusInt=0;
		
		// assigning value according to status of user
		
		switch(status)
		{
		case "single":
        	statusInt = 1;
            break;
        case "married":
        	statusInt = 2;
            break;
        default:statusInt = 3;break;				
		}
		
		// calculation of tax
		double tax = 0; 
			
		// if status is single
		
		if(statusInt==1)
		{
			if(incomeDo <8350) 
			{
				tax = incomeDo * 0.1 ;
			}
			else if(incomeDo >=8351 && incomeDo <= 33950) 
			{
				tax = 8350 * 0.10 + (incomeDo - 8350)*0.15 ;
			}
			else if (incomeDo >=33950 && incomeDo <= 82250)
			{
				tax = 8350*0.10 + (33950 - 8350)*0.15 +
						(incomeDo - 33950)*0.25;
			}
			else if (incomeDo >=82250 && incomeDo <= 171550)
			{
				tax = 8350*0.10 + (33950 - 8350)*0.15 +
						(82250-33950)*0.25 + (incomeDo - 82250)*0.28;

			}
			else if (incomeDo >=171550 && incomeDo <= 372950)
			{
				 tax = 8350*0.10 + (33950 - 8350)*0.15 +
						 (82250 - 33950)*0.25 + (171550 - 82250)*0.28 + (incomeDo - 171550)*0.33;
			}
			else 
			{
				tax = 8350*0.10 + (33950 - 8350)*0.15 + (82250 - 33950)*0.25 +
						(171550 - 82250)*0.28 + (372950 - 171550)*0.33 + (incomeDo - 372950)*0.35;
			}	
			
			// printing results 
			JOptionPane.showMessageDialog(null, "Income = "+ incomeDo + "\n"+
					" Status = "+ status  + "\n"+ 
					"Tax= " + tax);
					
		}
		
		// if status is married
		else if (statusInt==2)
		{
			if(incomeDo <16700)
			{
				 tax = incomeDo * 0.10;
			}
			else if(incomeDo >=16700 && incomeDo <= 67900) 
			{
				 tax = 16700 * 0.10 + (incomeDo - 16700)*0.15 ;
			}
			else if (incomeDo >=67900 && incomeDo <= 137050)
			{
				 tax = 16700*0.10 + (67900 - 16700)*0.15 +
						 (incomeDo - 67900)*0.25;
			}
			else if (incomeDo >=137050 && incomeDo <= 208850)
			{
				 tax = 16700*0.10 + (67900 - 16700)*0.15 +
						 (208850-67900)*0.25 + (incomeDo - 208850)*0.28;
			}
			else if (incomeDo >=208850 && incomeDo <= 372950)
			{
				 tax = 16700*0.10 + (67900 - 16700)*0.15 +
						 (208850-67900)*0.25 + (372950 - 137050)*0.28 + (incomeDo - 372950)*0.33;
			}
			else
			{
				tax = 16700*0.10 + (67900 - 16700)*0.15 + (208850-67900)*0.25 +
						(372950 - 137050)*0.28 + (372950-208850)*0.33 + (incomeDo - 372950)*0.35;
			}	
			
			// printing results 
			JOptionPane.showMessageDialog(null, "Income = "+ incomeDo + "\n"+
					" Status = "+ status  + "\n"+ 
					"Tax= " + tax);		
		}
		
		else 
		{
			JOptionPane.showMessageDialog(null, "Wrong choice, try again");
		}
	}	
		
		
		
	

}
