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
    int colour;

    public Player(String n, int c)
    {
    	this.name = n;
    	this.colour = c;
    }



    //method to check if game has been won. Should check players slot to see if it is full
    private boolean hasWonGame()
    {
        return true;

    }


    //Mehtod takes dice roll at start and compares against other player object's dice roll
    private boolean goFirst()
    {
        return true;
    }


    private void setColour(int c)
    {
        this.colour = c;

    }

    //Method gets the colour the player is using. o for white, 1 for black
    private String getColour(int c)
    {
        if(c == 1)
        	return "Black";
        
        else
        	return "White";
    }



}