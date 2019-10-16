package PA06;

public class TestByHardCoding {
	
	static Person[] personArray;
	
	public static void main(String[] args){		

		// Create an instance of Address using the constructor of Address
		Address address1 = new Address("Rockwell Hall East", 121, "Fort Collins", "Colorado", 80521);
		
		// Create an instance of MeDate using the constructor of MyDate
		// In this example, using the constructor MyDate(int year, int month, int day) 
		MyDate date1 = new MyDate(2010, 11, 17);
			  
		// create an instance of Faculty using the constructor of Faculty
		// An instance of Faculty is assigned to superclass Person
		Person person1 = new Faculty("Ramadan", "Abdunabi", address1, "(970) 491-6227", "ramadan.abdunabi@business.colostate.edu", "Professor", date1);
		
		// Hard-coding the array size to 2
		personArray = new Person[2];
		// Storing faculty information in the first element of personArray
		personArray [0] = person1;
		
		System.out.println(personArray[0].toString());
		// This will print out:
	//	Ramadan , Abdunabi , Address [street=Rockwell Hall East, houseNumber=121, city=Fort Collins, state=Colorado, zipCode=80521] , (970) 491-6227 , ramadan.abdunabi@business.colostate.edu , Professor , MyDate [year=2010, month=11, day=17]
		
		// Create an instance of Address using the constructor of Address
		Address address2 = new Address("Rockwell Hall West", 231, "Fort Collins", "Colorado", 80521);
		// create an instance of Student using the constructor of Student
		// An instance of Student is assigned to superclass Person
		Person person2 = new Student("Jim", "Miller", address2, "(970) 431-1212", "jim.miller@gmail.com", "Senior");
		// Assign instance of Student to the second element of personArray
		personArray [1] = person2;
		
		System.out.println("\n\n");
		System.out.println(personArray[1].toString());
		// This will print out:		
		//Jim , Miller , Address [street=Rockwell Hall West, houseNumber=231, city=Fort Collins, state=Colorado, zipCode=80521] , (970) 431-1212 , jim.miller@gmail.com , Senior
	}
}

