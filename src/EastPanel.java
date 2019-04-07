
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

	private JTextField enterText = new JTextField(); // a field for entering details
	JTextArea areaText = new JTextArea("Welcome to Backgammon\n"); // an area for displaying game details
	private JTextArea playerName = new JTextArea("Player: "); // Displays player name
	private JTextArea playerScore = new JTextArea("Score: "); // Displays Player Score
	private JPanel subpanel = new JPanel();					// a subpanel for buttons

	// adds scrolling functionality to the text area
	private 	JScrollPane scrollPane = new JScrollPane(areaText);

	// Players
	Player white = new Player("", 0);
	Player black = new Player("", 1);

	Document doc = areaText.getDocument(); // a means of getting text details
	int[] result = new int[2]; //a way to store dice rolls
	Board board; //a way to get the boards information to east panel
	
	//ArrayList of action listeners
	ArrayList<EventListener> listeners = new ArrayList<EventListener>();
	
	int turnNumber = 0; // to count what turn it is
	int match = 0;
	int doublingCube = 1;
	boolean hasDoubled = false;

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
		this.areaText.append("\nwName -> save white's name" + "\nbName -> save black's name" + "\npoints -> enter points to play to"
							+ "\nmove -> enter a move" + "\nnext -> end turn" + "\nquit -> end the program\n" );

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel
		playerScore.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates line around score
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

	private int[] autoDiceRoller() { // automatically rolls dice and returns an array of results
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
			playerScore.setText("Score: " + Integer.toString(white.getScore()));
			playerName.setText("Name: " + white.name);
			enterText.selectAll();
		}
		
		else if (text.startsWith("bName")) // command to save black player's name
		{
			black.name = text.substring(6);
			areaText.append("\nBlack : " + black.name);
			playerName.setText("Name: " + black.name);
			playerScore.setText("Score: " + Integer.toString(black.getScore()));
			enterText.selectAll();

		}

		else if (text.equals("next") && !(black.haveWon || white.haveWon)) // user switching between turns
		{
			nextTurn();
		}

		else if (text.startsWith("move") && !(black.haveWon || white.haveWon))
		{
			move(text);
		}// end of move
		
		else if(text.startsWith("cheat") && !(black.haveWon || white.haveWon))
		{
			notifyCheatListeners();
			
			if(white.myTurn)
			{
				white.myTurn = false;
				black.myTurn = true;
				areaText.append("\n\n" + black.name + "'s turn");
				playerName.setText("Name: " + black.name);
				playerScore.setText("Score: " + Integer.toString(black.getScore()));
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,1);
				moveCheck(board.acceptableMoves(1, result));
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
                moveCheck(board.acceptableMoves(0, result));
				enterText.selectAll();
				turnNumber++;
			}
		}

		else if(text.startsWith("points"))
		{
			match = Integer.parseInt(text.substring(7));
			if(match % 2 != 1)
			{
				areaText.append("\nInvalid match length.\nMust not be divisble by two.\n");
				match = 0;
			}
			notifyMatchListeners();
			enterText.selectAll();
		}

		else if(text.startsWith("double"))
		{
			if(white.isMyTurn())
			{
				if(white.hasDoublingCube())
				{
					areaText.append("\n" + white.getName() + " is doubling.");
					areaText.append("\nDo you accept, " + black.getName() + "?\nEnter Y/N");
					hasDoubled = true;
				}

				else
				{
					areaText.append("\nYou cannot double at this time.");
				}
			}

			else
			{
				if(black.hasDoublingCube())
				{
					areaText.append("\n" + black.getName() + " is doubling.");
					areaText.append("\nDo you accept, " + white.getName() + "?\nEnter Y/N");
					hasDoubled = true;
				}

				else
				{
					areaText.append("\nYou cannot double at this time.");
				}
			}

			enterText.selectAll();
		}

		else if(((text.startsWith("Y")) || (text.startsWith("y"))) && hasDoubled)
		{
			if(white.isMyTurn())
			{
				doublingCube = doublingCube * 2;
				white.doublingCube = false;
				black.doublingCube = true;
				areaText.append("\nScore will be multiplied by " + doublingCube);
				enterText.selectAll();
			}

			else if(black.isMyTurn())
			{
				doublingCube = doublingCube * 2;
				black.doublingCube = false;
				white.doublingCube = true;
				areaText.append("\nScore will be multiplied by " + doublingCube);
				enterText.selectAll();
			}
			notifyDoubleCubeListeners();
		}

		else if(((text.startsWith("N")) || (text.startsWith("n"))) && hasDoubled)
		{
			if(white.isMyTurn())
			{
				areaText.append("\n" + black.getName() + " has forfeited.");
			}

			else if(black.isMyTurn())
			{
				areaText.append("\n" + white.getName() + " has forfeited.");
			}
		}

		else if(text.startsWith("roll"))
		{

		}

		else
		{
			areaText.append("\nUnrecognised Command :\n");
			areaText.append(text + "\n");
			enterText.selectAll();
		}

		if (ReadyToStart() && turnNumber == 0) // Have to do this inside the action listener because of threads and swing
		{
			areaText.append("\nGAME START"); // Announces start of the games
			areaText.append("\nPOINTS TO WIN: " + match);
			gameHasBegun = true;

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
				moveCheck(board.acceptableMoves(0, result));
				white.myTurn = true;
			} 
			else {
				areaText.append("\n" + black.name + " goes first");
				playerName.setText("Name: " + black.name);
				playerScore.setText("Score: " + Integer.toString(black.getScore()));
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,1);
                moveCheck(board.acceptableMoves(1, result));
				black.myTurn = true;
			}

			turnNumber++;
		}



        if((white.haveWon || black.haveWon) && text.equals("yes"))
        {
            turnNumber = 0;
            board.restBoard();
        }


		if(black.hasWonGame(board.numInBlackSlot))
		{
			areaText.append("\nCongratulations " + black.getName()+" has won");
			areaText.append("\nWould you like to play again? yes/no");

		}

		else if(white.hasWonGame(board.numInWhiteSlot))
		{
			areaText.append("\nCongratulations " + white.getName()+" has won");
			areaText.append("\nWould you like to play again? yes/no");
		}

	}// end of actionPerformed

	private boolean ReadyToStart() // if both players given their names, this method returns true.
	{
		return (!(black.name.equals("")) && !(white.name.equals("")) && (match != 0));
	}
	
	public void addListener(EventListener l)
	{
		listeners.add(l);
	}
	
	private void notifyMoveListeners(String colour, int from, int to)
	{
		for(EventListener m : listeners)
		{
			m.move(colour, from, to);
		}
	}
	
	private void notifyCheatListeners()
	{
		for(EventListener m : listeners)
			m.cheat();
	}

	public void notifyMatchListeners()
	{
		for(EventListener m : listeners)
			m.match(match);
	}

	public void notifyDoubleCubeListeners() {
		for (EventListener m : listeners)
				m.doubleCube(doublingCube);
	}

	private int[] moveSelection(Board board, int colour, String input) {
	    String[] moves = board.acceptableMoves(colour, result).split("\\n");
	    int[] moveToReturn = new int[2];
	    int from; int to;

	    //formatting input for work
	    input = input.substring(input.length()-2, input.length()); // isolates the input from move
        input = input.replaceAll(" ", ""); // removes any white spaces from input
        input = input.toUpperCase();

		for (String move : moves) {
			if (move.startsWith(input)) { // checks if the move starts with the input i.e A
				String string = move.substring(2);
				string = string.replaceAll("\\s+", ""); // removing white spaces

				String firstHalf = string.substring(0, string.indexOf("-"));
				String secondHalf = string.substring(string.indexOf("-")+1);

				if(secondHalf.contains("*"))
				{
					secondHalf = secondHalf.substring(0, secondHalf.length()-1);
				}

                try {
						if (string.contains("Bar")) {
							from = 25;
							moveToReturn[0] = from;
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

	private void nextTurn() {
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
            moveCheck(board.acceptableMoves(1, result));
			enterText.selectAll();
		}

		else {
			white.myTurn = true;
			black.myTurn = false;
			playerName.setText("Name: " + white.name);
			playerScore.setText("Score: " + Integer.toString(white.getScore()));
			playerName.setText(white.name);
			playerScore.setText(Integer.toString(white.getScore()));
			areaText.append("\n\n" + white.name + "'s turn");
			result = autoDiceRoller();
			areaText.append("\nRoll: " + result[0] + " " + result[1]);
			addPossibleMoves(board,0);
            moveCheck(board.acceptableMoves(0, result));
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

	public void moveCheck(String input) {

	    String[] moves = input.split("\\n"); // saves possible moves to an array of strings

        if (moves.length == 1) {
			areaText.append("\nNo available moves,\n changing turn...\n");

			try {
				Thread.sleep(1000); // wait one second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			nextTurn(); // call next turn if no available moves
        	return;
        }

        else if (moves.length == 2) {
			areaText.append("\nOne move possible, making move...\n");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			move("move A"); // make first and only move
        	return;
        }
        else {return;} // do nothing if no if statements were triggered

	} // end of moveCheck


	private void addPossibleMoves(Board board, int colour)

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
