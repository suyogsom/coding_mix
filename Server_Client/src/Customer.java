
public class Customer {

	Integer number;
	String name;
	double balance;
     
	public Customer (Integer number, String name, double balance){
	      this.number = number;
	      this.name = name;
	      this.balance = balance;
	   }
   
   
   public void setNumber(Integer number) {
	   this.number = number;
	   }
   
   public int getNumber() {
	      return number;
	   }
   
   public void setName(String name) {
	   this.name = name;
	   }
   
   public String getName() {
      return name;
   }
  
    

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
   
   
   
  } 
   