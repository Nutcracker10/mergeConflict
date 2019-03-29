/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {

    JTextArea scoreToReach = new JTextArea("Score To Reach: "); // an area for displaying the dice roll result
    JTextArea turnNumber = new JTextArea(("Turn Number: "));
    Dice d = new Dice();                                  //Dice object for rolling

    SouthPanel(){


        //add textareas to subpanel
        this.setLayout(new GridLayout(1,2));          //adds border layout to south panel
        this.add(scoreToReach);  //adds dicedisplay to middle of panel
        this.add(turnNumber);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel


    }

}