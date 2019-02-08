import javax.swing.*;
import java.awt.*;

public class EastPanel extends JPanel {

    JTextField enterText = new JTextField();                     // a field for entering details
    JTextArea areaText = new JTextArea("Welcome to Backgammon"); // an area for displaying game details
    JTextArea playerName = new JTextArea("Player: ");         // Displays player name
    JTextArea playerScore = new JTextArea("Score: ");            // Displays Player Score
    JPanel subpanel = new JPanel();

    EastPanel(){
        this.setLayout(new BorderLayout());   // sets border layout to Eastpanel
        subpanel.setLayout(new GridLayout(2, 1)); // sets grid layout to subpanel

        //adds each component to panel
        subpanel.add(playerName);
        subpanel.add(playerScore);
        this.add(areaText, BorderLayout.CENTER);
        this.add(enterText, BorderLayout.SOUTH);
        this.add(subpanel, BorderLayout.NORTH);



        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));          // creates black lines around panel
        playerScore.setBorder(BorderFactory.createLineBorder(Color.BLACK));   // creates line around score
    }

}
