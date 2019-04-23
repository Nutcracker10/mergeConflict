import java.util.ArrayList;

public class mergeConflict implements BotAPI {

    // Team Name mergeConflict
    // The public API of Bot must not change
    // This is ONLY class that you can edit in the program
    // Rename Bot to the name of your team. Use camel case.
    // Bot may not alter the state of the game objects
    // It may only inspect the state of the board and the player objects

	private PlayerAPI me, opponent;
	private BoardAPI board;
	private CubeAPI cube;
	private MatchAPI match;
	private InfoPanelAPI info;
	private int MAX_SIZE = 100;

	mergeConflict(PlayerAPI me, PlayerAPI opponent, BoardAPI board, CubeAPI cube, MatchAPI match, InfoPanelAPI info) {
		this.me = me;
		this.opponent = opponent;
		this.board = board;
		this.cube = cube;
		this.match = match;
		this.info = info;
	}

	public String getName() {
		return "mergeConflict"; // must match the class name
	}

    public String getCommand(Plays possiblePlays) 
    {
        // Add your code here

        Player bot = (Player) me; //casting playerAPI into player
        int[][] boardArray = board.get(); //getting current state of board
        ArrayList<int[][]> positionsAfterMoves = new ArrayList<>(); //making an arrayList of the board;

        for(Play play : possiblePlays) //going through each play
        {
        	int fromPip;
            int toPip;

            Move possibleMove = play.getMove(0); //get move from play array list

            toPip = possibleMove.getToPip(); //get the to pip
            fromPip = possibleMove.getFromPip(); //get the from pip

            boardArray[bot.getId()][toPip] += 1; //show what it would look like on the board
            boardArray[bot.getId()][fromPip] -= 1;

            int[][] tmpArray = new int [2][boardArray[0].length]; //tmp array to copy these values into PAM array list
            
            for(int i =0; i < boardArray[0].length; i++) //have to do this because of pointers
            {
                tmpArray[bot.getId()][i] = boardArray[bot.getId()][i];
            }

           positionsAfterMoves.add(tmpArray); //add the new position

           boardArray[bot.getId()][toPip] -= 1; //reset the board array
           boardArray[bot.getId()][fromPip] += 1;
        }
        
        /*
         * for loop through the positionsAfterMoves
         * for each element, send to getScore
         * add score to score array
         * loop through score array, find biggest
         * get play with biggest score
         * return
         * */
        return "1";
    }

	public String getDoubleDecision() {
		// Add your code here
		return "n";
	}
	
	private int getScore(int[][] boardNext)
	{
		int[] possibleScores = new int[MAX_SIZE];
		int maxScore = 0;
		int i = 0;
		int[][] boardNow = board.get();
		
		if(boardNext[me.getId()][0] > boardNow[me.getId()][0])
		{
			possibleScores[i] = 10;
			i++;
		}
		
		
		//lots of if statements describing different positions
		//assign a score to possibleScores[i]
		//increase i
		
		return maxScore;
		
	}
	
	
}
