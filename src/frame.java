/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class frame extends JFrame implements EventListener
{

    //adds panels to frame
    EastPanel east = new EastPanel();
    SouthPanel south = new SouthPanel();
    Board board = new Board();
    Container c = this.getContentPane();

    frame() throws IOException, InterruptedException 
    {
        this.setSize(1000, 750);                        // sets window size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    // ends process on window close
        this.setResizable(false);                        //Prevents user from resizing window
        this.setLayout(new BorderLayout());            // adds Borderlayout to the frame
        this.setTitle("Backgammon");


        //adds panels to the frame
        c.add(board, BorderLayout.CENTER);
        c.add(east, BorderLayout.EAST);
        c.add(south, BorderLayout.SOUTH);

        east.addListener(this);
        //east.addListener(this);
        this.setVisible(true);  //makes the frame visible to the user
        east.setBoard(board);
    }
    
    public void move(String colour, int from, int to)
    {


        try
    	{
    	    board.Move(colour, from, to);
    		board.repaint();
    	}
    	catch(NoCheckerException e)
    	{
    		east.areaText.append("\nInvalid move, no checker at this pip");
    	}

        if(east.black.hasWonGame(board.numInBlackSlot))
        {
            east.areaText.append("\nCongratulations " +east.black.getName()+" has won");
        }

        if(east.white.hasWonGame(board.numInWhiteSlot))
        {
            east.areaText.append("\nCongratulations " +east.white.getName()+" has won");
        }




    }

    public void cheat()
    {
    	board.cheat();
    	board.repaint();
    }
    //returns the east panel
    public EastPanel getEastPanel()
    {
        return east;
    }

    public SouthPanel getSouthPanel()
    {
        return south;
    }

    public Board getBoard()
    {
        return board;
    }




}