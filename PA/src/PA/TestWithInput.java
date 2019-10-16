package PA;

import javax.swing.JOptionPane;
import java.util.Calendar;


public class TestWithInput {
	
   static Person[] person;

	static String num3;
    static int personNum, count=0;
    
   static int intHouseNum, intZipCode, intYear, intMonth, intDay, intUserSelection;
   static String street,state, city, strHouseNum, strZipCode, strYear, strMonth, strDay, strUserSelection ;
	
   static String firstName, lastName, strPhone, strEmail, strRank, strStatus; 
   
	public static void main(String[] args) {				
		
		try 
		{	// 1 - prompt the user to provide the number of students, integer n value 
			num3 = JOptionPane.showInputDialog("Please enter number of person : " );
			personNum = Integer.parseInt (num3);
			
			person = new Person[personNum];
			
			initialInputs();			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, " Exception is: " + e );
		}
		
	}// end main
	
	public static void initialInputs()
	{
			
		for(int i=0;i<personNum;i++)
		{   	 
			
			{	
				// Prompt the user to select student or faculty
					strUserSelection = JOptionPane.showInputDialog("Please enter student or faculty \n1.Faculty \n2.Student  " );
					intUserSelection = Integer.parseInt (strUserSelection);
				
				if(intUserSelection==1)
				{	++count;
					// take person data
					personData();
					
					// take address data				
					addressData();					
					// Instantiates the address object
					Address address  = new Address(street, intHouseNum, city,state,intZipCode );
										
										
					// take date data
					dateData();
					// Instantiates the date object
					MyDate date = new MyDate(intYear,intMonth,intDay );
					
					strRank = JOptionPane.showInputDialog("Please rank of faculty : " );
					
					person[i] = new Faculty (firstName,lastName, address, strPhone, strEmail, strRank, date );
					
				}
				
				else if(intUserSelection==2)
				{	++count;	
					// take person data
					personData();
					
					// take address data				
					addressData();					
					// Instantiates the address object
					Address address  = new Address(street, intHouseNum, city,state,intZipCode );
					
					strStatus = JOptionPane.showInputDialog("Please status of student : " );
					
					person[i] = new Student (firstName,lastName, address, strPhone, strEmail, strStatus );
					
				}
				else { JOptionPane.showMessageDialog(null, "Wrong choice, try again"); }
								
			}	
	     }
		JOptionPane.showMessageDialog(null, "Summary time");
		displayAllInfo();
		JOptionPane.showMessageDialog(null, "Thanks for your time bye!");
	}
	
	public static void displayAllInfo()
	{
		for(int i =0; i<personNum;i++)
		JOptionPane.showMessageDialog(null, person[i].toString());
	}
	
	

	public static void addressData()
	{
		JOptionPane.showMessageDialog(null, "Address information");
		street = JOptionPane.showInputDialog("Please enter Street : " );
		
		strHouseNum = JOptionPane.showInputDialog("Please enter House number : " );
		intHouseNum = Integer.parseInt (strHouseNum);
		
		city = JOptionPane.showInputDialog("Please enter City : " );
		state = JOptionPane.showInputDialog("Please enter State : " );
		
		while(true) 
		{
		strZipCode = JOptionPane.showInputDialog("Please enter Zip code : " );
		if(strZipCode.length()!=5)JOptionPane.showMessageDialog(null, "Wrong entry of zip, try again");
		else {intZipCode = Integer.parseInt (strZipCode); break;}		
		}
	}
	
	public static void dateData()
	{   int year = Calendar.getInstance().get(Calendar.YEAR);
		JOptionPane.showMessageDialog(null, "Appointment information");
		while(true) 
		{
		strYear = JOptionPane.showInputDialog("Please enter Year : " );
		if(strYear.length()!=4)JOptionPane.showMessageDialog(null, "Wrong entry of year, try again");
		else 
		{intYear = Integer.parseInt (strYear); 
			if(intYear<year) JOptionPane.showMessageDialog(null, "Wrong entry of year, try again");
			else break;
		  }
						
		}
			
		while(true) 
		{
		strMonth = JOptionPane.showInputDialog("Please enter Month : " );
				
		if(strMonth.length()==2||strMonth.length()==1) 
		{	intMonth = Integer.parseInt (strMonth); 
		 	if(intMonth>=1 && intMonth <=12)break;
		 	else JOptionPane.showMessageDialog(null, "Wrong entry of month, try again");
		}
		else 	
		 { 
			JOptionPane.showMessageDialog(null, "Wrong entry of month, try again");
		 }
		
		}
		
		while(true) {
		strDay = JOptionPane.showInputDialog("Please enter Day : " );
		if(strDay.length()==2 || strDay.length()==1) 
		{	intDay = Integer.parseInt (strDay); 
		    if(intDay>=1&& (intDay<=30||intDay<=31))break;
		    else JOptionPane.showMessageDialog(null, "Wrong entry of day, try again");
		}
		else {JOptionPane.showMessageDialog(null, "Wrong entry of day, try again");}
		
		}
	}
	
	public static void personData()
	{
		JOptionPane.showMessageDialog(null, "Personal information");
		firstName = JOptionPane.showInputDialog("Please enter first name : " );
		lastName = JOptionPane.showInputDialog("Please enter last name : " );
		
		while(true) {
		strPhone = JOptionPane.showInputDialog("Please enter phone number : " );
		if(strPhone.length()!=10)JOptionPane.showMessageDialog(null, "Wrong entry of phone, try again");
		else {break;}
		}
		
		while(true) {
		strEmail = JOptionPane.showInputDialog("Please enter email address : " );
		if(!strEmail.contains("@"))JOptionPane.showMessageDialog(null, "Wrong entry of email, try again");
		else if (strEmail.charAt(0)=='@')JOptionPane.showMessageDialog(null, "Wrong entry of email, try again");
		else if (!strEmail.contains(".com")) JOptionPane.showMessageDialog(null, "Wrong entry of email, try again");			
		else  break;
		}
		
	}
}
