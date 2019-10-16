package PP3;

// 1- this class implements the Taxable interface
public class TaxIncome implements Taxable{

	// 2- implement all the unimplemented abstract methods in the Taxable Interface, income tax is computed based on state and federal taxes   

	public  double compStateTax(double grossPay) 
	{
		return grossPay*Taxable.STATE_TAX;
	}
	
	
	public  double compFederalTax(double grossPay)
	{
		return grossPay*Taxable.FEDERAL_TAX;
	}

	public  double compIncomeTax(double grossPay)
	{
		double stateTax = compStateTax( grossPay) ;
		double federalTax = compFederalTax( grossPay);
		
		return grossPay - (stateTax+federalTax);
	}


	
}
