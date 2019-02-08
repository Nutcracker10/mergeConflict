import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CentrePanel extends JPanel {



    private BufferedImage image;  //gets backgammon board image


        //default constructor
        CentrePanel() throws IOException {

            this.setSize(400, 300);

            try
            {
                image =  ImageIO.read(CentrePanel.class.getResource("/resources/images/Backgammon_board_-_03.jpg")); //gets backgammon board image
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }

           JLabel label = new JLabel(new ImageIcon(image)); // assigns image to a Label
           this.add(label);            // adds image to panel

        }
    }


