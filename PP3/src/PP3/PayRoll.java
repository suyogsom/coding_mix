package PP3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PayRoll {
	
	// variable declaration 
	private String fileName;
	private PayRecord[] payRecords;	
	private  double totalNetPay;
	private  double avgNetPay;
	private PayRecord record;
	
	// pay roll constructor
	public PayRoll(String fileName, int n){
		
		this.fileName = fileName;
        this.payRecords = new PayRecord[n]; 
		
	}
	
	
	// read from file method
   public String readFromFile(){
		
		// read the initial data from PayRoll file to create the full 
	   // pay records with gross pay, taxes, and net pay, and then store it in PayRecord.txt file
	   BufferedReader br = null;
	   String result = "";
		try {

			String line;

			br = new BufferedReader(new FileReader("U:\\611 workspace\\PP3\\src\\PP3\\PayRecord.txt"));

			while ((line = br.readLine()) != null) {
				
				String[] stringArr = line.split(";");
				for (String s:stringArr) result +=s;
				  // System.out.print(s + ";" + ""); 
				
				//System.out.println();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;		
	} // end of read from file method
   
   
   // write to file method
   public void writeToFile() throws Exception{
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			File file = new File("U:\\611 workspace\\Spring_2019_CIS_611\\src\\products.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			for(int i =0;i<payRecords.length;i++) {
			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			//bw.write(Employee.employees[Employee.numOfEmployees-1].toString());
			bw.write("\n");
			bw.write(payRecords[i].toString() + "\nTotal Net Pay: " + totalNetPay() + "\nAverage Net Pay: " + avgNetPay());
			bw.write("\n");
			}
			//System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
	} // end of write to file method
   
   
   // creating employee method
	public Employee createEmployee(int empid, Status status, String fName, String lName, Address address) throws Exception{
		// creates a new Employee object and add it to the employees array, you need to pass parameters to this method
		Employee emp = null;
		try {
			 emp = new Employee(empid, status, fName, lName, address);
			 //Employee.employees [Employee.getNumOfEmployees()-1] = emp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return emp;
		
		
	}   // end of creating employee method
	
 
	   // creating employee pay record method
	public PayRecord createPayRecord(Status status, int payRecId, Date startDate, Date endDate, Employee employee, double monthIncome, int numMonth, double payHour, double PayRate){
		
		try 
		{
			for(int i=0;i<payRecords.length;i++) {
		// creates a new PayRecord for an Employee object and add it to  the payRecords array, you need to pass parameters to this method
		if(status == Status.FullTime)
		{
			record = new PayRecord( payRecId, employee ,  new PayPeriod(payRecId,startDate,endDate),  monthIncome, numMonth);
		}
		else if (status == Status.Hourly)
		{
			record = new PayRecord( payRecId, employee,  new PayPeriod(payRecId,startDate,endDate), payHour, PayRate);
		}
		
		
		// recording array
		payRecords[i]= record;
			}
	 }
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
		  
		
		
		return record;
	} // end of creating employee pay record method
	
	
	
	
	//  display pay record method
    public  String displayPayRecord(){
    	
		// it shows all payroll records for all currently added employee and the total net pay and average net pay in the GUI text area
    	// at should append data to text area, it must not overwrite data in the GUI text area
    	String output =  "\nTotal Net Pay = " + totalNetPay() + "\n Average Net Pay =" +  avgNetPay();  
    	
		return output;
	}  // end of display pay record method

    
    
    // calculate average net pay 
   public double avgNetPay(){
	     	  
	   // returns the average of the total net pay of all added employees
	   double net = 0;
	   
	   for(int i=0;i< payRecords.length;i++)
	   {
		   net = payRecords[i].netPay();
	   }
	   avgNetPay = net/payRecords.length;
	   
	    return avgNetPay;
		
	} // end of calculate average net pay
   
   
   public double totalNetPay()
   {
	   double pay = 0;
	   for(int i=0; i < payRecords.length; i++) {
		   pay += payRecords[i].netPay();
	   }
	   totalNetPay = pay;
	   return totalNetPay;
   }


public PayRecord[] getPayRecords() {
	return payRecords;
}


public double getTotalNetPay() {
	return totalNetPay;
}


public double getAvgNetPay() {
	return avgNetPay;
}

 

}
