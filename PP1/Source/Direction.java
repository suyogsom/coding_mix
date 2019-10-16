// This class must have the code in the run() method, sub-program/routain to slove the maze;
//   seraches for the Java logo based on the provided path/direction algorithm

public class Direction extends Thread{

	Maze maze;
	Position location;
	
	Direction(Maze maze, Position location) {
		
		this.maze = maze;
		this.location = location;
	}
	
	// this is the code part that needs to be programmed by students to solve the maze 
	// using the provided path/direction algorithm
	public void run(){

		// this is a SAMPLE code of moving the student image in the maze,
		// and updates the information in Position.jav GUI class, append text into the JTextArea object
		// you should delete this code and start your solution, you may just keep the part of updating the information
		// in the Position.java class, appending information into the JTextArea object
		
		
	while(!maze.isDone()) 
	{				
	
		if(maze.getCurrRow()==0 && maze.getCurrCol()==0) 
			{ location.textArea.append("Game begins now...");
			  location.textArea.append("Now at row: " + maze.getCurrRow() + ", column: " + maze.getCurrCol() + "\n");
			}
		 
		{
			
			if(maze.getCurrCol()%2==0)
			{
					if(maze.getCurrRow() == maze.getHeight() - 1) 
					{							
						if(maze.getCurrCol() == maze.getWidth() - 1) 
						  { maze.moveLeft(); if(maze.isDone()) {location.textArea.append("Success! Logo Found \n"); break;}}
						 								   													
						else if(maze.getCurrRow()== maze.getHeight()-1)
						  { maze.moveRight(); if(maze.isDone()) {location.textArea.append("Success! Logo Found \n"); break;}}
							
					}
					
				 else { location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if(maze.moveDown()) {if(maze.isDone()) {location.textArea.append("Success! Logo Found \n"); break;}}
					  
						else
						{ 	maze.moveRight(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
							maze.moveDown(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
							maze.moveDown(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
							maze.moveLeft(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
						}
					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					}					
					
			}				
					
			else	
			{	 
					if(maze.getCurrRow()==0) 
					{						
						if(maze.getCurrCol() == maze.getWidth() - 1) 
						   { if(maze.moveLeft()) maze.isDone(); {location.textArea.append("Success! Logo Found \n"); break;}}
							
						 else if(maze.getCurrRow()== 0)
						 { maze.moveRight();if(maze.isDone()) {location.textArea.append("Success! Logo Found \n"); break;}}
						    		   					   				    		
					}
					
					
				  else { location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
						if(maze.moveUp()) {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}				
					  
						else
						{ 	maze.moveLeft(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
							maze.moveUp(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
							maze.moveUp(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
							maze.moveRight(); {if(maze.isDone()){location.textArea.append("Success! Logo Found \n"); break;}}
						}
					location.textArea.append("Moved to row " + maze.getCurrRow() + ", column " + maze.getCurrCol() + "\n");
					  }
					
					
		    }		
		}
		
	
  }				
 }
}
