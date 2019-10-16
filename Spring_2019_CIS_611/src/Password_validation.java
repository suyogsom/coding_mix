
// Name: Suyog Somavanshi
// Assignment: PA_04_part01

import javax.swing.JOptionPane;

public class Password_validation 
{	
	// declaring variables
	
	    static int charCount = 0;
	    static int speCharCount = 0;
		static int digiCount = 0;
		static String password;
		static String userAnswer ;
		
	
	public static void main(String[] args)
	{
		// first input 
		 password = JOptionPane.showInputDialog("Enter your password : ");
		
		 if(isValidPassword( password))  
		 	{ JOptionPane.showMessageDialog(null,"Your password : " + password); }
			
		 else { 
				  JOptionPane.showMessageDialog(null,"Invalid password" ); 
				  userAnswer = JOptionPane.showInputDialog("Would you like to continue? : yes/no ");				 		  
			  }
		 
		 // loop until user says no
		 while(userAnswer.equals("yes"))
		 {
			 password = JOptionPane.showInputDialog("Enter your password : ");
			 
			 if(isValidPassword( password))  
			 	{ JOptionPane.showMessageDialog(null,"Your password : " + password); break; }
				
			 else {   
				 	  JOptionPane.showMessageDialog(null,"Invalid password" ); 			
					  userAnswer = JOptionPane.showInputDialog("Would you like to continue? : yes/no ");
					  if(userAnswer.equals("no"))break;
				  }
		 }
	}
	
	
	// validation of user input
	static boolean isValidPassword(String pass)
	{
		boolean result = false;
		
		for (int i = 0; i<pass.length(); i++) 
		{
			if(password.charAt(i)!=' ') charCount++;
			if(pass.charAt(i)=='%') speCharCount++;
			if(pass.charAt(i)=='#') speCharCount++;
			if(pass.charAt(i)=='&') speCharCount++;
			if(Character.isDigit(pass.charAt(i))) digiCount++;
		}
		

		// strict criteria for 3 validation
		if(charCount >= 8)  
		{
			if(speCharCount >= 1)
			{
				if(digiCount >= 2)
				{
					result = true;
				}
			}
			
		}
		
		else result = false;
		
		return result;
		
	}
	
	
}

