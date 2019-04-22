import java.util.ArrayList;

public class mergeConflict implements BotAPI {

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

    public String getCommand(Plays possiblePlays) {
        // Add your code here

        Player bot = (Player) me; //casting playerAPI into player
        int[][] boardArray = board.get(); //getting current state of board
        ArrayList<int[][]> positionsAfterMoves = new ArrayList<>(); //making an arrayList of the board;

        Plays playsFromThisPosition = board.getPossiblePlays(bot, new Dice()); //getting the plays from this position

        for(Play play : playsFromThisPosition) //going through each play
        {

            int fromPip;
            int toPip;

               Move possibleMove = play.getMove(0);

               toPip = possibleMove.getToPip();
               fromPip = possibleMove.getFromPip();

               boardArray[bot.getId()][toPip] += 1;
               boardArray[bot.getId()][fromPip] -= 1;

               int[][] tmpArray = new int [2][boardArray[0].length];
            for(int i =0; i < boardArray[0].length; i++)
                {
                    tmpArray[bot.getId()][i] = boardArray[bot.getId()][i];
                }

               positionsAfterMoves.add(tmpArray);

                boardArray[bot.getId()][toPip] -= 1;
                boardArray[bot.getId()][fromPip] += 1;


        }

        return "1";
    }

    public String getDoubleDecision() {
        // Add your code here
        return "n";
    }
}
