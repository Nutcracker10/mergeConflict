/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {

    JButton diceRoll = new JButton("ROLL DICE");     // a button for rolling dice
    JButton doubleroll = new JButton("DOUBLE");      // a button for the double mechanic
    JTextArea dicedisplay = new JTextArea("DICE ROLL: "); // an area for displaying the dice roll result
    JPanel subpanel = new JPanel();                       // a sub panel for buttons
    Dice d1 = new Dice();                                  //Dice object for rolling
    Dice d2 = new Dice();

    SouthPanel(){

        subpanel.setLayout(new GridLayout(1,2)); //Add a 1*2 grid

        //add textareas to subpanel
        subpanel.add(doubleroll);
        subpanel.add(diceRoll);

        this.setLayout(new BorderLayout());          //adds border layout to south panel
        this.add(subpanel, BorderLayout.EAST);       //adds diceroll to right side of panel
        this.add(dicedisplay, BorderLayout.CENTER);  //adds dicedisplay to middle of panel

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel


        diceRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dicedisplay.setText(d1.roll() + " " + d2.roll() + "\n" ); //when dice roll is cliked the numbers appear on the screem
            }
        });

    }
}