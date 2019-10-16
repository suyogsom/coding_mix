package PP2;

import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;


public class Payment {

	public static Validation validating;
	public static HashCode hashing;
	public static Customer[] customers;
	static String customernum;
	static int intCustomerNum;

	
	
	// the main entry method of the program that will get data from user and
	// perform the business logic
	
	public static void main(String[] args) throws Throwable 
	{
		try 
		{	
			hashing = new HashCode();
			validating = new  Validation();
			// input the number of customers and store it into variable n
            // must hold the number of customers based on the user input
			customernum = JOptionPane.showInputDialog("Enter number of customers you want to add");
		    intCustomerNum = Integer.parseInt(customernum);
		    customers = new Customer[intCustomerNum];
			
			initialInputs();			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, " Exception is: " + e );
		}
	}
	

	public static void initialInputs() throws Throwable
	{
	    int intCustomerId, count=0;
	    double doubleAmonut;
	    long longCardNum;
		String cusFirstName,cusLastName, customerId, amount, cardNum ="", exDate;		
			
		for(int i=0;i<intCustomerNum;i++)
		{   						
			cusFirstName = JOptionPane.showInputDialog("Please enter customer first name : " );
			cusLastName = JOptionPane.showInputDialog("Please enter customer last name : " );
			
			 customerId = JOptionPane.showInputDialog("Please enter customer ID : " );
		     intCustomerId = Integer.parseInt (customerId);			 		     
		     
		     JOptionPane.showMessageDialog(null,"Now time for credit card details ! " );
		     
		     while(true) {
		     cardNum = JOptionPane.showInputDialog("Please enter credit card number : " );	
		     if(validating.aValidNumber(cardNum)) 
		     {   
		    	 
		    	 longCardNum = Long.parseLong (cardNum);
		    	 		    	 
			     exDate = JOptionPane.showInputDialog("Please enter credit card expire date (MM/DD/YYYY) : " );			     
			     
			     CreditCard card = new CreditCard( longCardNum, exDate );
			    
				 amount = JOptionPane.showInputDialog("Please enter amount : " );
			     doubleAmonut = Double.parseDouble (amount);
			
			    // customers[i] = new Customer (cusFirstName,cusLastName, intCustomerId, doubleAmonut, card); 
			     addCustomer(cusFirstName,cusLastName, intCustomerId, doubleAmonut, card);count++;
			     writeToFile();
				 break;		     
		     }
		     else
		     {
		    	 JOptionPane.showMessageDialog(null,"Sorry but credit card number is not valid " );
		     }		
		     }
	     } 
		
		displayStat();
		if(count==intCustomerNum) { JOptionPane.showMessageDialog(null, "Thanks for your time bye!");}
	} 

	// this will check whether a card is valid
	/* public static Boolean isValidCard(String number){
		boolean result = false;
		if(validating.aValidNumber(number)); {result = true;}
		return result;

	}// end of the isValidCard method */

	
	
	// creates a hash code for the credit card number to be stored in file
    /*public static String createHashCode(String number){
    	HashCode code = new HashCode();	   	
		return code.getHashCode(Long.toString(card.getNumber()));

	}// end of the createHashCode method */


    
     // it adds a new customer to the array of customers once the payment was successful
 	
    public static void addCustomer(String fName, String lName, int id, double amount, CreditCard card){
		Customer customer  = new Customer( fName,  lName,  id,  amount,  card);
		if ( Customer.getNoOfCustomer()<=customers.length)
		{
			customers[Customer.getNoOfCustomer()-1] = customer; JOptionPane.showMessageDialog(null, "Customer added, Thanks!");
 		}
		else {
			JOptionPane.showMessageDialog(null, "Sorry no place , customer not added");
		}	
	}
 			  // end of the addCustomer method


 	 
 	 
	// it displays the payments AVG, MAX payment, and MIN payment,
	// only for accepted payments with valid cards
	public static void displayStat(){
		
		// display average payment
		double total = 0, average;
		
		   for(int i=0;i<customers.length;i++)
		   {
			  total += customers[i].getAmount();
		   }
		   average= total/customers.length;
		   
		   JOptionPane.showMessageDialog(null,"Average of amount : " + average );
		   
		   
		// display MAX payment 
		   
			  
			JOptionPane.showMessageDialog(null, "Max Amount: " + getMaxValue(customers) ); 
			   
			   
		// display MIN payment 
			   
			  
		    JOptionPane.showMessageDialog(null,"Min Amount: " + getMinValue(customers) );    
				  
		
		// display summary
		    JOptionPane.showMessageDialog(null,"Now time for Summary !" ); 
				   
		    JOptionPane.showMessageDialog(null,getCustomerData() );
		
	}// end of the displayStat method

	public static double getMaxValue(Customer[] customers){
		double maxPay = customers[0].getAmount() ;
		   
		   for(int i = 1; i < Customer.getNoOfCustomer() ; i ++) {
			   if(customers[i].getAmount() > maxPay) {
				   maxPay = customers[i].getAmount();					 
			   }
		   }		   
		return maxPay;
	}
	
	
	public static double getMinValue(Customer[] customers)
	{
		double minPay = customers[0].getAmount();
		   
		   for(int i = 1; i < Customer.getNoOfCustomer() ; i ++) {
			   if(customers[i].getAmount() < minPay)
			   {
		              minPay = customers[i].getAmount();
	            }			 
		   }		   
		   return minPay;
	}
	
	
  public static String getCustomerData() {		
		String output="";
    	for(int i=0;i<intCustomerNum;i++)
			output += customers[i]+ "\n";
		return output;
	}
	
	
	// write data to file, the credit card number should be encrypted
	// using one-way hash method in the Hashing class
    public static void writeToFile() throws Exception{
    	FileWriter write = new FileWriter("src\\customerData.txt");
	    PrintWriter print = new PrintWriter(write);
    
	    print.print( getCustomerData());
	   
	    print.close();
    } // end of the writeToFile method


  
}
