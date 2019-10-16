package PP4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class UserGUI extends JPanel implements ActionListener{

	// note that this is hard-coded can change if user wants but for this project we have to hard code it
	  private String url = "http://www.nfl.com/players/search?category=position&filter=defensiveback&conferenceAbbr=null&playerType=current&conference=ALL";
	  private Scraper scraper;
	
	  // all labels
	  private JLabel lblOutput;
	  
	  // buttons
	  private JButton btnScrape;
	  private JButton btnClose;	  
	 
	  // text area 
	  public static JTextArea textArea;
	  private JScrollPane jp;
	  
	  
	  
	  public UserGUI() throws IOException {
		 
		  // uses the url provided in the document
		  scraper = new Scraper(url);

	    initGUI();
	    doTheLayout();
	    
	    btnScrape.addActionListener(this);
	    btnClose.addActionListener(this);
	   
	  } // end of constructor

	  
	  // Creates and initialize the GUI objects
	  private void initGUI(){
		  
		  lblOutput = new JLabel("Output");
		  btnScrape = new JButton("Scrape NFL Page");
		  btnClose = new JButton("Close");
		  
		  textArea = new JTextArea(10, 20);
	      textArea.setEditable(false);
	      textArea.setLineWrap(true);
	      textArea.setWrapStyleWord(true);
	      jp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	      
	  
	  }// end of creating objects method

	
	  // Layouts the UI components as shown in the project document
	  private void doTheLayout(){
		  JPanel top = new JPanel();  JPanel center = new JPanel();  JPanel bottom = new JPanel(); 
		  
		  // top, center, bottom
		  top.setLayout(new BorderLayout());
		  top.add(btnScrape, BorderLayout.NORTH);
		  top.add(lblOutput, BorderLayout.CENTER);
		  
		  center.setLayout(new BorderLayout());
		  center.add(jp, BorderLayout.CENTER);
		  
		  bottom.setLayout(new BorderLayout());
		  bottom.add(btnClose, BorderLayout.CENTER);
		  
		
	     setLayout( new BorderLayout());
	     this.add(top, "North");
	     this.add(center, "Center");
	     this.add(bottom, "South");

	  }// end of Layout method

	 
	// Uses the Scraper object reference to return and display the data as shown in the project document 
	 void btnScrapeClicked() throws IOException{
		scraper.parseData();
		    
	  }// end of scrape action event method
	  
	 
	  void btnCloseClicked(){
	    System.exit(0);
	  }// end of close action event method


	public static void main(String[] args) throws IOException {
	    JFrame f = new JFrame("NFL Stats");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();
        contentPane.add( new UserGUI());
        contentPane.setSize(600, 600);
        f.pack();
        f.setSize(600, 500);
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
	
	}// end of main method


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnScrape)
		{
			try {
				btnScrapeClicked();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else btnCloseClicked();
				
	}

}// end of class
