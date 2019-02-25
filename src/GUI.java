
/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI{

    public static void main(String[] args) throws IOException {

        try
        {
            JFrame ourFrame = new frame(); //displays the frame to user
            //Assigning player's names
            EastPanel east = ((frame) ourFrame).getEastPanel(); //to be able to access panels in Main
            SouthPanel south = ((frame) ourFrame).getSouthPanel();
            Board board = ((frame) ourFrame).getBoard();

            Timer timer = new Timer(500, new ActionListener() { //slows the animation down.
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(east.white.isMyTurn())
                    {
                        board.whosTurn = 0;
                        board.repaint();
                    }

                    else if(east.black.isMyTurn())
                    {
                        board.whosTurn = 1;
                        board.repaint();
                    }

                }
            });
            timer.start();
        }
        catch(InterruptedException e)
        {
        	
        }
    }
}



