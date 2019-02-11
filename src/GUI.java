/* Caoimhe Tiernan 17336331
   Saorise Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;


public class GUI{

    public static void main(String[] args) throws IOException {

        try
        {
            new frame(); //displays the frame to user
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



