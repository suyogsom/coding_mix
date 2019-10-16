package PA05;



public class Course {
	
	private  int id,num;
	private String description;
	private  Student[] students;
	private  Grade[] grades;
	
	// complete course object constructor
	public Course(int id, String description, int num) {
		super();
		this.id = id;
		this.description = description;
		students = new Student[num];
		grades = new Grade[num];
	}

	// Creates and adds a student object to the  students array
	public  boolean addStudent(int id, String name){
		Student student = new Student(id, name);
		if ( Student.getNoOfStudents()<=students.length)
		{
			students[Student.getNoOfStudents()-1] = student; return true;
 		}
		else
			return false;
		
	}
	

	// adds a grade object to the  grades array
   public  boolean addStudentGrade( int id, String assignment, Student student, double score){
	   Grade grade = new Grade(id, assignment, student, score);	
	   
	   if ( Student.getNoOfStudents()<=grades.length)
		{
		   grades[Grade.getNoOfGrades() -1] = grade; return true;
		}
		else
			return false;
	}
   
   
   
   public  double getGradeAVG(){
	   
	   double total = 0;
	   for(int i=0;i<grades.length;i++)
	   {
		  total += grades[i].getScore();
	   }
	   return total/grades.length;
		
	}
   
   
  public  String getHiegestStudentGrade(){
	  
	  double maxScore = 0;
	  String result = "",stuName = null;
	   
	   for(int i = 0; i < Grade.getNoOfGrades() - 1; i ++) {
		   if(grades[i].getScore() < grades[i + 1].getScore()) {
			   maxScore = grades[i + 1].getScore();
			   stuName = grades[i + 1].getStudent().getName();
		   }
	   }
	   result = "Highest student grade = " + maxScore + " Name = " + stuName;
	   return result;
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Student[] getStudent()
{
	return students;
}



public  String getGradesData() {
	String output="";
	for(int i=0;i<Grade.getNoOfGrades();i++)
		output += grades[i]+ "\n";
	return output;
}

public Grade[] getGrade()
{
	return grades;
}


public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

@Override
public String toString() {
	return "Course \nCourse ID = " + id + " \nDescription = " + description + " \n\nGrade  "
			+ getGradesData() ;
	
}
   
  
   
}
