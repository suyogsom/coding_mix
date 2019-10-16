
package PA07; 

public class Student extends Person{
	

	private String status; // Values are Freshman, Sophomore, Junior, Senior 
	
	Student(String firstname, String lastName, Address address, String phoneNumber, String emailAddress, String status){
		// call the super class constructor to pass the Person data fields	
		
		this.status = status;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	// Override the abstract method from Person
	@Override
	public String toString() {
		return "Student Info \nStatus = " + status + "\nFirst name = " + firstname + "\nLastName = " + lastName + "\nAddress  "
				+ address.toString() + "\nPhone Number=" + phoneNumber + "\nEmail Address = " + emailAddress ;
	}
	
	
	public int compareTo(Student person)
	{
		if(this.lastName.compareTo(person.lastName)>0)
			return 1;
		else if(this.lastName.compareTo(person.lastName)<0)
			return -1;
		else
			return 0;
	}



}
