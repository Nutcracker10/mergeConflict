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
    WhiteChecker c1 = new WhiteChecker(0, 0);
    Container c = this.getContentPane();
    private JLayeredPane layeredPane; //to put the checkers on a diffrent layer to the board

    frame() throws IOException, InterruptedException {
        this.setSize(1000, 800);                        // sets window size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);    // ends process on window close
        this.setResizable(false);                        //Prevents user from resizing window
        this.setLayout(new BorderLayout());            // adds Borderlayout to the frame



        //adds panels to the frame
        c.add(board, BorderLayout.CENTER);
        c.add(east, BorderLayout.EAST);
        c.add(south, BorderLayout.SOUTH);

        this.setVisible(true);  //makes the frame visible to the user



        this.layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(board.getSize()); //setting layer to the size of the board
        c1.setVisible(true);
        layeredPane.add(c1);
        this.add(layeredPane);

      Timer timer = new Timer(1000, new ActionListener() { //slows the animation down.
          @Override
          public void actionPerformed(ActionEvent e) {
              ((Board) board).Moving();
              board.repaint();
          }
      });
        timer.setInitialDelay(1900);
        timer.start();




    }
}