package PA07; 

public class Faculty extends Person{
	

	
	private String rankOfFaculty; // values are Lecturer, Assistant Professor, Associate professor, Professor
	private MyDate appointmentDate;
	
	Faculty(String firstname, String lastName, Address address, String phoneNumber, String emailAddress, String rankOfFaculty, MyDate appointmentDate){
		// call the super class constructor to pass the Person data fields	
		
		this.rankOfFaculty = rankOfFaculty; // values are Lecturer, Assistant Professor, Associate Professor, Professor
		this.appointmentDate = appointmentDate;		
	}


	
	public String getRankOfFaculty() {
		return rankOfFaculty;
	}


	public void setRankOfFaculty(String rankOfFaculty) {
		this.rankOfFaculty = rankOfFaculty;
	}


	public MyDate getAppointmentDate() {
		return appointmentDate;
	}


	public void setAppointmentDate(MyDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}


	@Override
	public String toString() {
		return "Faculty info \nRank Of Faculty = " + rankOfFaculty + "\nAppointment Date = " + appointmentDate.toString() + "\nFirst name = "
				+ this.firstname + "\nLast Name = " + lastName + "\nAddress  " + address.toString() + "\nPhone Number = " + phoneNumber
				+ "\nEmail Address = " + emailAddress ;
	}
	
	
	public int compareTo(Faculty person)
	{
		if(this.lastName.compareTo(person.lastName)>0)
			return 1;
		else if(this.lastName.compareTo(person.lastName)<0)
			return -1;
		else
			return 0;
	}

}
