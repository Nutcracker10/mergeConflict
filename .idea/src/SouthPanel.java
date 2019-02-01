import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {

    JButton diceRoll = new JButton("ROLL DICE"); // a button for rolling dice
    JTextArea dicedisplay = new JTextArea("DICE ROLL: "); // an area for displaying the dice roll result

    SouthPanel(){
        this.setLayout(new BorderLayout());          //adds border layout to south panel
        this.add(diceRoll, BorderLayout.EAST);       //adds diceroll to right side of panel
        this.add(dicedisplay, BorderLayout.CENTER);  //adds dicedisplay to middle of panel
    }
}