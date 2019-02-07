import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CentrePanel extends JPanel
{
    private BufferedImage image;  //gets backgammon board image
    WhiteChecker white = new WhiteChecker();

    //default constructor
      
    CentrePanel() throws IOException 
    {
    	try
        {
    		image =  ImageIO.read(CentrePanel.class.getResource("/resources/images/Backgammon_board_-_03.jpg")); //gets backgammon board image
        }
        catch (IOException ioe)
    	{
        	ioe.printStackTrace();
        }



    	this.setLayout(new BorderLayout());              // sets the layout to border

        JLabel label = new JLabel(new ImageIcon(image)); // assigns image to a Label
        this.add(label, BorderLayout.CENTER);            // adds image to panel
    }
}


