import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class GUI{

    public GUI()
    {

    }

    public static void main(String[] args) throws IOException {

        JFrame ourFrame = new frame(); //displays the frame to user


        //trying to make a linked list of the spikes
        LinkedList<Spike<Object>> listOfSpikes = new LinkedList<>();
        Spike<Object> s1 = new Spike<>();
        Spike<Object> s2 = new Spike<>();
        //then put the checkers in the spikes and move them about

        WhiteChecker c1 = new WhiteChecker(0, 0);
        BlackChecker c2 = new BlackChecker(50, 50);

        s1.addChecker(c1);
        s1.addChecker(c2);



    }
}



