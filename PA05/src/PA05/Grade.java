package PA05;

public class Grade {
	private int id;
	private String assignment;
	private Student student;
	private double score;
	private static int noOfGrades;
	
	// complete grade object constructor
	public Grade(int id, String assignment, Student student, double score) {
		super();
		this.id = id;
		this.assignment = assignment;
		this.student = student;
		this.score = score;
		noOfGrades++;
	}

	// compete public getter and setter methods
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public static int getNoOfGrades() {
		return noOfGrades;
	}

	public static void setNoOfGrades(int noOfGrades) {
		Grade.noOfGrades = noOfGrades;
	}

	@Override
	public String toString() {
		return "\nGrade ID = " + id + " \nAssignment = " + assignment + " \n\nStudent  " + student + " \nScore = " + score ;
	}
	
	
	
	
	

}
