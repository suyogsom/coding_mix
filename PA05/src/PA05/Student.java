package PA05;

public class Student {
	
	private int id;
	private String name;
	private static int noOfStudents;

	// complete student object constructor
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		noOfStudents++;
	}
	// compete public getter and setter methods

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getNoOfStudents() {
		return noOfStudents;
	}

	public static void setNoOfStudents(int noOfStudents) {
		Student.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "\nStudent ID = " + id + " \nName = " + name ;
	}
	
	
	
}
