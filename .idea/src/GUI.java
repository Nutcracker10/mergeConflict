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

        new frame(); //displays the frame to user
        Checker check = new Checker();
        Spike spike = new Spike();

    }
}



