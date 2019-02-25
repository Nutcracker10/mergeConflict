/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class frame extends JFrame implements MoveListener{

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
    }
    
    public void move(String colour, int from, int to)
    {
    	board.Move(colour, from, to);
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