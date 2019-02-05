import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {

    JButton diceRoll = new JButton("ROLL DICE");     // a button for rolling dice
    JButton doubleroll = new JButton("DOUBLE");      // a button for the double mechanic
    JTextArea dicedisplay = new JTextArea("DICE ROLL: "); // an area for displaying the dice roll result
    JPanel subpanel = new JPanel();                       // a sub panel for buttons

    SouthPanel(){

        subpanel.setLayout(new GridLayout(1,2));

        subpanel.add(doubleroll);
        subpanel.add(diceRoll);

        this.setLayout(new BorderLayout());          //adds border layout to south panel
        this.add(subpanel, BorderLayout.EAST);       //adds diceroll to right side of panel
        this.add(dicedisplay, BorderLayout.CENTER);  //adds dicedisplay to middle of panel

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel
    }
}