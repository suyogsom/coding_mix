package PA08;

//add the class template

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.*;
import com.mysql.*;


class StaffClent extends JFrame implements ActionListener{


	private static String hostname;
	private static int port;
	private Message message;
	private Socket	clientSocket = null;
	ObjectOutputStream clientOutputStream ;
	ObjectInputStream clientInputStream;
	
	  private  final int VIEW_OP = 0;
		private final int INSERT_OP = 1;
		private  final int DELETE_OP = 2;
		private  final int UPDATE_OP = 3;
	
	  //private DataInputStream  clientInput  = null; 
	    //private DataOutputStream clientOut   = null;
	    
// declare UI component objects
	
	// all labels
	private JLabel lblTitle,lblStaffId, lblFirstName, lblLastName, lblMiddleName, lblAddress, lblCity, lblState, lblMobilePhone, lblMobilePhone1, lblMobileCarrier, lblMobileCarrier1;
	
	// all textFieldds
	private JTextField txtStaffId, txtFirstName, txtLastName, txtMiddleName, txtAddress, txtCity, txtMobilePhone, txtMobilePhone1, txtMobileCarrier, txtMobileCarrier1;
	
	// all buttons
	private JButton btnView, btnInsert, btnUpdate, btnDelete, btnClear, btnClose;
	
	// display combo list for state
	private JComboBox combList;
	
	// textArea
	private JTextArea textArea;
	private JScrollPane jp;
	

	// constructor
public StaffClent(String hostname, int port) throws UnknownHostException, IOException, ClassNotFoundException, SQLException {
	//super("PA08");
	this.port = port;
	this.hostname = hostname;
	
	
	
	// Create a connection with the StaffServer server on port number 8000
	//clientSocket = new Socket(hostname, port);
	//clientOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
	//clientInputStream = new ObjectInputStream(clientSocket.getInputStream());
	System.out.println("Connected"); 
 
	
	
	// call these two methods to create user GUI
	initComponenet();
	doTheLayout();
	
	// action listener
	btnView.addActionListener(this);
	btnInsert.addActionListener(this);
	btnUpdate.addActionListener(this);
	btnDelete.addActionListener(this);
	btnClear.addActionListener(this);
	btnClose.addActionListener(this);
	
}

private void initComponenet(){
	// Initialize the GUI components
	
	// labels
	lblTitle =  new JLabel ("Staff information"); lblStaffId =  new JLabel ("Staff ID"); lblFirstName = new JLabel ("First name"); lblLastName = new JLabel ("Last name"); lblMiddleName = new JLabel ("Middle name");
	lblAddress = new JLabel ("Address"); lblCity = new JLabel ("City"); lblState = new JLabel ("State"); lblMobilePhone = new JLabel ("Mobile Phone Number 1"); lblMobilePhone1 = new JLabel ("Mobile phone number 2");
	lblMobileCarrier = new JLabel ("Mobile phone carrier 1"); lblMobileCarrier1 = new JLabel ("Mobile phone carrier 2");
	
	// text fields
	txtStaffId = new JTextField(20); txtFirstName = new JTextField(20); txtLastName = new JTextField(20); txtMiddleName = new JTextField(20);txtAddress = new JTextField(20); txtCity = new JTextField(20);
	txtMobilePhone = new JTextField(20); txtMobilePhone1 = new JTextField(20);txtMobileCarrier = new JTextField(20); txtMobileCarrier1 = new JTextField(20);
	
	// buttons
	btnView = new JButton("View");
	btnInsert = new JButton("Insert");
	btnUpdate = new JButton("Update");
	btnDelete = new JButton("Delete");
	btnClear = new JButton("Clear");
	btnClose = new JButton("Close");
	
	// combo list
	 String[] listStrings = { "Select state","Arizona","Colorado", "New york", "New Mexico", "Lowa", "Alabama", "Other" };
     combList = new JComboBox(listStrings);
     
     // text area
     textArea = new JTextArea(10, 20);
     textArea.setEditable(false);
     textArea.setLineWrap(true);
     textArea.setWrapStyleWord(true);
     jp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
}

private void doTheLayout(){
	// Arrange the UI components into GUI window
	
	// panels
	JPanel top = new JPanel();  JPanel topTop = new JPanel(); JPanel topCenter = new JPanel(); JPanel topBottom = new JPanel(); 
	JPanel center = new JPanel(); JPanel centerTop = new JPanel(); JPanel centerCenter = new JPanel(); JPanel centerBottom = new JPanel(); 
	JPanel bottom = new JPanel(); JPanel bottomTop = new JPanel(); JPanel bottomCenter = new JPanel(); 
	
	// setting top
	top.setLayout(new BorderLayout());
	topTop.add(lblTitle);
	topCenter.add(lblStaffId);topCenter.add(txtStaffId);topCenter.add(lblLastName);topCenter.add(txtLastName);topCenter.add(lblFirstName);topCenter.add(txtFirstName);topCenter.add(lblMiddleName);topCenter.add(txtMiddleName);
	topBottom.add(lblAddress);topBottom.add(txtAddress);
	
	// setting center
	center.setLayout(new BorderLayout());
	centerTop.add(lblCity); centerTop.add(txtCity); centerTop.add(lblState);centerTop.add(combList);
	centerCenter.add(lblMobilePhone);centerCenter.add(txtMobilePhone);centerCenter.add(lblMobileCarrier);centerCenter.add(txtMobileCarrier);
	centerBottom.add(lblMobilePhone1);centerBottom.add(txtMobilePhone1);centerBottom.add(lblMobileCarrier1);centerBottom.add(txtMobileCarrier1);
	
	// setting bottom
	bottomTop.add(btnView); bottomTop.add(btnInsert);bottomTop.add(btnUpdate);bottomTop.add(btnDelete);bottomTop.add(btnClear);bottomTop.add(btnClose);
	bottomCenter.add(jp);
	
	
	 top.setLayout(new BorderLayout());
	  top.add(topTop, BorderLayout.NORTH);
	  top.add(topCenter, BorderLayout.CENTER);
	  top.add(topBottom,  BorderLayout.SOUTH);
	  
	  center.setLayout(new BorderLayout());
	  center.add(centerTop, BorderLayout.NORTH);
	  center.add(centerCenter, BorderLayout.CENTER);
	  center.add(centerBottom,  BorderLayout.SOUTH);
	  
	bottom.add(bottomTop,BorderLayout.NORTH);
	bottom.add(bottomCenter, BorderLayout.CENTER); 
	 
	
     setLayout( new BorderLayout());
    this.add(top, "North");
    this.add(center, "Center");
    this.add(bottom, "South");
	
	
}	
	
 
@Override
public void actionPerformed(ActionEvent e) {
	
	if (e.getSource() == btnView){ viewButtonClicked();}
      else if (e.getSource() == btnInsert){ insertButtonClicked();}	
			else if(e.getSource() == btnUpdate){ updateButtonClicked();}
			else if(e.getSource()== btnDelete) { deleteButtonClicked();}
						
	
	else if(e.getSource()== btnClear)
	{
		clearButtonClicked();
	} 
	
	else
		try {
			closeButtonClicked();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
}

private void viewButtonClicked() {
	  
	  // handle view button clicked event 
	String strStaffId = txtStaffId.getText();
	message = new Message(Integer.parseInt(strStaffId));
	 JOptionPane.showMessageDialog(null, "View done!");
	
  }

private void insertButtonClicked(){
	  
	  // handle insert button clicked event 
	String id = txtStaffId.getText(); String firstName = txtFirstName.getText();String lastName = txtLastName.getText(); String middleName = txtMiddleName.getText();
	String address = txtAddress.getText(); String city = txtCity.getText(); String state =(String) combList.getSelectedItem();
	String homePhone = txtMobilePhone.getText(); String homeCarrier = txtMobileCarrier.getText(); String workPhone = txtMobilePhone1.getText(); String workCarrier = txtMobileCarrier1.getText();
	
	message = new Message(Integer.parseInt(id),lastName, firstName, middleName, address, city,state,Integer.parseInt(homePhone), Integer.parseInt(workPhone),homeCarrier, workCarrier,INSERT_OP);
	
	 JOptionPane.showMessageDialog(null, "Record added successfully");
	
  }


private void updateButtonClicked(){
	
	// handle update button clicked event
	int staffId = Integer.parseInt(txtStaffId.getText());
	String address = txtAddress.getText();
	message = new Message(staffId);
	message.setOpType(UPDATE_OP);
	message.setAddress(address);
	 JOptionPane.showMessageDialog(null, "Record updated successfully");
	
  }

private void deleteButtonClicked(){
	  
	// handle delete button clicked event
	int staffId = Integer.parseInt(txtStaffId.getText());
	message = new Message(staffId);
	message.setOpType(UPDATE_OP);
	 JOptionPane.showMessageDialog(null, "Record deleted successfully");
  }
  
  
  void clearButtonClicked(){
	  
	// handle clear button clicked event
	  txtLastName.setText("");txtFirstName.setText(""); txtMiddleName.setText(""); txtAddress.setText(""); txtCity.setText("");
	   txtMobilePhone.setText(""); txtMobilePhone1.setText("");txtMobileCarrier.setText(""); txtMobileCarrier1.setText("");
	 combList.setSelectedIndex(0);  JOptionPane.showMessageDialog(null, "Everything is clear now");
  
  }
  

  void closeButtonClicked() throws IOException{
	  
	// handle close button clicked event
	  JOptionPane.showMessageDialog(null, "Exiting program Bye!");System.exit(0);
  
  }
  
  /**Main method
 * @throws IOException 
 * @throws UnknownHostException 
 * @throws SQLException 
 * @throws ClassNotFoundException */
  public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, SQLException {
	  
	  // create the user GUI
	  //hostname = JOptionPane.showInputDialog("Please enter your host name");
	 // port = Integer.parseInt(JOptionPane.showInputDialog("Please enter your port number"));
	  
	 // StaffServer server = new StaffServer(6132);
	  StaffClent frame = new StaffClent("BUSCISMYSQL01",6132);
		 
		
		//Set GUI frame settings
		 frame.pack();
		 frame.setLocationRelativeTo(null); // New since JDK 1.4
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true); // Display the frame
		 
  }
}