import javax.swing.*;
import javax.swing.text.LayeredHighlighter;
import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class frame extends JFrame {

    //adds panels to frame
    EastPanel east = new EastPanel();
    SouthPanel south = new SouthPanel();
    Board board = new Board();
    WhiteChecker c1 = new WhiteChecker(0, 0);
    private JLayeredPane layeredPane; //to put the checkers on a diffrent layer to the board

    frame() throws IOException, InterruptedException {
        this.setSize(1000, 800);                        // sets window size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    // ends process on window close
        this.setResizable(false);                        //Prevents user from resizing window
        this.setLayout(new BorderLayout());            // adds Borderlayout to the frame
        this.setVisible(true);                            //makes the frame visible to the user

        Canvas board = new Board();
        board.setSize(800, 600);

        //adds panels to the frame
        this.add(board, BorderLayout.CENTER);
        this.add(east, BorderLayout.EAST);
        this.add(south, BorderLayout.SOUTH);
        this.pack();

        this.layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(board.getSize()); //setting layer to the size of the board
        c1.setVisible(true);
        layeredPane.add(c1);
        this.add(layeredPane);


        for (int i = 0; i < 2; i++) {


            ((Board) board).Moving(); //moving a black checker around}
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e) {}

            board.repaint();
        }


    }
}