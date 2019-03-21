
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

	// adds scrolling functionality to the text area
	JScrollPane scrollPane = new JScrollPane(areaText);



	// Players
	Player white = new Player("", 0);
	Player black = new Player("", 1);

	Document doc = areaText.getDocument(); // a means of getting text details
	int[] result = new int[2]; //a way to store dice rolls
	Board board; //a way to get the boards information to east panel
	
	//ArrayList of action listeners
	ArrayList<MoveListener> listeners = new ArrayList<MoveListener>();
	
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

		result[0] = die.die1;
		result[1] = die.die2;

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
			playerName.append(white.name);
			enterText.selectAll();
		}
		
		else if (text.startsWith("bName")) // command to save black player's name
		{
			black.name = text.substring(6);
			areaText.append("\nBlack : " + black.name);
			enterText.selectAll();

		}

		else if (text.equals("next") && !(black.haveWon || white.haveWon)) // user switching between turns
		{
			if (white.myTurn) {
				white.myTurn = false;
				black.myTurn = true;
				areaText.append("\n" + black.name + "'s turn");
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,1);
				enterText.selectAll();
			}

			else {
				white.myTurn = true;
				black.myTurn = false;
				areaText.append("\n" + white.name + "'s turn");
				result = autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,0);
				enterText.selectAll();


			}
			turnNumber++;
		}

		else if (text.startsWith("move") && !(black.haveWon || white.haveWon)) {

			String subString = text.substring(5); // a substring of the numbers from the command
			String firstHalf = subString.substring(0, (subString.length() / 2));
			String secondHalf = subString.substring((subString.length() / 2));

			firstHalf = firstHalf.replaceAll("\\s+", ""); // removes white space characters
			secondHalf = secondHalf.replaceAll("\\s+", "");

			if (subString.length() < 6) {

				try {
					int from = Integer.parseInt(firstHalf);
					int to = Integer.parseInt(secondHalf);
					areaText.append("\n" + from + " " + to);
					
					if((from < 0) || (to < 0) || (from > 25) || (to > 25))
					{
						areaText.append("Not a valid move");
						return;
					}
					
					if(white.myTurn)
					{
						notifyMoveListeners(white.getColour(), from, to);
					}
					
					else if(black.myTurn)
					{
						notifyMoveListeners(black.getColour(), from, to);
					}
						
				} catch (NumberFormatException e) {
					areaText.append("\nmove : Invalid format\n");
				}

			} 
			else {
				areaText.append("\nInvalid number of arguments");
			}

			enterText.selectAll();
			turnNumber++;

		}
		
		else if(text.startsWith("cheat"))
		{
			notifyCheatListeners();
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
			if(white.myTurn)
				board.setWhosTurn(0);
			else
				board.setWhosTurn(1);

			if (white.goFirst(black)) { // We check who goes first
				areaText.append("\n" + white.name + " goes first");
				autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,0);
				white.myTurn = true;
			} 
			else {
				areaText.append("\n" + black.name + " goes first");
				autoDiceRoller();
				areaText.append("\nRoll: " + result[0] + " " + result[1]);
				addPossibleMoves(board,1);
				black.myTurn = true;
			}
		}



	}// end of actionPerformed

	public boolean ReadyToStart() // if both players given their names, this method returns true.
	{
		return ((!(black.name.equals("")) && !(white.name.equals(""))));
	}

	public void checkerMover(int n, int m) { // takes in some ints n and m for moving checkers
		areaText.append("\n" + n + " " + m + "\n");
	}
	
	public void addListener(MoveListener l)
	{
		listeners.add(l);
	}
	
	public void notifyMoveListeners(String colour, int from, int to)
	{
		for(MoveListener m : listeners)
		{
			m.move(colour, from, to);
		}
	}
	
	public void notifyCheatListeners()
	{
		for(MoveListener m : listeners)
			m.cheat();
	}

	public void addPossibleMoves(Board board, int colour)

	{
		areaText.append(board.acceptableMoves(colour,result));
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
