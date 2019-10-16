import java.io.Serializable;


public class Message implements Serializable {
	
	public Integer number;
	public String name;
	public double balance;
	public int opType;
	public double amount;
	
	public Message (int number, String name, double balance, int opType, double amount ){
		this.number = number;
	    this.name = name;
	    this.balance = balance;
		this.opType = opType;
		this.amount = amount;
	}

}
