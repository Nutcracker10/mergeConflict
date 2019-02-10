import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.function.Predicate.isEqual;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class EastPanel extends JPanel implements ActionListener {

    JTextField enterText = new JTextField();                       // a field for entering details
    JTextArea areaText = new JTextArea("Welcome to Backgammon\n" + "type quit to end the game"); // an area for displaying game details
    JTextArea playerName = new JTextArea("Player: ");              // Displays player name
    JTextArea playerScore = new JTextArea("Score: ");              // Displays Player Score
    JPanel subpanel = new JPanel();                                // a subpanel for buttons

    // adds scrolling functionality to the text area
    JScrollPane scrollPane = new JScrollPane(areaText);

    EastPanel(){
        this.setLayout(new BorderLayout());   // sets border layout to Eastpanel
        subpanel.setLayout(new GridLayout(2, 1)); // sets grid layout to subpanel

        // prevents user from typing in these areas
        areaText.setEditable(false);
        playerScore.setEditable(false);
        playerName.setEditable(false);

        enterText.addActionListener(this);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        //adds each component to panel
        subpanel.add(playerName);
        subpanel.add(playerScore);
        this.add(areaText, BorderLayout.CENTER);
        this.add(enterText, BorderLayout.SOUTH);
        this.add(subpanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.EAST);


        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));          // creates black lines around panel
        playerScore.setBorder(BorderFactory.createLineBorder(Color.BLACK));   // creates line around scor
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String text = enterText.getText();

        areaText.append("\n"+ stringRecogniser(text) + "\n"); // sends string to recogniser to make action
        enterText.selectAll();


    }// end of actionPerformed

    public String stringRecogniser (String s) {

        if (s.equals("quit")) { System.exit(0); return s; } //ends program if quit was entered

        else { return ("Unknown command: " + s);}
    }
}
