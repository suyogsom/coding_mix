package PP2;


public class Customer {
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	private static int noOfCustomer;
	
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		noOfCustomer++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {		
		return card;
	}
   


	public static int getNoOfCustomer() {
		return noOfCustomer;
	}

	public static void setNoOfCustomer(int noOfCustomer) {
		Customer.noOfCustomer = noOfCustomer;
	}

	@Override
	public String toString() {
		return "\n\nCustomer information \nID = " + id + "\nFirst Name = " + fName + " \nLast Name = " + lName + "\nAmount = " + amount + "\nCard information" + card;
				
	}

	
	
	// add public setter/getter methods, and also the toString method

}

