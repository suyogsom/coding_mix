package PA07;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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

public class UserGUI extends JFrame implements ActionListener{
	
	static Person[] personArray;
	static int numberOfPersons;
	final static String[] facultyStatus = {"Freshman", "Sophomore", "Junior", "Senior"};
	final static String[] studentStaus = {"Lecturer", "Assistant Professor", "Associate Professor", "Professor"};
	static Address address;
	static Person person;

	// declare all GUI components below
	
	// all labels
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblStreetName;
	private JLabel lblHouseNum;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblPhone;
	private JLabel lblEmail;
	
	
	// all text fields
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtStreetName;
	private JTextField txtHouseNum;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtZip;
	private JTextField txtPhone;
	private JTextField txtEmail;
	
	// all buttons
	private JButton btnAdd;
	private JButton btnClose;
	private JButton btnSort;
	private JButton btnDisplay;
	
	
	// text area & scroll pane
	private JTextArea textAreaForPerson;
	private JTextArea textArea;
	private JScrollPane jp;
	
	// radio buttons
	static JRadioButton radioFaculty;
	static JRadioButton radioStudent;
	ButtonGroup btnGroup;
	
	// display list
	private JList displayList;
	
  
				// constructor
				UserGUI(int nPersons){
					
					// create person array of size nPersons
					personArray = new Person[nPersons];
					
					//Initialize the components
					initComponenet();

					//Organize the GUI components
					doTheLayout();
					
					/*Add the action listeners GUI buttons(add, sort, and display)
					Example: addButton.addActionListener(this);*/
					
					btnAdd.addActionListener(this);
					btnSort.addActionListener(this);
					btnClose.addActionListener(this);
					btnDisplay.addActionListener(this);
					
								       		
					
				}//End of constructor

				private void initComponenet(){
				
					  // initialize all user interface components
					
					// labels 
					lblLastName = new JLabel("Last Name");					
					lblFirstName = new JLabel("First Name");					
					lblStreetName = new JLabel("Street");		
					lblHouseNum = new JLabel("House Number");
					lblCity = new JLabel("City");
					lblState = new JLabel("State");
					lblZip = new JLabel("Zip");
					lblPhone = new JLabel("Phone");
					lblEmail = new JLabel("eMail");

					
					// text fields
					txtLastName = new JTextField(40);
					txtFirstName = new JTextField(40);
					txtStreetName = new JTextField(40);
					txtHouseNum = new JTextField(40);
					txtCity = new JTextField(40);
					txtState = new JTextField(40);
					txtZip = new JTextField(40);
					txtPhone = new JTextField(40);
					txtEmail = new JTextField(40);
					
					
					// radio buttons
					radioFaculty = new JRadioButton("Faculty",true);				
					radioStudent = new JRadioButton("Student");
					

					// button group
					btnGroup = new ButtonGroup();
					btnGroup.add(radioFaculty);
					btnGroup.add(radioStudent);
				      
			      // define text area and add it scroll pane
					textAreaForPerson = new JTextArea("\n",10,30);
					textArea = new JTextArea("Program output\n",10,30);
					textArea.setEditable(false);
					jp = new JScrollPane(textArea);
					
					
				  // button 
					btnAdd = new JButton("Add");
					btnSort = new JButton("Sort");
					btnClose = new JButton("Close");
					btnDisplay = new JButton("Display");
					
					//radioFaculty.addActionListener(this);
					//radioStudent.addActionListener(this);
				}

			   private void doTheLayout(){
					// Organize the components into GUI window
				   JPanel top = new JPanel();
				   JPanel center = new JPanel();
				   JPanel centerTop = new JPanel();
				   JPanel centerBottom = new JPanel();
				   JPanel bottom = new JPanel();
					
				   
				   // adding component to top
				   top.setPreferredSize( new Dimension( 40, 200 ) );
				   top.add(lblFirstName); top.add(txtFirstName);
				   top.add(lblLastName);top.add(txtLastName);
				   top.add(lblStreetName);top.add(txtStreetName);
				   top.add(lblHouseNum);top.add(txtHouseNum);
				   top.add(lblCity);top.add(txtCity);
				   top.add(lblState);top.add(txtState);
				   top.add(lblZip);top.add(txtZip);
				   top.add(lblEmail);top.add(txtEmail);
				   top.add(lblPhone); top.add(txtPhone);

				   
				   // add to center top
				   center.setLayout(new BorderLayout());
				   centerTop.add(radioFaculty);
				   centerTop.add(radioStudent); 
				  // centerTop.add(displayList);
				   
				   // add to center bottom 				  
				   centerBottom.add(btnAdd);
				   centerBottom.add(btnSort);
				   centerBottom.add(btnDisplay);
				   centerBottom.add(btnClose);
				   
				   // add center top and bottom to the center
				   center.add(centerBottom, BorderLayout.SOUTH);
				   center.add(centerTop, BorderLayout.NORTH);
				   
				   // add to bottom 
				   bottom.add(jp);
				   
				   
				   // add everything to JFrame
				   this.add(top,"North");
				   this.add(bottom,"South");
				   this.add(center,"Center");
				}

				
				@Override
				public void actionPerformed(ActionEvent e) {
					// Call the required button action method according to the action event
					if (e.getSource() == btnAdd)
					{
						try {
							addButtonClicked();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else if (e.getSource() == btnSort)
					{
						try {
							sortBnttonClicked();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
									
					else if(e.getSource() == btnDisplay)
					{
						try {
							displaynttonClicked();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					else btnCloseClicked();
				
				}
				
				private void btnCloseClicked()
				{
					JOptionPane.showMessageDialog(null, "Exiting the program");
					System.exit(0);
				}
			   
				private void addButtonClicked() throws FileNotFoundException{
					//Method to implement add button action
					
					String firstName , lastName, streetName , email , houseNum , city , state , zip, phone ;

					
					// validating first name
					if(txtFirstName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtFirstName, "Invalid first name");
						txtFirstName.setText("");
						return;
					}
					else
					{
						firstName = txtFirstName.getText();
					}
					
					
					// validating last name
					if(txtLastName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtLastName, "Invalid street name");
						txtLastName.setText("");
						return;
					}
					else
					{
						lastName = txtLastName.getText();
					}
					
					
					// validating address name
					if(txtHouseNum.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtHouseNum, "Invalid house number");
						txtHouseNum.setText("");
						return;
					}
					else
					{
						houseNum = txtHouseNum.getText();
					}
					
					if(txtStreetName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtStreetName, "Invalid street");
						txtStreetName.setText("");
						return;
					}
					else
					{
						streetName = txtStreetName.getText();
					}
					
					if(txtCity.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtCity, "Invalid city");
						txtCity.setText("");
						return;
					}
					else
					{
						city = txtCity.getText();
					}
					
					if(txtState.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtState, "Invalid state");
						txtState.setText("");
						return;
					}
					else
					{
						state = txtState.getText();
					}
					
					if(txtZip.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtZip, "Invalid zip");
						txtZip.setText("");
						return;
					}
					else
					{
						zip = txtZip.getText();
					}
					
					// validating email 					
					if(txtEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(txtEmail, "Invalid email");
						txtEmail.setText("");
						return;
					}
					else
					{
						email = txtEmail.getText();
					}
					
					
					//  phone 				
				
						phone = txtPhone.getText();
					
					
					
					
					// add person based on radio button 
					
						
							if(radioFaculty.isSelected())
							{
								MyDate date = new MyDate();
								//String rank = displayList.getName();
								String rank = "none";
								person = new Faculty( firstName,  lastName,  new Address (streetName, Integer.parseInt(houseNum),city,state,Integer.parseInt(zip)), phone , email, rank ,date);
							}
							else if (radioStudent.isSelected())
							{
								//String status = displayList.getName();
								String status = "new";
								person = new Student( firstName,  lastName,  new Address (streetName, Integer.parseInt(houseNum),city,state,Integer.parseInt(zip)),  phone,  email, status);
							}
						
					
					// clear all text fields
					txtFirstName.setText("");
					txtLastName.setText("");
					txtStreetName.setText("");
					txtHouseNum.setText("");
					txtCity.setText("");
					txtState.setText("");
					txtZip.setText("");
					txtEmail.setText("");
					txtPhone.setText("");
					
					displaynttonClicked();
				}

						
				private void sortBnttonClicked() throws FileNotFoundException {
					//Method to implement sort button action
					selectionSort();
					displaynttonClicked();
				}

				private void displaynttonClicked() throws FileNotFoundException{
					// Method to implement display button action
					// calls the selection sort to sort the personArray
					selectionSort();
					// displays the array in the text area after sorting
					String message = "\n " + "First Name \t " + "Last Name \t " + "Email \t " + "Address \t " + "Phone \t ";
					for(int j = 0; j< personArray.length; j++)
					{
						message = "\n" + personArray[j].toString();
					}
					
					// display 
					textArea.setText(message);
				}
				
				
				private void selectionSort() {
				//Method to sort person objects based on last name	
					for(int i=0; i< personArray.length; i++)
					{
						Person currentMin = personArray [i];
						int currentMinIndex = i;
						
						for(int j = i+1; j< personArray.length; j++)
						{
							if(currentMin.compareTo(personArray [j])>0)
							{
								currentMin = personArray [j];
								currentMinIndex =j;
							}
						}
						
						// swap
						if(currentMinIndex !=i)
						{
							personArray[currentMinIndex] = personArray[i];
							personArray[i] = currentMin;
						}
					}
				}
				
				
				
			
			public static void main(String[] args) throws FileNotFoundException {
						
				//declare variables
				 String strumberOfPersons;
				
				// 1 - prompt the user to provide the number of students, integer n value 
				strumberOfPersons = JOptionPane.showInputDialog("Please enter number of person : " );
				numberOfPersons = Integer.parseInt (strumberOfPersons);
				

				//Input number of audiences.

				//Create a new GUI
				UserGUI frame = new UserGUI(numberOfPersons);
				
				//Set GUI frame settings
				 frame.pack();
				 frame.setLocationRelativeTo(null); // New since JDK 1.4
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.setVisible(true); // Display the frame
			
			}// end main
			
	
	}
