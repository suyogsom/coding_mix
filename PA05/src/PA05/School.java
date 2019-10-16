package PA05;
import PA05.Course;
import javax.swing.JOptionPane;

public class School {
 
	private static Course course; 
    static String num3;
    static int stuNum = 0;
	
	
	public static void main(String[] args) {				
	
		try 
		{	// 1 - prompt the user to provide the number of students, integer n value 
			num3 = JOptionPane.showInputDialog("Please enter number of student : " );
			stuNum = Integer.parseInt (num3);
			
			initialInputs();			
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, " Exception is: " + e );
		}
		
	}// end main
	
	
	
	public static void initialInputs()
	{
	    int couId , count=0;
		String couName,num1 ;		
			
		for(int i=0;i<stuNum;i++)
		{   	
			num1 = JOptionPane.showInputDialog("Please enter course ID : " );
			couId = Integer.parseInt (num1);
			
			couName = JOptionPane.showInputDialog("Please enter course name : " );

			// 2 - Instantiates the course object
			course  = new Course(couId, couName, stuNum ); 
			
			// 3 - Prompt the user to input the student data, and calls addStudentGrade() to add the student to course, for n students
			 String stuId = JOptionPane.showInputDialog("Please enter student ID : " );
		     int intStuId = Integer.parseInt (stuId);	
		     
		     String stuName = JOptionPane.showInputDialog("Please enter student name : " );
			 addStudentToCourse(intStuId,stuName);	
			
		     // 4 - Prompt the user to input the grade data, and calls aaddStudentGradeToCourse() to add the grade to course, for n grades
			 String graId = JOptionPane.showInputDialog("Please enter grade ID : " );
		     int intGraId = Integer.parseInt (graId);	
		     
		     String subName = JOptionPane.showInputDialog("Please enter subject name : " );	
		     
		     String score = JOptionPane.showInputDialog("Please enter score : " );
		     double intScore = Double.parseDouble (score);
		     addStudentGradeToCourse(intGraId, subName, course.getStudent()[i], intScore);
		     
		  // 5 - Displays the course statistics by calling displayCourseStat()
			 displayCourseStat(); count++;
			 
			 if(count==stuNum) { JOptionPane.showMessageDialog(null, "Thanks for your time bye!");	break;}
	     }
	}
	
	
	// it uses the course object to add a new student to the course
	public static void addStudentToCourse(int stuId, String stuName){
		if (course.addStudent(stuId,stuName)) {
			JOptionPane.showMessageDialog(null, "Student added, Thanks!");			
		}
		else
			JOptionPane.showMessageDialog(null, "Sorry class is full, student not added");
	} // end method
	
	
	
	// it uses the course object to add a new grade object to the course
	public static void addStudentGradeToCourse(int gradId, String subName, Student student, double intScore){
		if (course.addStudentGrade(gradId, subName,student , intScore)) {
			JOptionPane.showMessageDialog(null, "Grade added, Thanks!");
		}
		else
			JOptionPane.showMessageDialog(null, "Sorry no class grades not added");
	} // end method
	
	
	
	
	// it should display the grade average and the highest student grade, student name 
	public static void displayCourseStat(){
		JOptionPane.showMessageDialog(null, course.toString());

	} // end method

}

