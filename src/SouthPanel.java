/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel 
{
    // creating text areas
    JTextArea matchLength = new JTextArea("Match Length: ");
    JTextArea doubleCube = new JTextArea("Double Cube: ");
    JTextArea score = new JTextArea("Score: ");
    int match;
    int cube = 1;
    
    SouthPanel()
    {
        this.setLayout(new GridLayout(1,2));          //adds grid layout to south panel
       // add text fields to panel
        this.add(matchLength);
        this.add(doubleCube);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // creates black lines around panel
        doubleCube.append(Integer.toString(cube));
    }
    
    public void setMatchLength(int p)
    {
    	matchLength.append(Integer.toString(p));
    } // updates match length

    public void setDoubleCube(int input) 
    {
    	doubleCube.setText("Double Cube: "+Integer.toString(input));	
    } // updates double cube
    
    

}