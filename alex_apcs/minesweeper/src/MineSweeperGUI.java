//
// Class:	   MineSweeper
// Written By: Frank Lee
// Date:	   November 2010
//
// Character based implementation of mine sweeper game.
// Uses a nested class Tile to group Tile variables (aka struct)
// MineSweeper class implements most of the game operation.
//
// Revision:   Implement Graphical User Interface with Java swing classes
// Date:       March 2011 
// 
// Uses buttons to represent MineSweeper display tiles.
// All previous console interaction is commented out.
// Not all error possibilities considered.
// New comments related to GUI added.
// TO DO: 
// - tinker with button text size and color
// - 
//

import java.util.Scanner;
import javax.swing.*;           // GUI classes

import java.awt.event.*;        // for ActionListener
import java.awt.*;


public class MineSweeperGUI implements ActionListener { // GUI: ActionListener for monitoring user interaction
	// main method
	public static void main(String[] args){
		int	width, depth, bombs, result;						// game setup		
		boolean gameOver = false;
		java.util.Scanner	console;					// Java	console	Scanner
		console	= new java.util.Scanner(System.in);
		// System.out.println("MINE SWEEPER");	  
		// Input data	
		// System.out.print("Enter Mine Field Width:");	
		// width = console.nextInt();
		
		// GUI: .showInputDialog(String prompt, String defaultValue)
		width = Integer.parseInt(JOptionPane.showInputDialog("Enter Field Width", "20"));  
		//System.out.print("Enter Mine Field Depth:");	  
		//depth = console.nextInt();
		depth = Integer.parseInt(JOptionPane.showInputDialog("Enter Field Depth", "12"));
		//System.out.print(" Enter Number of Bombs:");	  
		//bombs = console.nextInt();
		bombs = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Bombs", "20"));
		// create MineSweeper instance
		// MineSweeperGUI mGame = new MineSweeperGUI(width, depth, bombs);
		mGame = new MineSweeperGUI(width, depth, bombs);
		
		//System.out.println("PLAY MINE SWEEPER!!");	 
		
		/* GUI: Afer the construction of MineSweeperGUI object
		 *      the monitoring of user input will now be handled by the actionPerformed method as
		 *      required by the implementation of the actionListener.
		 *      
		 *      The below operations will be performed in the actionPerformed method.
		 * 
		while (!gameOver) {
			//mGame.printTiles();
			//mGame.printTileValues(); //DEBUG
			long start = System.currentTimeMillis();   // a System method for elapsed time monitoring
			System.out.println("Enter Row and Column:");	  
			depth = console.nextInt();	
			width = console.nextInt();
			result = mGame.play(depth, width);
			if (result == BAD_COORDINATE) {
				System.out.println("** Incorrect Coordinate - Try Again **");	 
			} else if (result == DONE) {
				long end = System.currentTimeMillis();   // a System method for elapsed time monitoring
				mGame.printTiles();
				System.out.println("Congratulations, mine field cleared.");	
				System.out.println("Elapsed Time = " + ((end-start)/1000/60) + " minutes and " + ((end-start)/1000%60) + " seconds.");
				gameOver = true;
			} else if (result == LOSE) { 
				mGame.printTiles();
				System.out.println("KA BOOM, Game Over.");	
				gameOver = true;
			}
		}
		//System.out.println("Program Done");	
		  								
		 */
	}
	
	// GUI: this required method will receive and process user interaction 
	//      with GUI objects.
    public void actionPerformed(ActionEvent e)
    {
    	int userRow=0, userCol=0;
        int result;
        
        Object evtSource = e.getSource();   // ActionEvent method that returns reference of object that initiated event
        // determine which object initiated event
        // GUI Only has the 2D array of buttons.
        // Determine which button was clicked.
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				if (evtSource == tiles[row][col].display) {
					// record the row and col
					userRow = row;
					userCol = col;
				}		
			}
		}	
		
		result = mGame.play(userRow, userCol);
		//  GUI: no longer possible since user can only click an enabled button.
		//  if (result == BAD_COORDINATE) {
		// 	System.out.println("** Incorrect Coordinate - Try Again **");	 
		if (result == DONE) {
			//long end = System.currentTimeMillis();   // a System method for elapsed time monitoring
			//mGame.printTiles();
			//System.out.println("Congratulations, mine field cleared.");	
			JOptionPane.showMessageDialog(frame, "Congratulations, mine field cleared.");
			initialize(); // GUI: new game
			//System.out.println("Elapsed Time = " + ((end-start)/1000/60) + " minutes and " + ((end-start)/1000%60) + " seconds.");
			//gameOver = true;
		} else if (result == LOSE) { 
			//mGame.printTiles();
			//System.out.println("KA BOOM, Game Over.");
			JOptionPane.showMessageDialog(frame, "KA BOOM, Game Over.");
			initialize(); // GUI: new game
			//gameOver = true;
		}
		
		// GUI:
        // method is done
		// program will be idle until next event occurs
    }

	// class constants
	private final char  COVERED = 'X';
	private final char    CLEAR = ' ';
	private final int      BOMB = 9;
	private final int      OPEN = 0;
	private final int PROCESSED = -1;	
	private static final int CONTINUE = 0;
	private static final int BAD_COORDINATE = -1;
	private static final int LOSE = -10;	
	private static final int DONE = 10;	
	
	// (A nested Tile class)
	// Class Tile
	// Used to monitor program values and user display information.
	// (with public class variables, a.k.a struct)
	private class Tile {
		public int value;		 // program information
		// public char display;	 // user display info
		public JButton display;  // GUI: use JButtons for display instead of chars
		// constructor, default settings
		public Tile () {
			value = PROCESSED;
			//display = CLEAR;
			display = new JButton("");   //  GUI: no button label to begin
			display.setFocusable(false); //  GUI: do not allow focus highlighting
		}
	}
	
	// class variables
	private Tile[][] tiles;    // 2D array, choosing to view model as [rows][columns]
	private int rowSize, colSize, numBombs;
	
	// GUI: class variables (Added as part of March 2011 Revision)
	private JFrame frame;					   // Main frame to contain 2D grid of buttons
	private static MineSweeperGUI mGame;       // Make MineSweeperGUI object class accessible for use in main and actionPerformed methods.
	
	// GUI: class constants
	private final int  BUTTON_WIDTH = 50;	  // pixel size for each button
	private final int  BUTTON_HEIGHT = 50;	
	
	// Method: printTiles
	// Show tile chars
	public int play(int row, int col) {
		int response = CONTINUE;
		// check for bomb
		
		// GUI: two conditionals no longer possible with button management.
		// if (row<1 || row >rowSize || col<1 || col>colSize) {
		// 	response = BAD_COORDINATE;	
		// } else if (tiles[row][col].display!=COVERED) {
		// 	response = BAD_COORDINATE;
		if (tiles[row][col].value==BOMB) {
			response = LOSE;
			uncoverBombs();
		} else {
			uncoverTile(row, col);
			if (gameOver()) {
				response = DONE;
			}
		}
		// print Tile.display
		return (response);
	}
	
	// Constructor: setup 2D array, initialize bombs, initialize variables.
	public MineSweeperGUI(int w, int d, int b){
		rowSize = d;
		colSize = w;
		numBombs = b;
		// create arrays with a single element buffer around the array rectangle
		// i.e. the top left corner of the playing area is [1][1]	
		tiles = new Tile[rowSize+2][colSize+2];
		// fill to buffer as PROCESSED
		for (int row=0; row<rowSize+2; row++) {
			for (int col=0; col<colSize+2; col++){
				tiles[row][col] = new Tile();
			}
		}	
		
		/* GUI: moved to initialize() method
		//  clear field values
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				tiles[row][col].value=OPEN;
				tiles[row][col].display=COVERED;
			}
		}	
		*/
		
		// GUI: Setup JFrame and fill with buttons
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Dimension(int width, int height)
		frame.setSize(new Dimension(colSize*BUTTON_WIDTH, rowSize*BUTTON_HEIGHT));  // Dimension class in java.awt.*;
		frame.setTitle("Mine Sweeper 1.0");
		frame.setLayout(new GridLayout(rowSize, colSize)); // set JFrame with containers for display buttons
		frame.setResizable(false); // do not allow window resizing
		
		// GUI: add buttons on the field to the JFrame
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				// add the respective display button to the frame grid; columns filled first
				frame.add(tiles[row][col].display); 
				// include button as a GUI object to be montitored for events 
				tiles[row][col].display.addActionListener(this);
			}
		}	
		
		frame.setVisible(true);   // show frame to screen
		
		// debug
		//printTiles();
		//printTileValues();
		//System.out.println("+++++++++++++++++++++");
		initialize();
		showButtonValues(); // DEBUG tool // GUI: equivalent to printTileValues console method
	}
	
	// Method: printTiles
	// Show tile chars
	public void printTiles() {
		// print Tile.display
		for (int row=0; row<rowSize+2; row++) {
			for (int col=0; col<colSize+2; col++){
				System.out.printf("%2c", tiles[row][col].display);
			}
			System.out.println();
		}	
	}
	// Method: printTileValues
	// Show tile value
	public void printTileValues() {
		// print Tile.display
		for (int row=0; row<rowSize+2; row++) {
			for (int col=0; col<colSize+2; col++){
				System.out.printf("%2d", tiles[row][col].value);
			}
			System.out.println();
		}	
	}
	
	// Method: showButtonValues
	// Show value associated with each button
	public void showButtonValues() {
		// set button text
		for (int row=0; row<rowSize+2; row++) {
			for (int col=0; col<colSize+2; col++){
				tiles[row][col].display.setText(""+tiles[row][col].value);
			}
		}	
	}	
	
	// Method: uncoverBombs
	// Game is over, uncover all bombs
	public void uncoverBombs() {
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				if (tiles[row][col].value==BOMB){
					// tiles[row][col].display=toDisplayChar(tiles[row][col].value);
					tiles[row][col].display.setText("B");  // GUI: set button text to bomb
					tiles[row][col].display.setEnabled(false);	   // GUI: disable button
				}
			}
		}	
	}
	
	// Method: gameOver
	// check if player has one; number of tiles not processed = numBombs
	public boolean gameOver() {
		boolean gameover = false;
		int count = 0;
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				//if (tiles[row][col].display==COVERED){
				if (tiles[row][col].display.isEnabled()==true){  // GUI: count covered by counted enabled buttons
					count++;
				}
			}
		}
		if (count==numBombs) {
			gameover = true;
		}
		return(gameover);
	}
	
	// Method: initialize
	// Fill field with bombs and compute neighboring bombs information
	private void initialize() {	
		java.util.Random rand = new java.util.Random();		// Random class	
		int a, b, count=0;
		
		// GUI: clear field values and set up display buttons
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				tiles[row][col].value=OPEN;
				// tiles[row][col].display=COVERED;
				tiles[row][col].display.setEnabled(true); // enable all buttons for a new game
				tiles[row][col].display.setText(" ");     // GUI: already done in Tile constructor, this line demonstrates changing button text with .setText
			}
		}	
		
		// add random bombs
		while (count<numBombs) {
			a = rand.nextInt(rowSize)+1; // pick a row (+1 for buffer compensation)
			b = rand.nextInt(colSize)+1; // pick a col
			// confirm no Bomb is already at the position
			if (tiles[a][b].value != BOMB) {
				// place a Bomb at this position
				tiles[a][b].value = BOMB;
				count++;
			} else {
				//System.out.println("Repeat");
			}
		}
		//
		// TO DO: 
		// Fill tiles with number of neighboring bombs information
		// (quadruple nested loops with conditional)
		for (int row=1; row<=rowSize; row++) {
			for (int col=1; col<=colSize; col++){
				// if no bomb at this position ...
				if (tiles[row][col].value!=BOMB) { 
					// ... count number of bombs in neighboring tiles
					for (int rowShift=-1; rowShift<=1; rowShift++) {
						for (int colShift=-1; colShift<=1; colShift++){
							// ?
							if (tiles[row+rowShift][col+colShift].value==BOMB) {
								tiles[row][col].value++;
							}
						}
					} // end of neighboring Bomb count
				} // end of if
			}
			
		} // end of filling 	
		

		
	}
	
	// Method: uncoverTile
	// Update Tile.display to show selected tile, r,c.
	public void uncoverTile(int r, int c) {
		//java.util.Scanner	console;					// DEBUG
		//console	= new java.util.Scanner(System.in); // DEBUG
		
		// tiles[r][c].display=toDisplayChar(tiles[r][c].value);
		// GUI: use new method to updateButton
		updateButton(r,c);
		//printTiles();  // DEBUG
		//printTileValues(); // DEBUG
		// 
		// Use recursive concepts to display the entire open area if r,c value is OPEN
		// this is recursive because it calls itself. by doing this, it checks if surrounding tiles are without a bomb and uncovers them if true.
		if (tiles[r][c].value==OPEN) {
			// mark this spot as being used
			tiles[r][c].value=PROCESSED;
			// recursively uncoverTile to all neighboring tiles
			for (int rowShift=-1; rowShift<=1; rowShift++) {
				for (int colShift=-1; colShift<=1; colShift++){
					// ?
					//console.nextLine(); // DEBUG PAUSE
					uncoverTile(r+rowShift, c+colShift);
				}
			} 	
		}
		
		
	}
	
	// GUI: (added as part of March 2011 revision)
	// Method: updateButton
	// update button text and state at row, col
	private void updateButton(int row, int col) {
		int val = tiles[row][col].value;
		String t;
		
		if (val==BOMB) {
			t = "B";		
		} else if (val==OPEN || val==PROCESSED) {
			t = " ";	
		} else if (val==1) {t = "1";	
		} else if (val==2) {t = "2";
		} else if (val==3) {t = "3";
		} else if (val==4) {t = "4";
		} else if (val==5) {t = "5";
		} else if (val==6) {t = "6";
		} else if (val==7) {t = "7";
		} else if (val==8) {t = "8";
		} else { 
			t = "E"; // Error
		}
		
		// adjust button
		tiles[row][col].display.setText(t);
		tiles[row][col].display.setEnabled(false); // disable button
	}
	
	
	// Method: toDisplayChar
	// convert Tile.value to Tile.display character
	private char toDisplayChar(int val) {
		char c;
		if (val==BOMB) {
			c = 'B';		
		} else if (val==OPEN || val==PROCESSED) {
			c = CLEAR;	
		} else if (val==1) {c = '1';	
		} else if (val==2) {c = '2';	
		} else if (val==3) {c = '3';	
		} else if (val==4) {c = '4';	
		} else if (val==5) {c = '5';	
		} else if (val==6) {c = '6';	
		} else if (val==7) {c = '7';	
		} else if (val==8) {c = '8';	
		} else { 
			c = 'E'; // Error
		}
		return (c);
	}
	
}
