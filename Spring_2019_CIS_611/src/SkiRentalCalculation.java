import javax.swing.JOptionPane;

public class SkiRentalCalculation 
{
	// declaring final sales tax variable
	static final double SALES_TAX = 0.075;
	static int custIntNum;
	static int numIntDays;
	static int numIntRental;
	
	public static void main(String[] args)
	{
		custIntNum = custCalculation();
		
		//arrays for first name, last name and values
		String[] custName = new String[custIntNum];
		double[] chargeTotal = new double[custIntNum];
		
		int j =1;
		
		for(int i=0;i<custIntNum;i++)
		{
			
			//  enter name		
			String customerName =JOptionPane.showInputDialog("Enter name of " + j + " customer");
			custName[i] = customerName;
		   
			
			numIntDays = dayCalculation();
			
			// enter number of rentals
			numIntRental = rentalCalculation();						
			
			// are you first time user
			String firstUser =JOptionPane.showInputDialog("Are you first time user? (y/n)");
			
			
			// are you member
			String member =JOptionPane.showInputDialog("Are you member? (y/n)");
			
			
			// do you have discount coupon			
			String discount =JOptionPane.showInputDialog("Do you have discount compoun? (y/n)");
			
			
			// calculating total charges
			JOptionPane.showMessageDialog(null,"Wait calculating your charges");
						
			
			double subTotal = 0;
			if(numIntRental>=0 && numIntRental <=3)
			{
			switch(numIntRental)
			{
			case 0: subTotal = 60 * numIntDays;
					if (firstUser.equalsIgnoreCase("y")) {subTotal -= subTotal*0.05;}
					if (member.equalsIgnoreCase("y")) {subTotal -= subTotal*0.1;}
					subTotal +=  subTotal*SALES_TAX;
					if (discount.equalsIgnoreCase("y") ) {subTotal -= 5;}					
					break;
			case 1: subTotal = 110 * numIntDays + 110* 0.075;
					if (firstUser.equalsIgnoreCase("y")) {subTotal -= 110*0.08;}
					if (member.equalsIgnoreCase("y")) {subTotal -= 110*0.12;}
					subTotal +=  subTotal*SALES_TAX;
					if (discount.equalsIgnoreCase("y") ) {subTotal -= 10;}
					break;
			case 2: subTotal = 155 * numIntDays + 155* 0.075;
					if (firstUser.equalsIgnoreCase("y")) {subTotal -= 155*0.08;}
					if (member.equalsIgnoreCase("y")) {subTotal -= 155*0.12;}	
					subTotal +=  subTotal*SALES_TAX;
					if (discount.equalsIgnoreCase("y") ) {subTotal -= 10;}
					break;
			
			case 3: subTotal = 190 * numIntDays + 190* 0.075;
					if (firstUser.equalsIgnoreCase("y")) {subTotal -= 190*0.08;}
					if (member.equalsIgnoreCase("y")) {subTotal -= 190*0.12;}
					subTotal +=  subTotal*SALES_TAX;
					if (discount.equalsIgnoreCase("y") ) {subTotal -= 10;}
					break;
			}
			
			chargeTotal[i] = subTotal;
			j++;
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"You have not selected any rental items ");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Summary " );
		
		for(int i =0; i<custIntNum;i++)
		{			
			JOptionPane.showMessageDialog(null, custName[i]  +" : " + chargeTotal[i] );			
		}
	}
	
	static int custCalculation() 
	{

		int num =0;
		
		try
		{	// take user input about number of customers
			String customerNum =JOptionPane.showInputDialog("Please enter total number of customers : ");
		
			// convert this into integer value
			 num =Integer.parseInt(customerNum);			 			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, " Exception is: " + e );
		}
		
		return num;			
	}
	
	static int dayCalculation() 
	{
		int day =0;
		
		try
		{   // take user input about number of customers
			String numberOfDays =JOptionPane.showInputDialog("Please enter number of days");
			
			// convert this into integer value
			day =Integer.parseInt(numberOfDays);		 		
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, " Exception is: " + e );
		}
		
		return day;				
	}
	
	static int rentalCalculation() 
	{
		int rental =0;
		
		try
		{  // take user input about number of customers
			String numberOfRental =JOptionPane.showInputDialog("Please enter number of rental items");			
			
			// convert this into integer value
			 rental =Integer.parseInt(numberOfRental); 		 		
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, " Exception is: " + e );
		}
		
		return rental;				
	}
}
