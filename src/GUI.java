
/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class GUI{

    public static void main(String[] args) throws IOException {

        try
        {
            JFrame ourFrame = new frame(); //displays the frame to user
            //Assigning player's names
            EastPanel east = ((frame) ourFrame).getEastPanel(); //to be able to access panels in Main
            SouthPanel south = ((frame) ourFrame).getSouthPanel();
            Board board = ((frame) ourFrame).getBoard();


            east.areaText.append("\nCommands : "); //telling the user what commands they can use
            east.areaText.append("\nwName -> save white's name" + "\nbName -> save black's name"
                                + "\nquit -> end the program");



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
        catch(InterruptedException e){}


        //trying to make a linked list of the spikes

        Spike<Object> s1 = new Spike<>();
        Spike<Object> s2 = new Spike<>();
        //then put the checkers in the spikes and move them about

        WhiteChecker c1 = new WhiteChecker(0, 0);
        BlackChecker c2 = new BlackChecker(50, 50);

        s1.addChecker(c1);
        s1.addChecker(c2);
    }
}



