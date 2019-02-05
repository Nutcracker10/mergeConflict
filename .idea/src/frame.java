import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class frame extends JFrame {

    //adds panels to frame
    EastPanel east = new EastPanel();
    SouthPanel south = new SouthPanel();
    //CentrePanel centre = new CentrePanel();

    frame() throws IOException {
        this.setSize(800, 600);         // sets window size
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // ends process on window close
        this.setResizable(false);                     //Prevents user from resizing window
        this.setLayout(new BorderLayout());           // adds Borderlayout to the frame
        this.setVisible(true);                        //makes the frame visible to the user

        //adds panels to the frame
        this.add(east, BorderLayout.EAST);
        this.add(south, BorderLayout.SOUTH);
        //this.add(centre, BorderLayout.CENTER);
    }
}
