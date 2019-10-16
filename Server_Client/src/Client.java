

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class Client {
	
	private Socket	conn;
	public ClientGui gui;
	ObjectOutputStream clientOutputStream;
	ObjectInputStream clientInputStream;
	public Message message;
	private  final int INSERT_OP = 0;
	private final int DEPOSITE_OP = 1;
	private  final int WITHDRAW_OP = 2;
		

	public Client(int port) throws IOException {
		
		viewGui(); 
		connect("localhost", port);
		 
	}	
	
	public void connect(String hostAddress,int  connectingPort) throws IOException{
		
		conn = new Socket(hostAddress, connectingPort);
		clientOutputStream = new ObjectOutputStream(conn.getOutputStream());
		clientInputStream = new ObjectInputStream(conn.getInputStream());
		gui.resposeText.append("Connected \n");
	}
		
	
	public void sendMessage(int number, String name, int opType, double amount) throws IOException, ClassNotFoundException {	
		
		message = new Message (number, name, 0.0, opType, amount);
		clientOutputStream.writeObject(message);
       	receivingMessage();
		
		}


	private void receivingMessage() throws IOException, ClassNotFoundException {
	
		message = (Message)clientInputStream.readObject();
		
		
		switch (message.opType) { 
		
		case INSERT_OP: if (message.number != null){
			
			            gui.resposeText.append("customerNumber:  "  + message.number +
					    "   customerName:   " + message.name + "   customerBalance:   " 
	        		    + message.balance +  "   IS INSERTED   " +  "\n");
			            }else{
				            gui.resposeText.append(" Customer "  +   "  Is NOT INSERTED!  "  + "\n");
			            }
		                break;
		
	  case DEPOSITE_OP: if (message.number != null){
		                gui.resposeText.append("customerNumber:  "  + message.number +
		                   "   customerName:   " + message.name + "   customerBalance:   " 
		                   + message.balance +  "   After Deposite   " +  "\n");
                       } else{
	                      gui.resposeText.append(" Amount "  + "  Is NOT Deposited!  "  + "\n");
                       }
                       break;
			
		case WITHDRAW_OP: if (message.number != null){
                             gui.resposeText.append("customerNumber:  "  + message.number +
                              "   customerName:   " + message.name + "   customerBalance:   " 
                              + message.balance +  "   After Withdraw   " +  "\n");
                           } else{
                             gui.resposeText.append(" Amount "  + "  Is NOT Withdrawn!  "  + "\n");
                           }
                           break;
		}
	}
	
	
	public void insertCustomer(Integer number, String name) throws IOException, ClassNotFoundException {
		
		sendMessage(number,name, INSERT_OP,0.0);
			
	}
	
	public void deposit(Integer number, double amount) throws IOException, ClassNotFoundException {
		
		sendMessage(number, "", DEPOSITE_OP,amount);
			
	}
	

	public void withdraw(Integer number, double amount) throws IOException, ClassNotFoundException {
	
	sendMessage(number, "", WITHDRAW_OP,amount);
		
	}


	public void viewGui(){
	
	gui = new ClientGui(this);
    gui.pack();
    gui.setVisible( true );
    
	}

	public void close() throws IOException{
	
		clientOutputStream.close();
		clientInputStream.close();
		System.exit(0);
		
	}

	public static void main(String[] args) throws IOException {
	
	int port = 9090;
	Client client = new Client(port); 
	
	} 
	
}
