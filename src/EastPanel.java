
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
	private JTextArea playerName = new JTextArea("Name: "); // Displays player name
	private JTextArea playerScore = new JTextArea("Score: "); // Displays Player Score
	private JPanel subpanel = new JPanel();					// a subpanel for buttons

	// adds scrolling functionality to the text area
	private JScrollPane scrollPane = new JScrollPane(areaText);
	JScrollBar sb = scrollPane.getVerticalScrollBar(); //

	// Players
	Player white = new Player("", 0);
	Player black = new Player("", 1);

	Document doc = areaText.getDocument(); // a means of getting text details
	int[] result = new int[2]; //a way to store dice rolls
	Board board; //a way to get the boards information to east panel
	
	//ArrayList of action listeners
	ArrayList<EventListener> listeners = new ArrayList<EventListener>();
	
	int turnNumber = 0; // to count what turn it is
	int match = 0; //points to win
	int doublingCube = 1; //value of doubling cube
	int numOfDie = 2; //amount of dice
	boolean hasDoubled = false; //check if someone has doubled
	boolean matchWon = false; //check if the whole game has been won

	public EastPanel() 
	{

		this.setLayout(new BorderLayout()); // sets border layout to EastPanel
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
							+ "\nroll -> roll dice" + "\ndouble -> use doubling cube" + "\nmove -> enter a move" +
							"\nnext -> end turn" + "\nquit -> end the program\n" );
		this.areaText.append("\nEnter white player's name,\nblack player's name and\npoints to start game\n");

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

		else if (text.startsWith("move") && !(black.haveWon || white.haveWon)) //user entering their move
		{
		    if(numOfDie != 0)
			    move(text);
		    else
		        areaText.append("\nOut of moves");
		}// end of move
		
		else if(text.startsWith("cheat") && !(black.haveWon || white.haveWon)) //jump to end of the game
		{
			notifyCheatListeners();
			
			if(white.myTurn)
			{
				white.myTurn = false;
				black.myTurn = true;
				areaText.append("\n\n" + black.name + "'s turn");
				playerName.setText("Name: " + black.name);
				playerScore.setText("Score: " + Integer.toString(black.getScore()));
				enterText.selectAll();
				turnNumber++;
			}
			
			else
			{
				black.myTurn = false;
				white.myTurn = true;
				areaText.append("\n\n" + white.name + "'s turn");
				playerName.setText("Name: " + white.name);
				playerScore.setText("Score: " + Integer.toString(black.getScore()));
				enterText.selectAll();
				turnNumber++;
			}
		}

		else if(text.startsWith("points")) //set how many points to play to
		{
		    try {
                match = Integer.parseInt(text.substring(7)); // parse the number after "points"
                if (match % 2 != 1) {
                    areaText.append("\nInvalid match length.\nMust not be divisble by two.\n");
                    match = 0;
                }
                notifyMatchListeners();
                enterText.selectAll();
            } catch(StringIndexOutOfBoundsException e){
		        areaText.append("\nNo number detected after \n\"points\"");
            }
		}

		else if(text.startsWith("double")) //double
		{
			if(white.isMyTurn())
			{
				if(white.hasDoublingCube())
				{
					areaText.append("\n\n" + white.getName() + " is doubling.");
					areaText.append("\nDo you accept, " + black.getName() + "?\nEnter Y/N");
					hasDoubled = true;
				}

				//if white does not own the doubling cube, they cannot double
				else
				{
					areaText.append("\n\nYou cannot double at this time.");
				}
			}

			else
			{
				if(black.hasDoublingCube())
				{
					areaText.append("\n\n" + black.getName() + " is doubling.");
					areaText.append("\nDo you accept, " + white.getName() + "?\nEnter Y/N");
					hasDoubled = true;
				}

				//if black does not own the doubling cube, they cannot double
				else
				{
					areaText.append("\n\nYou cannot double at this time.");
				}
			}

			enterText.selectAll();
		}

		//if the player entered y, and they've doubled and it's not the end of the game
		else if(((text.startsWith("Y")) || (text.startsWith("y"))) && hasDoubled && !matchWon)
		{
			if(white.isMyTurn())
			{
				doublingCube = doublingCube * 2;
				white.doublingCube = false;
				black.doublingCube = true;
				areaText.append("\nScore will be multiplied by " + doublingCube + "\n");
				enterText.selectAll();
			}

			else if(black.isMyTurn())
			{
				doublingCube = doublingCube * 2;
				black.doublingCube = false;
				white.doublingCube = true;
				areaText.append("\nScore will be multiplied by " + doublingCube + "\n");
				enterText.selectAll();
			}

			hasDoubled = false;
			notifyDoubleCubeListeners();
		}

		else if(((text.startsWith("N")) || (text.startsWith("n"))) && hasDoubled && !matchWon)
		{
			if(white.isMyTurn())
			{
				areaText.append("\n" + black.getName() + " has forfeited.");
				hasDoubled = false;
				endGame(white, black);
				enterText.selectAll();
			}

			else if(black.isMyTurn())
			{
				areaText.append("\n" + white.getName() + " has forfeited.");
				hasDoubled = false;
				endGame(black, white);
				enterText.selectAll();
			}
		}

		else if(text.startsWith("roll")) //roll the dice and get a list of possible moves
		{
			numOfDie = 2;
			result = autoDiceRoller();
			areaText.append("\nRoll: " + result[0] + " " + result[1]);
			
			if(result[0] == result[1]) 
			{
                numOfDie = 4;

            }
			
			if(black.isMyTurn())
			{
				addPossibleMoves(board,1);
				moveCheck(board.acceptableMoves(1, result));
			}
			
			else if(white.isMyTurn())
			{
				addPossibleMoves(board, 0);
				moveCheck(board.acceptableMoves(0, result));
			}
			enterText.selectAll();
		}

		else if(matchWon && text.equals("yes")) //if the match is over and the players wish to play another game
        {
			areaText.append("\n\nStarting new game...");

			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}


			//resets everything
        	white.name = "";
        	black.name = "";
        	white.score = 0;
        	black.score = 0;
        	notifyScoreListeners();
            white.haveWon = false;
            black.haveWon = false;
            white.doublingCube = true;
            black.doublingCube = true;
            doublingCube = 1;
            notifyDoubleCubeListeners();
            match = 0;
            notifyMatchListeners();
            matchWon = false;
            playerName.setText("Name: ");
            playerScore.setText("Score: ");
            areaText.setText("");
            board.restBoard();
            areaText.append("\nCommands : ");
    		areaText.append("\nwName -> save white's name" + "\nbName -> save black's name" + "\npoints -> enter points to play to"
    							+ "\nroll -> roll dice" + "\ndouble -> use doubling cube" + "\nmove -> enter a move" +
    							"\nnext -> end turn" + "\nquit -> end the program\n" );
    		areaText.append("\n\nEnter white player's name,\nblack player's name and\npoints to start game\n");
        }

		else if(matchWon && text.startsWith("no")) //if the match has ended and the players do not wish to play another round
		{
			areaText.append("\n\nEnding program...");
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.exit(0);
		}
		
		else if(matchWon)
		{
			areaText.append("\nInvalid response.");
			areaText.append("\n\nDo you want to play another game?\n Yes/No");
			enterText.selectAll();
			
		}

		else //unrecognised command
		{
			areaText.append("\nUnrecognised Command :\n");
			areaText.append(text + "\n");
			enterText.selectAll();
		}

		if (ReadyToStart() && turnNumber == 0) // Have to do this inside the action listener because of threads and swing
		{
			notifyScoreListeners();
			areaText.append("\nGAME START"); // Announces start of the games
			areaText.append("\nPOINTS TO WIN: " + match);

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
				white.myTurn = true;
			} 
			else {
				areaText.append("\n" + black.name + " goes first");
				playerName.setText("Name: " + black.name);
				playerScore.setText("Score: " + Integer.toString(black.getScore()));
				black.myTurn = true;
			}

			turnNumber++;
		}

		if(black.hasWonGame(board.numInBlackSlot)) //if black has all their checkers in the bear off
		{
			endGame(black, white);
		}

		if(white.hasWonGame(board.numInWhiteSlot)) //if white has all their checkers in the bear off
		{
			endGame(white, black);
		}



	}// end of actionPerformed

	private boolean ReadyToStart() // if both players given their names and the match point has been set, this method returns true.
	{
		return (!(black.name.equals("")) && !(white.name.equals("")) && (match != 0));
	}
	
	private void endGame(Player winner, Player loser) //what happens at the end of a game
	{
		areaText.append("\n\nCongratulations!!\n" + winner.getName() + " has won this match!");
		//adds the player's current score to the score they received in this match by the doubling cube
		winner.setScore(winner.getScore() + board.getScore(winner.getColour()) * doublingCube);
		areaText.append("\nThe score is now:\n  " + winner.getName() + ": " + winner.getScore()
						+ "\n  " + loser.getName() + ": " + loser.getScore());

		//if the winner has reached the match score
		if(winner.getScore() >= match)
		{
			areaText.append("\n\n" + winner.getName() + " has won the game!");
			matchWon = true;
			areaText.append("\n\nDo you want to play \nanother game? Yes/No");
		}

		//starts the next round
		else
		{
			areaText.append("\n\nStarting next match...\n\n");

			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}

			notifyScoreListeners();
			turnNumber = 0;
            white.haveWon = false;
            black.haveWon = true;
            white.doublingCube = true;
            black.doublingCube = true;
            doublingCube = 1;
            board.restBoard();
		}
	}

	public void addListener(EventListener l)
	{
		listeners.add(l);
	}
	
	//calls move for all event listeners
	private void notifyMoveListeners(String colour, int from, int to)
	{
		for(EventListener m : listeners)
		{
			m.move(colour, from, to);
		}
	}
	
	//calls cheat for all event listeners
	private void notifyCheatListeners()
	{
		for(EventListener m : listeners)
			m.cheat();
	}

	//calls match for all event listeners
	public void notifyMatchListeners()
	{
		for(EventListener m : listeners)
			m.match(match);
	}

	//calls doubleCube for all event listeners
	public void notifyDoubleCubeListeners() 
	{
		for (EventListener m : listeners)
				m.doubleCube(doublingCube);
	}
	
	public void notifyScoreListeners()
	{
		for(EventListener m : listeners)
			m.score(white, black);
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
						if (string.contains("Bar")) { // adds value of 25 if bar is involved
							from = 25;
							moveToReturn[0] = from;
						}
						else {
							firstHalf = firstHalf.replaceAll("-", "");
							from = Integer.parseInt(firstHalf);
							moveToReturn[0] = from;
						}
						if(string.contains("Off")) { // adds value of 0 to to if off is involved
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

	private void nextTurn() 
	{
		if (white.myTurn) 
		{
			white.myTurn = false;
			black.myTurn = true;
			playerName.setText("Name: " + black.name);
			playerScore.setText("Score: " + Integer.toString(black.getScore()));
			playerName.setText(black.name);
			enterText.selectAll();
			areaText.append("\n\n" + black.getName() + "'s turn.");
		}

		else 
		{
			white.myTurn = true;
			black.myTurn = false;
			playerName.setText("Name: " + white.name);
			playerScore.setText("Score: " + Integer.toString(white.getScore()));
			playerName.setText(white.name);
			playerScore.setText(Integer.toString(white.getScore()));
			enterText.selectAll();
			areaText.append("\n\n" + white.getName() + "'s turn.");
		}

		turnNumber++;


	} // end of next turn

	public void move(String text) {

		int colour;
		if(white.myTurn)
			colour = white.colour;
		else
			colour = black.colour;

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

		enterText.selectAll();
		turnNumber++;
		areaText.append("\n");
		numOfDie--;
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
			areaText.append("\nOne move possible,\n making move...\n");

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
