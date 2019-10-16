package PP4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Scraper {
	
	private Matcher matcher;
	private Regex regex;
	private String url,display,url1,url2;
	URLConnection connect = null;
	String result = String.format("%-10s %-10s %-25s %-10s %-10s %-10s %-10s %-10s\n", "Pos", "Num", "Player Name", "Status", "TCKL", "SCK", "INT", "Team") + "\r\n";
	
	// constructor
	public Scraper (String url) throws IOException {
		this.url = url;
	} 
	
	// reads the data from a web page and searches for the string matches
	public void parseData() throws IOException {
		//Declaring  variables to store scraped values
		int y = 1;
		String playerPosition = "",playerNumber = "",playerName = "",playerStatus = "",playerTckl = "",playerSck = "",playerInte = "",playerTeam = "",strCon = "",strConEx = "";

		// all pattern references
		Pattern patPosition = Pattern.compile("CB(?=</td>)|SAF(?=</td>)|DB(?=</td>)");  Pattern patNumber = Pattern.compile("<td class=\"tbdy\">[\\d]*</td><td><a href=\"/player|<td class=\"tbdy\"></td><td><a href=\"/player");   Pattern patName = Pattern.compile("<td><a href=\"(.*?)profile\">(.*?)</a></td>");
		Pattern patStatus = Pattern.compile("<td class=\"tbdy\">(.*?)</td><td class=\"ra\">[\\s]+TCKL"); Pattern patTckl = Pattern.compile("<td class=\"ra\">[\\s]+TCKL+[\\s]+</td>[\\s]*<td class=\"tbdy\">(.*?)</td>");					Pattern patSck = Pattern.compile("<td class=\"ra\">[\\s]+SCK+[\\s]+</td>[\\s]*<td class=\"tbdy\">(.*?)</td>");
		Pattern patInte = Pattern.compile("<td class=\"ra\">[\\s]+INT+[\\s]+</td>[\\s]*<td class=\"tbdy\">(.*?)</td>");   Pattern patTeam = Pattern.compile("<td class=\"tbdy1\"><a href=\"/teams/(.*?)</a></td></tr>");
	
		// Regex object initialization
		regex = new Regex(patPosition, patNumber, patName, patStatus, patTckl, patSck, patInte, patTeam);
			
		url1 = url;
		java.net.URL urlFinal = new java.net.URL(url1);
		Scanner inputURL = new Scanner(urlFinal.openStream());
		
		while(inputURL.hasNext()) {
			String line = inputURL.nextLine();
			strCon = strCon.concat(line);
		}
		inputURL.close();
		
		Pattern patPageNumber = Pattern.compile("<span class=\"linkNavigation floatRight\">(.*?)next");
		Matcher matPageNumber = patPageNumber.matcher(strCon);
		// till you get all pages
		if(matPageNumber.find()) {
			String strPageNumber = matPageNumber.group(1);
			Pattern patPage = Pattern.compile("Go to page [\\d]");
			Matcher matPage = patPage.matcher(strPageNumber);
			while(matPage.find()) {
				y++;
			}
		}
		
		// putting page number into URL
		for(int x = 1;x<=y;x++) {
			url2 = "http://www.nfl.com/players/search?category=position&playerType=current&conference=ALL&d-447263-p="+x+"&filter=defensiveback&conferenceAbbr=null";
			java.net.URL urlFInal2 = new java.net.URL(url2);
			Scanner scannerInputURL2 = new Scanner(urlFInal2.openStream());
			while(scannerInputURL2.hasNext()) {
				String line = scannerInputURL2.nextLine();
				strConEx = strConEx.concat(line);
			}
			
			// matching records using matcher
			Matcher matPosition = regex.getPos().matcher(strConEx);		Matcher matNumber = regex.getNum().matcher(strConEx);	Matcher matName = regex.getLlayerName().matcher(strConEx);	Matcher matStatus = regex.getStatus().matcher(strConEx);
			Matcher matTckl = regex.getTckl().matcher(strConEx);		Matcher matSck = regex.getSck().matcher(strConEx);		Matcher matInte = regex.getIntt().matcher(strConEx);		Matcher matTeam = regex.getTeam().matcher(strConEx);

			// trying to get all records
			while(matPosition.find()&&matName.find()&&matNumber.find()&&matStatus.find()&&matTckl.find()&&matSck.find()&&matInte.find()&&matTeam.find()) {
				playerPosition = matPosition.group();  playerNumber = matNumber.group().substring(matNumber.group().indexOf(">") + 1, matNumber.group().indexOf("<", 2)); playerName = matName.group(2); playerStatus = matStatus.group(1).substring(matStatus.group(1).length()-3);
				playerTckl = matTckl.group(1);  playerSck = matSck.group(1);	playerInte = matInte.group(1);	 playerTeam = matTeam.group(1).substring(matTeam.group(1).indexOf(">")+1);
				
				result += String.format("%-10s %-10s %-25s %-10s %-10s %-10s %-10s %-10s\n", playerPosition, playerNumber, playerName, playerStatus, playerTckl, playerSck, playerInte, playerTeam) + "\r\n";
	
			} // end while loop
			
		}// end for loop
		
			String resultFile = "U:\\611 workspace\\PP4\\src\\PP4\\NFLStat.txt";
			
			// writing to file
			PrintWriter writingOutput = new PrintWriter (resultFile);			
			writingOutput.println(result);
			writingOutput.close();
			
			JOptionPane.showMessageDialog(null, "Results successfully wrote to file and now showing on GUI");
			display(result); 
			
	} // end parse method
	
	// shows the output (scraped data) in a text-area 
	public String display(String display) throws IOException{
		UserGUI.textArea.append(result);
		return null;
	}
} //end class