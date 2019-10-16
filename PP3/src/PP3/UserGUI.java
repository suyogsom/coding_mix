package PP3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.Date;


public class UserGUI extends JFrame implements ActionListener{

	  private PayRoll payRoll;
	  private String fileName = "PayRoll.txt";
	  private static int numOfEmployee, trial ;
	  static int check =0, chek2=0 , count3=1;
	  static  Status empStatus ;

	// declare all GUI components below
		
		// all labels
		private JLabel lblSection_1 ,lblEmpId, lblFirstName,lblLastName,lblEmpStatus,lblStreetName,lblHouseNum,lblCity,lblState,lblZip;
		private JLabel lblSubSection, lblSection_2,lblPayPeriodId, lblStartDate, lblEndDate, lblSection_3, lblPayRecordId, lblMonthIncome, lblMonthNum, lblPayHours, lblPayRate, lblSection_4;
		
		// all text fields
		private JTextField txtEmpId ,txtFirstName,txtLastName,txtStreetName,txtHouseNum,txtCity,txtZip;
		private JTextField txtPayPeriodId, txtStartDate, txtEndDate, txtPayRecordId, txtMonthIncome, txtMonthNum, txtPayHours, txtPayRate;
		
		// all buttons
		private JButton btnAddEmployee,btnClose,btnAddPayRecord,btnDisplay;
		
	
		// radio buttons
		static JRadioButton radioFullTime; static JRadioButton radioHourly;     ButtonGroup btnGroup;
						
		// display combo list for state
		private JComboBox combList;
		
		// text area for average
		  private JTextArea textArea;
		  private JScrollPane jp;
		
	
		// constructor
		UserGUI(int nPersons) throws Exception{
			
			 // prompt the user to input the number of pay records
           // is the number of pay records for employees
            // change this 3 here
		 
            payRoll = new PayRoll(fileName,numOfEmployee);

            //Initialize the components
            initGUI();
            
            //Organize the GUI components
            doTheLayout();
			
			btnAddEmployee.addActionListener(this);
			btnAddPayRecord.addActionListener(this);
			btnClose.addActionListener(this);
			btnDisplay.addActionListener(this);
								       		
			
		}//End of constructor
		
		
		
		
		private void initGUI(){
		      
			// labels 
			lblSection_1 = new JLabel("<html> <font color='blue'>Employee</font></html>",JLabel.LEFT); lblSubSection = new JLabel("Employee Address"); lblSection_2 = new JLabel("<html> <font color='blue'>Pay Period</font></html>"); lblSection_3 = new JLabel("<html> <font color='blue'>Pay Record</font></html>"); lblSection_4 = new JLabel("<html> <font color='blue'></font>Current Employee record and statiscis (Total & average pays)</html>");
			lblEmpStatus = new JLabel("<html> <font color='blue'></font>Employee status</html>");lblEmpId = new JLabel("Emp ID");lblLastName = new JLabel("Last Name");	lblFirstName = new JLabel("First Name");  lblStreetName = new JLabel("Street");	lblHouseNum = new JLabel("House Number");			
			lblCity = new JLabel("City"); lblState = new JLabel("State");  lblZip = new JLabel("Zip");	lblPayPeriodId = new JLabel("Pay period ID"); lblStartDate = new JLabel("Start date (dd/MM/yyyy)");	lblEndDate = new JLabel("End date (dd/MM/yyyy)");
			lblPayRecordId = new JLabel("Pay Record ID"); lblMonthIncome = new JLabel("Monthly Income (Use decimals Ex.2.5)"); lblMonthNum = new JLabel("Number of Month"); lblPayHours = new JLabel("Pay Hours (Use decimals Ex.2.5)"); lblPayRate = new JLabel("Pay Rate (Use decimals Ex.2.5)");
					
			
			// text fields

			txtLastName = new JTextField(20); txtFirstName = new JTextField(20); txtEmpId = new JTextField(20);txtStreetName = new JTextField(20); txtHouseNum = new JTextField(20); txtCity = new JTextField(20); txtZip = new JTextField(20);
			txtPayPeriodId = new JTextField(20);  txtStartDate = new JTextField(20); txtEndDate = new JTextField(20); txtPayPeriodId = new JTextField(20); txtPayRecordId = new JTextField(20);txtMonthIncome = new JTextField(20); txtMonthNum = new JTextField(20); txtPayRate = new JTextField(30); txtPayHours = new JTextField(20); 
	
			
			// radio buttons
			radioFullTime = new JRadioButton("Full Time",true);				
			radioHourly = new JRadioButton("Hourly");
			

			// button group
			btnGroup = new ButtonGroup();
			btnGroup.add(radioFullTime);
			btnGroup.add(radioHourly);
			
			
		  // button 
			btnAddPayRecord = new JButton("Add Pay Record");
			btnAddEmployee = new JButton("Add Employee");
			btnClose = new JButton("Close");
			btnDisplay = new JButton("Display Avg salary");
			
	      
	      String[] listStrings = { "","Colorado", "New york", "New Mexico", "Lowa", "Alabama", "Other" };
	      combList = new JComboBox(listStrings);
	      
	      textArea = new JTextArea(10, 20);
	      textArea.setEditable(false);
	      textArea.setLineWrap(true);
	      textArea.setWrapStyleWord(true);
	      jp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	      
	      
	      
		  }// end of creating objects method
		
		
		 private void doTheLayout(){

		      // panels
			  JPanel first = new JPanel();  JPanel firstTop = new JPanel();   JPanel firstCenter = new JPanel();  JPanel firstBottom = new JPanel(); 
			  JPanel second = new JPanel(); JPanel secondTop = new JPanel();   JPanel secondCenter = new JPanel();  JPanel secondBottom = new JPanel(); 
			  JPanel third = new JPanel(); JPanel thirdTop = new JPanel();   JPanel thirdCenter = new JPanel();  JPanel thirdBottom = new JPanel(); 
			  JPanel fourth = new JPanel(); JPanel fourthTop = new JPanel();   JPanel fourthCenter = new JPanel();  JPanel fourthBottom = new JPanel(); 
			  JPanel fifth = new JPanel(); JPanel fifthTop = new JPanel();   JPanel fifthCenter = new JPanel();  JPanel fifthBottom = new JPanel(); 
			  JPanel sixth = new JPanel(); JPanel sixthTop = new JPanel();   JPanel sixthCenter = new JPanel();  JPanel sixthBottom = new JPanel(); 			
			 
			  JPanel top = new JPanel();  JPanel center = new JPanel();  JPanel bottom = new JPanel(); 
			 
			  // setting first	
			  first.setLayout(new BorderLayout());
			  firstTop.add(lblSection_1);
			  firstCenter.add(lblEmpId); firstCenter.add(txtEmpId);firstCenter.add(lblFirstName);firstCenter.add(txtFirstName); firstCenter.add(lblLastName); firstCenter.add(txtLastName); 		      
			  firstBottom.add(lblEmpStatus);
			  
			  first.add(firstTop, BorderLayout.NORTH);
			  first.add(firstCenter, BorderLayout.CENTER);
			  first.add(firstBottom, BorderLayout.SOUTH);
			  
			  // second
			  second.setLayout(new BorderLayout());
			  secondTop.add(radioFullTime); secondTop.add(radioHourly); 
			  secondCenter.add(lblSubSection);  		      
			  secondBottom.add(lblStreetName);secondBottom.add(txtStreetName);secondBottom.add(lblHouseNum);secondBottom.add(txtHouseNum);secondBottom.add(lblCity);secondBottom.add(txtCity);
			  
			  second.add(secondTop, BorderLayout.NORTH);
			  second.add(secondCenter, BorderLayout.CENTER);
			  second.add(secondBottom, BorderLayout.SOUTH);

			  
			  // third		      
			  third.setLayout(new BorderLayout());
			  thirdTop.add(lblState); thirdTop.add(combList); thirdTop.add(lblZip); thirdTop.add(txtZip); 
			  thirdCenter.add(btnAddEmployee);  		      
			  thirdBottom.add(lblSection_2);
			  
			  third.add(thirdTop, BorderLayout.NORTH);
			  third.add(thirdCenter, BorderLayout.CENTER);
			  third.add(thirdBottom, BorderLayout.SOUTH);
			  
			  // fourth
			  fourth.setLayout(new BorderLayout());
			  fourthTop.add(lblPayPeriodId); fourthTop.add(txtPayPeriodId);  fourthTop.add(lblStartDate); fourthTop.add(txtStartDate);  fourthTop.add(lblEndDate); fourthTop.add(txtEndDate);       
			  fourthBottom.add(lblSection_3);
			  
			  fourth.add(fourthTop, BorderLayout.NORTH);
			  fourth.add(fourthCenter, BorderLayout.CENTER);
			  fourth.add(fourthBottom, BorderLayout.SOUTH);
		 
		     // fifth
			  fifth.setLayout(new BorderLayout());
			  fifthTop.add(lblPayRecordId); fifthTop.add(txtPayRecordId); fifthTop.add(lblMonthIncome); fifthTop.add(txtMonthIncome); fifthTop.add(lblMonthNum); fifthTop.add(txtMonthNum); 
			  fifthCenter.add(lblPayHours);  fifthCenter.add(txtPayHours); fifthCenter.add(lblPayRate);  fifthCenter.add(txtPayRate);  			      
			  fifthBottom.add(btnAddPayRecord);
			  
			  fifth.add(fifthTop, BorderLayout.NORTH);
			  fifth.add(fifthCenter, BorderLayout.CENTER);
			  fifth.add(fifthBottom, BorderLayout.SOUTH);
		      
		
			  // sixth
			  sixth.setLayout(new BorderLayout());
			  sixthTop.add(lblSection_4); 
			  sixthCenter.add(jp); 
			  sixthBottom.add(btnDisplay);  //sixthBottom.add(jp);
			  sixthBottom.add(btnClose);
			  
			  sixth.add(sixthTop, BorderLayout.NORTH);
			  sixth.add(sixthCenter, BorderLayout.CENTER);
			  sixth.add(sixthBottom, BorderLayout.SOUTH);
			  
			  
			  // top, center, bottom
			  top.setLayout(new BorderLayout());
			  top.add(first, BorderLayout.NORTH);
			  top.add(second, BorderLayout.CENTER);
			  
			  center.setLayout(new BorderLayout());
			  center.add(third, BorderLayout.NORTH);
			  center.add(fourth, BorderLayout.CENTER);
			  
			  bottom.setLayout(new BorderLayout());
			  bottom.add(fifth, BorderLayout.NORTH);
			  bottom.add(sixth, BorderLayout.CENTER);
			  
			
		      setLayout( new BorderLayout());
		     this.add(top, "North");
		     this.add(center, "Center");
		     this.add(bottom, "South");

		  }// end of Layout method

	 
		 
		 // all handling of GUI part
	@Override
	public void actionPerformed(ActionEvent e) {
		// Call the required button action method according to the action event
		if (e.getSource() == btnAddEmployee)
		{
			addEmployeeClicked();
		}
		else if (e.getSource() == btnAddPayRecord)
		{
			try {
				addPayRecordClicked();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
						
		else if(e.getSource() == btnDisplay)
		{
			try {
				btnDisplayClicked();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else btnCloseClicked();
	
		
	}// end of action performed  method
	
	
	// when user clicks on add employee button
	private void addEmployeeClicked()
	{
		
		try
		{

			String empId = txtEmpId.getText();
			String fName = txtFirstName.getText();
			String lName = txtLastName.getText();
			String street = txtStreetName.getText();
			String houseNum = txtHouseNum.getText();
			String city = txtCity.getText();
			String state = (String) combList.getSelectedItem();		
			String zip = txtZip.getText();
			
			
			
			Address address = new Address(street,Integer.parseInt(houseNum),city,state,Integer.parseInt(zip));
			
			int count = 0;
			if(radioFullTime.isSelected())
			{
				empStatus = Status.FullTime;			
			}
			else if (radioHourly.isSelected())
			{
				empStatus = Status.Hourly;
			
			}
			
			if(count3==1)textArea.append(payRoll.readFromFile());count3--;
			textArea.append((payRoll.createEmployee(Integer.parseInt(empId), empStatus, fName, lName, address)).toString());count++; numOfEmployee--;chek2++;
			if(count >0)JOptionPane.showMessageDialog(null, "Employee added successfully");
			
			//disable add employee and other related fields
			if(numOfEmployee<=0) {
			btnAddEmployee.setEnabled(false);
			txtFirstName.setEditable(false);
			txtEmpId.setEditable(false);
			txtLastName.setEditable(false);
			txtStreetName.setEditable(false);
			txtHouseNum.setEditable(false);
			txtCity.setEditable(false);
			txtZip.setEditable(false);
			combList.setEditable(false);
			}
			else
			{
				txtFirstName.setText("");
				txtEmpId.setText("");
				txtLastName.setText("");
				txtStreetName.setText("");
				txtHouseNum.setText("");
				txtCity.setText("");
				txtZip.setText("");
			}
			if(check<=0)btnDisplay.setEnabled(false);  
			if(chek2<trial)btnAddPayRecord.setEnabled(false);
			else if(chek2==trial)btnAddPayRecord.setEnabled(true);
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}


	
		
	}// end of add employee button method
	
	
	
	// when user clicks on add pay record
	
	private void addPayRecordClicked() throws Exception
	{
		try
		{
			
				String empId = txtEmpId.getText();
				String fName = txtFirstName.getText();
				String lName = txtLastName.getText();
				String street = txtStreetName.getText();
				String houseNum = txtHouseNum.getText();
				String city = txtCity.getText();
				String state = (String) combList.getSelectedItem();		
				String zip = txtZip.getText();
				
			   String monthIncome = txtMonthIncome.getText();
			   String numOfMonth = txtMonthNum.getText();
			   String payhours = txtPayHours.getText();
			   String payRate = txtPayRate.getText();
				
				
				Address address = new Address(street,Integer.parseInt(houseNum),city,state,Integer.parseInt(zip));
				
				String payRecId = txtPayRecordId.getText();
			
				int count = 0;
				
				// getting date

				  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

			      Date startDate = formatter.parse(txtStartDate.getText());
			      Date endDate = formatter.parse(txtEndDate.getText());
			      
			     
			      // emp status
			     
			      boolean result = true;
					if(radioFullTime.isSelected())
					{
						empStatus = Status.FullTime;							
					}
					else if (radioHourly.isSelected())
					{
						empStatus = Status.Hourly;  result = false;		 
					}
					Employee employee = payRoll.createEmployee(Integer.parseInt(txtEmpId.getText()) , empStatus, fName, lName, address);
					
					
					if(result)
					{					
					   textArea.append(payRoll.createPayRecord(empStatus,Integer.parseInt(payRecId),startDate,endDate,employee,Double.parseDouble(monthIncome),Integer.parseInt(numOfMonth),0,0).toString());count++;
					   payRoll.writeToFile();
					}
					else 
					{
						textArea.append(payRoll.createPayRecord(empStatus,Integer.parseInt(payRecId),startDate,endDate,employee,0,0,Double.parseDouble(payhours),Double.parseDouble(payRate)).toString());count++;
						payRoll.writeToFile();
					
					}
			
					
				
				if(count>1)JOptionPane.showMessageDialog(null, "Pay record added successfully"); check++;
				
				
				// disabling all outputs once user clicks on add pay record
			
					txtPayPeriodId.setText("");
					txtStartDate.setText("");
					txtEndDate.setText("");
					txtMonthIncome.setText("");
					txtMonthNum.setText("");
					txtPayHours.setText("");
					txtPayRate.setText("");
					txtPayRecordId.setText("");
				
				if(check>=1)btnDisplay.setEnabled(true);
			
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		
	
		
	}// end of add pay record button method
		

	// when user clicks on display button 
	private void btnDisplayClicked() throws FileNotFoundException{
		try
		{
			 textArea.append(payRoll.displayPayRecord().toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	  
		
	  
	}// end of display button method
	
	
	// when user clicks on close button 
	private void btnCloseClicked()
	{
		JOptionPane.showMessageDialog(null, "Exiting program Bye!");
		System.exit(0);
	}// end of close button method
	
	
				// main method
			 public static void main(String[] args) throws Exception  {
									 
				try 
				{
					 String strNumOfEmployee = JOptionPane.showInputDialog("Welcome ! Please enter number of employees you want to add : ");
				     numOfEmployee = Integer.parseInt(strNumOfEmployee);
				     trial = numOfEmployee;
					//Create a new GUI
					UserGUI frame = new UserGUI(numOfEmployee);
					//UserGUI frame = new UserGUI(3);
					
					//Set GUI frame settings
					 frame.pack();
					 frame.setLocationRelativeTo(null); // New since JDK 1.4
					 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 frame.setVisible(true); // Display the frame
				
				}
		
				catch (Exception e)
				{
					e.printStackTrace();
				}

				
				}// end main
		
	
		}