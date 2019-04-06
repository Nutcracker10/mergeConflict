
/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EastPanel extends JPanel implements ActionListener, Scrollable{

	JTextField enterText = new JTextField(); // a field for entering details
	JTextArea areaText = new JTextArea("Welcome to Backgammon\n"); // an area for displaying game details
	JTextArea playerName = new JTextArea("Player: "); // Displays player name
	JTextArea playerScore = new JTextArea("Score: "); // Displays Player Score
	JPanel subpanel = new JPanel();					// a subpanel for buttons

    private int moveStatus = 2; // a global variable which dictates how the move function works

	// adds scrolling functionality to the text area
	JScrollPane scrollPane = new JScrollPane(areaText);



	// Players
	Player white = new Player("", 0);
	Player black = new Player("", 1);

	Document doc = areaText.getDocument(); // a means of getting text details
	int[] result = new int[2]; //a way to store dice rolls
	Board board; //a way to get the boards information to east panel
	
	//ArrayList of action listeners
	ArrayList<EventListener> listeners = new ArrayList<EventListener>();
	
	int turnNumber = 0; // to count what turn it is

	public EastPanel() 
	{


		this.setLayout(new BorderLayout()); // sets border layout to Eastpanel
		subpanel.setLayout(new GridLayout(2, 1)); // sets grid layout to subpanel

		// prevents user from typing in these areas
		areaText.setEditable(false);
		playerScore.setEditable(false);
		playerName.setEditable(false);

		enterText.addActionListener(this);

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// adds each component to panel
		subpanel.add(playerName);
		subpanel.add(playerScore);
		this.add(enterText, BorderLayout.SOUTH);
		this.add(subpanel, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.EAST); //textarea contained in scrollpane

	//	areaText.setPreferredSize(new Dimension(155, 627));

		this.areaText.append("\nCommands : "); // telling the user what commands they can use
		this.areaText.append("\nwName -> save white's name" + "\nbName -> save black's name" + "\nmove -> enter a move" +
							 "\nnext -> end turn" + "\nquit -> end the program\n" );

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel
		playerScore.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates line around score

		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);







	}

	public int[] autoDiceRoller() { // automatically rolls dice and returns an array of results
		Dice die = new Dice();
		int[] result = new int[2];

		result[0] = die.getDie1();
		result[1] = die.getDie2();

		return result;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		String text = enterText.getText();
		boolean gameHasBegun = false; // flag to show the game has started

		if (text.equals("quit")) { // ends program if string is quit
			System.exit(0);
		}
		
		else if (text.startsWith("wName")) // command to save white player's name
		{
			white.name = text.substring(6);
			areaText.append("\nWhite : " + white.name);
			playerName.setText(white.name);
			enterText.selectAll();
		}
		
		else if (text.startsWith("bName")) // command to save black player's name
		{
			black.name = text.substring(6);
			areaText.append("\nBlack : " + black.name);
			playerName.setText(black.name);
			enterText.selectAll();

		}

		else if (text.equals("next") && !(black.haveWon || white.haveWon)) // user switching between turns
		{
			nextTurn();
		}

		else if (text.startsWith("move") && !(black.haveWon || white.haveWon)) {

			move(text);

		}// end of move
		
		else if(text.startsWith("cheat"))
		{
			notifyCheatListeners();
			
			if(white.myTurn)
			{
				white.myTurn = false;
				black.myTurn = true;
				areaText.append("\n\n" + black.name + "'s turn");
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,1);
				moveStatus = moveCheck(board.acceptableMoves(1, result));
				enterText.selectAll();
				turnNumber++;
			}
			
			else
			{
				black.myTurn = false;
				white.myTurn = true;
				areaText.append("\n\n" + white.name + "'s turn");
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,0);
                moveStatus = moveCheck(board.acceptableMoves(0, result));
				enterText.selectAll();
				turnNumber++;
			}
		}

		else {
			areaText.append("\nUnrecognised Command :\n");
			areaText.append(text + "\n");
			enterText.selectAll();
		}

		if (ReadyToStart() && turnNumber == 0) // Have to do this inside the action listener because of threads and swing
		{
			areaText.append("\nGAME START"); // Announces start of the games
			gameHasBegun = true;
		}

		if (gameHasBegun) // if the game has started
		{
			if(white.myTurn) {
				board.setWhosTurn(0);
			}
			else {
				board.setWhosTurn(1);
			}

			if (white.goFirst(black)) { // We check who goes first
				areaText.append("\n" + white.name + " goes first");
				playerName.setText("Name: " + white.name);
				playerScore.setText("Score: " + Integer.toString(white.getScore()));
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,0);
				moveStatus = moveCheck(board.acceptableMoves(0, result));
				white.myTurn = true;
			} 
			else {
				areaText.append("\n" + black.name + " goes first");
				playerName.setText("Name: " + black.name);
				playerScore.setText("Score: " + Integer.toString(black.getScore()));
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,1);
                moveStatus = moveCheck(board.acceptableMoves(1, result));
				black.myTurn = true;
			}
		}



	}// end of actionPerformed

	public boolean ReadyToStart() // if both players given their names, this method returns true.
	{
		return ((!(black.name.equals("")) && !(white.name.equals(""))));
	}
	
	public void addListener(EventListener l)
	{
		listeners.add(l);
	}
	
	public void notifyMoveListeners(String colour, int from, int to)
	{
		for(EventListener m : listeners)
		{
			m.move(colour, from, to);
		}
	}
	
	public void notifyCheatListeners()
	{
		for(EventListener m : listeners)
			m.cheat();
	}

	public int[] moveSelection(Board board, int colour, String input) {
	    String[] moves = board.acceptableMoves(colour, result).split("\\n");
	    int[] moveToReturn = new int[2];
	    int from; int to;

	    //formatting input for work
	    input = input.substring(input.length()-2, input.length()); // isolates the input from move
        input = input.replaceAll(" ", ""); // removes any white spaces from input
        input = input.toUpperCase();

        for (int i=0; i<moves.length;i++) {
            if (moves[i].startsWith(input) ) { // checks if the move starts with the input i.e A
            	String string = moves[i].substring(2);
            	string = string.replaceAll("\\s+", ""); // removing white spaces

                String firstHalf = string.substring(0, string.indexOf("-"));

                try {
						if (string.contains("Bar")) {
							from = 25;
							moveToReturn[0] =from;
						}
						else {
							firstHalf = firstHalf.replaceAll("-", "");
							from = Integer.parseInt(firstHalf);
							moveToReturn[0] = from;
						}
						if(string.contains("Off")) {
							to = 0;
							moveToReturn[1] = to;
						}
						else {
							String secondHalf = string.substring(string.indexOf("-") + 1);
							to = Integer.parseInt(secondHalf);
							moveToReturn[1] = to;
						}
                    }
                    catch (NumberFormatException e) {
                        areaText.append("\nERROR in MOVESELECTION()\n");
                    }
                }
            }  //end of for loop

        return moveToReturn;
    }//end of moveSelection

	public void nextTurn() {
		if (white.myTurn) {
			white.myTurn = false;
			black.myTurn = true;
			playerName.setText("Name: " + black.name);
			playerScore.setText("Score: " + Integer.toString(black.getScore()));
			playerName.setText(black.name);

			areaText.append("\n\n" + black.name + "'s turn");
			result = autoDiceRoller();
			areaText.append("\nRoll: " + result[0] + " " + result[1]);
			addPossibleMoves(board,1);
            moveStatus= moveCheck(board.acceptableMoves(1, result));
			enterText.selectAll();
		}

		else {
			white.myTurn = true;
			black.myTurn = false;
			playerName.setText("Name: " + white.name);
			playerScore.setText("Score: " + Integer.toString(white.getScore()));
			playerName.setText(white.name);
			areaText.append("\n\n" + white.name + "'s turn");
			result = autoDiceRoller();
			areaText.append("\nRoll: " + result[0] + " " + result[1]);
			addPossibleMoves(board,0);
            moveStatus = moveCheck(board.acceptableMoves(0, result));
			enterText.selectAll();
		}
		
		turnNumber++;


	} // end of next turn

	public void move(String text) {

		int colour;
		if(white.myTurn)
			colour = white.colour;
		else
			colour = black.colour;
		/*
		if (moveStatus == 0) { // change to next turn
			areaText.append("No available moves, changing turn...\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nextTurn();
			moveStatus = 2;
			return;
		}

		else if(moveStatus == 1) {
			areaText.append("One move possible, making move...\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move("move A");
			moveStatus = 2;
			return;
		} */

		if(true) { // move as normal
			int[] array = moveSelection(board, colour, text); // break up all possible moves into a 2d array
			int to = array[1];
			int from = array[0];


			areaText.append("\n" + from + " " + to);

			if ((from < 0) || (to < 0) || (from > 25) || (to > 25)) {
				areaText.append("Not a valid move");
				return;
			}

			if (white.myTurn) {
				notifyMoveListeners(white.getColour(), from, to);
			} else if (black.myTurn) {
				notifyMoveListeners(black.getColour(), from, to);
			}

		}
		enterText.selectAll();
		turnNumber++;
		areaText.append("\n");
		addPossibleMoves(board, colour);
	} // end of move

	public int moveCheck(String input) {

	    String[] moves = input.split("\\n"); // saves possible moves to an array of strings

        if (moves.length == 1) {
			areaText.append("\nNo available moves,\n changing turn...\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			moveStatus = 2;
			nextTurn();
        	return 0;
        } // return 0 if there are no moves

        else if (moves.length == 2) {
			areaText.append("\nOne move possible, making move...\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move("move A");
			moveStatus = 2;

        	return 1;
        } // return 1 if there is only one move

        else {return 2;} // else return 2

	} // end of moveCheck


	public void addPossibleMoves(Board board, int colour)

	{
		areaText.append(board.acceptableMoves(colour, result));
	}

	public void setBoard(Board board)
	{
		this.board = board;
	}

	//methods to implement the scrollable class

	public Dimension getPreferredScrollableViewportSize()
	{
		return new Dimension(155, 627);
	}


	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction)
	{
		return 4;
	}

	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction)
	{
		return 2;
	}

	public boolean getScrollableTracksViewportHeight()
	{
		return true;
	}

	public  boolean getScrollableTracksViewportWidth()
	{
		return true;
	}


}
