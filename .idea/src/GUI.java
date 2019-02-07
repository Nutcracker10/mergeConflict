import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class GUI{


    public GUI(){}


    public static void main(String[] args) throws IOException {

        new frame(); //displays the frame to user


        //trying to make a linked list of the spikes
        LinkedList<Spike> listOfSpikes = new LinkedList<Spike>();
        Spike s1 = new Spike();
        Spike s2 = new Spike();
        //then put the checkers in the spikes and move them about


        WhiteChecker c1 = new WhiteChecker();
        BlackChecker c2 = new BlackChecker();

    }
}



