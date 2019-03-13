/* Caoimhe Tiernan 17336331
   Saoirse Houlihan 17340803
   James   Kirwan   17402782
*/
//needs a randome number generator
// Doubling die will be a subclass

import java.util.Random;
import java.awt.Graphics;
public class Dice 
{
	public int die1;
	public int die2;
	private Random rand;

    public Dice()
    {
    	rand = new Random();
        die1 = roll();
        die2 = roll();
    }
    
    public void paint(Graphics g)
    {
    	drawDieOne(g);
    	drawDieTwo(g);
    }

    //returns a random number from 1 to 6
    public int roll()
    {
    	return rand.nextInt(6) + 1;
    }
 
    
    private void drawDieOne(Graphics g)
    {

    }
    
    private void drawDieTwo(Graphics g)
    {
    	
    }

}
