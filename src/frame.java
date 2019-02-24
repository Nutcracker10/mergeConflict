/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class frame extends JFrame {

    //adds panels to frame
    EastPanel east = new EastPanel();
    SouthPanel south = new SouthPanel();
    Board board = new Board();
    Container c = this.getContentPane();
    private int i = 1;
    private JLayeredPane layeredPane; //to put the checkers on a diffrent layer to the board

    frame() throws IOException, InterruptedException {
        this.setSize(1000, 750);                        // sets window size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    // ends process on window close
        this.setResizable(false);                        //Prevents user from resizing window
        this.setLayout(new BorderLayout());            // adds Borderlayout to the frame
        this.setTitle("Backgammon");


        //adds panels to the frame
        c.add(board, BorderLayout.CENTER);
        c.add(east, BorderLayout.EAST);
        c.add(south, BorderLayout.SOUTH);

        this.setVisible(true);  //makes the frame visible to the user

        Timer timer = new Timer(1000, new ActionListener() { //slows the animation down.
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == 25)
                    return;

                else {
                    ((Board) board).Moving(i, i + 1);
                    board.repaint();
                    i++;
                }
            }
        });
        timer.setInitialDelay(1000);
        timer.start();




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