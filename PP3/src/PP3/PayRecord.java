package PP3;


public class PayRecord {
	
	private int rID;
    private Employee employee;
    private PayPeriod payPeriod;
    private TaxIncome payTax;
    
    private double payHours;
    private double payRate;
    
    private double montlyIncome;
    private int numMonths;
    static int numberOfPayRecord;
   
    public static final int REG_HOURS = 40;
    public static final double OT_RATE = 1.25;
    
    // pay record constructor for hourly employee
    public PayRecord(int id, Employee e, PayPeriod period, double hours, double rate){
    	
    	this.rID = id;
    	this.employee = e;
    	this.payPeriod = period;
    	this.payHours = hours;
    	this.payRate = rate;
    	this.montlyIncome = 0;
    	this.numMonths = 0;
    	this.payTax = new TaxIncome();
    	numberOfPayRecord++;
  
    }
    
    // pay record constructor for full time employee
    public PayRecord(int id, Employee e, PayPeriod period, double mIncome, int mNum){
 	
 	this.rID = id;
 	this.employee = e;
 	this.payPeriod = period;
 	this.payHours = 0;
 	this.payRate = 0;
 	this.montlyIncome = mIncome;
 	this.numMonths = mNum;
 	this.payTax = new TaxIncome();

 }

    
    // 1- add setters and getters methods
    public int getrID() {
		return rID;
	}

	public void setrID(int rID) {
		this.rID = rID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PayPeriod getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(PayPeriod payPeriod) {
		this.payPeriod = payPeriod;
	}

	public TaxIncome getPayTax() {
		return payTax;
	}

	public void setPayTax(TaxIncome payTax) {
		this.payTax = payTax;
	}

	public double getPayHours() {
		return payHours;
	}

	public void setPayHours(double payHours) {
		this.payHours = payHours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getMontlyIncome() {
		return montlyIncome;
	}

	public void setMontlyIncome(double montlyIncome) {
		this.montlyIncome = montlyIncome;
	}

	public int getNumMonths() {
		return numMonths;
	}

	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}

	
	  public static int getNumberOfPayRecord() {
		return numberOfPayRecord;
	}
	
	  // 2- add override method toString()

@Override
  public String toString() {
	return "\n\nPay Period information = " + payPeriod  + "\n\nPay Record information \nPay record ID = " + rID 
			+ ",Pay Hours = " + payHours + ",Pay Rate = " + payRate + ",Montly Income = " + montlyIncome + ",Number of Months = "
			+ numMonths ;
}
  
  
    // 3- complete the code in the following methods: grossPay() and netPay()
	// complete the code to compute the gross pay for the employee based on the employee status
	public double grossPay(){
		
		// variable to store gross pay
		double grossPay = 0;
		
		if(Status.FullTime == employee.getEmpStatus())
		{
			grossPay = numMonths*montlyIncome;
		}
		else if( Status.Hourly == employee.getEmpStatus())
		{
			if(payHours>=40)
			{
				// check this one more time or ask professor about percentage ????
				grossPay = (payHours-40)*1.25 + 40*payRate;
			}
			else
			{
				grossPay =  40*payRate;
			}
		}
		return grossPay;
	}
  

	// complete the code in this method to compute the net pay of the employee after taxes (state and federal)
     public double netPay(){
    	double grossPay =  grossPay( );
    	
    	// check this once  ?????????????????? 	
    	double tax = payTax.compIncomeTax(grossPay);
    	
	    return tax;
  }
  
 
}
