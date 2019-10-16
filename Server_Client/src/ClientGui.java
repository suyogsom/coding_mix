
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

class ClientGui extends JFrame {

private     JSplitPane  splitPaneV;
private     JSplitPane  splitPaneH;
private     JPanel      panel1;
private     JPanel      panel2;
private     JPanel      panel3;

public JTextField nameField;
public JTextField numberField;
public JTextField amountField;
public JTextField numberReqField;
public JTextArea resposeText;
public JButton insertButton;
public JButton depositButton;
public JButton withdrawButton;
public JButton closeButton;
Client conn;

public ClientGui(Client conn){
	
	this.conn = conn;
    setTitle( "Bank Customer" );
    setBackground( Color.BLUE );

    JPanel topPanel = new JPanel();
    topPanel.setLayout( new BorderLayout() );
    getContentPane().add( topPanel );

    createPanel1();
    createPanel2();
    createPanel3();

    splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
    topPanel.add( splitPaneV, BorderLayout.CENTER );

    splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
    splitPaneH.setRightComponent( panel2 );
    splitPaneH.setLeftComponent( panel1 );
    
    splitPaneV.setLeftComponent( splitPaneH );
    splitPaneV.setRightComponent( panel3 );
    
    insertButton.addActionListener( new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e){
            try {
				insert_actionPerformed(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
            }
    });
    
    depositButton.addActionListener( new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e){
            try {
				deposit_actionPerformed(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
            }
    });

    
    withdrawButton.addActionListener( new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e){
            try {
				withdraw_actionPerformed(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
            }
    });
    
    
    closeButton.addActionListener( new java.awt.event.ActionListener() {
        public void actionPerformed(ActionEvent e){
            try {
				close_actionPerformed(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            }
    });
    
}


 
  public void createPanel1(){
	  
    panel1 = new JPanel();
    panel1.setLayout( new FlowLayout() );
    panel1.setBackground(Color.CYAN);
    
    nameField = new JTextField(15);
    numberField = new JTextField(5);
    insertButton = new JButton( "Insert" );
    panel1.add( new JLabel("Number"));
    panel1.add( numberField);
    panel1.add( new JLabel("Name"));
    panel1.add( nameField );
    panel1.add(insertButton);
    

  }


  public void createPanel2(){
    panel2 = new JPanel();
    panel2.setLayout( new FlowLayout() );
    panel2.setBackground(Color.yellow.brighter());

    depositButton = new JButton( "Deposit" );
    withdrawButton = new JButton( "Withdraw" );
    amountField = new JTextField(5);
    numberReqField = new JTextField(5);
    panel2.add(depositButton);
    panel2.add(withdrawButton);
    panel2.add( new JLabel("Number"));
    panel2.add(numberReqField); 
    panel2.add( new JLabel("Amount"));
    panel2.add(amountField);
    
  }


  public void createPanel3(){
    
	panel3 = new JPanel();
    panel3.setLayout( new BorderLayout() );
    panel3.setPreferredSize( new Dimension( 400, 500 ) );
    panel3.setMinimumSize( new Dimension( 100, 50 ) );
    
    resposeText = new JTextArea();
    resposeText.setEditable(false);
    closeButton = new JButton( "Close" );
    
    panel3.add( new JLabel( "Server Response:" ), BorderLayout.NORTH );
    panel3.add( resposeText,BorderLayout.CENTER );
           
    JScrollPane scroll = new JScrollPane ( resposeText );
    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
    panel3.add(scroll);
    panel3.add( closeButton,BorderLayout.WEST );
    
  }



  void insert_actionPerformed(ActionEvent e) throws IOException, ClassNotFoundException{
	
	Integer number = 0;
	String name = nameField.getText();
	String numbertext = numberField.getText(); 
	
	if (name.length() == 0 || numbertext.length() == 0){
		nameField.setText("");
		numberField.setText("");
		resposeText.append("Data Is Needed  \n");
		return;
	}
	
	try {
			number = Integer.parseInt(numbertext);
			
	} catch(NumberFormatException nfe) {
		nameField.setText("");
		numberField.setText("");
		resposeText.append("Invaild Input Data Format \n");
		System.out.println("catched");
		return;
		
	} 
	
	nameField.setText("");
	numberField.setText("");
	resposeText.append("Customer Data Inserted \n");
	conn.insertCustomer(number, name);
	
  }


  void deposit_actionPerformed(ActionEvent e) throws IOException, ClassNotFoundException{
	
	Integer number = 0;
	double amount = 0;
	String numberText = numberReqField.getText();
	String amounText =  amountField.getText(); 
	
	if (numberText.length() == 0 || amounText.length() == 0){
		numberReqField.setText("");
		amountField.setText("");
		resposeText.append("Data Is Needed  \n");
		return;
	}
	
	try {
			number = Integer.parseInt(numberText);
			amount = Double.parseDouble(amounText);
			
	} catch(NumberFormatException nfe) {
		numberReqField.setText("");
		amountField.setText("");
		resposeText.append("Invaild Input Data Format \n");
		System.out.println("catched");
		return;
		
	} 
	
	numberReqField.setText("");
	amountField.setText("");
	resposeText.append("Customer Data Inserted \n");
	conn.deposit(number, amount); 
	
  }


  void withdraw_actionPerformed(ActionEvent e) throws IOException, ClassNotFoundException{
	
	Integer number = 0;
	double amount = 0;
	String numberText = numberReqField.getText();
	String amounText = amountField.getText(); 
	
	if (numberText.length() == 0 || amounText.length() == 0){
		numberReqField.setText("");
		amountField.setText("");
		resposeText.append("Data Is Needed  \n");
		return;
	}
	
	try {
			number = Integer.parseInt(numberText);
			amount = Double.parseDouble(amounText);
			
	} catch(NumberFormatException nfe) {
		numberReqField.setText("");
		amountField.setText("");
		resposeText.append("Invaild Input Data Format \n");
		System.out.println("catched");
		return;
		
	} 
	
	numberReqField.setText("");
	amountField.setText("");
	resposeText.append("Customer Data Inserted \n");
	conn.withdraw(number, amount); 
	
  }


  void close_actionPerformed(ActionEvent e) throws IOException{
    
	  conn.close();
	  
  }

}