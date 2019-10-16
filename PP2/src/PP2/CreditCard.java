
package PP2;

public class CreditCard {
	
	private long number;
	private String expDate;
	
	public CreditCard(long number, String expDate) {
		super();
		this.number = number;
		this.expDate = expDate;
	}


	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}


	@Override
	public String toString() { 
		HashCode code = new HashCode();		
		return "\nCard number = " + code.getHashCode(Long.toString(getNumber())) + " \nExpire Date = " + expDate ;
	}
	
	
	
	// add public setter/getter methods, and also the toString method
}
