import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {

    JTextField enterText = new JTextField();                     // a field for entering details
    JTextArea areaText = new JTextArea("Welcome to Backgammon"); // an area for displaying game details
    JTextArea playerDetails = new JTextArea("Player: ");         // Displays player name

    EastPanel(){
        this.setLayout(new BorderLayout()); // sets border layout to Eastpanel

        //adds each component to panel
        this.add(areaText, BorderLayout.CENTER);
        this.add(enterText, BorderLayout.NORTH);
        this.add(playerDetails, BorderLayout.SOUTH);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));          // creates black lines around panel
        playerDetails.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates line around name
    }

}
