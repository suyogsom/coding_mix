package PA08;

// add the class template 

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.applet.*;
import javax.swing.*;

import java.sql.*;
import javax.swing.border.*;

public class StaffServer {
 
  private Statement statement = null;
  private int port;
  Message message;;
  ServerSocket 	serverSocket;
  Socket clientSocket ;
  private Connection connect = null;

  
  ObjectInputStream serverInputStream;
  ObjectOutputStream serverOutputStream;
  
  
  private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
  
  	// operations
	public static int opType;
    private  final int VIEW_OP = 0;
	private final int INSERT_OP = 1;
	private  final int DELETE_OP = 2;
	private  final int UPDATE_OP = 3;

  
  public StaffServer (int port) throws ClassNotFoundException, SQLException{
	  
	  this.port = port;
	  initializeDB();
	  
  }

  
  public void initializeDB() throws ClassNotFoundException, SQLException {
    
      
	  try {
		// create the server
		serverSocket = new ServerSocket(port); System.out.print("Server is up successfully");
		//clientSocket = serverSocket.accept();
		
		// to load MySQL drive 
		 Class.forName("com.mysql.cj.jdbc.Driver"); System.out.print("\n\nDriver loaded successfully");
		 
		 // Connect to your database using your credentials
		 connect = DriverManager.getConnection("jdbc:mysql://BUSCISMYSQL01/team17db","suyogsom","c611c!04903");
		 System.out.print("\n\nConnected with database successfully");
		 
		  // Create a statement object
		 statement = connect.createStatement();
		 
		 
		  while (true) {
	          //  loops for ever waiting for the client connection requests
	          Socket socket = serverSocket.accept();          
	          HandleAClient task = new HandleAClient(socket);
	          new Thread(task).start();
	        } 
		 
		 
		  // loops for ever waiting for the client connection requests
  	     		// create a thread for each client connection request using Runnable class HandleAClient 
		 
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    
 
  }

 

  /**View record by ID
 * @throws SQLException */
  private void view() throws SQLException {
   // Build a SQL SELECT statement
	  opType =0;
	  statement = connect.createStatement();
	  resultSet = statement.executeQuery("SELECT * FROM team17db.staff" );
  }

  
  /**Insert a new record
 * @throws SQLException */
  private void insert() throws SQLException {
    // Build a SQL INSERT statement
	  opType =1;
	  statement = connect.createStatement();
	  resultSet = statement.executeQuery("SELECT * FROM team17db.staff Where id = " + message.getId() + ";");
	  
	  if (!resultSet.next()) {
			
			 preparedStatement = connect.prepareStatement("insert into  customer values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		          
		      preparedStatement.setInt(1, message.getId());
		      preparedStatement.setString(2, message.getLastName());
		      preparedStatement.setString(3, message.getFirstName());
		      preparedStatement.setString(4, message.getMi());
		      preparedStatement.setString(5, message.getAddress());
		      preparedStatement.setString(6, message.getCity());
		      preparedStatement.setString(7, message.getState());
		      preparedStatement.setInt(8, message.getmPhoneNo());
		      preparedStatement.setInt(9, message.gethPhoneNo());
		      preparedStatement.executeUpdate();
		   

			} else { 			
			    System.out.print("Staff ID exist in sysytem");
				
			}
   }

  /**Update a record*/
  private void update() {
  // Build a SQL UPDATE statement
	  opType =2;
  }

  /**Clear text fields*/
  private void delete() {
	// Build a SQL DELETE statement
	  opType =3;
  }

  
  
  
    // inner Runnable class handle a client connection
	class HandleAClient implements Runnable {
	    private Socket socket; // A connected socket

	    /** Construct a thread */
	    public HandleAClient(Socket socket) {
	      this.socket = socket;
	    }

	    /** Run a thread */
	    public void run() {
	    	
	    	try {
				ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		     try {
				ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    	
	    	// write the code to call a proper method to process the client request
	    	while (true){
	    		
	    		Message message = null;	
	    		try {
					message = (Message )serverInputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		
	            switch (opType) { 
	    		
	    		case  VIEW_OP: try {
						view();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    				        break; 	    				        
	    		 case INSERT_OP: try {
						insert();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                                break; 
	    		 case DELETE_OP:  update();
	                                 break; 
	    		 case UPDATE_OP:  delete();
                 					break; 
	    		 }
	            
	            try {
	            	 outputToClient(message);;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	    	   }
	    }
	   }// end of class Runnable 
	
	
	public void outputToClient(Message message) throws IOException {
		
        serverOutputStream.writeObject(message);

	}
	
  
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    StaffServer server = new StaffServer(6132);
    
  }
}
