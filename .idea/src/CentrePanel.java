import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CentrePanel extends JPanel {

    BufferedImage image = ImageIO.read(new File("Backgammon_board_-_03/java.jpg")); //gets backgammon board image

    //default constructor
    CentrePanel() throws IOException {
        this.setLayout(new BorderLayout());              // sets the layout to border

        JLabel label = new JLabel(new ImageIcon(image)); // assigns image to a Label
        this.add(label, BorderLayout.CENTER);            // adds image to panel
    }
}
