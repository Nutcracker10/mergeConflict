/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
//Class to represent the players
// Has method to check if player has won the game, returns true or false
// Has method to check if the player goes first, returns 1 or 2
// Has method to Get Colour of player
public class Player
{
    String name;
    int colour, initiaive;
    Dice roll;
    boolean myTurn, haveWon, doublingCube;
    Coordinate lastMove;
    int score;

    public Player(String n, int c)
    {
    	this.name = n;
    	this.colour = c;
    	score = 0;
        roll = new Dice();
        initiaive = roll.getDie1();
        myTurn = false;
        haveWon = false;
        doublingCube = true;
        lastMove = new Coordinate(0, 0);
    }

    //method to check if game has been won. Should check players slot to see if it is full
    public boolean hasWonGame(int checksInSlot)
    {
         if(checksInSlot == 15)
         {
             haveWon = true;
             return true;
         }

        return false;
    }


    //Mehtod takes dice roll at object creation and compares against other player object's dice roll
    public boolean goFirst(Player opponent)
    {
       if(this.initiaive > opponent.initiaive) //if player's roll is hihger
            return true;
        
        else if(this.initiaive == opponent.initiaive) //if the same, re roll check again
        {

                this.initiaive = roll.roll();
                return goFirst(opponent);
        }

        else
        	return false; //else return false
    }


    public void setColour(int c) //0 for white, 1 for black
    {
        this.colour = c;

    }
    
    public void setScore(int s) //sets score
    {
    	this.score = s;
    }

    //Method gets the colour the player is using. o for white, 1 for black
    public String getColour()
    {
        if(this.colour == 1)
        	return "Black";
        
        else
        	return "White";
    }

    public String getName()
    {
        return name;
    }
    
    public int getScore()
    {
    	return score;
    }

    public boolean isMyTurn()
    {
        return myTurn;
    }
    
    public boolean hasDoublingCube()
    {
    	return doublingCube;
    }




}