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
	private int MAX_SIZE = 1000;

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
        	int fromPipOne; int toPipOne;
        	int fromPipTwo; int toPipTwo;

            Move possibleMove = play.getMove(0); //get move from play array list

            toPipOne = possibleMove.getToPip(); //get the to pip
            fromPipOne = possibleMove.getFromPip(); //get the from pip

            boardArray[bot.getId()][toPipOne] += 1; //show what it would look like on the board
            boardArray[bot.getId()][fromPipOne] -= 1;

            Move possibleMoveTwo = play.getMove(1); //get move from play array list

            toPipTwo = possibleMoveTwo.getToPip(); //get the to pip
            fromPipTwo = possibleMoveTwo.getFromPip(); //get the from pip

            boardArray[bot.getId()][toPipTwo] += 1; //show what it would look like on the board
            boardArray[bot.getId()][fromPipTwo] -= 1;

            int[][] tmpArray = new int [2][boardArray[0].length]; //tmp array to copy these values into PAM array list
            
            for(int i =0; i < boardArray[0].length; i++) //have to do this because of pointers
            {
                tmpArray[bot.getId()][i] = boardArray[bot.getId()][i];
            }

            positionsAfterMoves.add(tmpArray); //add the new position

            boardArray[bot.getId()][toPipOne] -= 1; //reset the board array
            boardArray[bot.getId()][fromPipOne] += 1;

            boardArray[bot.getId()][toPipTwo] -= 1; //reset the board array
            boardArray[bot.getId()][fromPipTwo] += 1;
        }
        
        
       int[] scoreArray = new int[positionsAfterMoves.size()];

       for(int i=0; i<positionsAfterMoves.size(); i++) 
       {
    	   boolean hasHit = possiblePlays.get(i).getMove(0).isHit() || possiblePlays.get(i).getMove(1).isHit();
    	   scoreArray[i] = getScore(positionsAfterMoves.get(i), hasHit);
       }
       int biggest = getLargest(scoreArray);
       return Integer.toString(biggest+1);

    }
    
    private int getLargest(int[] array) {
		int maxIndex = 0; int maxScore = 0;

		for(int i=0; i<array.length; i++) {
			if(maxScore < array[i]) 
			{
				maxIndex = i;
				maxScore = array[i];
			}
		}
		return maxIndex;
	}

	public String getDoubleDecision() 
	{
		// Add your code here
		return "y";
	}
	
	private int getScore(int[][] boardNext, boolean hasHit)
	{
		int[] possibleScores = new int[MAX_SIZE];
		int maxScore = 0;
		int i = 0;
		int[][] boardNow = board.get();
		
		if(boardNext[me.getId()][0] == 1 + boardNow[me.getId()][0])
		{
			possibleScores[i] = 10;
			i++;
		}
		
		if(boardNext[me.getId()][0] > 1 + boardNow[me.getId()][0])
		{
			possibleScores[i] = 11;
			i++;
		}
		
		for(int j = 0; j < boardNext[me.getId()].length; j++)
		{
			if(boardNext[me.getId()][j] == 1)
			{
				possibleScores[i] = 1;
				i++;
			}
			
			if(boardNow[me.getId()][j] == 1 && boardNext[me.getId()][j] != 1)
			{
				possibleScores[i] = 6;
			}
			
			if(boardNext[me.getId()][j] > 1 && boardNext[me.getId()][j+1] > 1 && boardNext[me.getId()][j+2] > 1 &&
					boardNext[me.getId()][j+3] > 1 && boardNext[me.getId()][j+4] > 1 && boardNext[me.getId()][j+5] > 1)
			{
				possibleScores[i] = 9;
				i++;
			}
			else if(boardNext[me.getId()][j] > 1 && boardNext[me.getId()][j+1] > 1 && boardNext[me.getId()][j+2] > 1 &&
					boardNext[me.getId()][j+3] > 1 && boardNext[me.getId()][j+4] > 1)
			{
				possibleScores[i] = 8;
				i++;
			}
			else if(boardNext[me.getId()][j] > 1 && boardNext[me.getId()][j+1] > 1 && boardNext[me.getId()][j+2] > 1 &&
					boardNext[me.getId()][j+3] > 1)
			{
				possibleScores[i] = 7;
				i++;
			}
			else if(boardNext[me.getId()][j] > 1 && boardNext[me.getId()][j+1] > 1 && boardNext[me.getId()][j+2] > 1)
			{
				possibleScores[i] = 5;
				i++;
			}
			else if(boardNext[me.getId()][j] > 1 && boardNext[me.getId()][j+1] > 1)
			{
				possibleScores[i] = 4;
				i++;
			}	
		}
		
		if(boardNext[me.getId()][24] < boardNow[me.getId()][24])
		{
			possibleScores[i] = 4;
			i++;
		}
		else if(boardNext[me.getId()][23] < boardNow[me.getId()][23])
		{
			possibleScores[i] = 4;
			i++;
		}
		else if(boardNext[me.getId()][22] < boardNow[me.getId()][22])
		{
			possibleScores[i] = 4;
			i++;
		}
		else if(boardNext[me.getId()][21] < boardNow[me.getId()][21])
		{
			possibleScores[i] = 4;
			i++;
		}
		else if(boardNext[me.getId()][20] < boardNow[me.getId()][20])
		{
			possibleScores[i] = 4;
			i++;
		}
		else if(boardNext[me.getId()][19] < boardNow[me.getId()][19])
		{
			possibleScores[i] = 4;
			i++;
		}
		
		if(boardNext[me.getId()][4] > boardNow[me.getId()][4])
		{
			possibleScores[i] = 4;
			i++;
		}
		else if(boardNext[me.getId()][5] > boardNow[me.getId()][5])
		{
			possibleScores[i] = 4;
			i++;
		}
		if(boardNext[me.getId()][5] > boardNow[me.getId()][5])
		{
			possibleScores[i] = 4;
			i++;
		}
		
		if(hasHit && (boardNext[me.getId()][1] == 1 || boardNext[me.getId()][2] == 1 || boardNext[me.getId()][3] == 1
				|| boardNext[me.getId()][4] == 1 || boardNext[me.getId()][5] == 1 || boardNext[me.getId()][6] == 1))
		{
			possibleScores[i] = 1;
			i++;
		}
		else if(hasHit)
		{
			possibleScores[i] = 3;
			i++;
		}
		
		for(int j = 0; j < possibleScores.length; j++)
		{
			if(possibleScores[j] > maxScore)
				maxScore = possibleScores[j];
		}
		
		return maxScore;
	}
	
	
}
