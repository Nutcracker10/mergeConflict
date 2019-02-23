/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EastPanel extends JPanel implements ActionListener {

    JTextField enterText = new JTextField();                       // a field for entering details
    JTextArea areaText = new JTextArea("Welcome to Backgammon\n"); // an area for displaying game details
    JTextArea playerName = new JTextArea("Player: ");              // Displays player name
    JTextArea playerScore = new JTextArea("Score: ");              // Displays Player Score
    JPanel subpanel = new JPanel();
    // a subpanel for buttons

    // adds scrolling functionality to the text area
    JScrollPane scrollPane = new JScrollPane(areaText);

    //Players
    Player white = new Player("", 0);
    Player black = new Player("", 1);

    Document doc = areaText.getDocument();                          // a means of getting text details


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

        this.areaText.append("\nCommands : "); //telling the user what commands they can use
        this.areaText.append("\nwName -> save white's name" + "\nbName -> save black's name"
                + "\nquit -> end the program\n");


        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));          // creates black lines around panel
        playerScore.setBorder(BorderFactory.createLineBorder(Color.BLACK));   // creates line around score

    }

    public int[] autoDiceRoller() { // automatically rolls dice and returns an array of results
        Dice d6 = new Dice();
        int[] result = new int[2];

        result[0] = d6.roll(); result [1] = d6.roll();

        return result;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String text = enterText.getText();
        int turnNumber = 0; //to count what turn it is
        boolean gameHasBegun = false; //flag to show the game has started

        if(text.equals("quit")){         // ends program if string is quit
            System.exit(0);
        }
        else if(text.startsWith("wName")) //command to save white player'ss name
        {
           // white = new Player(text.substring(6),0); //name should start the space after the command word
            white.name = text.substring(6);
            areaText.append("\nWhite : " + white.name);
            playerName.append(white.name);
            enterText.selectAll();

        }
        else if(text.startsWith("bName")) //command to save black player's name
        {
           // black = new Player(text.substring(6),1);
            black.name = text.substring(6,0);
            areaText.append("\nBlack : " + black.name);
            enterText.selectAll();

        }

        else if(text.equals("next")) //user switching between turns
        {
            if(white.myTurn)
            {
                white.myTurn = false;
                black.myTurn = true;
                areaText.append("\n"+black.name+"'s turn");
                areaText.append("\nRoll: " + autoDiceRoller()[0] + " " + autoDiceRoller()[1]);
                enterText.selectAll();
            }

            else
                {
                    white.myTurn = true;
                    black.myTurn = false;
                    areaText.append("\n"+white.name+"'s turn");
                    areaText.append("\nRoll: " + autoDiceRoller()[0] + " " + autoDiceRoller()[1]);
                    enterText.selectAll();

                }
            turnNumber++;
        }

        else if (text.startsWith("move")) {

            String subString = text.substring(5);

            if (subString.length() < 6) {

                try{
                    int pipNum = Integer.parseInt(subString.substring(0,1));
                    int pipToMoveTo = Integer.parseInt(subString.substring(2,3));
                    areaText.append("\n" + pipNum + " " + pipToMoveTo);
                    //checkerMover(pipNum, pipToMoveTo);
                }
                catch (NumberFormatException e){
                    areaText.append("\nmove : Invalid format\n");
                }

            }
            else {
                areaText.append("\nInvalid number of arguments");
            }



            enterText.selectAll();

        }

        else {
            areaText.append("\nUnrecognised Command :\n");
            areaText.append(text + "\n");
            enterText.selectAll();
        }


        if(ReadyToStart() && turnNumber == 0) //Have to do this inside the action listner because of threads and swing
        {
            areaText.append("\nGAME START"); //Annouces start of the games
            gameHasBegun = true;
        }

        if(gameHasBegun) //if the game has started
        {

            if(turnNumber == 0) {
                if (white.goFirst(black)) { //We check who goes first
                    areaText.append("\n" + white.name + " goes first");
                    white.myTurn = true;
                } else {
                    areaText.append("\n" + black.name + " goes first");
                    black.myTurn = false;
                }
            }


            if(white.myTurn) //add code for what happens on white's turn
            {


            }

            if(black.myTurn) //add code for what happens on black's turn
            {


            }



        }

    }//end of actionPerformed


    public boolean ReadyToStart() //if both players given their names, this method returns true.
    {
       return ( ( !(black.name.equals("")) && !(white.name.equals("")) ) );
    }

    public void checkerMover(int n, int m) { // takes in some ints n and m for moving checkers
        areaText.append("\n" + n +" "+ m + "\n");
    }






}
