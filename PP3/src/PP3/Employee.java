package PP3;

// 1- The Employee class extends superclass Person
public class Employee extends Person{
	
	private int eID;
    private Status empStatus;
    static int numOfEmployees;
	static Employee[] employees;
	
    
    // 2- add the subclass Employee constructor that calls the supper Person class constructor, you should provide input data for all parent class data fields

   /* public Employee(int eID, Status empStatus) {
		super();
		this.eID = eID;
		this.empStatus = empStatus;
	} */

    public Employee(int eID, Status empStatus,String fName, String lname, Address address)
    {
    	super();
		this.eID = eID;
		this.empStatus = empStatus;
		this.address = address;
		this.fName = fName;
		this.lName = lname;
		numOfEmployees++;
		
    }

     // 3- add setters/getters methods
	public int geteID() {
		return eID;
	}


	public void seteID(int eID) {
		this.eID = eID;
	}


	public Status getEmpStatus() {
		return empStatus;
	}


	public void setEmpStatus(Status empStatus) {
		this.empStatus = empStatus;
	}

	

	public static int getNumOfEmployees() {
		return numOfEmployees;
	}

	@Override
	public String toString() {
		return "Employee information \nEmployee ID = "  + eID + ", Status = " + empStatus + ", First Name = " + fName + ", Last Name = " + lName
				+ "\nAddress information  " + address ;
	}

	

   

	
}
