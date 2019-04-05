/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {

    // creating text areas
    JTextArea scoreToReach = new JTextArea("Score To Reach: ");
    JTextArea matchLength = new JTextArea(("Match Length: "));
    JTextArea doubleCube = new JTextArea("Doube Cube: ");

    SouthPanel(){


        this.setLayout(new GridLayout(1,2));          //adds grid layout to south panel
       // add text fields to panel
        this.add(scoreToReach);
        this.add(matchLength);
        this.add(doubleCube);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel


    }

}