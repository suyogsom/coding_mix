import java.awt.Container;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


import javax.swing.JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Server {
	
	Socket		conn;
	ServerSocket 		serverSocket;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	ServerGui gui;
	ObjectInputStream serverInputStream;
	ObjectOutputStream serverOutputStream; 
	Message message;
	private  final int INSERT_OP = 0;
	private final int DEPOSITE_OP = 1;
	private  final int WITHDRAW_OP = 2;
	
	
	
	
	public Server(int port) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		viewGui();
		startListening(port);
		
	}	
	
		
	public Boolean startListening(int listeningPort) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		try {
			
			serverSocket = new ServerSocket(listeningPort);
			
			// this will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // setup the connection with the DB.
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost/mydatabase?"
		              + "user=root&password=");
		      
			gui.txtDisplayResults.append("Server Is Listening ON Port:  " + listeningPort + "\n");
			
			
		} catch (IOException e) {
			e.printStackTrace();
			gui.txtDisplayResults.append(e.getMessage()+"   :It couldn't listen on the port "+listeningPort + "\n");
			return false;
		}
				
		conn = serverSocket.accept(); 
		serverInputStream = new ObjectInputStream(conn.getInputStream());
		serverOutputStream = new ObjectOutputStream(conn.getOutputStream());
		gui.txtDisplayResults.append("Connection Request ....... Connection Accepted" + "\n");
		receivingMessage();
		return true;
		
	}
	
	
	private void receivingMessage() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		while (true){
		
		message = null;	
		message = (Message )serverInputStream.readObject();
		
		
        switch (message.opType) { 
		
		case INSERT_OP: insert(message);
				        break; 
				        
		 case DEPOSITE_OP: deposite(message);
                            break; 

		 case WITHDRAW_OP:  withdraw(message);
                             break; 
		 }
			
		 sendMessage(message); 
	   }
	    
		
	}
	
	public void deposite (Message message) throws SQLException{
		
	           // statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      // resultSet gets the result of the SQL query
		      resultSet = statement.executeQuery("select * from customer Where number = " + message.number + ";");
		 		
		if (resultSet.next() && message.amount > 0 ) {
			
			  message.balance= Double.parseDouble(resultSet.getString("balance")) + message.amount;
              message.name = resultSet.getString("name");
			
			 preparedStatement = connect
		          .prepareStatement("update customer SET balance = ? WHERE number = ? ");
		      preparedStatement.setDouble(1, message.balance);
		      preparedStatement.setInt(2, message.number);
		      preparedStatement.executeUpdate();
            
		      gui.txtDisplayResults.append("customerNumber:  "  + message.number +
		  		    "   customerName:   " + message.name + "   customerBalance:   "
		           + message.balance + " Is Updated  " + "\n");
		      		      
			} else { 
				gui.txtDisplayResults.append(" Cannot Do Deposite For  " + "customerNumber:  "  + message.number +
		    		    "\n");
			     message.number = null;
				//writeResultSet(resultSet);
			}
		
	}

	
	public void withdraw (Message message) throws SQLException{
		
        // statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // resultSet gets the result of the SQL query
	      resultSet = statement.executeQuery("select * from customer Where number = " + message.number + ";");
	 		
	if (resultSet.next() && Double.parseDouble(resultSet.getString("balance")) >= message.amount ) {
		
		  message.balance= Double.parseDouble(resultSet.getString("balance")) - message.amount;
       message.name = resultSet.getString("name");
		
		 preparedStatement = connect
	          .prepareStatement("update customer SET balance = ? WHERE number = ? ");
	      preparedStatement.setDouble(1, message.balance);
	      preparedStatement.setInt(2, message.number);
	      preparedStatement.executeUpdate();
     
	      gui.txtDisplayResults.append("customerNumber:  "  + message.number +
	  		    "   customerName:   " + message.name + "   customerBalance:   "
	           + message.balance + " Is Updated  " + "\n");
	      		      
		} else { 
			gui.txtDisplayResults.append(" Cannot Do Withdraw For " + "customerNumber:  "  + message.number 
	    		     + "\n");
		     message.number = null;
			//writeResultSet(resultSet);
		}
	
}

	
	
	public void insert (Message message) throws SQLException{
		
        // statements allow to issue SQL queries to the database
	      statement = connect.createStatement();
	      // resultSet gets the result of the SQL query
	      resultSet = statement.executeQuery("select * from customer Where number = " + message.number + ";");
	 		
	if (!resultSet.next()) {
		
		 preparedStatement = connect
	          .prepareStatement("insert into  customer values (?, ?, ?)");
	      preparedStatement.setInt(1, message.number);
	      preparedStatement.setString(2, message.name);
	      preparedStatement.setDouble(3, message.balance);
	      preparedStatement.executeUpdate();
     
	      gui.txtDisplayResults.append("customerNumber:  "  + message.number +
	    "   customerName:   " + message.name + "   customerBalance:   "
     + message.balance + " Is Inserted  " + "\n");
		} else { 
			gui.txtDisplayResults.append("customerNumber:  "  + resultSet.getString("number") +
		    "   customerName:   " + resultSet.getString("name") + "   customerBalance:   "
         + resultSet.getString("balance") + " Is Exist  " + "\n");
		     message.number = null;
			//writeResultSet(resultSet);
		}
	
}
	
		
	public void sendMessage(Message message) throws IOException {
		
        serverOutputStream.writeObject(message);

	}
	
	
	void viewGui(){
	
	JFrame frame = new JFrame();
	frame.setTitle("Bank Server");
	Container contentPane = frame.getContentPane();
	gui = new ServerGui(this);
	contentPane.add(gui);
	frame.pack();
	frame.setVisible(true);
	
	}


	public void closeAll() throws IOException, SQLException{
	 serverInputStream.close();
     serverOutputStream.close();
     resultSet.close();
     statement.close();
     connect.close();
 	 System.exit(0);
 	 
 	}


	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
	
	int 	port 	= 9090; 
	Server server = new Server(port);

	} 

}
